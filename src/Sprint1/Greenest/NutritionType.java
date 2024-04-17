package Sprint1.Greenest;

public enum NutritionType {
    TAP_WATER ("kranvatten", "liter"),
    PROTEIN_NUTRITION ("proteindryck", "deciliter"),
    MINERAL_WATER ("mineralvatten", "centiliter");

    private String description;
    private String measure;

    NutritionType(String description, String measure) {
        this.description = description;
        this.measure = measure;
    }

    public String getDescription() {
        return description;
    }

    public String getMeasure() {
        return measure;
    }
}
