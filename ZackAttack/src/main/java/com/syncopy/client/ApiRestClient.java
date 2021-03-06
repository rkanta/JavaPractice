package com.syncopy.client;

import java.io.Console;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.syncopy.client.config.AppProperties;
import com.syncopy.models.IexResponse;
import com.syncopy.models.ZackMsg;

@Component
public class ApiRestClient {
	
	@Autowired
	AppProperties Aprop;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	Logger log = Logger.getLogger(ApiRestClient.class);

	public ResponseEntity<IexResponse[]> callService(final String url, final String method, String symbol, String range) {
		HttpHeaders headers = new HttpHeaders();
		
		

		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		//headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.add("Authorization", Aprop.getAuthorisation());
		//headers.setBasicAuth(Aprop.getAuthorisation());
		//headers.set("Authorization", Aprop.getAuthorisation());
		//headers.setBearerAuth(Aprop.getAuthorisation());

		 HttpEntity<String> entity = new HttpEntity<>(headers);

		 Map<String, String> urlParams = new HashMap<>();
		 urlParams.put("symbol", symbol);
		 urlParams.put("range", range);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        .queryParam("token", "Tsk_8f75f56109014eb984d8d6a6608b74bb");

		ResponseEntity<IexResponse[]> response = null;
		try {
			if (HttpMethod.GET.name().equalsIgnoreCase(method)) {
				System.out.println(builder.buildAndExpand(urlParams).toUri());
				//System.out.println(url);
                
				//System.out.println(restTemplate());

				//response = restTemplate().getForEntity(url, ZackMsg[].class);
				response = restTemplate().exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, IexResponse[].class);
			} else if (HttpMethod.POST.name().equalsIgnoreCase(method)) {
				log.debug("POST request " + symbol);
			}
		} catch (ResourceAccessException e) {
			log.error(" Error Calling service api ", e);
			log.error("Exception class name " + e.getCause().getClass().getSimpleName());

		} catch (Exception e) {
			
		System.out.println(e.getMessage());
	//	System.out.println(response.getStatusCode());
			log.error(" Error Calling service api ", e);
			log.error("Exception class name " + e.getClass().getName());
		}
		return response;

	}

	


}
