package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        if (rows < 2 || cols < 2) {
            System.out.println("wrong input");
            return;
        }
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] readLine = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int first = 0;
        int second = 0;
        int third = 0;
        int forth = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 1; i++) {
            int sum = 0;
            for (int j = 0; j < cols - 1; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    first = matrix[i][j];
                    second = matrix[i][j + 1];
                    third = matrix[i + 1][j];
                    forth = matrix[i + 1][j + 1];
                }
            }
        }
        System.out.println(first + " " + second);
        System.out.println(third + " " + forth);
        System.out.println(maxSum);
    }
}
