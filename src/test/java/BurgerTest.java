import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.mockito.Mockito.when;


public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    public Ingredient ingredient1;
    @Mock
    public Ingredient ingredient2;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void ingredientWasAdd() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }
    @Test
    public void ingredientRemovedIsSuccess() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void ingredientsMovedIsSuccess() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }
    @Test
    public void BurgerPriceIsCorrect() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient2.getPrice()).thenReturn(200F);
        float price = bun.getPrice()*2 + ingredient1.getPrice() + ingredient2.getPrice();
        Assert.assertEquals(price, burger.getPrice(), 0F);
    }
    @Test
    public void BurgerReceiptIsCorrect() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sause");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("sour cream");
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient2.getPrice()).thenReturn(200F);
        float burgerPrice = bun.getPrice()*2 + ingredient1.getPrice() + ingredient2.getPrice();
        StringBuilder burgerReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        burgerReceipt.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                    ingredient1.getName()));
        burgerReceipt.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(),
                    ingredient2.getName()));
        burgerReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        burgerReceipt.append(String.format("%nPrice: %f%n", burgerPrice));

        Assert.assertEquals(burgerReceipt.toString(), burger.getReceipt());
    }
    }
