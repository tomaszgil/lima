package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class TextTransformerLatex {

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

    public String toLatex(String text){

        for (Map.Entry<String,String> entry: this.map.entrySet()) {
            text = text.replaceAll(entry.getKey(), Matcher.quoteReplacement(entry.getValue()));
        }
        return text;
    }

}
