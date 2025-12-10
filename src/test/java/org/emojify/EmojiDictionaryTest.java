package org.emojify;

import java.util.Map;
import java.util.HashMap;
import java.util.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;


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
        String filePath = "/simpleTestFile.json";
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

    // Add test files about getKeys() function

    @Test // happy path test : when loading file with no problem_it should return all keys and I should be able to iterate through it
    void testGetKeys() throws IOException{
        String filePath = "/simpleTestFile.json";
        dictionary.load(filePath) ;
        List<String> resultList = dictionary.getKeys();

        List<String> expectedList = new ArrayList<>() ;
        expectedList.add("love");
        expectedList.add("fire");
        expectedList.add("done");

        for(String key : resultList){
            System.out.println("key in dictionary: "+key);
        }
        System.out.println("");
        for(String key : expectedList){
            System.out.println("expected keys: "+key);
        }        

        assertEquals(expectedList, resultList, "The resulting List does not match the expected List."); 
    }

    @Test // when file is empty, it should return empty List (bad end case)
    void testEmptyFileGetKeys() throws IOException {

        String filePath = "/empty.json";
        dictionary.load(filePath) ;
        List<String> resultList = dictionary.getKeys();

        List<String> expectedList = new ArrayList<>(); // the result should be empty list

        assertEquals(expectedList, resultList, "The resulting List does not match the expected List.");

    }
    
    @Test // when file location is not exist, it should return empty HashMap (bad end case)
    void testNotExistFileGetKeys() throws IOException {
        String filePath = "/noSuchFile.json";
        dictionary.load(filePath) ;
        List<String> resultList = dictionary.getKeys();

        List<String> expectedList = new ArrayList<>(); // the result should be empty list

        assertEquals(expectedList, resultList, "The resulting List does not match the expected List.");

    }
}