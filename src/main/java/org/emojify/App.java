package org.emojify;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ConsoleInterface console = new ConsoleInterface();
        boolean running = true;
        //read word from json

        while (running) {

            int choice = console.showMenu("Menu", List.of(
                    "Parse emoji",
                    "Finish app"
            ));

            switch (choice) {

                case 1 -> {
                    String text = console.readLine("Add text to parse to emoji:");
                    //call method to parse
                    console.print(text);
                }

                case 2 -> {
                    running = false;
                    console.print("Closing app ...");
                    console.close();
                }
            }
        }
    }
}