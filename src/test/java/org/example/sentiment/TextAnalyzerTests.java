package org.example.sentiment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TextAnalyzerTests {

    static Stream<Arguments> testSentimentScoreProvider() {
        return Stream.of(
                arguments("shit", new SentimentScore(1, 0, 0)),
                arguments("mid", new SentimentScore(0, 1, 0)),
                arguments("fire", new SentimentScore(0, 0, 1)),
                arguments("fire fire", new SentimentScore(0, 0, 1)),
                arguments("mid fire", new SentimentScore(0, 0.5f, 0.5f)),
                arguments("mid fire shit", new SentimentScore(1f / 3, 1 / 3f, 1 / 3f))

        );
    }

    @ParameterizedTest
    @MethodSource("testSentimentScoreProvider")
    public void testSentimentScore(String text, SentimentScore expectedResult) {
        assertEquals(expectedResult, TextAnalyzer.sentimentScore(text));
    }
}
