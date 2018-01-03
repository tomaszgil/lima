package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class TextTransformerAbbreviation {

    private final String[] transforms;
    private Map<String,String> map;

    public TextTransformerAbbreviation(String[] transforms){
        this.transforms = transforms;
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

    public String toAbbreviation(String text){
        // shorten

        for(Map.Entry<String,String> entry : this.map.entrySet()){
            text=text.replaceAll(entry.getKey(),entry.getValue());
        }
        return text;
    }

    public String fromAbbreviation(String text){
        // expand

        for(Map.Entry<String,String> entry : this.map.entrySet()){
            text=text.replaceAll(entry.getValue(),entry.getKey());
        }
        return text;
    }

}
