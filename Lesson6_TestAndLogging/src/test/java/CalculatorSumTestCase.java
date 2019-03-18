import calculator.Calculator;
import calculator.ICalc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorSumTestCase {

    private ICalc calc;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, 2, 4},
                {4, 6, 10},
                {50, 100, 150},
                {50, 50, 100},
        });
    }

    private int a;
    private int b;
    private int res;

    public CalculatorSumTestCase(int a, int b, int res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }


    @Test
    public void test_sum() {
        int actualResult = calc.add(a, b);
        Assert.assertEquals("Invalid values: a = " + a + "; b = " + b, res, actualResult);
    }
}
