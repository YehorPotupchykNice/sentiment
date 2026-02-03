package org.example.sentiment.service;

import lombok.NonNull;
import org.example.sentiment.analyzers.SentimentScore;
import org.example.sentiment.analyzers.TextAnalyzer;
import org.example.sentiment.dto.*;

import java.util.ArrayList;

public class SegmentAnalysisServiceImpl implements SegmentAnalysisService {

    private SegmentScore toSegmentScore(String id, SentimentScore score) {
        return new SegmentScore(id, score.getNegative(), score.getNeutral(), score.getPositive());
    }

    @Override
    public  AnalyzeResponse analyze(@NonNull AnalyzeRequest request) {
        if (request.getSegments() == null) {
            throw new NullPointerException("segments is null");
        }
        return new AnalyzeResponse(new ArrayList<>());
    }
}
