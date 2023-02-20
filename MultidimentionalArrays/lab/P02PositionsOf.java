package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] readLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int digit = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = matrix[i][j];
                if (digit == current) {
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
