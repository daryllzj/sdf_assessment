package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // all text files are kept in dir "text"
        String dirPath = "text";
        
        // takes in filename as argument
        String textName = args[0];

        // checks if file exist
        File textFile = new File(dirPath + File.separator + textName);
        if (textFile.exists()) {
            System.out.println("file exists \n");   
        } else {
            System.out.println("file does not exist");
        }

        List<String> textWithoutPunctuations = new ArrayList<>();

        // read the file
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(fr);
        String line;

        // continues to read each line of text until null
        while (((line = br.readLine())!= null)) {
            // removes punctuation with regex
            String clean = line.replaceAll("\\p{P}", "");
            // splits each work via the space
            String[] cleanWords = clean.toLowerCase().split(" ");
            // adds each word into the list
            for (String string : cleanWords) {
                if (!string.trim().equals(" ")) {
                    textWithoutPunctuations.add(string.trim());
                }
                
            }
        }

        // create a hashmap
        Map<String, Integer> wordCount = new HashMap<>();

        // loop through each string to see if there is a key-value pair
        for (String string : textWithoutPunctuations) {
            Integer count = wordCount.get(string);
            if (count == null) {
                wordCount.put(string, 1);
            } else {
                wordCount.put(string, wordCount.get(string)+1);
            }
        }

        // put hashmap into an array
       List <Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        // sort hashmap
       Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

        @Override
        public int compare(java.util.Map.Entry<String, Integer> o1, java.util.Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
            
       });

       // print out results
       System.out.println("--- Word Ranking <Highest to Lowest> ---");

        for (Map.Entry<String,Integer> entry : list) {
            System.out.println("Word : " + entry.getKey() + " ; " + "Term Frequency : " + entry.getValue().floatValue()/list.size());
        }




        





        




        


        




    }
}