package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;


/**
 * This class is controller which handle POST and GET request
 * path /normal means that we are expecting input in text format.
 *
 * @author  Kamil Kołodziej
 */

@RestController
@RequestMapping("/normal")
public class TextTransformerController {

    /**
     * This method handle GET request
     * @param text - user input which needs to be transformed
     * @param transforms - one or sequence of transformation required from user
     * @return text after transformations
     */
    @RequestMapping(path = "/{text}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper") String[] transforms) {

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


        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
}
