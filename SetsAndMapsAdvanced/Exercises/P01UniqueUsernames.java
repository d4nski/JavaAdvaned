package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> stringSet = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();
            stringSet.add(word);
        }
        for (String s : stringSet) {
            System.out.println(s);
        }
    }
}
