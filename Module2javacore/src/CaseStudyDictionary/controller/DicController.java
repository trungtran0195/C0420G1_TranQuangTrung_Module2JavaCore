package CaseStudyDictionary.controller;

import CaseStudyDictionary.model.Example;
import CaseStudyDictionary.model.Word;
import CaseStudyDictionary.service.ScannerUtils;

import java.io.IOException;
import java.util.ArrayList;

import static com.sun.tools.javac.util.StringUtils.toLowerCase;

public class DicController {
    public static void addNewWord(String result) {
        ArrayList<Example> listNounExample = new ArrayList<>();
        ArrayList<Example> listAdjectiveExample = new ArrayList<>();
        ArrayList<Example> listVerbExample = new ArrayList<>();
        ArrayList listSynonymous = new ArrayList();
        Word word = new Word();
        word.setWord(result);
        System.out.println("Enter pronoun:");
        word.setPronoun(ScannerUtils.scanner.nextLine());
        System.out.println("Enter noun:");
        word.setNoun(ScannerUtils.scanner.nextLine());
        while (true){
            System.out.println("Enter noun example:");
            String nounExample = ScannerUtils.scanner.nextLine();
            if(!"".equals(nounExample)){
                System.out.println("Enter meaning: ");
                String meaning = ScannerUtils.scanner.nextLine();
                Example example = new Example();
                example.setExample(nounExample);
                example.setExampleMeaning(meaning);
                listNounExample.add(example);
            }else {
                word.setNounEx(listNounExample);
                break;
            }
        }
        System.out.println("Enter adjective:");
        word.setAdjective(ScannerUtils.scanner.nextLine());
        while (true){
            System.out.println("Enter adjective example:");
            String adjectiveExample = ScannerUtils.scanner.nextLine();
            if(!"".equals(adjectiveExample)){
                System.out.println("Enter meaning: ");
                String meaning = ScannerUtils.scanner.nextLine();
                Example example = new Example();
                example.setExample(adjectiveExample);
                example.setExampleMeaning(meaning);
                listAdjectiveExample.add(example);
            }else {
                word.setAdjectiveEx(listAdjectiveExample);
                break;
            }
        }
        System.out.println("Enter verb:");
        word.setVerb(ScannerUtils.scanner.nextLine());
        while (true){
            System.out.println("Enter verb example:");
            String verbExample = ScannerUtils.scanner.nextLine();
            if(!"".equals(verbExample)){
                System.out.println("Enter meaning: ");
                String meaning = ScannerUtils.scanner.nextLine();
                Example example = new Example();
                example.setExample(verbExample);
                example.setExampleMeaning(meaning);
                listVerbExample.add(example);
            } else{
                word.setVerbEx(listVerbExample);
                break;
            }
        }
        while (true){
            System.out.println("Enter synonymous:");
            String synonymous = ScannerUtils.scanner.nextLine();
            if (!"".equals(synonymous)){
                listSynonymous.add(synonymous);
            }else {
                word.setSynonymous(listSynonymous);
                break;
            }
        }

    WriteAndReadFile.outputWord(word);
        System.out.println("Input new word:" +word.getWord());
        MainController.backMainMenu();
    }

    public static void defineWord() {
        System.out.println("Enter word:");
        String search = ScannerUtils.scanner.nextLine();
        try {
            ArrayList<Word> listWord = WriteAndReadFile.inputWord();
            for (int i = 0; i<listWord.size();i++){
                if (toLowerCase(search).equals(toLowerCase(listWord.get(i).getWord()))){
                    listWord.get(i).showInfo();
                }else {
                    System.out.println("Word not found ! Create new ones!");
                    addNewWord(search);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("không có dữ liệu yêu cầu nhập mới");
            DicController.addNewWord(search);
        }
    }

    public static void editWord() {
        System.out.println("Enter word:");
        String search = ScannerUtils.scanner.nextLine();
        try {
            ArrayList<Word> listWord = WriteAndReadFile.inputWord();
            for (int i = 0; i<listWord.size();i++){
                if (toLowerCase(search)  == toLowerCase(listWord.get(i).getWord())){
                    ArrayList<Example> listNounExample = new ArrayList<>();
                    ArrayList<Example> listAdjectiveExample = new ArrayList<>();
                    ArrayList<Example> listVerbExample = new ArrayList<>();
                    ArrayList listSynonymous = new ArrayList();

                    while (true){
                        System.out.println("Enter noun example:");
                        String nounExample = ScannerUtils.scanner.nextLine();
                        if (!"".equals(nounExample)){
                            System.out.println("Enter meaning: ");
                            String meaning = ScannerUtils.scanner.nextLine();
                            Example example = new Example();
                            example.setExample(nounExample);
                            example.setExampleMeaning(meaning);
                            listNounExample.add(example);
                        } else{
                            listWord.get(i).setNounEx(listNounExample);
                            break;
                        }
                    }

                    while (true){
                        System.out.println("Enter adjective example:");
                        String adjectiveExample = ScannerUtils.scanner.nextLine();
                        if(!"".equals(adjectiveExample)){
                            System.out.println("Enter meaning: ");
                            String meaning = ScannerUtils.scanner.nextLine();
                            Example example = new Example();
                            example.setExample(adjectiveExample);
                            example.setExampleMeaning(meaning);
                            listAdjectiveExample.add(example);
                        }else {
                            listWord.get(i).setAdjectiveEx(listAdjectiveExample);
                            break;
                        }
                    }

                    while (true){
                        System.out.println("Enter verb example:");
                        String verbExample = ScannerUtils.scanner.nextLine();
                        if(!"".equals(verbExample)){
                            System.out.println("Enter meaning: ");
                            String meaning = ScannerUtils.scanner.nextLine();
                            Example example = new Example();
                            example.setExample(verbExample);
                            example.setExampleMeaning(meaning);
                            listVerbExample.add(example);
                        }else {listWord.get(i).setVerbEx(listVerbExample);
                            break;}
                    }
                    while (true){
                        System.out.println("Enter synonymous:");
                        String synonymous = ScannerUtils.scanner.nextLine();
                        if (!"".equals(synonymous)){
                            listSynonymous.add(synonymous);
                        }else{  listWord.get(i).setSynonymous(listSynonymous);
                            break;}
                    }

                    WriteAndReadFile.outputWordNotAppend(listWord);
                    MainController.backMainMenu();
                }else {
                    System.out.println("Word not found ! Create new ones!");
                    addNewWord(search);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void dropWord() {
        System.out.println("Enter delete word:");
        String delete = ScannerUtils.scanner.nextLine();
        try {
            ArrayList<Word> listWord = WriteAndReadFile.inputWord();
            for (int i = 0; i<listWord.size();i++){
                if (toLowerCase(delete)  == toLowerCase(listWord.get(i).getWord())){
                    listWord.remove(i);
                    WriteAndReadFile.outputWordNotAppend(listWord);
                    MainController.backMainMenu();
                }else {
                    System.out.println("Word not found !");
                    MainController.backMainMenu();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
