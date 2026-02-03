package org.example.sentiment.analyzers;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SentimentScore {
    private float negative;
    private float neutral;
    private float positive;

    @Override
    public String toString() {
        return String.format("positive: %s; neutral: %s; negative: %s", positive, neutral, negative);
    }
}
