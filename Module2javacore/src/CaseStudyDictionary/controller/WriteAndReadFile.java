package CaseStudyDictionary.controller;

import CaseStudyDictionary.model.Word;
import CaseStudyDictionary.service.ScannerUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteAndReadFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String OPEN = "(";
    private static final String CLOSE = "(";
    private static final String filepath = "src\\CaseStudyDictionary\\data\\dictionary.def";
    private static final String csvpath = "src\\CaseStudyDictionary\\data\\textDictionary.csv";

    public static void outputWord(Word word) {
        try{
        if (!Files.exists(Paths.get(filepath))) {
            ArrayList<Word> listWord = new ArrayList<>();
            Files.createFile(Paths.get(filepath));
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            listWord.add(word);
            oo.writeObject(listWord);
        } else {
            ArrayList<Word> listWord;
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream o = new ObjectInputStream(fis);
            listWord = (ArrayList<Word>) o.readObject();
            listWord.add(word);
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            oo.writeObject(listWord);
        }
        }catch (IOException io){
            System.out.println(io.getMessage());
            outputWordNotAppend(word);
        } catch (ClassNotFoundException co){
            System.out.println(co.getMessage());
        }
    }

    private static void outputWordNotAppend(Word word) {
        try {
            ArrayList<Word> listWord = new ArrayList<>();
            FileOutputStream fos = null;
            fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            listWord.add(word);
            oo.writeObject(listWord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void outputWordToCsv(){
        try {
        FileInputStream fis =  new FileInputStream(filepath);
        ObjectInputStream o = new ObjectInputStream(fis);
        ArrayList<Word> listWord = (ArrayList<Word>) o.readObject();
        for (int i = 0; i < listWord.size(); i++){
            wordToCsv(listWord.get(i),true);
        }
    }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Word> inputWord() throws ClassNotFoundException, IOException{
        if (!Files.exists(Paths.get(filepath))) {
            Files.createFile(Paths.get(filepath));
        }
        FileInputStream fis =  new FileInputStream(filepath);
        ObjectInputStream o = new ObjectInputStream(fis);
        ArrayList<Word> listWord = (ArrayList<Word>) o.readObject();
        return listWord;
    }

    public static void outputWordNotAppend(ArrayList<Word> listWord) {
        try{
            if (!Files.exists(Paths.get(filepath))) {
                Files.createFile(Paths.get(filepath));
            }
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            oo.writeObject(listWord);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void wordToCsv(Word word, boolean append) {
        try{
            if (!Files.exists(Paths.get(csvpath))){
                Files.createFile(Paths.get(csvpath));
            }
            FileWriter fileWriter = new FileWriter(csvpath, append);
            StringBuffer buffer = new StringBuffer();
            buffer.append(NEW_LINE_SEPARATOR);
            buffer.append(word.getWord()).append(COMMA_DELIMITER);
            buffer.append(word.getNoun()).append(COMMA_DELIMITER);
            for (int i = 0; i< word.getNounEx().size();i++){
                buffer.append(word.getNounEx().get(i).getExample()).append(OPEN);
                buffer.append(word.getNounEx().get(i).getExampleMeaning()).append(CLOSE);
                buffer.append(COMMA_DELIMITER);
            }
            buffer.append(word.getAdjective()).append(COMMA_DELIMITER);
            for (int i = 0; i < word.getAdjectiveEx().size() ; i++){
                buffer.append(word.getAdjectiveEx().get(i).getExample()).append(OPEN);
                buffer.append(word.getAdjectiveEx().get(i).getExampleMeaning()).append(CLOSE);
                buffer.append(COMMA_DELIMITER);
            }
            buffer.append(word.getVerb()).append(COMMA_DELIMITER);
            for (int i = 0; i< word.getVerbEx().size();i++){
                buffer.append(word.getVerbEx().get(i).getExample()).append(OPEN);
                buffer.append(word.getVerbEx().get(i).getExampleMeaning()).append(CLOSE);
                buffer.append(COMMA_DELIMITER);
            }
            buffer.append(OPEN);
            for (int i =0 ; i<word.getSynonymous().size();i++) {
                buffer.append(word.getSynonymous().get(i));
                buffer.append(COMMA_DELIMITER);
            }
            buffer.append(CLOSE);

            fileWriter.append(buffer.toString());
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}