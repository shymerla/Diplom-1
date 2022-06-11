package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void availableBunsNotEmpty(){
        Database database = new Database();
        assertNotNull(database.availableBuns());
    }

    @Test
    public void availableIngredientsNotEmpty(){
        Database database = new Database();
        assertNotNull(database.availableIngredients());
    }

}
