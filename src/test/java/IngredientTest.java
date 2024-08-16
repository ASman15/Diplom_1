import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    @Mock
    private Ingredient ingredient = new Ingredient(type, name, price);
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    public void testGetTypeSause() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, null, 0);
        IngredientType returnGetType = ingredient.getType();
        Assert.assertEquals(IngredientType.SAUCE, returnGetType);
    }
    @Test
    public void testGetTypeFilling() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, null, 0);
        IngredientType returnGetType = ingredient.getType();
        Assert.assertEquals(IngredientType.FILLING, returnGetType);
    }
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(null, "hot sauce", 0);
        String returnGetName = ingredient.getName();
        Assert.assertEquals("hot sauce", returnGetName);
    }
    @Test
    public void TestGetPrice() {
        Ingredient ingredient = new Ingredient(null, null, 100);
        int returnGetPrice = (int)ingredient.getPrice();
        Assert.assertEquals(100, returnGetPrice);
    }
}
