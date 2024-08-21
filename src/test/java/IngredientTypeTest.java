import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTypeTest {
    private IngredientType type;
    private String name;
    private float price;

    @Test
    public void IngredientTypeReturnRightEqual() {
        for (IngredientType ingredients : IngredientType.values()) {
            Assert.assertEquals(ingredients, IngredientType.valueOf(String.valueOf(ingredients)));
        }
    }
}