package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> takeMinNum = Collections::min;

        System.out.println(takeMinNum.apply(intList));
    }
}
