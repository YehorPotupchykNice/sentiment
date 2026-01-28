package org.example.sentiment.dto;

import lombok.NoArgsConstructor;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

@NoArgsConstructor
public class SegmentDeserializer extends ValueDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        var node = ctxt.readTree(p);
        var t = node.get("type").stringValue();
        return switch (t) {
            case "text" -> new TextSegment(node.get("id").stringValue(), node.get("text").stringValue());
            case "video" -> new VideoSegment(node.get("id").stringValue(), node.get("url").stringValue(), node.get("transcript").stringValue());
            default -> null;
        };
    }
}
