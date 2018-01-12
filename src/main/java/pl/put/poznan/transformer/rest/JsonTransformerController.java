package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonTransformer;

/**
 * This class is controller which handle POST and GET request
 * path /json means that we are expecting input in JSON format.
 *
 * @author  Kamil Kołodziej
 */
@RestController
@RequestMapping("/json")
public class JsonTransformerController {

    /**
     * This method handle GET request
     * @param text - user input which needs to be transformed
     * @param transforms - one or sequence of transformation required from user
     * @return JSON Object with text after transformations
     */
    @RequestMapping(path = "/{text}", produces = "application/json")
    public JsonTransformer jsonTransformer(@PathVariable String text,
                               @RequestParam(value="transforms", defaultValue="upper") String[] transforms) {

        return new JsonTransformer(transforms, text);
    }

    /**
     * This method handle POST request
     * @param jsonTransformer - user input text and transformations in JSON format
     * @return JSON Object with text after transformations
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public JsonTransformer jsonTransformerInput(@RequestBody JsonTransformer jsonTransformer) {

        return new JsonTransformer(jsonTransformer);
    }
}
