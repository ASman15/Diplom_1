import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;
    private String name;
    private float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, null, 0},
                {IngredientType.SAUCE, null, 0},
        };
    }
    public IngredientTypeTest(IngredientType type, String name, int price) {
        this.type=type;
        this.name=name;
        this.price=price;
    }
    @Test
    public void IngredientTypeReturnRightEqual() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType returnGetType = ingredient.getType();
        Assert.assertEquals(type, returnGetType);
    }
    }