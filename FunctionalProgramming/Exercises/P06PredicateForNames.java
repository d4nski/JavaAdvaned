package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] namesList = scanner.nextLine().split("\\s+");

        Predicate<String> isPassing = name -> name.length() <= n;

        Arrays.stream(namesList).filter(isPassing).forEach(System.out::println);
    }
}
