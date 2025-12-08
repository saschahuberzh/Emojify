package org.emojify;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmojiDictionaryTest {

    private EmojiDictionary dictionary; // 필드로 선언

    // 각 @Test가 실행되기 전에 이 메서드가 실행됩니다.
    // this method is executed before each @Test executed.
    @BeforeEach
    void setUp() {
        // 매번 새로운 객체를 생성하여 초기화합니다.
        // every time, I make new instance of EmojiDictionary and initialize it.
        this.dictionary = new EmojiDictionary(); 
    }


    @Test // happy path test : it should contain all key:value pairs
    void testLoad() throws IOException {
        String filePath = "/simpletTesfile.json";
        dictionary.load(filePath) ;
        Map<String, String> resultMap = dictionary.getEmojies();

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("love", "❤️");
        expectedMap.put("fire", "🔥");
        expectedMap.put("done", "✅");

        assertEquals(expectedMap, resultMap, "The resulting Map does not match the expected Map.");

    }

    @Test // when file location is not exist, it should return empty HashMap (bad end case)
    void testNotExistFile() throws IOException {
        String filePath = "/noSuchFile.json";
        dictionary.load(filePath) ;
        Map<String, String> resultMap = dictionary.getEmojies();

        Map<String, String> expectedMap = new HashMap<>(); // the result should be empty map

        assertEquals(expectedMap, resultMap, "The resulting Map does not match the expected Map.");

    }

    @Test // when file is empty, it should return empty HashMap (bad end case)
    void testEmptyFile() throws IOException {

        String filePath = "/empty.json";
        dictionary.load(filePath) ;
        Map<String, String> resultMap = dictionary.getEmojies();

        Map<String, String> expectedMap = new HashMap<>(); // the result should be empty map

        assertEquals(expectedMap, resultMap, "The resulting Map does not match the expected Map.");


    }
}