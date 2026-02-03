package org.example.sentiment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.sentiment.analyzers.TextAnalyzer;

@EqualsAndHashCode(callSuper = true)
@Data
public class TextSegment extends BaseSegment {
    private String text;

    public TextSegment(String id, String text) {
        super(id, "text");
        this.text = text;
    }

    @Override
    public SegmentScore toSegmentScore() {
        var score = TextAnalyzer.sentimentScore(this.getText());
        return new SegmentScore(this.getId(), score.getNegative(), score.getNeutral(), score.getPositive());
    }
}
