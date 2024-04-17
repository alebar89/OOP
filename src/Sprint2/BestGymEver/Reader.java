package Sprint2.BestGymEver;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    String errorMessage = "Ett fel uppstod";

    public Map<String, Customer> read(String p, String fileName) {
        Map<String, Customer> mapOfVisitors = new HashMap();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(p, fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String socialSecurityNumber = parts[0].trim();
                    String name = parts[1].trim();
                    line = br.readLine();
                    if (line != null) {
                        String dateOfPayment = line.trim();
                        Customer newCustomer = new Customer(socialSecurityNumber, name, dateOfPayment);
                        mapOfVisitors.put(socialSecurityNumber, newCustomer);
                        mapOfVisitors.put(name, newCustomer);
                    }
                } else {
                    System.out.println(errorMessage);
                }
            }
        } catch (Exception e) {
            System.out.println(errorMessage);
        }
        return mapOfVisitors;
    }
}
