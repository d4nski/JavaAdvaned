package MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];
        if (pattern.equals("A")) {
            int numbers = 1;
            for (int cols = 0; cols < n; cols++) {
                for (int rows = 0; rows < n; rows++) {
                    matrix[rows][cols] = numbers;
                    numbers++;
                }
            }

        } else if (pattern.equals("B")) {
            int number = 1;
            for (int cols = 0; cols < n; cols++) {
                if (cols % 2 == 0) {
                    for (int rows = 0; rows < n; rows++) {
                        matrix[rows][cols] = number;
                        number++;
                    }
                } else {
                    for (int rows = n - 1; rows >= 0; rows--) {
                        matrix[rows][cols] = number;
                        number++;
                    }
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
