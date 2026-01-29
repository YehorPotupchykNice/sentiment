package org.example.sentiment.service;

import org.example.sentiment.analyzers.SentimentScore;
import org.example.sentiment.analyzers.TextAnalyzer;
import org.example.sentiment.dto.*;

public class SegmentAnalysisServiceImpl implements SegmentAnalysisService {

    private SegmentScore toSegmentScore(String id, SentimentScore score) {
        return new SegmentScore(id, score.getNegative(), score.getNeutral(), score.getPositive());
    }

    @Override
    public  AnalyzeResponse analyze(AnalyzeRequest request) {
        var segments = request.getSegments().stream().map(s-> {
            if (s instanceof TextSegment t) {
                return toSegmentScore(t.getId(), TextAnalyzer.sentimentScore(t.getText()));
            }
            return null;
        });
        return new AnalyzeResponse(segments.toList());
    }
}
