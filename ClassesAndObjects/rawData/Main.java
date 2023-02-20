package rawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<Car>> carsByCargo = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tireList = new ArrayList<>();
            for (int j = 5; j < input.length ; j+=2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire currentTire = new Tire(tirePressure, tireAge);
                tireList.add(currentTire);
            }
            Car car = new Car(model, engine, cargo, tireList );
            carsByCargo.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargo.get(cargoType).add(car);

        }
        String command = scanner.nextLine();
        carsByCargo.get(command).forEach(car -> car.extract(command));
    }
}
