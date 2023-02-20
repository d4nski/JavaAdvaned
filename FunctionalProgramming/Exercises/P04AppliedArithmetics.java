package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> adding = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplying = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtracting = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printing = list -> {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        };
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    inputList = adding.apply(inputList);
                    break;
                case "multiply":
                    inputList = multiplying.apply(inputList);
                    break;
                case "subtract":
                    inputList = subtracting.apply(inputList);
                    break;
                case "print":
                    printing.accept(inputList);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
