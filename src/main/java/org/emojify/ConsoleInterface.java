package org.emojify;

import java.util.List;
import java.util.Scanner;
//
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.HeadlessException;

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
            System.out.println("Please choose a number between " + min + " and " + max + ".");
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

    // Copy the string to the system clipboard.
    public void copyToClipboard(String text) {
        try {
            // 1. Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // 2. Create a transferable string selection
            StringSelection selection = new StringSelection(text);

            // 3. Set the clipboard contents
            clipboard.setContents(selection, null);

            // 4. Print success message
            System.out.println("(✨ Copied to clipboard!)");

        } catch (HeadlessException e) {
            // Handle environments without a display (e.g., CI servers, headless linux)
            System.out.println("Note: Clipboard is unavailable in this environment (Headless).");
        } catch (Exception e) {
            // Handle other unexpected errors
            System.out.println("Failed to copy to clipboard: " + e.getMessage());
        }
    }
}
