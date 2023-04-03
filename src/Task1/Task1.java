package Task1;

import java.io.*;
import java.util.*;


public class Task1{

    private static final String PHONE_REGEX_1 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
    private static final String PHONE_REGEX_2 = "\\d{3}-\\d{3}-\\d{4}";

    public static void main(String[] args) {
        String fileName = "src/Task1/Phones.txt";
        Map<String, Integer> phoneMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches(PHONE_REGEX_1) || line.matches(PHONE_REGEX_2)) {
                    phoneMap.put(line, phoneMap.getOrDefault(line, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}