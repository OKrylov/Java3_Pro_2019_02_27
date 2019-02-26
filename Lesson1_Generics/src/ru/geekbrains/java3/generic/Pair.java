package ru.geekbrains.java3.generic;

public class Pair<L, R> {

    private final L valueLeft;
    private final R valueRight;

    public Pair(L valueLeft, R valueRight) {
        this.valueLeft = valueLeft;
        this.valueRight = valueRight;
    }

    public L getValueLeft() {
        return valueLeft;
    }

    public R getValueRight() {
        return valueRight;
    }
}
