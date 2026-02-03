package org.example.sentiment.service;

import lombok.NonNull;
import org.example.sentiment.analyzers.SentimentScore;
import org.example.sentiment.analyzers.TextAnalyzer;
import org.example.sentiment.dto.*;

import java.util.ArrayList;

public class SegmentAnalysisServiceImpl implements SegmentAnalysisService {

    @Override
    public AnalyzeResponse analyze(@NonNull AnalyzeRequest request) {
        if (request.getSegments() == null) {
            throw new NullPointerException("segments is null");
        }
        var scores = new ArrayList<SegmentScore>();
        request.getSegments().forEach(segment -> {
            if (segment == null) {
                return;
            }
            scores.add(segment.toSegmentScore());
        });
        return new AnalyzeResponse(scores);
    }
}
