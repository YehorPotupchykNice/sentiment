package org.example.sentiment.web;

import org.example.sentiment.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class AnalyzerControllerTests {
    @Autowired
    private MockMvc mvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    void testSegmentRequest(BaseSegment segment, String segmentId, SegmentScore expectedScore) throws Exception {
        List<BaseSegment> segments = Arrays.asList(segment);
        var content = objectMapper.writeValueAsString(new AnalyzeRequest(segments));
        var mvcRes = mvc.perform(post("/analyze").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andExpect(status().isOk()).andReturn();

        var res = objectMapper.readValue( mvcRes.getResponse().getContentAsString(), AnalyzeResponse.class);
        assertEquals(1, res.getSegmentScores().size());
        var s = res.getSegmentScores().get(0);
        assertEquals(segmentId, segment.getId());
        assertEquals(expectedScore.getNegative(), s.getNegative());
        assertEquals(expectedScore.getPositive(), s.getPositive());
        assertEquals(expectedScore.getNeutral(), s.getNeutral());
    }

    @Test
    public void testTextSegment() throws Exception {
        var segmentId = "text_segment";
        var segmentText = "fire mid";
        var segment = new TextSegment(segmentId, segmentText);
        var expectedScore = new SegmentScore(segmentId, 0f, 0.5f, 0.5f);
        testSegmentRequest(segment, segmentId, expectedScore);

    }

    @Test
    public void testVoiceSegment() throws Exception {
        var segmentId = "voice_segment";
        var segmentTranscript = "fire mid";
        var expectedScore = new SegmentScore(segmentId, 0f, 0.5f, 0.5f);
        var segment = new VoiceSegment(segmentId, "https://example.com/lol.wav", segmentTranscript);
        testSegmentRequest(segment, segmentId, expectedScore);
    }

}
