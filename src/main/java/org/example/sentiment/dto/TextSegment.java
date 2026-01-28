package org.example.sentiment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TextSegment extends BaseSegment {
    public TextSegment(String id, String text) {
        super(id);
        this.text = text;
    }

    private String text;
}
