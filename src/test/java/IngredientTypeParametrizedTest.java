import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IngredientTypeParametrizedTest {

    @Test
    public void checkValuesAmount() {
        assertEquals(IngredientType.values().length, 2);
    }

    @Test
    public void checkTypeSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void checkExceptionWithoutValue() {
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("WRONG"));
    }
}