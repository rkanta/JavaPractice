package com.etrade.exampleapp.market;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import com.etrade.exampleapp.AbstractClient;
import com.etrade.exampleapp.oauth.ApiException;

public class QuotesClient extends AbstractClient {

    public QuotesClient(){}

    Map<String,String> apiProperties;

    @Override
    public String getHttpMethod(){
        return "GET";
    }

    @Override
    public String getURL(String symbol) {
        String url = String.format("%s%s%s", apiProperties.get("API_BASE_URL"),apiProperties.get("QUOTE_URI"),symbol);
        log.debug("Portfolio URL "+url);
        return url;
    }

    @Override
    public String getURL() {
        return ("");
    }
    public void setApiProperties(Map<String, String> apiProperties) {
        this.apiProperties = apiProperties;
    }


    public String getQuotes(String symbol)  throws UnsupportedEncodingException, GeneralSecurityException, ApiException {

        log.debug("Value of isInitialized in QuotesClient : "+isInitialized);

        Map<String,String> queryParam = new HashMap<String, String>();
        queryParam.put("consumerKey", params.getConsumerKey());

        log.debug(" Calling GetQuote API ");
        return apiRestClient.callService(getURL(symbol),  getHttpMethod(), queryParam);
    }

}
