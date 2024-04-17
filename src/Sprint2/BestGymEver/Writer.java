package Sprint2.BestGymEver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public void writeToFile(String filePath, String fileName, String data) {
        String errorMessage = "Ett fel uppstod";
        //Path p = Paths.get("src/Sprint2/BestGymEver/" + fileName);
        //String filePath = String.valueOf(p);

        try {
            File file = new File(filePath + fileName);

            if (!file.exists()) {
                file.createNewFile();

                System.out.println("En ny fil " + fileName + " har skapats");
            } else {
                System.out.println("Filen " +  fileName + " existerar redan");
            }

            try (FileWriter fw = new FileWriter(file, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(data);
                bw.newLine();

                System.out.println("Utskrift har gjorts till fil " + fileName);

            } catch (IOException e) {
                System.out.println(errorMessage);
            }
        } catch (IOException e) {
            System.out.println(errorMessage);
        }
    }
}