package org.example.sentiment.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzeRequest {
    private List<BaseSegment> segments;
}
