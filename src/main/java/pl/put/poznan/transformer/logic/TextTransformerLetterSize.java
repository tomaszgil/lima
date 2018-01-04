package pl.put.poznan.transformer.logic;

public class TextTransformerLetterSize {

    public TextTransformerLetterSize(){}

    public String upper(String text){
        // changing to uppercase
        return text.toUpperCase();
    }

    public String lower(String text){
        // changing to lowercase
        return text.toLowerCase();
    }

    public String capitalize(String text){
        // capitalizing
        char[] chars = text.toCharArray();

        chars[0] = Character.toUpperCase(chars[0]);

        for(int x=1; x<chars.length;x++){
            if(chars[x-1] == ' '){
                chars[x] = Character.toUpperCase(chars[x]);
            }
        }
        String textCapitalized = new String(chars);
        return textCapitalized;
    }
}
