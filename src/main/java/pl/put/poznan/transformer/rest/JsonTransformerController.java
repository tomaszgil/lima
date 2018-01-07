package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonTransformer;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;

@RestController
@RequestMapping("/json")
public class JsonTransformerController {

    @RequestMapping(path = "/{text}", produces = "application/json")
    public JsonTransformer jsonTransformer(@PathVariable String text,
                               @RequestParam(value="transforms", defaultValue="upper") String[] transforms) {

        return new JsonTransformer(transforms, text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public JsonTransformer jsonTransformerInput(@RequestBody JsonTransformer jsonTransformer) {

        return new JsonTransformer(jsonTransformer);
    }
}
