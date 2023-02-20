package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 1; i <= intArr[0]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            firstSet.add(num);
        }

        for (int i = 1; i <= intArr[1]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            secondSet.add(num);
        }
        firstSet.retainAll(secondSet);
        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }

    }
}
