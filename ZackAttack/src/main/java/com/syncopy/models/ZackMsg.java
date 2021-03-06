
package com.syncopy.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total_results",
    "messages",
    "analytics_id"
})
public class ZackMsg {

    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("messages")
    private List<List<ZackMessage>> messages = null;
    @JsonProperty("analytics_id")
    private String analyticsId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("messages")
    public List<List<ZackMessage>> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<List<ZackMessage>> messages) {
        this.messages = messages;
    }

    @JsonProperty("analytics_id")
    public String getAnalyticsId() {
        return analyticsId;
    }

    @JsonProperty("analytics_id")
    public void setAnalyticsId(String analyticsId) {
        this.analyticsId = analyticsId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
