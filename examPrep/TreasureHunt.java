package examPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRowsCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputRowsCols[0]);
        int cols = Integer.parseInt(inputRowsCols[1]);

        char[][] field = new char[rows][cols];
        int playerRow = 0;
        int playerCol = 0;

        for (int r = 0; r < rows; r++) {
            char[] input = scanner.nextLine().replace(" ", "").toCharArray();
            for (int lng = 0; lng < input.length; lng++) {
                field[r][lng] = input[lng];
                if (field[r][lng] == 'Y') {
                    playerRow = r;
                    playerCol = lng;
                }

            }
        }
        boolean isFound = false;
        List<String> steps = new ArrayList<>();
        String commands = scanner.nextLine();
        while (true) {
            if (commands.equals("up")) {
                int possiblePosition = playerRow - 1;
                if (possiblePosition >= 0) {
                    if (field[possiblePosition][playerCol] != 'T') {
                        playerRow = possiblePosition;
                        steps.add(commands);
                    }
                }
            } else if (commands.equals("down")) {
                int possiblePosition = playerRow + 1;
                if (possiblePosition <= rows - 1) {
                    if (field[possiblePosition][playerCol] != 'T') {
                        playerRow = possiblePosition;
                        steps.add(commands);
                    }
                }
            } else if (commands.equals("right")) {
                int possiblePosition = playerCol + 1;
                if (possiblePosition <= cols - 1) {
                    if (field[playerRow][possiblePosition] != 'T') {
                        playerCol = possiblePosition;
                        steps.add(commands);
                    }
                }
            } else if (commands.equals("left")) {
                int possiblePosition = playerCol - 1;
                if (possiblePosition >= 0) {
                    if (field[playerRow][possiblePosition] != 'T') {
                        playerCol = possiblePosition;
                        steps.add(commands);
                    }
                }
            } else if (commands.equals("Finish")) {
                if (field[playerRow][playerCol] == 'X') {
                    isFound = true;
                    break;
                }
                break;
            }

            commands = scanner.nextLine();
        }
        if (isFound) {
            System.out.println("I've found the treasure!");
            String output = steps.toString();
            System.out.println("The right path is " + output.replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
