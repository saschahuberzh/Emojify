package org.emojify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    void testLoad() {


    }

    @Test // when file location is not exist, it should return empty HashMap (bad end case)
    void testNotExistFile()
    {

    }

    @Test // when file is empty, it should return empty HashMap (bad end case)
    void testEmptyFile(){

    }
}