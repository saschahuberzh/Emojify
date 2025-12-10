package org.emojify;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*; 

public class AppTest {

    @Test
    void testAppMainExecution() {
        String simulatedInput = "2\n";
        InputStream originalIn = System.in;
        
        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
            assertDoesNotThrow(() -> App.main(new String[]{}));

        } finally {
            System.setIn(originalIn);
        }
    }
}