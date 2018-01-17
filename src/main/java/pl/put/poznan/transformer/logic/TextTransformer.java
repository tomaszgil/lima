package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.rest.JsonTransformerController;

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
    private static final Logger logger = LoggerFactory.getLogger(TextTransformer.class);

    private final String[] transforms;
    private TextTransformerAbbreviation textTransformerAbbreviation;
    private TextTransformerInverse textTransformerInverse;
    private TextTransformerLetterSize textTransformerLetterSize;
    private TextTransformerLatex textTransformerLatex;
    private TextTransformerNumbers textTransformerNumbers;
    private TextTransformerRepetition textTransformerRepetition;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
        this.textTransformerAbbreviation = new TextTransformerAbbreviation();
        this.textTransformerInverse = new TextTransformerInverse();
        this.textTransformerLetterSize = new TextTransformerLetterSize();
        this.textTransformerLatex = new TextTransformerLatex();
        this.textTransformerNumbers = new TextTransformerNumbers();
        this. textTransformerRepetition = new TextTransformerRepetition();
    }

    /**
     * This method invokes all of the transformations in a given order.
     * @param text input which needs to be transformed
     * @return text after list of transformations
     */
    public String transform(String text){
        for(int i=0; i<transforms.length; i++)
        {
            if(transforms[i].contains("fromabbreviation")){
                text = textTransformerAbbreviation.fromAbbreviation(text);
            }
            if(transforms[i].contains("toabbreviation")){
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
            if(transforms[i].contains("numbers")){
                text = textTransformerNumbers.toText(text);
            }
            if(transforms[i].contains("repetitions")){
                text = textTransformerRepetition.deleteRepetitions(text);
            }
            logger.debug("Text after " + (i+1) + " transform: " + text);
        }

        logger.debug("Final form: " + text);
        return text;
    }
}
