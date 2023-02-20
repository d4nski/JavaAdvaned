package P03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, BankAccount> acc;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
acc = new HashMap<>();
        while(!input.equals("End")){
            String command = input.split("\\s+")[0];
String result = "";
            if(command.equals("Create")){
result = createAccount();
            }else if(command.equals("Deposit")){
int id = Integer.parseInt(input.split("\\s+")[1]);
double amount = Double.parseDouble(input.split("\\s+")[2]);
result = depositInAcc(id, amount);
            }else if(command.equals("SetInterest")){
double interest = Double.parseDouble(input.split("\\s+")[1]);
                result = setInterest(interest);

            }else if(command.equals("GetInterest")){
                int id = Integer.parseInt(input.split("\\s+")[1]);
                int years = Integer.parseInt(input.split("\\s+")[2]);
                getInterest(id, years);
                result = getInterest(id, years);
            }
if(!result.isEmpty()){
            System.out.println(result);

}

            input = scanner.nextLine();
        }
    }

    private static String getInterest(int id, int years) {
        BankAccount bankAccount = acc.get(id);
        if(!acc.containsKey(id)){
            return "Account does not exist";
        }
        double interest = bankAccount.getInterest(years);
        return String.format("%.2f", interest);
    }

    private static String setInterest(double interest) {
        BankAccount.setInterestRate(interest);
        return "";

    }

    private static String depositInAcc(int id, double amount) {
        if(!acc.containsKey(id)){
            return "Account does not exist";
        }
        acc.get(id).deposit(amount);
        return String.format("Deposited %d to ID%d", (int) amount, id);
    }

    private static String createAccount(){
        BankAccount bankAccount = new BankAccount();
        int id = bankAccount.getId();
        acc.put(id, bankAccount);
        return String.format("Account ID%d created", id);
    }
}
