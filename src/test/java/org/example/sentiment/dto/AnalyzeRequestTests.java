package org.example.sentiment.dto;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

public class AnalyzeRequestTests {

    @Test
    public void testDeserializeText() {
        var json = """
                {"segments":[
                    {"type":"text", "text": "some text here"}
                ]}""";
        var request = new ObjectMapper().readValue(json, AnalyzeRequest.class);
        System.out.println(request);
    }
}
