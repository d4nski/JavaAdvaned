package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> stringSet = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            for (int j = 0; j < inputArr.length; j++) {
                stringSet.add(inputArr[j]);
            }
        }
        for (String s : stringSet) {
            System.out.print(s + " ");
        }
    }
}
