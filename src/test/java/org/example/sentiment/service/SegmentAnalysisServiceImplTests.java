package org.example.sentiment.service;

import org.example.sentiment.dto.AnalyzeRequest;
import org.example.sentiment.dto.AnalyzeResponse;
import org.example.sentiment.dto.BaseSegment;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SegmentAnalysisServiceImplTests {

    @Test
    public void testNullRequest() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();
        assertThrows(NullPointerException.class, () -> segmentAnalysisService.analyze(null));
    }

    @Test
    public void testNullInRequest() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();
        assertThrows(NullPointerException.class, () -> segmentAnalysisService.analyze(new AnalyzeRequest()));
    }

    @Test
    public void testNullsInRequest() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();
        var request = new AnalyzeRequest(Arrays.asList(new BaseSegment[]{null}));
        var result = segmentAnalysisService.analyze(request);
        var expected = new AnalyzeResponse(new ArrayList<>());
        assertEquals(expected, result);
    }
}
