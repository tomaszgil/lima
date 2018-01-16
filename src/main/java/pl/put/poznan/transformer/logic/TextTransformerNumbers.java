package pl.put.poznan.transformer.logic;

/**
 * This class consists of method that supports changing numbers
 * to text.
 *
 * @author  Miłosz Pogodski
 */
public class TextTransformerNumbers {

    /**
     * String arrays are used to store supported numbers in text.
     */
    private String[] jedności;
    private String[] nastki;
    private String[] dziesiątki;

    private String[] setki;
    public TextTransformerNumbers(){

        this.jedności = new String[]{ "", "jeden ", "dwa ", "trzy ", "cztery ",
                    "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć ", };
        this.nastki = new String[]{ "", "jedenaście ", "dwanaście ", "trzynaście ",
                    "czternaście ", "piętnaście ", "szesnaście ", "siedemnaście ",
                    "osiemnaście ", "dziewiętnaście ", };
        this.dziesiątki = new String[]{ "", "dziesięć ", "dwadzieścia ",
                    "trzydzieści ", "czterdzieści ", "pięćdziesiąt ",
                    "sześćdziesiąt ", "siedemdziesiąt ", "osiemdziesiąt ",
                    "dziewięćdziesiąt ", };
        this.setki = new String[]{ "", "sto ", "dwieście ", "trzysta ", "czterysta ",
                    "pięćset ", "sześćset ", "siedemset ", "osiemset ",
                    "dziewięćset ", };
    }

    /**
     * This method is used for converting numbers to text equivalents.
     *
     * @param text text which we want have numbers transformed
     * @return text with numbers as text.
     */
    public String toText(String text){

        int x,y,z,c,v;
        boolean check;
        for (int i = 0; i < text.length(); i++){
            x = 0;
            y = 0;
            z = 0;
            check = false;
            if (Character.isDigit(text.charAt(i))) {
                x = Character.getNumericValue(text.charAt(i));
                if (i < text.length()-1 && Character.isDigit(text.charAt(i+1))){
                    y = x;
                    x = Character.getNumericValue(text.charAt(i+1));
                    if (i < text.length()-2 && Character.isDigit(text.charAt(i+2))){
                        z = y;
                        y = x;
                        x = Character.getNumericValue(text.charAt(i+2));
                    }
                }
                c = 100 * z + 10 * y + x;
                if (c == 0){
                    text = text.replaceFirst(Integer.toString(c),"zero ");
                }else {

                    v = 10 * y + x;

                    if (v < 20 && v > 10) {
                        text = text.replaceFirst(Integer.toString(c), setki[z] + nastki[x]);
                    } else {
                        text = text.replaceFirst(Integer.toString(c), setki[z] + dziesiątki[y] + jedności[x]);
                    }
                }
            }
            if (i < text.length()-1 && text.charAt(i) == ',' && Character.isDigit(text.charAt(i + 1))) {
                y = Character.getNumericValue(text.charAt(i + 1));
                if (i < text.length() - 2 && Character.isDigit(text.charAt(i + 2))) {
                    x = Character.getNumericValue(text.charAt(i + 2));
                    check = true;
                }
                c = 10 * y + x;
                if (c == 0){
                    text = text.replaceFirst("," + Integer.toString(c),"");
                }else {

                    if (c < 20 && c > 10) {
                        text = text.replaceFirst("," + Integer.toString(c), "i " + nastki[x] + "setnych");
                    } else {
                        if(check)
                            text = text.replaceFirst("," + Integer.toString(c), "i " + dziesiątki[y] + jedności[x] + "setnych");
                        else
                            text = text.replaceFirst("," + Integer.toString(c/10), "i " + dziesiątki[y] + jedności[x] + "setnych");
                    }
                }
            }
        }
        text = text.replaceFirst("0", "");

        return text;
    }

}
