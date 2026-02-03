package org.example.sentiment.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AnalyzeResponse {
   private List<SegmentScore> segmentScores;
}
