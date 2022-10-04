import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String expectedType;
    private final String expectedName;
    private final float expectedPrice;



    public IngredientParametrizedTest(IngredientType type, String name, float price,
                                      String expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.expectedType = expectedType;
        this.name = name;
        this.expectedName = expectedName;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Cheese", 10.77f, "SAUCE", "Cheese", 10.77f},
                {IngredientType.SAUCE, "Chili", 150.673f, "SAUCE", "Chili",  150.673f},
                {IngredientType.SAUCE, "", 0, "SAUCE", "", 0},
                {IngredientType.FILLING, "Tomato", 5.99f, "FILLING", "Tomato", 5.99f},
                {IngredientType.FILLING, "Chicken", 55, "FILLING", "Chicken", 55},
                {IngredientType.FILLING, "", 100.01f, "FILLING", "", 100.01f},
        };
    }

    @Test
    public void checkBeCreateIngredients() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getType(), IngredientType.valueOf(expectedType));
        assertEquals(ingredient.getName(), expectedName);
        assertEquals(ingredient.getPrice(), expectedPrice, 0.0);
    }
}