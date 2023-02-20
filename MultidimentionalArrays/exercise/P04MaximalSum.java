package MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(inputLine[j]);
            }
        }
        int[][] secondMatrix = new int[3][3];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++) {
            int sum = 0;
            for (int j = 0; j < cols - 2; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    secondMatrix[0][0] = matrix[i][j];
                    secondMatrix[0][1] = matrix[i][j + 1];
                    secondMatrix[0][2] = matrix[i][j + 2];
                    secondMatrix[1][0] = matrix[i + 1][j];
                    secondMatrix[1][1] = matrix[i + 1][j + 1];
                    secondMatrix[1][2] = matrix[i + 1][j + 2];
                    secondMatrix[2][0] = matrix[i + 2][j];
                    secondMatrix[2][1] = matrix[i + 2][j + 1];
                    secondMatrix[2][2] = matrix[i + 2][j + 2];

                }
            }

        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
