package com.neueda.leap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main_printsExpectedMessage() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        String output = outContent.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
        assertEquals("Hello world from PR Lab! Sean's change\n", output);
    }
}
