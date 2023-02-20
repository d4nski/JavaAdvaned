package FunctionalProgramming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String[]> printNames = array -> {
            for (String s : array) {
                System.out.println(s);
            }
        };

        printNames.accept(input);
    }
}
