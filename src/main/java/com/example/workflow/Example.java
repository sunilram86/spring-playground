package com.example.workflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "q",
        "from"
})
public class Example {

    @JsonProperty("q")
    private String q;
    @JsonProperty("from")
    private String from;

    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

}