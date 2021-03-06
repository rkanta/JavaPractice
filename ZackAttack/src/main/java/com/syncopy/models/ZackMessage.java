
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
    "id",
    "type",
    "content",
    "channel_id",
    "author",
    "attachments",
    "embeds",
    "mentions",
    "mention_roles",
    "pinned",
    "mention_everyone",
    "tts",
    "timestamp",
    "edited_timestamp",
    "flags",
    "hit"
})
public class ZackMessage {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("content")
    private String content;
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("attachments")
    private List<Object> attachments = null;
    @JsonProperty("embeds")
    private List<Embed> embeds = null;
    @JsonProperty("mentions")
    private List<Object> mentions = null;
    @JsonProperty("mention_roles")
    private List<Object> mentionRoles = null;
    @JsonProperty("pinned")
    private Boolean pinned;
    @JsonProperty("mention_everyone")
    private Boolean mentionEveryone;
    @JsonProperty("tts")
    private Boolean tts;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("edited_timestamp")
    private Object editedTimestamp;
    @JsonProperty("flags")
    private Integer flags;
    @JsonProperty("hit")
    private Boolean hit;
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

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("channel_id")
    public String getChannelId() {
        return channelId;
    }

    @JsonProperty("channel_id")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("embeds")
    public List<Embed> getEmbeds() {
        return embeds;
    }

    @JsonProperty("embeds")
    public void setEmbeds(List<Embed> embeds) {
        this.embeds = embeds;
    }

    @JsonProperty("mentions")
    public List<Object> getMentions() {
        return mentions;
    }

    @JsonProperty("mentions")
    public void setMentions(List<Object> mentions) {
        this.mentions = mentions;
    }

    @JsonProperty("mention_roles")
    public List<Object> getMentionRoles() {
        return mentionRoles;
    }

    @JsonProperty("mention_roles")
    public void setMentionRoles(List<Object> mentionRoles) {
        this.mentionRoles = mentionRoles;
    }

    @JsonProperty("pinned")
    public Boolean getPinned() {
        return pinned;
    }

    @JsonProperty("pinned")
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    @JsonProperty("mention_everyone")
    public Boolean getMentionEveryone() {
        return mentionEveryone;
    }

    @JsonProperty("mention_everyone")
    public void setMentionEveryone(Boolean mentionEveryone) {
        this.mentionEveryone = mentionEveryone;
    }

    @JsonProperty("tts")
    public Boolean getTts() {
        return tts;
    }

    @JsonProperty("tts")
    public void setTts(Boolean tts) {
        this.tts = tts;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("edited_timestamp")
    public Object getEditedTimestamp() {
        return editedTimestamp;
    }

    @JsonProperty("edited_timestamp")
    public void setEditedTimestamp(Object editedTimestamp) {
        this.editedTimestamp = editedTimestamp;
    }

    @JsonProperty("flags")
    public Integer getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    @JsonProperty("hit")
    public Boolean getHit() {
        return hit;
    }

    @JsonProperty("hit")
    public void setHit(Boolean hit) {
        this.hit = hit;
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
