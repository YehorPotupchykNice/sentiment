package org.example.sentiment;

public class TextAnalyzer {
    //description of the task is very vague - so let's do some complete bullshit here
    //score will be simply calculated by ratio of 3 words - shit, mid and fire
    public static SentimentScore sentimentScore(String text) {
        return new SentimentScore(0, 0, 0);
    }
}
