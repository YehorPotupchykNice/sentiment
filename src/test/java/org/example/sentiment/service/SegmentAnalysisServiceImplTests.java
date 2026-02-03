package org.example.sentiment.service;

import org.example.sentiment.dto.*;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

    @Test
    public void testTextInRequest() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();

        var segmentId = "text_segment";
        var segmentText = "fire mid";
        var segment = new TextSegment(segmentId, segmentText);

        var expectedScore = new SegmentScore(segmentId, 0f, 0.5f, 0.5f);
        var expected = new AnalyzeResponse(Arrays.asList(new SegmentScore[]{expectedScore}));

        var request = new AnalyzeRequest(Arrays.asList(new BaseSegment[]{segment}));
        var result = segmentAnalysisService.analyze(request);

        assertEquals(expected.getSegmentScores().size(), result.getSegmentScores().size());
        assertTrue(result.getSegmentScores().containsAll(expected.getSegmentScores()));
    }

    @Test
    public void testSegmentAndNullInRequest() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();

        var segmentId = "text_segment";
        var segmentText = "fire mid";
        var segment = new TextSegment(segmentId, segmentText);

        var expectedScore = new SegmentScore(segmentId, 0f, 0.5f, 0.5f);
        var expected = new AnalyzeResponse(Arrays.asList(new SegmentScore[]{expectedScore}));

        var request = new AnalyzeRequest(Arrays.asList(new BaseSegment[]{segment, null}));
        var result = segmentAnalysisService.analyze(request);

        assertEquals(expected.getSegmentScores().size(), result.getSegmentScores().size());
        assertTrue(result.getSegmentScores().containsAll(expected.getSegmentScores()));
    }
}
