package calculator;

import java.io.IOException;

public class Calculator implements ICalc {

    private NumberProvider numberProvider;

    public Calculator() {
        this(null);
    }

    public Calculator(NumberProvider numberProvider) {
        this.numberProvider = numberProvider;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }

    @Override
    public int sumFromProvider() {
        int a = numberProvider.getNumber();
        int b = numberProvider.getNumber();
        return add(a, b);
    }
}
