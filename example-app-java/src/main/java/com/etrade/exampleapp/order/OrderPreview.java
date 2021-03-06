package com.etrade.exampleapp.order;

import static com.etrade.exampleapp.ETClientApp.out;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.etrade.exampleapp.AbstractClient;
import com.etrade.exampleapp.oauth.ApiException;
import com.etrade.exampleapp.order.model.OrderTerm;
import com.etrade.exampleapp.order.model.PriceType;

public class OrderPreview extends AbstractClient {
	
	@Inject
    private VelocityEngine velocityEngine;

	public OrderPreview(){}

	Map<String,String> apiProperties;

	@Override
	public String getHttpMethod(){
		return "POST";
	}

	@Override
	public String getURL(String accountIdKey) {
		String url = String.format("%s%s%s%s", apiProperties.get("API_BASE_URL"),apiProperties.get("ACCOUNTS_URI"),accountIdKey,"/orders/preview");
		log.debug("GetOrder URL "+url);
		return url;
	}

	@Override
	public String getURL() {
		return ("");
	}
	public void setApiProperties(Map<String, String> apiProperties) {
		this.apiProperties = apiProperties;
	}


	private String orderPreview(final String accountIdKey, String request) throws UnsupportedEncodingException, GeneralSecurityException, ApiException{

		log.debug("OrderPreview Initialized");

		log.debug(" Generating Signature for GetOrders api call");

		params.computeSignature(getHttpMethod(), getURL(accountIdKey));

		Map<String,String> queryParam = params.getHeaderMap();

		log.debug(" Calling Order Preview API ");
		return apiRestClient.callService(getURL(accountIdKey),  getHttpMethod(), queryParam, request);
	}
	public void fillOrderActionMenu(int choice, Map<String,String> input) {
		switch(choice) {
		case 1:
			input.put("ACTION", "BUY");
			break;
		case 2:
			input.put("ACTION", "SELL");
			break;
		case 3:
			input.put("ACTION", "SELL_SHORT");
			break;
		}
	}
	public void fillOrderPriceMenu(int choice, Map<String,String> input) {
		switch(choice) {
		case 1:
			input.put("PRICE_TYPE", "MARKET");
			break;
		case 2:
			input.put("PRICE_TYPE", "LIMIT");
			break;
		}
	}


	public void fillDurationMenu(int choice, Map<String,String> input) {
		switch(choice) {
		case 1:
			input.put("ORDER_TERM", "GOOD_FOR_DAY");
			break;
		case 2:
			input.put("ORDER_TERM", "IMMEDIATE_OR_CANCEL");
			break;
		case 3:
			input.put("ORDER_TERM", "FILL_OR_KILL");
			break;
		}
	}
	
	public void previewOrder(final String accountIdKey, Map<String,String> inputs) {
		String response = "";
		String requestJson = "";
		try {
			Template t = velocityEngine.getTemplate( "orderpreview.vm" );
			
			VelocityContext context = new VelocityContext();
			
			context.put("DATA_MAP", inputs);
			
			StringWriter writer = new StringWriter();
			
			t.merge( context, writer );
			
			requestJson =  writer.toString();
			
			log.debug(requestJson);
			
			response = orderPreview(accountIdKey,requestJson);
			log.debug(response);
			parseResponse(response);
			
		}catch(ApiException e) {
			out.println();
			out.println(String.format("HttpStatus: %20s", e.getHttpStatus()));
			out.println(String.format("Message: %23s", e.getMessage()));
			out.println(String.format("Error Code: %20s", e.getCode()));
			out.println();out.println();
		}
		catch (UnsupportedEncodingException e) {
			log.error(" getBalance : UnsupportedEncodingException " ,e);
		} catch (GeneralSecurityException e) {
			log.error(" getBalance : GeneralSecurityException " ,e);
		}catch (Exception e) {
			log.error(" getBalance : GenericException " ,e);
		}

	}
	
	public Map<String,String> getOrderDataMap(){
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("ORDER_TYPE", "EQ");
		map.put("CLIENT_ID", UUID.randomUUID().toString().substring(0, 8));
		map.put("PRICE_TYPE", "");
		map.put("ORDER_TERM", "");
		map.put("MARKET_SESSION", "REGULAR");
		map.put("STOP_VALUE", "");
		map.put("LIMIT_PRICE", "");
		map.put("SECURITY_TYPE", "EQ");
		map.put("SYMBOL", "");
		map.put("ACTION", "");
		map.put("QUANTITY_TYPE", "QUANTITY");
		map.put("QUANTITY", "");
		
		return map;
	}
	public void parseResponse(final String body) {
		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(body);
			
			JSONObject orderResponse = (JSONObject) jsonObject.get("PreviewOrderResponse");
			JSONArray orderData = null;
			
			StringBuilder outputString = new StringBuilder("");
			
			if( orderResponse != null ) {
				orderData = (JSONArray) orderResponse.get("Order");
				Object[] responseData = new Object[15];
				Iterator orderItr = orderData.iterator();

				StringBuilder sbuf = new StringBuilder();
				Formatter fmt = new Formatter(sbuf);


				JSONObject instrument = null;
				JSONObject previewId = null;
				JSONObject order = null;
				JSONObject product = null;
				
				
				if (orderItr.hasNext()) {
					order = (JSONObject) orderItr.next();

					JSONArray orderInstArr = (JSONArray)order.get("Instrument");

					Iterator orderdInstItr = orderInstArr.iterator();
					if( orderdInstItr.hasNext()) {
						instrument = (JSONObject)orderdInstItr.next();
						product = (JSONObject)instrument.get("Product");
					}
					JSONArray previewIds = (JSONArray)orderResponse.get("PreviewIds");
					Iterator previewIdItr = previewIds.iterator();
					if(previewIdItr.hasNext()) {
						previewId = (JSONObject)previewIdItr.next();
					}
				}
				outputString.append(String.format("%30s : %45s\n", "PreviewId", String.valueOf(previewId.get("previewId"))));

				outputString.append(String.format("%30s : %45s\n", "AccountId", String.valueOf(orderResponse.get("accountId"))));
				
				outputString.append(String.format("%30s : %45s\n", "Symbol", product.get("symbol")));

				outputString.append(String.format("%30s : %45s\n", "Total Order Value", String.valueOf(orderResponse.get("totalOrderValue"))));

				outputString.append(String.format("%30s : %45s\n", "OrderTerm", OrderUtil.getTerm((OrderTerm.getOrderTerm(String.valueOf(order.get("orderTerm")))))));

				outputString.append(String.format("%30s : %45s\n", "PriceType", OrderUtil.getPrice(PriceType.getPriceType(String.valueOf(order.get("priceType"))),order)));

				outputString.append(String.format("%30s : %45s\n", "Commission", order.get("estimatedCommission")));

				outputString.append(String.format("%30s : %45s\n", "Description", instrument.get("symbolDescription")));
				
				outputString.append(String.format("%30s : %45s\n", "OrderAction", instrument.get("orderAction")));
				
				outputString.append(String.format("%30s : %45s\n", "Quantity", instrument.get("quantity")));


				out.println(outputString.toString());
	
				out.println();
				out.println();
			}
				
			

		}catch (Exception e) {
			log.error(" getPortfolio " ,e);
		}


	}
}
