package pl.put.poznan.transformer.logic;

/**
 * This class invokes transforms on given string
 * and return a result in a String format for
 * normal path.
 *
 * @author Kamil Kołodziej
 */
public class TextTransformer {

    /**
     * Transforms list keep all the transformations that needs to be
     * invoked on a given string.
     */
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

    /**
     * This method invokes all of the transformations in a given order.
     * @param text input which needs to be transformed
     * @return text after list of transformations
     */
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
