package FirstAndSecond;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dada = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dada[0]);
        int cols = Integer.parseInt(dada[1]);
        char[][] matrix = new char[rows][cols];
        int myRow = -1;
        int myCol = -1;
        for (int r = 0; r < rows; r++) {
            char[] input = scanner.nextLine().replace(" ", "").toCharArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c] == 'B') {
                    myRow = r;
                    myCol = c;
                }
            }
        }
        int touched = 0;
        int movesMade = 0;

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            if (command.equals("up") && myRow != 0) {
                int newPosition = myRow - 1;
                if (matrix[newPosition][myCol] != 'O') {
                    myRow--;
                    if (matrix[myRow][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        touched++;

                    }
                    movesMade++;
                }
            } else if (command.equals("down") && myRow != rows - 1) {

                int newPosition = myRow + 1;
                if (matrix[newPosition][myCol] != 'O') {
                    myRow++;
                    if (matrix[myRow][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        touched++;

                    }
                    movesMade++;
                }

            } else if (command.equals("left") && myCol != 0) {

                int newPosition = myCol - 1;
                if (matrix[myRow][newPosition] != 'O') {
                    myCol--;
                    if (matrix[myRow][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        touched++;

                    }
                    movesMade++;
                }

            } else if (command.equals("right") && myCol != cols - 1) {
                int newPosition = myCol + 1;
                if (matrix[myRow][newPosition] != 'O') {
                    myCol++;
                    if (matrix[myRow][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        touched++;

                    }
                    movesMade++;
                }

            }

            if (touched == 3) {
                break;
            }


            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touched, movesMade);


    }
}
