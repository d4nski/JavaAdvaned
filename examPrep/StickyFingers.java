package examPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];
        List<String> command = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        int playerRow = 0;
        int playerCol = 0;


        for (int rows = 0; rows < n; rows++) {
            char[] inputLine = scanner.nextLine().replace(" ", "").toCharArray();
            for (int cols = 0; cols < inputLine.length; cols++) {
                field[rows][cols] = inputLine[cols];
                if (field[rows][cols] == 'D') {
                    playerRow = rows;
                    playerCol = cols;

                }
            }
        }
        int totalMoney = 0;
        boolean isCaught = false;
        while (!command.isEmpty()) {
            String currentCommand = command.get(0);
            command.remove(0);

            if (currentCommand.equals("up")) {
                int possiblePosition = playerRow - 1;
                if (possiblePosition >= 0) {
                    field[playerRow][playerCol] = '+';
                    playerRow = possiblePosition;
                    if (field[playerRow][playerCol] == '$') {
                        field[playerRow][playerCol] = 'D';
                        int stolenMoney = playerRow * playerCol;
                        totalMoney += stolenMoney;
                        System.out.printf("You successfully stole %d$.\n", stolenMoney);
                    } else if (field[possiblePosition][playerCol] == 'P') {
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
                        field[possiblePosition][playerCol] = '#';

                        isCaught = true;
                        break;
                    } else if (field[playerRow][playerCol] == '+') {
                        field[playerRow][playerCol] = 'D';
                    }

                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (currentCommand.equals("down")) {
                int possiblePosition = playerRow + 1;
                if (possiblePosition < n) {
                    field[playerRow][playerCol] = '+';
                    playerRow = possiblePosition;
                    if (field[playerRow][playerCol] == '$') {
                        field[playerRow][playerCol] = 'D';
                        int stolenMoney = playerRow * playerCol;
                        totalMoney += stolenMoney;
                        System.out.printf("You successfully stole %d$.\n", stolenMoney);
                    } else if (field[possiblePosition][playerCol] == 'P') {
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
                        field[possiblePosition][playerCol] = '#';

                        isCaught = true;
                        break;
                    } else if (field[playerRow][playerCol] == '+') {
                        field[playerRow][playerCol] = 'D';
                    }

                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (currentCommand.equals("left")) {
                int possiblePosition = playerCol - 1;
                if (possiblePosition >= 0) {
                    field[playerRow][playerCol] = '+';
                    playerCol = possiblePosition;
                    if (field[playerRow][playerCol] == '$') {
                        field[playerRow][playerCol] = 'D';
                        int stolenMoney = playerRow * playerCol;
                        totalMoney += stolenMoney;
                        System.out.printf("You successfully stole %d$.\n", stolenMoney);
                    } else if (field[playerRow][possiblePosition] == 'P') {
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
                        field[playerRow][possiblePosition] = '#';

                        isCaught = true;
                        break;
                    } else if (field[playerRow][playerCol] == '+') {
                        field[playerRow][playerCol] = 'D';
                    }

                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (currentCommand.equals("right")) {
                int possiblePosition = playerCol + 1;
                if (possiblePosition < n) {
                    field[playerRow][playerCol] = '+';
                    playerCol = possiblePosition;
                    if (field[playerRow][playerCol] == '$') {
                        field[playerRow][playerCol] = 'D';
                        int stolenMoney = playerRow * playerCol;
                        totalMoney += stolenMoney;
                        System.out.printf("You successfully stole %d$.\n", stolenMoney);
                    } else if (field[playerRow][possiblePosition] == 'P') {
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
                        field[playerRow][possiblePosition] = '#';

                        isCaught = true;
                        break;
                    } else if (field[playerRow][playerCol] == '+') {
                        field[playerRow][playerCol] = 'D';
                    }

                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalMoney);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(field[r][c] + " ");
            }
            System.out.println();
        }

    }

}
