
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
    "avg_peakreturns",
    "avg_presentreturns",
    "PerfMessages"
})
public class ZackPerformanceResponse {

    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("avg_peakreturns")
    private String avgpeakreturns;
    @JsonProperty("avg_presentreturns")
    private String avgpresentreturns;
    @JsonProperty("PerfMessages")
    private List<PerfMessage> perfMessages = null;
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
    
    @JsonProperty("avg_peakreturns")
    public String getavgpeakreturns() {
        return avgpeakreturns;
    }

    @JsonProperty("avg_peakreturns")
    public void setavgpeakreturns(String avgpeakreturns) {
        this.avgpeakreturns = avgpeakreturns;
    }
    
    @JsonProperty("avg_presentreturns")
    public String getavgpresentreturns() {
        return avgpresentreturns;
    }

    @JsonProperty("avg_presentreturns")
    public void setavgpresentreturns(String avgpresentreturns) {
        this.avgpresentreturns = avgpresentreturns;
    }

    @JsonProperty("PerfMessages")
    public List<PerfMessage> getPerfMessages() {
        return perfMessages;
    }

    @JsonProperty("PerfMessages")
    public void setPerfMessages(List<PerfMessage> perfMessages) {
        this.perfMessages = perfMessages;
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
