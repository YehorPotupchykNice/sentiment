package org.example.sentiment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SegmentScore {
    private String id;
    private float negative;
    private float neutral;
    private float positive;
}
