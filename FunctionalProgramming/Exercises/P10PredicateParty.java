package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            if (input.contains("Remove")) {
                if (input.contains("StartsWith")) {
                    String word = input.split("\\s+")[2];
                    for (String s : namesList) {
                        if (s.startsWith(word)) {
                            namesList.remove(s);
                            break;
                        }
                    }
                } else if (input.contains("EndsWith")) {
                    String word = input.split("\\s+")[2];
                    for (String s : namesList) {
                        if (s.endsWith(word)) {
                            namesList.remove(s);
                            break;
                        }
                    }
                } else if (input.contains("Length")) {
                    int n = Integer.parseInt(input.split("\\s+")[2]);
                    for (String s : namesList) {
                        if (s.length() == n) {
                            namesList.remove(s);
                            break;
                        }
                    }
                }

            } else {
                int count = 0;
                String name = "";
                if (input.contains("StartsWith")) {
                    String word = input.split("\\s+")[2];
                    for (String s : namesList) {
                        if (s.startsWith(word)) {
                            name = s;
                            count++;
                        }
                    }
                    for (int i = 0; i < count; i++) {
                        namesList.add(name);

                    }
                } else if (input.contains("EndsWith")) {
                    String word = input.split("\\s+")[2];
                    for (String s : namesList) {
                        if (s.endsWith(word)) {
                            name = s;
                            count++;
                        }
                    }
                    for (int i = 0; i < count; i++) {
                        namesList.add(name);

                    }
                } else if (input.contains("Length")) {
                    int n = Integer.parseInt(input.split("\\s+")[2]);
                    for (String s : namesList) {
                        if (s.length() == n) {
                            count++;
                            name = s;

                        }
                    }
                    for (int i = 0; i < count; i++) {
                        namesList.add(name);

                    }
                }
            }

            input = scanner.nextLine();
        }
        if (namesList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            namesList = namesList.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < namesList.size(); i++) {
                if (i == namesList.size() - 1) {
                    System.out.println(namesList.get(i) + " are going to the party!");
                } else {
                    System.out.print(namesList.get(i) + ", ");
                }
            }

        }
    }
}
