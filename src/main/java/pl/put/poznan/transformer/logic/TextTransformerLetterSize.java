package pl.put.poznan.transformer.logic;

/**
 * This class consists of methods that support changing letter sizes
 * in given strings.
 *
 * @author  Miłosz Pogodski
 */
public class TextTransformerLetterSize {

    public TextTransformerLetterSize(){}

    /**
     * This method is used for converting all of the characters
     * to upper case.
     *
     * @param text text which we want to change
     * @return text in upper case
     */
    public String upper(String text){
        // changing to uppercase
        return text.toUpperCase();
    }

    /**
     * This method is used for converting all of the characters
     * to lower case.
     *
     * @param text text which we want to change
     * @return text in lowercase
     */
    public String lower(String text){
        // changing to lowercase
        return text.toLowerCase();
    }

    /**
     * This method is used for capitalizing every word in given text.
     *
     * @param text text which we want to change
     * @return capitalized text
     */
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
