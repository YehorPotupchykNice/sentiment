package org.example.sentiment.service;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SegmentAnalysisServiceImplTests {

    @Test
    public void testNull() {
        var segmentAnalysisService = new SegmentAnalysisServiceImpl();
        var result = segmentAnalysisService.analyze(null);
        assertNull(result);
    }
}
