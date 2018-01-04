package pl.put.poznan.transformer.logic;

public class TextTransformerInverse {


    public TextTransformerInverse(){}

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
