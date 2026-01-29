package org.example.sentiment.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
