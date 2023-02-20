package SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> charMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!charMap.containsKey(currentChar)) {
                charMap.put(currentChar, 1);

            } else {
                int currentCount = charMap.get(currentChar);
                charMap.put(currentChar, currentCount + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
