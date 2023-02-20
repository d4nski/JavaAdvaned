package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, numbers) -> {
            for (int integer : numbers) {
                if (number % integer != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int i = 1; i <= n; i++) {
            if (isDivisible.apply(i, inputList)) {
                System.out.print(i + " ");
            }
        }
    }
}
