package Sprint1.Greenest;

public class Palm extends Plant {

    public Palm(String name, double length, NutritionType nutritionType) {
        super(name, length, nutritionType);
    }

    //Metod som ska ge oss rätt mängd mat
    //POLYMORFISM
    @Override
    public double waterPlants() {
        return 0.5 * getPlantLength(); //0.5 liter * längd i meter
    }
}
