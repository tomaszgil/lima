package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonTransformer;

import java.util.Arrays;

/**
 * This class is controller which handle POST and GET request
 * path /json means that we are expecting input in JSON format.
 *
 * @author  Kamil Kołodziej
 */
@RestController
@RequestMapping("/json")
public class JsonTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(JsonTransformerController.class);


    /**
     * This method handle GET request
     * @param text - user input which needs to be transformed
     * @param transforms - one or sequence of transformation required from user
     * @return JSON Object with text after transformations
     */
    @RequestMapping(path = "/{text}", produces = "application/json")
    public JsonTransformer jsonTransformer(@PathVariable String text,
                               @RequestParam(value="transforms", defaultValue="upper") String[] transforms) {

        logger.debug("Text to transform: " + text);
        logger.debug("List of transformation: " + Arrays.toString(transforms));

        return new JsonTransformer(transforms, text);
    }

    /**
     * This method handle POST request
     * @param jsonTransformer - user input text and transformations in JSON format
     * @return JSON Object with text after transformations
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public JsonTransformer jsonTransformerInput(@RequestBody JsonTransformer jsonTransformer) {

        logger.debug("Text to transform: " + jsonTransformer.getText());
        logger.debug("List of transformation: " + Arrays.toString(jsonTransformer.getTransforms()));
        return new JsonTransformer(jsonTransformer);
    }
}
