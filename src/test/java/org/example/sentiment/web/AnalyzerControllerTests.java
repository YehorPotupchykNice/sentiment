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

    @Test
    public void testTextSegment() throws Exception {
        var segmentId = "segment_a";
        var segmentText = "fire mid";
        var expectedScore = new SegmentScore(segmentId, 0f, 0.5f, 0.5f);
        List<BaseSegment> segments = Arrays.asList(new TextSegment(segmentId, segmentText));
        var content = objectMapper.writeValueAsString(new AnalyzeRequest(segments));
        var mvcRes = mvc.perform(post("/analyze").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andExpect(status().isOk()).andReturn();

        var res = objectMapper.readValue( mvcRes.getResponse().getContentAsString(), AnalyzeResponse.class);
        assertEquals(1, res.getSegmentScores().size());
        var segment = res.getSegmentScores().get(0);
        assertEquals(segmentId, segment.getId());
        assertEquals(expectedScore.getNegative(), segment.getNegative());
        assertEquals(expectedScore.getPositive(), segment.getPositive());
        assertEquals(expectedScore.getNeutral(), segment.getNeutral());

    }

}
