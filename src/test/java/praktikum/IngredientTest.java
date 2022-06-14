package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price){
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test credentials : TYPE {0},  NAME {1}, PRICE {2}")
    public static Object [][] getData() {
       return new Object[][] {
               {IngredientType.SAUCE, "flame tartar", 45f},
               {IngredientType.FILLING, "forein chicks", 68f}
       };
    }

    @Test
    public void getPriceCorrect(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Price NOT correct", price, actualPrice, 0f);
    }

    @Test
    public void getNameCorrect(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        assertEquals("Name NOT correct", name, actualName);
    }

    @Test
    public void getTypeCorrect(){
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("IngredientType NOT correct", ingredientType, actualIngredientType);
    }

}
