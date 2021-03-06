
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
    "id",
    "username",
    "avatar",
    "discriminator",
    "public_flags",
    "bot"
})
public class Author {

    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("discriminator")
    private String discriminator;
    @JsonProperty("public_flags")
    private Integer publicFlags;
    @JsonProperty("bot")
    private Boolean bot;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("discriminator")
    public String getDiscriminator() {
        return discriminator;
    }

    @JsonProperty("discriminator")
    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @JsonProperty("public_flags")
    public Integer getPublicFlags() {
        return publicFlags;
    }

    @JsonProperty("public_flags")
    public void setPublicFlags(Integer publicFlags) {
        this.publicFlags = publicFlags;
    }

    @JsonProperty("bot")
    public Boolean getBot() {
        return bot;
    }

    @JsonProperty("bot")
    public void setBot(Boolean bot) {
        this.bot = bot;
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
