package Sprint1.Greenest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarnivorousPlant extends Plant {

    public CarnivorousPlant(String name, double length, NutritionType nutritionType) {
        super(name, length, nutritionType);
    }

    //POLYMORFISM
    @Override
    public double waterPlants() {
        //0.1 liter + 0.2 * längd i meter
        //* 10 för att få resultatet i dl
        //Specialare för att double buggar...
        BigDecimal dr = new BigDecimal(((0.2 * getPlantLength()) + 0.1) * 10).setScale(2, RoundingMode.HALF_UP);
        return dr.doubleValue();
        //URSPRUNGLIG LÖSNING SOM EJ FUNKADE P G A DUBBEL-BUGG...
        //((0.1 + (0.2 * getPlantLength())) * 10);
    }
}
