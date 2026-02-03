package org.example.sentiment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SegmentScore {
    private String id;
    private float negative;
    private float neutral;
    private float positive;
}
