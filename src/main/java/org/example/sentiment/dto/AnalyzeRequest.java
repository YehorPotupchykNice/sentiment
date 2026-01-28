package org.example.sentiment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;

public class AnalyzeRequest {
    private class SegmentDeserializer extends ValueDeserializer<Object> {
        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
            var currentToken = p.currentToken();

            return null;
        }
    }

    @JsonProperty
    @JsonDeserialize(using = SegmentDeserializer.class)
    private BaseSegment[] segments;
}
