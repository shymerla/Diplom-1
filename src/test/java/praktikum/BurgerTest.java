package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    String testBunName = "gluten free bun";
    String testIngredientName = "meat";
    Float testBunPrice = 25f;
    Float testIngredientPrice = 15f;

    @Before
    public void makeBurger() {
        burger = new Burger();
    }

    @Mock
    Bun bun;
    Ingredient firstIngredients = mock(Ingredient.class);
    Ingredient secondIngredients = mock(Ingredient.class);

    @Test
    public void setBunsCorrect() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("LowFat bun");
        String actualName = bun.getName();
        assertEquals("Set Buns is ERROR", "LowFat bun", actualName);
    }

    @Test
    public void addIngredientCorrect() {
        burger.addIngredient(firstIngredients);
        assertEquals("Ingredients NOT added", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientCorrect() {
        burger.addIngredient(firstIngredients);
        burger.removeIngredient(0);
        assertEquals("Ingredients NOT removed", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientCorrect() {
        burger.addIngredient(firstIngredients);
        burger.addIngredient(secondIngredients);
        burger.moveIngredient(0,1);
        assertEquals("Ingredients NOT move", "secondIngredients", burger.ingredients.get(0).toString());
    }

    @Test
    public void getPriceCorrect() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(125f);
        float actualPrice = bun.getPrice();
        assertEquals("Price NOT correct", 125f, actualPrice, 0f);
    }

    @Test
    public void getReceiptCorrect() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(testBunPrice);
        Mockito.when(bun.getName()).thenReturn(testBunName);
        Mockito.when(firstIngredients.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredients.getName()).thenReturn(testIngredientName);
        Mockito.when(firstIngredients.getPrice()).thenReturn(testIngredientPrice);

        burger.addIngredient(firstIngredients);

        String expected = String.format("(==== %s ====)%n", testBunName) +
                          String.format("= %s %s =%n", firstIngredients.getType().toString().toLowerCase(), testIngredientName) +
                          String.format("(==== %s ====)%n", testBunName) +
                          String.format("%nPrice: %f%n", (testBunPrice*2 + testIngredientPrice));
        assertEquals("Receipt NOT correct", expected, burger.getReceipt());



    }

}
