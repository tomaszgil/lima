package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


/**
 * This class is controller which handle POST and GET request
 * path /normal means that we are expecting input in text format.
 *
 * @author  Kamil Kołodziej
 */

@RestController
@RequestMapping("/normal")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    /**
     * This method handle GET request
     * @param text - user input which needs to be transformed
     * @param transforms - one or sequence of transformation required from user
     * @return text after transformations
     */
    @RequestMapping(path = "/{text}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper") String[] transforms) {

        logger.debug("Text to transform: " + text);
        logger.debug("List of transformation: " + Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    /**
     * This method handle POST request
     * @param text - user input which needs to be transformed
     * @param transforms - one or sequence of transformation required from user
     * @return text after transformations
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {


        logger.debug("Text to transform: " + text);
        logger.debug("List of transformation: " + Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
}
