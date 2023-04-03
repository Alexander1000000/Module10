package Task3;

import java.io.*;
import java.util.*;


public class Task3 {
    public static void main(String[] args) {
        String fileName = "src/Task3/Words.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()
                        .reversed())
                .forEach(entry -> System.out.println(entry.getKey()
                        + " " + entry.getValue()));
    }
}