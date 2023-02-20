package MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputLine[j];
            }
        }
        String[] commands = scanner.nextLine().split("\\s+");
        while (!commands[0].equals("END")) {
            if (commands[0].equals("swap") && commands.length == 5) {
                int firstRow = Integer.parseInt(commands[1]);
                int firstCol = Integer.parseInt(commands[2]);
                int secondRow = Integer.parseInt(commands[3]);
                int secondCol = Integer.parseInt(commands[4]);
                if (firstRow < rows && secondRow < rows && firstCol < cols && secondCol < cols) {
                    String firstDigit = matrix[firstRow][firstCol];
                    String secondDigit = matrix[secondRow][secondCol];
                    matrix[firstRow][firstCol] = secondDigit;
                    matrix[secondRow][secondCol] = firstDigit;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            commands = scanner.nextLine().split("\\s+");
        }
    }
}
