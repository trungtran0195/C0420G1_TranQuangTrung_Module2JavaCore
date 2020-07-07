package CaseStudyDictionary.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
    private String word;
    private String pronoun;
    private String noun;
    private ArrayList<Example> nounEx;
    private String adjective;
    private ArrayList<Example> adjectiveEx;
    private String verb;
    private ArrayList<Example> verbEx;
    private ArrayList synonymous;

    public Word() {
    }

    public Word(String word, String pronoun, String noun, ArrayList<Example> nounEx, String adjective, ArrayList<Example> adjectiveEx, String verb, ArrayList<Example> verbEx, ArrayList synonymous) {
        this.word = word;
        this.pronoun = pronoun;
        this.noun = noun;
        this.nounEx = nounEx;
        this.adjective = adjective;
        this.adjectiveEx = adjectiveEx;
        this.verb = verb;
        this.verbEx = verbEx;
        this.synonymous = synonymous;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public ArrayList<Example> getNounEx() {
        return nounEx;
    }

    public void setNounEx(ArrayList<Example> nounEx) {
        this.nounEx = nounEx;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public ArrayList<Example> getAdjectiveEx() {
        return adjectiveEx;
    }

    public void setAdjectiveEx(ArrayList<Example> adjectiveEx) {
        this.adjectiveEx = adjectiveEx;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public ArrayList<Example> getVerbEx() {
        return verbEx;
    }

    public void setVerbEx(ArrayList<Example> verbEx) {
        this.verbEx = verbEx;
    }

    public ArrayList getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(ArrayList synonymous) {
        this.synonymous = synonymous;
    }

    public void showInfo() {
        System.out.println("@"+this.word+
                "\n*Tính từ:"+this.adjective+
                "\nVí dụ:");
        for (int i = 0 ; i< this.adjectiveEx.size();i++){
            System.out.println("-");
            System.out.print(this.adjectiveEx.get(i).getExample());
            System.out.println("-");
            System.out.print(this.adjectiveEx.get(i).getExampleMeaning());
        }
        System.out.println("\n*Danh từ:"+this.noun+
                           "\nVí dụ:");
        for (int i = 0 ; i< this.nounEx.size();i++){
            System.out.println("-");
            System.out.print(this.nounEx.get(i).getExample());
            System.out.println("-");
            System.out.print(this.nounEx.get(i).getExampleMeaning());
        }
        System.out.println("\n*Động từ:"+this.verb+
                "\nVí dụ:");
        for (int i = 0 ; i< this.verbEx.size();i++){
            System.out.println("-");
            System.out.print(this.verbEx.get(i).getExample());
            System.out.println("-");
            System.out.print(this.verbEx.get(i).getExampleMeaning());
        }
        System.out.println("\n*Tương đồng:");
        for (int i = 0 ; i< this.synonymous.size();i++){
            System.out.println("-");
            System.out.print(this.synonymous.get(i));
        }

    }
}
