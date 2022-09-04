
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Ingredient  ingredientThird;

    Burger burger = new Burger();

    @Test
    public void setBunInBurger(){
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void checkAddIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        assertEquals(burger.ingredients, List.of(ingredientFirst, ingredientSecond, ingredientThird));
    }

    @Test
    public void checkRemoveIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.removeIngredient(1);
        assertEquals(burger.ingredients, List.of(ingredientFirst, ingredientThird));
    }

    @Test
    public void checkMoveIngredients(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients, List.of(ingredientThird, ingredientFirst, ingredientSecond));
    }

    @Test
    public void checkGetPrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        Mockito.when(bun.getPrice()).thenReturn(150.55f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(50f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(99.85f);
        Mockito.when(ingredientThird.getPrice()).thenReturn(43.25f);

        assertEquals(burger.getPrice(), 494.2f, 0.0);
    }

    @Test
    public void checkGetReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);

        Mockito.when(bun.getName()).thenReturn("Белая");
        Mockito.when(bun.getPrice()).thenReturn(150.55f);
        Mockito.when(ingredientFirst.getName()).thenReturn("Чили");
        Mockito.when(ingredientSecond.getName()).thenReturn("Котлета");
        Mockito.when(ingredientThird.getName()).thenReturn("Салат");
        Mockito.when(ingredientFirst.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientSecond.getType()).thenReturn(FILLING);
        Mockito.when(ingredientThird.getType()).thenReturn(FILLING);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(50f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(99.85f);
        Mockito.when(ingredientThird.getPrice()).thenReturn(43.25f);

        String expectedReceipt = "(==== Белая ====)\r\n" +
                "= sauce Чили =\r\n" +
                "= filling Котлета =\r\n" +
                "= filling Салат =\r\n" +
                "(==== Белая ====)\r\n" +
                "\r\n" +
                "Price: 494,200012\r\n";

        assertEquals(burger.getReceipt(), expectedReceipt);
    }
}