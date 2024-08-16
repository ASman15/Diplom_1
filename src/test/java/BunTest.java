import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {

    private String testName;

    public int testPrice;

    @Mock
    Bun bun = new Bun(testName, testPrice);
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Parameterized.Parameters
    public static Object [][] data() {
        return new Object [][] {
                {"black bun", 0},
                {null, 100},
        };
    }
    public BunTest(String testName, int testPrice) {
        this.testName=testName;
        this.testPrice=testPrice;
    }
    @Test
    public void testGetName() {
        Bun bun = new Bun(testName, testPrice);
        String returnGetName = bun.getName();
        Assert.assertEquals(testName, returnGetName);
    }
    @Test
    public void testGetPrice() {
        Bun bun = new Bun(testName, testPrice);
        int returnGetPrice = (int) bun.getPrice();
        Assert.assertEquals(testPrice, returnGetPrice);
    }
}
