package SetsAndMapsAdvanced.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> stringMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            stringMap.put(name, number);

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (stringMap.containsKey(name)) {
                System.out.println(name + " -> " + stringMap.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            name = scanner.nextLine();
        }
    }
}
