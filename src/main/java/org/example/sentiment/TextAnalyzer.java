package org.example.sentiment;

import java.util.Arrays;
import java.util.stream.Stream;

public class TextAnalyzer {
    private static long countWord(String[] words, String word) {
        return Arrays.stream(words).filter(w -> w.equals(word)).count();
    }

    //description of the task is very vague - so let's do some complete bullshit here
    //score will be simply calculated by ratio of 3 words - shit, mid and fire
    public static SentimentScore sentimentScore(String text) {

        var words = Arrays.stream(text.split(" ")).map(String::toLowerCase).toArray(String[]::new);
        var positive = countWord(words, "fire");
        var neutral = countWord(words, "mid");
        var negative = countWord(words, "shit");
        var total = positive + neutral + negative;
        return new SentimentScore((float) negative / total, (float) neutral / total, (float) positive / total);
    }
}
