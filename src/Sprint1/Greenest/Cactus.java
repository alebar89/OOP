package Sprint1.Greenest;

public class Cactus extends Plant {
    //Konstant eftersom mängden inte skiljer sig, undvika hårdkodning :)
    final double quantityOfNutrition = 0.02;

    public Cactus(String name, double length, NutritionType nutritionType) {
        super(name, length, nutritionType);
    }

    //POLYMORFISM
    @Override
    public double waterPlants() {
        return quantityOfNutrition * 100; //2 cl (* 100 för att få resultatet i cl)
    }
}
