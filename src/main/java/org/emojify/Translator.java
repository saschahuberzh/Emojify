package org.emojify;
import java.util.Map;

public class Translator{
    //logic issue3
    private Map<String, String> emojiMap;

    public Translator(Map<String, String> emojiMap) {
        //if map null
        this.emojiMap = emojiMap != null ? emojiMap : new HashMap<>();
    }

    public String toEmoji(String sentence){
        if (sentence == null || sentence.isEmpty()){
            return "";
        }
        StringBuilder result = new StringBuilder();

        //iteration
        for (String word : words){
            //check if the word is in the map
            String searchKey = word.toLowerCase();
            if (emojiMap.containsKey(searchKey)){
                //if found
                result.append(emojiMap.get(searchKey));
            }else{
                //keeping the word
                result.append(word);
            }
            //putting a space between each word
            result.append(" ");
        }
        //remove the last space
        return result.toString().trim();
    }
}