package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;
    private TextTransformerAbbreviation textTransformerAbbreviation;
    private TextTransformerInverse textTransformerInverse;
    private TextTransformerLetterSize textTransformerLetterSize;
    private TextTransformerLatex textTransformerLatex;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
        this.textTransformerAbbreviation = new TextTransformerAbbreviation();
        this.textTransformerInverse = new TextTransformerInverse();
        this.textTransformerLetterSize = new TextTransformerLetterSize();
        this.textTransformerLatex = new TextTransformerLatex();
    }

    public String transform(String text){
        for(int i=0; i<transforms.length; i++)
        {
            if(transforms[i].contains("abbreviation")){
                text = textTransformerAbbreviation.fromAbbreviation(text);
                text = textTransformerAbbreviation.toAbbreviation(text);
            }
            if(transforms[i].contains("inverse")){
                text = textTransformerInverse.inverse(text);
            }
            if(transforms[i].contains("upper")){
                text = textTransformerLetterSize.upper(text);
            }
            if(transforms[i].contains("lower")){
                text = textTransformerLetterSize.lower(text);
            }
            if(transforms[i].contains("capitalize")) {
                text = textTransformerLetterSize.capitalize(text);
            }
            if(transforms[i].contains("latex")){
                text = textTransformerLatex.toLatex(text);
            }
        }

        return text;
    }
}
