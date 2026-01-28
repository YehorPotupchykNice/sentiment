package org.example.sentiment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VideoSegment extends BaseSegment {
    public VideoSegment(String id, String url, String transcript) {
        super(id);
        this.url = url;
        this.transcript = transcript;
    }
    private String url;
    private String transcript;
}
