package examPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLiquid = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputIngredient = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : inputLiquid) {
            queue.offer(i);
        }
        for (int i : inputIngredient) {
            stack.push(i);
        }
        int biscuits = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int stackNumber = stack.pop();
            int queueNumber = queue.poll();


            int combine = stackNumber + queueNumber;

            if (combine == 25) {
                biscuits++;
            } else if (combine == 50) {
                cake++;
            } else if (combine == 75) {
                pastry++;
            } else if (combine == 100) {
                pie++;
            } else {
                stack.push(stackNumber + 3);
            }

        }
        if (biscuits > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (queue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            int now = 0;
            int size = queue.size();
            for (Integer integer : queue) {
                if (now == size - 1) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
                now++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            int now = 0;
            int size = stack.size();
            for (Integer integer : stack) {
                if (now == size - 1) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
                now++;
            }
        }
        System.out.printf("Biscuit: %d\nCake: %d\nPie: %d\nPastry: %d", biscuits, cake, pie, pastry);
    }
}
