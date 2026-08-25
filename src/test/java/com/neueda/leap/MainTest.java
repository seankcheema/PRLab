package com.neueda.leap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void printsGreeting() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            Main.main(new String[0]);

            assertEquals(
                    "Hello world from PR Lab! Mohammeds Shoaib and Sean's changes" + System.lineSeparator(),
                    output.toString(StandardCharsets.UTF_8));
        } finally {
            System.setOut(originalOut);
        }
    }
}