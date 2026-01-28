package org.example.sentiment.analyzers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SentimentScore {
    private float negative;
    private float neutral;
    private float positive;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SentimentScore other)) {
            return false;
        }
        return this.negative == other.negative && this.neutral == other.neutral && this.positive == other.positive;
    }

    @Override
    public String toString() {
        return String.format("positive: %s; neutral: %s; negative: %s", positive, neutral, negative);
    }
}
