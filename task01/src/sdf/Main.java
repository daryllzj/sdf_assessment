package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // all text files are kept in dir "text"
        String dirPath = "text";
        
        // takes in filename as argument
        String textName = args[0];

        // checks if file exist
        File textFile = new File(dirPath + File.separator + textName);
        if (textFile.exists()) {
            System.out.println("file exists");   
        } else {
            System.out.println("file does not exist");
        }

        // create a new array to store words without punctuations
        List<String> textWithoutPunctuations = new ArrayList<>();

        try {

            // read the file
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(fr);
        String line;

        // continues to read each line of text until null
        while (((line = br.readLine())!= null)) {
            // removes punctuation with regex
            String clean = line.strip().replaceAll("\\p{P}", "");
            // splits each work via the space
            String[] cleanWords = clean.trim().toLowerCase().split(" ");
            // adds each word into the list
            for (String string : cleanWords) {
                if (!string.equals(" ")) {
                    textWithoutPunctuations.add(string.trim());
                }
                
            }
        }

        br.close();
        fr.close();

        // create a hashmap
        Map<String, Integer> wordCount = new HashMap<>();

        // loop through each string to see if there is a key-value pair
        for (String string : textWithoutPunctuations) {
            Integer count = wordCount.get(string);
            // if there is no value to the key, add 1 to value
            if (count == null) {
                wordCount.put(string, 1);
            } else {
                // if there is a value for key, increment by 1
                wordCount.put(string, wordCount.get(string)+1);
            }
        }

        // put hashmap into an array list
       List <Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        // sort hashmap based on value
       Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

        @Override
        public int compare(java.util.Map.Entry<String, Integer> o1, java.util.Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
            
       });

       // print out results
       System.out.println("\n--- Top 10 Words Ranking <Highest to Lowest> ---");

       // copy top 10 key value pairs to a new list
        List<Map.Entry<String,Integer>> top10 = list.stream().limit(10).collect(Collectors.toList());

        // for each pair in list, print out result
        for (Map.Entry<String,Integer> entry : top10) {
            System.out.println("Word: " + entry.getKey() + "; Count: " + entry.getValue()+ "; Term Frequency: " + String.format("%.4f", entry.getValue().floatValue()/textWithoutPunctuations.size()) );
        }
        System.out.println("--- Thank you. Please pass me ---\n");
            
        } catch (Exception e) {
            System.out.println("please put text file in directory 'text'");
        }

        

        




        





        




        


        




    }
}