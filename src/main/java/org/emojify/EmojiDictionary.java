package org.emojify;

import java.util.* ;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.reflect.Type ;
import java.lang.Character ;

public class EmojiDictionary{

    private Map<String,String> emojies ;

    public EmojiDictionary(){
        this.emojies = new HashMap<>() ;
    }

    public void load(String fileLocation) throws IOException {
        Gson gson = new Gson();

        InputStream inputStream = getClass().getResourceAsStream(fileLocation);
    
        if (inputStream == null) {
            System.out.println("ERROR: Could not find file at: " + fileLocation);
            return ;
        }
        try(Reader reader = new InputStreamReader(inputStream)){

            // emojies = (HashMap) gson.fromJson(reader, emojies.getClass());
            Type type = new TypeToken<HashMap<String, String>>() {}.getType(); // I am not sure which one is better to use, HashMap or Map?

            Map<String, String> testMap = gson.fromJson(reader, type);
            if(testMap != null){
                this.emojies = testMap ; 

            }

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
        catch(IOException e){
            System.out.println("Error : file is not exist");
        }
        catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }

    // This is a helper method to verify that the load() method is working properly.
    // This method returns an unmodifiable Map instance.
    // Attempting put/remove from outside will result in an UnsupportedOperationException.
    // The next issue will create the correct method to access the map.
    public Map<String, String> getEmojies() {
        return Collections.unmodifiableMap(this.emojies);
    }
    

}