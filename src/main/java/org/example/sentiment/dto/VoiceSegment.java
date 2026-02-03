package org.example.sentiment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.sentiment.analyzers.TextAnalyzer;

@EqualsAndHashCode(callSuper = true)
@Data
public class VoiceSegment extends BaseSegment {
    private String url;
    private String transcript;

    public VoiceSegment(String id, String url, String transcript) {
        super(id, "voice");
        this.url = url;
        this.transcript = transcript;
    }

    @Override
    public SegmentScore toSegmentScore() {
        var score = TextAnalyzer.sentimentScore(this.getTranscript());
        return new SegmentScore(this.getId(), score.getNegative(), score.getNeutral(), score.getPositive());
    }
}
