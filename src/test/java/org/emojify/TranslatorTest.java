package org.emojify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class TranslatorTest {

    private Translator translator;
    private Map<String, String> testMap;

    @BeforeEach
    public void setUp() {
        //define a manual map for testing
        testMap = new HashMap<>();
        testMap.put("happy", "😀");
        testMap.put("heart", "❤️");
        testMap.put("pizza", "🍕");

        translator = new Translator(testMap);
    }

    @Test
    public void testToEmoji_BasicReplacement() {
        String input = "I am happy";
        String expected = "I am 😀";
        assertEquals(expected, translator.toEmoji(input));
    }

    @Test
    public void testToEmoji_CaseSensitivity() {
        //"Happy" should match "happy" key
        String input = "Happy";
        String expected = "😀";
        assertEquals(expected, translator.toEmoji(input));
    }

    @Test
    public void testToEmoji_NoMatch() {
        String input = "This is a test";
        String expected = "This is a test";
        assertEquals(expected, translator.toEmoji(input));
    }

    @Test
    public void testToEmoji_MixedContent() {
        String input = "I love pizza and my heart";
        String expected = "I love 🍕 and my ❤️";
        assertEquals(expected, translator.toEmoji(input));
    }

    @Test
    public void testToEmoji_EmptyInput() {
        assertEquals("", translator.toEmoji(""));
    }

    @Test
    public void testToEmoji_NullInput() {
        assertEquals("", translator.toEmoji(null));
    }

    @Test
    public void testTranslator_NullMapConstructor() {
        // Ensure app doesn't crash if map is null
        Translator emptyTranslator = new Translator(null);
        assertEquals("hello", emptyTranslator.toEmoji("hello"));
    }

    @Test
    public void testRepeatedWords() {
        // Check if all occurrences of the same word are replaced
        String input = "happy happy";
        String expected = "😀 😀";
        assertEquals(expected, translator.toEmoji(input));
    }
}