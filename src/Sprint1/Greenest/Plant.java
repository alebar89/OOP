package Sprint1.Greenest;

public abstract class Plant implements Watering {
    //INKAPSLING, VÄRDEN GES GENOM KONSTRUKTORN, KAN ÄNDRAS MED SETTERS OCH HÄMTAS MED GETTERS, FÖR ATT BLI ÅTKOMLIGA
    //FÖR ANDRA DELAR AV PROGRAMMET
    private String plantName;
    private double plantLength;
    private NutritionType nutritionType;

    public String getPlantName() {
        return plantName;
    }

    public double getPlantLength() {
        return plantLength;
    }

    public NutritionType getNutritionType() {
        return nutritionType;
    }

    public Plant(String plantName, double plantLength, NutritionType nutritionType) {
        this.plantName = plantName;
        this.plantLength = plantLength;
        this.nutritionType = nutritionType;
    }

    @Override
    public String plantNutrition() {
        return getPlantName() + " ska matas med "
                + waterPlants() + " " + getNutritionType().getMeasure() + " " + getNutritionType().getDescription();
    }
}
