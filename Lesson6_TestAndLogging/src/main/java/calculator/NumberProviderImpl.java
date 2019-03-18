package calculator;

import java.util.Scanner;

public class NumberProviderImpl implements NumberProvider {

    @Override
    public int getNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
}
