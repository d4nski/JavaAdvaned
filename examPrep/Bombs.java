package examPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> stack = new ArrayDeque<>();
        int[] inputStack = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : inputStack) {
            stack.push(i);
        }


        int countDatura = 0;
        int countCherry = 0;
        int countSmoke = 0;
        boolean isFilled = false;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int effect = queue.peek();
            int casing = stack.peek();
            int sum = effect + casing;

            if (sum == 60) {
                countCherry++;
                queue.poll();
                stack.pop();
            } else if (sum == 40) {
                countDatura++;
                queue.poll();
                stack.pop();
            } else if (sum == 120) {
                countSmoke++;
                queue.poll();
                stack.pop();
            } else {
                int current = stack.pop();
                stack.push(current - 5);
            }
            if (countDatura >= 3 && countCherry >= 3 && countSmoke >= 3) {
                isFilled = true;
                break;
            }
        }

        if (isFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            int size = queue.size();
            int now = 0;
            for (Integer integer : queue) {
                now++;
                if (now == size) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
            }
        }

        System.out.print("Bomb Casings: ");
        if (stack.isEmpty()) {
            System.out.println("empty");
        } else {
            int size = stack.size();
            int now = 0;
            for (Integer integer : stack) {
                now++;
                if (now == size) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
            }
        }
        System.out.println("Cherry Bombs: " + countCherry);
        System.out.println("Datura Bombs: " + countDatura);
        System.out.println("Smoke Decoy Bombs: " + countSmoke);

    }
}
