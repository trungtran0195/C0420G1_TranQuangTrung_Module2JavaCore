package CaseStudyDictionary.model;

import java.io.Serializable;

public class Example implements Serializable {
    private String example;
    private String exampleMeaning;

    public Example() {
    }

    public Example(String example, String exampleMeaning) {
        this.example = example;
        this.exampleMeaning = exampleMeaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExampleMeaning() {
        return exampleMeaning;
    }

    public void setExampleMeaning(String exampleMeaning) {
        this.exampleMeaning = exampleMeaning;
    }
}
