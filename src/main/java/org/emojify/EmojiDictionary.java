package org.emojify;

import java.util.* ;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.nio.file.Paths; 

import java.lang.reflect.Type ;
import java.lang.Character ;

public class EmojiDictionary{

    private Map<String,String> emojies ;

    public EmojiDictionary(){
        this.emojies = new HashMap<>() ;
    }

    public void load(String fileLocation){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(Paths.get(fileLocation).toFile())){

            // emojies = (HashMap) gson.fromJson(reader, emojies.getClass());
            Type type = new TypeToken<HashMap<String, String>>() {}.getType(); // I am not sure which one is better to use, HashMap or Map?

            this.emojies = gson.fromJson(reader, type);


            // if the value is not an emoji, remove the pair from the map
            Iterator<Map.Entry<String, String>> iter = emojies.entrySet().iterator() ;

            while(iter.hasNext()){
                Map.Entry<String , String> emojiPair = iter.next();
                int codeEmoji =emojiPair.getValue().codePointAt(0) ;
                if(!Character.isEmoji(codeEmoji)){
                    iter.remove();
                }
            }

        }
        catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }

}