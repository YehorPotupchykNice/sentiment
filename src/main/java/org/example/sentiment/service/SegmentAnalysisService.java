package org.example.sentiment.service;

import org.example.sentiment.dto.AnalyzeResponse;
import org.example.sentiment.dto.BaseSegment;

import java.util.List;

public interface SegmentAnalysisService {
    AnalyzeResponse analyze(List<BaseSegment> segments);
}
