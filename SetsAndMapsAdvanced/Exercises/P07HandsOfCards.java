package SetsAndMapsAdvanced.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> mapA = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("JOKER")){
            String name = input.split(": ")[0];
            List<String>  listCards= Arrays.stream(input.split(": ")[1].split(", ")).collect(Collectors.toList());
            for (String card : listCards) {
                if(!mapA.containsKey(name)){
                mapA.put(name, new HashSet<>());

                }
                mapA.get(name).add(card);
            }

            input = scanner.nextLine();
        }
        mapA.entrySet().forEach(entry -> {String name = entry.getKey();
        Set<String> cards = entry.getValue();
        int points = getCardsPoints(cards);
        System.out.printf("%s: %d\n", name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> symbolsValue = getSymbolsValues();
        int sumPoints = 0;
        for (String card:cards) {
            int points = 0;
            if(card.startsWith("10")){
                char type = card.charAt(2);
                points = 10 * symbolsValue.get(type);
            }else{
                char power = card.charAt(0);
                char type = card.charAt(1);
                points = symbolsValue.get(power) * symbolsValue.get(type);
            }
            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character,Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return  characterValues;
    }
}
