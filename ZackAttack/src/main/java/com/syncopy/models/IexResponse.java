
package com.syncopy.models;

import java.math.BigInteger;
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
    "close",
    "high",
    "low",
    "open",
    "symbol",
    "volume",
    "id",
    "key",
    "subkey",
    "date",
    "updated",
    "changeOverTime",
    "marketChangeOverTime",
    "uOpen",
    "uClose",
    "uHigh",
    "uLow",
    "uVolume",
    "fOpen",
    "fClose",
    "fHigh",
    "fLow",
    "fVolume",
    "label",
    "change",
    "changePercent"
})
public class IexResponse {

    @JsonProperty("close")
    private Double close;
    @JsonProperty("high")
    private Double high;
    @JsonProperty("low")
    private Double low;
    @JsonProperty("open")
    private Double open;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("volume")
    private BigInteger volume;
    @JsonProperty("id")
    private String id;
    @JsonProperty("key")
    private String key;
    @JsonProperty("subkey")
    private String subkey;
    @JsonProperty("date")
    private String date;
    @JsonProperty("updated")
    private BigInteger updated;
    @JsonProperty("changeOverTime")
    private Double changeOverTime;
    @JsonProperty("marketChangeOverTime")
    private Double marketChangeOverTime;
    @JsonProperty("uOpen")
    private Double uOpen;
    @JsonProperty("uClose")
    private Double uClose;
    @JsonProperty("uHigh")
    private Double uHigh;
    @JsonProperty("uLow")
    private Double uLow;
    @JsonProperty("uVolume")
    private BigInteger uVolume;
    @JsonProperty("fOpen")
    private Double fOpen;
    @JsonProperty("fClose")
    private Double fClose;
    @JsonProperty("fHigh")
    private Double fHigh;
    @JsonProperty("fLow")
    private Double fLow;
    @JsonProperty("fVolume")
    private BigInteger fVolume;
    @JsonProperty("label")
    private String label;
    @JsonProperty("change")
    private Double change;
    @JsonProperty("changePercent")
    private Double changePercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("close")
    public Double getClose() {
        return close;
    }

    @JsonProperty("close")
    public void setClose(Double close) {
        this.close = close;
    }

    @JsonProperty("high")
    public Double getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Double high) {
        this.high = high;
    }

    @JsonProperty("low")
    public Double getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Double low) {
        this.low = low;
    }

    @JsonProperty("open")
    public Double getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(Double open) {
        this.open = open;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("volume")
    public BigInteger getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("subkey")
    public String getSubkey() {
        return subkey;
    }

    @JsonProperty("subkey")
    public void setSubkey(String subkey) {
        this.subkey = subkey;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("updated")
    public BigInteger getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(BigInteger updated) {
        this.updated = updated;
    }

    @JsonProperty("changeOverTime")
    public Double getChangeOverTime() {
        return changeOverTime;
    }

    @JsonProperty("changeOverTime")
    public void setChangeOverTime(Double changeOverTime) {
        this.changeOverTime = changeOverTime;
    }

    @JsonProperty("marketChangeOverTime")
    public Double getMarketChangeOverTime() {
        return marketChangeOverTime;
    }

    @JsonProperty("marketChangeOverTime")
    public void setMarketChangeOverTime(Double marketChangeOverTime) {
        this.marketChangeOverTime = marketChangeOverTime;
    }

    @JsonProperty("uOpen")
    public Double getUOpen() {
        return uOpen;
    }

    @JsonProperty("uOpen")
    public void setUOpen(Double uOpen) {
        this.uOpen = uOpen;
    }

    @JsonProperty("uClose")
    public Double getUClose() {
        return uClose;
    }

    @JsonProperty("uClose")
    public void setUClose(Double uClose) {
        this.uClose = uClose;
    }

    @JsonProperty("uHigh")
    public Double getUHigh() {
        return uHigh;
    }

    @JsonProperty("uHigh")
    public void setUHigh(Double uHigh) {
        this.uHigh = uHigh;
    }

    @JsonProperty("uLow")
    public Double getULow() {
        return uLow;
    }

    @JsonProperty("uLow")
    public void setULow(Double uLow) {
        this.uLow = uLow;
    }

    @JsonProperty("uVolume")
    public BigInteger getUVolume() {
        return uVolume;
    }

    @JsonProperty("uVolume")
    public void setUVolume(BigInteger uVolume) {
        this.uVolume = uVolume;
    }

    @JsonProperty("fOpen")
    public Double getFOpen() {
        return fOpen;
    }

    @JsonProperty("fOpen")
    public void setFOpen(Double fOpen) {
        this.fOpen = fOpen;
    }

    @JsonProperty("fClose")
    public Double getFClose() {
        return fClose;
    }

    @JsonProperty("fClose")
    public void setFClose(Double fClose) {
        this.fClose = fClose;
    }

    @JsonProperty("fHigh")
    public Double getFHigh() {
        return fHigh;
    }

    @JsonProperty("fHigh")
    public void setFHigh(Double fHigh) {
        this.fHigh = fHigh;
    }

    @JsonProperty("fLow")
    public Double getFLow() {
        return fLow;
    }

    @JsonProperty("fLow")
    public void setFLow(Double fLow) {
        this.fLow = fLow;
    }

    @JsonProperty("fVolume")
    public BigInteger getFVolume() {
        return fVolume;
    }

    @JsonProperty("fVolume")
    public void setFVolume(BigInteger fVolume) {
        this.fVolume = fVolume;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("change")
    public Double getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(Double change) {
        this.change = change;
    }

    @JsonProperty("changePercent")
    public Double getChangePercent() {
        return changePercent;
    }

    @JsonProperty("changePercent")
    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
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
