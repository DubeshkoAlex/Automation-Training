package com.epam.tat.intro;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntroTest {

    @Test
    public void test() {
        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;
        System.setOut(controlledOut);
        Intro.main(new String[]{});
        controlledOut.flush();
        assertEquals("Hello, AutoCode!", sink.toString().trim());

        System.setOut(defaultOut);
    }

}
