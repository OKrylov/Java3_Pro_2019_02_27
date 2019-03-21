import calculator.Calculator;
import calculator.ICalc;
import calculator.NumberProvider;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class CalculatorTestCase {


    private ICalc calc;
    private NumberProvider numberProvider;

    @Before
    public void setUp() throws Exception {
        numberProvider = Mockito.mock(NumberProvider.class);
        calc = new Calculator(numberProvider);
    }

    @After
    public void tearDown() throws Exception {
        calc = null;
    }

    @Test
    public void test_sum() {
        int result = calc.add(2, 2);
        Assert.assertEquals(4, result);
    }


    @Test
    public void test_sum1() {
        int result = calc.add(5, 10);
        Assert.assertEquals(15, result);
    }

    @Test
    public void test_sub() {
        Assert.assertThat(calc.sub(5, 12), Is.is(-7));
    }

    @Test
    public void testMul() {
        Assert.assertThat(calc.mul(2, 3), Is.is(6));
    }


    @Test(timeout = 100L)
    public void testDiv() {
        Assert.assertThat(calc.div(6, 3), Is.is(2));
    }

    @Test
    public void testDiv1() {
        Assert.assertThat(calc.div(0, 3), Is.is(0));
    }

    @Test(expected = ArithmeticException.class)
    public void testDiv2() {
        Assert.assertThat(calc.div(3, 0), Is.is(0));
    }

    @Test
    public void testMock() throws IOException {
        Mockito
                .when(numberProvider.getNumber())
                .thenReturn(10, 8);


        int result = calc.sumFromProvider();
        Assert.assertEquals(18, result);
    }

}
