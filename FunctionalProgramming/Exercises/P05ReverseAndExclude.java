package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(inputArr);

        inputArr.removeIf(e -> e % n == 0);
        Consumer<List<Integer>> printList = e -> {
            for (Integer integer : e) {
                System.out.print(integer + " ");
            }

        };
        printList.accept(inputArr);

    }
}
