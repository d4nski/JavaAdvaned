package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mapA = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                mapA.putIfAbsent(name, email);
            }

            name = scanner.nextLine();
        }
        for (String s : mapA.keySet()) {
            System.out.println(s + " -> " + mapA.get(s));
        }
    }
}
