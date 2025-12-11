package org.emojify;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        ConsoleInterface console = new ConsoleInterface();
        EmojiDictionary dictionary = new EmojiDictionary();

        try {
            dictionary.load("/emoji_mappings.json");
        } catch (IOException e) {
            console.print("Error loading dictionary: " + e.getMessage());
        }

        //create translator
        Translator translator = new Translator(dictionary.getEmojies());

        boolean running = true;

        while (running) {

            int choice = console.showMenu("Menu", List.of(
                    "Parse emoji",
                    "Finish app"
            ));

            switch (choice) {

                case 1 -> {
                    String text = console.readLine("Add text to parse to emoji:");
                    String translatedText = translator.toEmoji(text);
                    console.print(translatedText + "\n");
                    // Copy result to clipboard
                    console.copyToClipboard(translatedText); 
                }

                case 2 -> {
                    console.print("Available words that can be converted to emojis:");

                    // use existing getKeys()
                    for (String word : dictionary.getKeys()) {
                        console.print("- " + word);
                    }

                    console.print("");
                }

                case 3 -> {
                    running = false;
                    console.print("Closing app ...");
                    console.close();
                }
            }
        }
    }
}