
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
    "type",
    "description",
    "color",
    "author"
})
public class Embed {

    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("color")
    private Integer color;
    @JsonProperty("author")
    private Author_ author;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("color")
    public Integer getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(Integer color) {
        this.color = color;
    }

    @JsonProperty("author")
    public Author_ getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author_ author) {
        this.author = author;
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
