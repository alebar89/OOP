package Sprint1.Greenest;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class RunProgram {
    public static void runProgram() {
        //Boolean för att sätta igång och avsluta programmet
        boolean runProgram = true;

        Map<String, Plant> plantMap = new HashMap<>();
        plantMap.put("igge", new Cactus("Igge", 0.2, NutritionType.MINERAL_WATER));
        plantMap.put("laura", new Palm("Laura", 5, NutritionType.TAP_WATER));
        plantMap.put("olof", new Palm("Olof", 1, NutritionType.TAP_WATER));
        plantMap.put("meatloaf", new CarnivorousPlant("Meatloaf", 0.7, NutritionType.PROTEIN_NUTRITION));
        //TESTOBJEKT HASHMAP
        //plantMap.put("alex", new CarnivorousPlant("Alex", 3.5, NutritionType.PROTEIN_NUTRITION));

        /*
        // ALTERNATIVT SKRIVSÄTT
        Plant cactus1 = new Cactus("Igge", 0.2, NutritionType.MINERAL_WATER);
        Plant palm1 = new Palm("Laura", 5, NutritionType.TAP_WATER);
        Plant palm2 = new Palm("Olof", 1, NutritionType.TAP_WATER);
        Plant cPlant1 = new CarnivorousPlant("Meatloaf", 0.7, NutritionType.PROTEIN_NUTRITION);
        //Testobjekt
        //Plant cPlant2 = new CarnivorousPlant("Hej", 3, NutritionType.PROTEIN_NUTRITION);

        Map<String, Plant> plantMap = new HashMap<>();
        plantMap.put("igge", new Cactus(cactus1.getPlantName(), cactus1.getPlantLength(), cactus1.getNutritionType()));
        plantMap.put("laura", new Palm(palm1.getPlantName(), palm1.getPlantLength(), palm1.getNutritionType()));
        plantMap.put("olof", new Palm(palm2.getPlantName(), palm2.getPlantLength(), palm2.getNutritionType()));
        plantMap.put("meatloaf", new CarnivorousPlant(cPlant1.getPlantName(), cPlant1.getPlantLength(), cPlant1.getNutritionType()));
        //Testobjekt
        //plantMap.put("hej", new CarnivorousPlant(cPlant2.getPlantName(), cPlant2.getPlantLength(), cPlant2.getNutritionType()));
        */

        //TESTOBJEKT POLYMORFISM
        //Plant testObj1 = new CarnivorousPlant("Peter", 10, NutritionType.MINERAL_WATER);
        //System.out.println(testObj1.waterPlants());

        while (runProgram) {
            String programMessage = "Vilken växt ska få mat?";
            String errorMessage = "Okänd växt. Vänligen skriv in ett korrekt namn.";
            String userInput = JOptionPane.showInputDialog(programMessage);

            if (userInput == null) {
                runProgram = false;
                continue;
            }
            if (!plantMap.containsKey(userInput.toLowerCase())) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            Plant chosenPlant = plantMap.get(userInput.toLowerCase());
            JOptionPane.showMessageDialog(null, chosenPlant.plantNutrition());
        }
    }
}
