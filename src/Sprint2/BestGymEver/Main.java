package Sprint2.BestGymEver;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reader r = new Reader();
        Writer w = new Writer();
        String basePath = "src/Sprint2/BestGymEver/";

        Map<String, Customer> customers = r.read(basePath, "Data");

        boolean runProgram = true;

        while (runProgram) {

            String userInput;

            System.out.println("Skriv ett namn eller personnummer: ");
            Scanner scan = new Scanner(System.in);
            userInput = scan.nextLine().trim();

            boolean customerFoundInList = customers.containsKey(userInput);

            if (!customerFoundInList) {
                System.out.println("Kund saknas");
                continue;
            }

            Customer chosenCustomer = customers.get(userInput);

            if (chosenCustomer.hasValidSubscription()) {
                System.out.println("Kund har giltigt medlemskap");
                w.writeToFile(basePath, "Customers logg", chosenCustomer.toString());
            } else {
                System.out.println("F d kund, saknar giltigt medlemskap");
            }
        }
    }
}
