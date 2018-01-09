package pl.put.poznan.transformer.logic;

/**
 * This class invokes transforms on given string
 * and return a result in a JSON format for
 * json path.
 *
 * @author Kamil Kołodziej
 */
public  class JsonTransformer {

    /**
     * Text String keep the input at first and then is overwritten by
     * result of next transformations from transforms list.
     */
    private String text;
    private String [] transforms;

    public JsonTransformer(){}

    /**
     * This method creates JSON Object for GET requests by
     * invoking sequence of transformation on given String.
     */
    public JsonTransformer(String [] transforms, String text) {
        TextTransformer textTransformer = new TextTransformer(transforms);
        this.text = textTransformer.transform(text);
        this.transforms = transforms;
    }

    /**
     * This method creates Json Object for POST requests by
     * invoking sequence of transformation on given JSON Object.
     */
    public JsonTransformer(JsonTransformer jsonTransformer){
        TextTransformer textTransformer = new TextTransformer(jsonTransformer.getTransforms());
        this.transforms = jsonTransformer.getTransforms();
        this.text = textTransformer.transform(jsonTransformer.getText());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTransforms() {
        return transforms;
    }

    public void setTransforms(String[] transforms) {
        this.transforms = transforms;
    }
}
