
package com.syncopy.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ticker",
    "duration",
    "changePercentage",
    "alertDate",
    "tickerAlertPrice",
    "tickerAllTimeHigh",
    "presentchangePercentage"
})
public class PerfMessage {

    @JsonProperty("ticker")
    private String ticker;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("changePercentage")
    private String changePercentage;
    @JsonProperty("alertDate")
    private String alertDate;
    @JsonProperty("tickerAlertPrice")
    private String tickerAlertPrice;
    @JsonProperty("tickerAllTimeHigh")
    private String tickerAllTimeHigh;
    @JsonProperty("presentchangePercentage")
    private String presentchangePercentage;
    @JsonProperty("description")
    private String description;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ticker")
    public String getTicker() {
        return ticker;
    }

    @JsonProperty("ticker")
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("changePercentage")
    public String getChangePercentage() {
        return changePercentage;
    }

    @JsonProperty("changePercentage")
    public void setChangePercentage(String changePercentage) {
        this.changePercentage = changePercentage;
    }

    @JsonProperty("alertDate")
    public String getAlertDate() {
        return alertDate;
    }

    @JsonProperty("alertDate")
    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    @JsonProperty("tickerAlertPrice")
    public String getTickerAlertPrice() {
        return tickerAlertPrice;
    }

    @JsonProperty("tickerAlertPrice")
    public void setTickerAlertPrice(String tickerAlertPrice) {
        this.tickerAlertPrice = tickerAlertPrice;
    }

    @JsonProperty("tickerAllTimeHigh")
    public String getTickerAllTimeHigh() {
        return tickerAllTimeHigh;
    }

    @JsonProperty("tickerAllTimeHigh")
    public void setTickerAllTimeHigh(String tickerAllTimeHigh) {
        this.tickerAllTimeHigh = tickerAllTimeHigh;
    }
    
    @JsonProperty("presentchangePercentage")
    public String getpresentchangePercentage() {
        return presentchangePercentage;
    }

    @JsonProperty("presentchangePercentage")
    public void setpresentchangePercentage(String presentchangePercentage) {
        this.presentchangePercentage = presentchangePercentage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("description")
	public String getDescription() {
		return description;
	}
    @JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

}
