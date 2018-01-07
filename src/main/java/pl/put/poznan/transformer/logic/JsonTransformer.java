package pl.put.poznan.transformer.logic;

public  class JsonTransformer {

    private String text;
    private String [] transforms;

    public JsonTransformer(){}

    public JsonTransformer(String [] transforms, String text) {
        TextTransformer textTransformer = new TextTransformer(transforms);
        this.text = textTransformer.transform(text);
        this.transforms = transforms;
    }

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
