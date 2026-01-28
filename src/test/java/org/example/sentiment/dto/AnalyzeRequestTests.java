package org.example.sentiment.dto;

import org.example.sentiment.analyzers.TextAnalyzer;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AnalyzeRequestTests {

    @Test
    public void testDeserialize() {
        var json = """
                {
                  "segments": [
                    {
                      "id": "text_segment",
                      "type": "text",
                      "text": "some text here"
                    },
                    {
                      "id": "video_segment",
                      "type": "video",
                      "url": "example.com",
                      "transcript": "video transcript here"
                    }
                  ]
                }""";
        var request = new ObjectMapper().readValue(json, AnalyzeRequest.class);
        System.out.println(request);
        assertInstanceOf(TextSegment.class, request.getSegments()[0]);
        assertEquals("text_segment", request.getSegments()[0].getId());
        assertEquals("some text here", ((TextSegment) request.getSegments()[0]).getText());

        assertInstanceOf(VideoSegment.class, request.getSegments()[1]);
        assertEquals("video_segment", request.getSegments()[1].getId());
        assertEquals("video transcript here", ((VideoSegment) request.getSegments()[1]).getTranscript());
        assertEquals("example.com", ((VideoSegment) request.getSegments()[1]).getUrl());
    }
}
