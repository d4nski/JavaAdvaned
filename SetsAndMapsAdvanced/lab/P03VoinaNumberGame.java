package SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerSet = new LinkedHashSet<>();
        Set<Integer> secondPlayerSet = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            int number = scanner.nextInt();
            firstPlayerSet.add(number);
        }
        for (int i = 0; i < 20; i++) {
            int number = scanner.nextInt();
            secondPlayerSet.add(number);
        }
        int rounds = 1;
        int one = 0;
        int two = 0;
        while (!firstPlayerSet.isEmpty() || !secondPlayerSet.isEmpty()) {
            if (rounds >= 50) {
                break;
            }
            for (Integer integer : firstPlayerSet) {
                one = integer;
                firstPlayerSet.remove(integer);
                break;
            }
            for (Integer integer : secondPlayerSet) {
                two = integer;
                secondPlayerSet.remove(integer);
                break;
            }
            if (one > two) {
                firstPlayerSet.add(one);
                firstPlayerSet.add(two);
            } else if (two > one) {
                secondPlayerSet.add(one);
                secondPlayerSet.add(two);
            }
            rounds++;
        }
        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerSet.size() > firstPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
