package pl.put.poznan.transformer.logic;

/**
 * This class consists of a method used for inverting
 * given string.
 *
 * @author  Miłosz Pogodski
 */
public class TextTransformerInverse {

    public TextTransformerInverse(){}

    /**
     * This method is used for inverting the string.
     *
     * @param text text which we want to invert
     * @return inverted text
     */
    public String inverse(String text){
        //
        char[] textChar = text.toCharArray();
        int left, right;
        right = textChar.length-1;
        char temp;

        for (left=0;left<right;left++,right--){
            temp = textChar[left];
            if(Character.isUpperCase(temp))
                textChar[left]=Character.toUpperCase(textChar[right]);
            else
                textChar[left]=Character.toLowerCase(textChar[right]);

            if(Character.isUpperCase(textChar[right]))
                textChar[right]=Character.toUpperCase(temp);
            else
                textChar[right]=Character.toLowerCase(temp);
        }

        return String.valueOf(textChar);
    }

}
