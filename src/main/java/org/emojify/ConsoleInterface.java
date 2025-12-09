package org.emojify;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    private final Scanner scanner;

    public void print(String message) {
        System.out.print(message);
    }

    public ConsoleInterface() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int showMenu(String title, List<String> options) {
        System.out.println();
        System.out.println("=== " + title + " ===");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        return readIntInRange("Choose one of the number above.", 1, options.size());
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt + " (" + min + "–" + max + "): ");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please chose a number between " + min + " and " + max + ".");
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please add valid number.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
