package SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> stringSet = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(",\\s+");

            if (command[0].equals("IN")) {
                stringSet.add(command[1]);

            } else if (command[0].equals("OUT")) {
                stringSet.remove(command[1]);

            }


            input = scanner.nextLine();
        }
        if (stringSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : stringSet) {
                System.out.println(s);
            }
        }
    }
}
