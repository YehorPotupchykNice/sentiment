package org.example.sentiment;

import org.example.sentiment.service.SegmentAnalysisService;
import org.example.sentiment.service.SegmentAnalysisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public SegmentAnalysisService segmentAnalysisService() {
        return new SegmentAnalysisServiceImpl();
    }
}
