import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String bunName;
    private final String expectedBunName;
    private final float bunPrice;
    private final float expectedBunPrice;

    public BunParametrizedTest(String bunName, float bunPrice, String expectedBunName, float expectedBunPrice) {
        this.bunName = bunName;
        this.expectedBunName = expectedBunName;
        this.bunPrice = bunPrice;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters( name = "{index}: Bun({0}) price{1}" )
    public static Object[][] getBunData() {
        return new Object[][] {
                {" ", 0, " ", 0},
                {"Bun", 1.5f, "Bun", 1.5f},
                {"Bulka", 10, "Bulka", 10}
        };
    }

    @Test
    public void checkBeCreateBunWithNameAndPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(expectedBunName,bun.getName());
        assertEquals(bun.getPrice(), expectedBunPrice, 0.0);
    }
}