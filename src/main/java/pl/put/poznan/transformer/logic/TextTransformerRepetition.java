package pl.put.poznan.transformer.logic;

/**
 * This class consists of method that eliminates
 * repetitions in text.
 *
 * @author  Miłosz Pogodski
 */
public class TextTransformerRepetition {

    /**
     * This method is used to join String array.
     *
     * @param strings text which we want to join.
     * @param separator separator used between texts fragments.
     * @return joined text.
     */
    public static String joinString(String[] strings, String separator) {
        if(strings.length == 0) return "";
        if(strings.length == 1) return strings[0];
        StringBuilder sb = new StringBuilder();
        sb.append(strings[0]);
        for(int i = 1; i < strings.length; i++) {
            sb.append(separator);
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    /**
     * This method is used to delete repetitions in text.
     *
     * @param text text which we want have repetitions removed.
     * @return text with repetitions removed.
     */
    public String deleteRepetitions(String text){

        String[] parts = text.split(" ");
        for (int i = 0; i < parts.length - 1; i++){
            if (parts[i].equals(parts[i+1]))
                parts[i] = "";
        }

        return joinString(parts," ");
    }
}
