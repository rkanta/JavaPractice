package com.syncopy.client.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("api")
public class AppProperties {
    
	private String baseUrl;
	private String monthUri;
	private String dayUri;
	private String dateUri;
	private String stockUri;
	private String authorisation;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getMonthUri() {
		return monthUri;
	}
	public void setMonthUri(String monthUri) {
		this.monthUri = monthUri;
	}
	public String getDayUri() {
		return dayUri;
	}
	public void setDayUri(String dayUri) {
		this.dayUri = dayUri;
	}
	public String getDateUri() {
		return dateUri;
	}
	public void setDateUri(String dateUri) {
		this.dateUri = dateUri;
	}
	/**
	 * @return the authorisation
	 */
	public String getAuthorisation() {
		return authorisation;
	}
	/**
	 * @param authorisation the authorisation to set
	 */
	public void setAuthorisation(String authorisation) {
		this.authorisation = authorisation;
	}
	/**
	 * @return the stockUri
	 */
	public String getStockUri() {
		return stockUri;
	}
	/**
	 * @param stockUri the stockUri to set
	 */
	public void setStockUri(String stockUri) {
		this.stockUri = stockUri;
	}
	
	
	
	
	
	

	
	
	
}
