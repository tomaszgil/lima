package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * This class consists of methods used for expanding and shortening
 * given abbreviations, specified a map.
 *
 * @author  Miłosz Pogodski
 */
public class TextTransformerAbbreviation {

    /**
     * Map property is used to store collection of supported abbreviations
     * with their expanded forms.
     */
    private Map<String,String> map;

    public TextTransformerAbbreviation(){
        this.map = new HashMap<String, String>();

        this.map.put("profesor","prof\\.");
        this.map.put("Profesor","Prof\\.");
        this.map.put("doktor","dr");
        this.map.put("Doktor","Dr");
        this.map.put("na przykład","np\\.");
        this.map.put("Na przykład","Np\\.");
        this.map.put("i tym podobne","itp\\.");
        this.map.put("I tym podobne","Itp\\.");
    }

    /**
     * This method is used for shortening supported words.
     *
     * @param text text in which we want to have supported words shortened
     * @return text with shortened words
     */
    public String toAbbreviation(String text){
        for(Map.Entry<String,String> entry : this.map.entrySet()){
            text=text.replaceAll(entry.getKey(),entry.getValue());
        }
        return text;
    }

    /**
     * This method is used for expanding supported abbreviations.
     *
     * @param text text in which we want to have supported abbreviations expanded
     * @return text with expanded abbreviations
     */
    public String fromAbbreviation(String text){
        for(Map.Entry<String,String> entry : this.map.entrySet()){
            text=text.replaceAll(entry.getValue(),entry.getKey());
        }
        return text;
    }

}
