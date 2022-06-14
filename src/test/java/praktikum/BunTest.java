package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String bunName = "crazy bun";
    private final float bunPrice = 111f;

    @Test
    public void getNameOfBunCorrect() {
        Bun bun =new Bun(bunName,bunPrice);
        String actualName = bun.getName();
        assertEquals("Name of bun ERROR", bunName, actualName);
    }

    @Test
    public void getPriceOfBunCorrect() {
        Bun bun =new Bun(bunName,bunPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Price of bun ERROR", bunPrice, actualPrice, 0);
    }
}
