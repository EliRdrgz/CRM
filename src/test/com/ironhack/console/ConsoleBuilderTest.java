package com.ironhack.console;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleBuilderTest {

    @Test
    void textConsoleInput() {
        String response = "holaquetal";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        String input = consoleBuilder.textConsoleInput("Enter your name: ");
        assertEquals(response, input);
    }

    @Test
    void textConsoleInput_CleanSpaces() {
        String response = "holaquetal     ";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        String input = consoleBuilder.textConsoleInput("Enter your name: ");
        assertEquals(response.trim(), input);
    }

    @Test
    void numberConsoleInput() {
        String response = "2342342";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        Integer input = consoleBuilder.numberConsoleInput("enter Number: ");
        assertEquals(2342342, input);
    }

    @Test
    void numberConsoleInput_options() {
        String response = "4";
        int[] options = {1, 2, 3, 4, 5};
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        Integer input = consoleBuilder.numberConsoleInput("enter Number: ", options);
        assertEquals(4, input);
    }

    @Test
    void numberConsoleInput_max_min() {
        String response = "4";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        Integer input = consoleBuilder.numberConsoleInput("enter Number: ", 1, 4);
        assertEquals(4, input);
    }

    @Test
    void emailConsoleInput() {
        String response = "fsadfasd@fjslak.com";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        String input = consoleBuilder.emailConsoleInput("enter Number: ");
        assertEquals(response, input);

    }

    @Test
    void listConsoleInput_text() {
        List<String> options = Arrays.asList("New lead", "Show leads", "Lookup Lead id", "Convert id", "Search " +
                "opportunity by company name", "Load demo data", "Edit opportunity", "Exit");
        String response = "New lead";
        Scanner keyboard = new Scanner(response);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        String input = consoleBuilder.listConsoleInput("enter Number: ", options);
        assertEquals(response.toUpperCase(), input);

    }

    @Test
    void listConsoleInput_number() {
        List<String> options = Arrays.asList("New lead", "Show leads", "Lookup Lead id", "Convert id", "Search " +
                "opportunity by company name", "Load demo data", "Edit opportunity", "Exit");
        String response = "New lead";
        Scanner keyboard = new Scanner("1");
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(keyboard);
        String input = consoleBuilder.listConsoleInput("enter Number: ", options);
        assertEquals(response.toUpperCase(), input);

    }
}