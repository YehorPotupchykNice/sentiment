package org.example.sentiment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TextSegment extends BaseSegment {
    private String text;

    public TextSegment(String id, String text) {
        super(id, "text");
        this.text = text;
    }
}
