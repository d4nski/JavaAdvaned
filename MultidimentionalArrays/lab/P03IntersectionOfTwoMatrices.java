package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] matrixA = new char[rows][cols];
        char[][] matrixB = new char[rows][cols];
        char[][] matrixC = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                String toString = input[j];
                char toChar = toString.charAt(0);
                matrixA[i][j] = toChar;
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                String toString = input[j];
                char toChar = toString.charAt(0);
                matrixB[i][j] = toChar;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixA[i][j] == matrixB[i][j]) {
                    matrixC[i][j] = matrixA[i][j];
                } else {
                    matrixC[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixC[i][j] + " ");

            }
            System.out.println();
        }

    }
}
