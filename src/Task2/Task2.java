package Task2;

import java.io.*;
import java.util.*;


public class Task2 {
    public static void main(String[] args) {
        String fileName = "src/Task2/Info.txt";
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String header = reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                userList.add(new User(name, age));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer = new FileWriter("user.json")) {
            writer.write("[\n");
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                String json = "{\n"
                        + "    \"name\": \"" + user.name + "\",\n"
                        + "    \"age\": " + user.age + "\n"
                        + "}";
                if (i < userList.size() - 1) {
                    json += ",\n";
                }
                writer.write(json);
            }
            writer.write("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}