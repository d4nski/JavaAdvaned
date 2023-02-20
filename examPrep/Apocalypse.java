package FirstAndSecond;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class Apocalypse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<Integer> textileQueue = new ArrayDeque<>();

        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(textileQueue::offer);

        input = scanner.nextLine();
        Deque<Integer> medicamentsStack = new ArrayDeque<>();

        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(medicamentsStack::push);

        Map<String, Integer> mapa = new HashMap<>();

        while (!textileQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int queue = textileQueue.peek();
            int stack = medicamentsStack.peek();
            int sum = queue + stack;

            if (sum == 30) {
                mapa.putIfAbsent("Patch", 0);
                int current = mapa.get("Patch");
                mapa.put("Patch", current + 1);
                textileQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 40) {
                mapa.putIfAbsent("Bandage", 0);
                int current = mapa.get("Bandage");
                mapa.put("Bandage", current + 1);
                textileQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 100) {
                mapa.putIfAbsent("MedKit", 0);
                int current = mapa.get("MedKit");
                mapa.put("MedKit", current + 1);
                textileQueue.poll();
                medicamentsStack.pop();
            } else if (sum > 100) {
                mapa.putIfAbsent("MedKit", 0);
                int current = mapa.get("MedKit");
                mapa.put("MedKit", current + 1);
                textileQueue.poll();
                medicamentsStack.pop();
                int difference = sum - 100;
                int lastEl = medicamentsStack.pop();
                medicamentsStack.push(difference + lastEl);
            } else {
                textileQueue.poll();
                int lastMedicine = medicamentsStack.pop();
                medicamentsStack.push(lastMedicine + 10);
            }

        }

        if (textileQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        }


        mapa.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach(e -> System.out.println((e.getKey() + " - " + e.getValue())));
        if (!medicamentsStack.isEmpty()) {
            int now = 0;
            int size = medicamentsStack.size();
            System.out.print("Medicaments left: ");
            for (Integer integer : medicamentsStack) {
                if (now == size - 1) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
                now++;
            }
        }

        if (!textileQueue.isEmpty()) {
            int now = 0;
            int size = textileQueue.size();
            System.out.print("Textiles left: ");
            for (Integer integer : textileQueue) {
                if (now == size - 1) {
                    System.out.println(integer);
                    break;
                }
                System.out.print(integer + ", ");
                now++;
            }
        }
    }
}
