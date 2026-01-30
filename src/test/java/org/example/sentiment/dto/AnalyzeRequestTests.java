package org.example.sentiment.dto;

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
                      "id": "voice_segment",
                      "type": "voice",
                      "url": "example.com",
                      "transcript": "transcript here"
                    }
                  ]
                }""";
        var request = new ObjectMapper().readValue(json, AnalyzeRequest.class);
        System.out.println(request);
        assertInstanceOf(TextSegment.class, request.getSegments().get(0));
        assertEquals("text_segment", request.getSegments().get(0).getId());
        assertEquals("some text here", ((TextSegment) request.getSegments().get(0)).getText());

        assertInstanceOf(VoiceSegment.class, request.getSegments().get(1));
        assertEquals("voice_segment", request.getSegments().get(1).getId());
        assertEquals("transcript here", ((VoiceSegment) request.getSegments().get(1)).getTranscript());
        assertEquals("example.com", ((VoiceSegment) request.getSegments().get(1)).getUrl());
    }
}
