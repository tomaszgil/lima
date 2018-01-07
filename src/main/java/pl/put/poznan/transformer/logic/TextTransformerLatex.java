package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;


/**
 * This class consists of a method exchanging certain characters in string
 * to a format supported by Latex.

 * @author  Kinga Neumann
 */
public class TextTransformerLatex {

    /**
     * Map property is used to store collection of supported characters
     * with their Latex equivalents.
     */
    private Map<String,String> map;

    public TextTransformerLatex(){
        this.map = new HashMap<String, String>();
        this.map.put("\\%","\\%");        
        this.map.put("\\_","\\_");
        this.map.put("\\{","\\{");
        this.map.put("\\}","\\}");
        this.map.put("\\#","\\#");
        this.map.put("\\&","\\&");
        this.map.put("\\$","\\$");
    }

    /**
     * This method is used for swapping characters to match Latex standards.
     *
     * @param text text which we want have specified characters swapped
     * @return text with Latex characters
     */
    public String toLatex(String text){

        for (Map.Entry<String,String> entry: this.map.entrySet()) {
            text = text.replaceAll(entry.getKey(), Matcher.quoteReplacement(entry.getValue()));
        }
        return text;
    }

}
