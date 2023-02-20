package SetsAndMapsAdvanced.lab;

import java.util.*;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> setString = new TreeSet<>();

        String invited = scanner.nextLine();
        while (!invited.equals("PARTY")) {
            setString.add(invited);


            invited = scanner.nextLine();
        }

        String arrived = scanner.nextLine();
        while (!arrived.equals("END")) {
            setString.remove(arrived);


            arrived = scanner.nextLine();
        }
        System.out.println(setString.size());
        for (String s : setString) {
            System.out.println(s);
        }

    }
}
