package homework;

import java.util.Arrays;

public class Lesson6_DZ {

    public int[] task1(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 4) {
                return Arrays.copyOfRange(data, i + 1, data.length);
            }
        }
        throw new RuntimeException("Invalid array");
    }

    public boolean task2(int[] data) {
        boolean contains1 = false;
        boolean contains4 = false;

        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case 1:
                    contains1 = true;
                    break;
                case 4:
                    contains4 = true;
                    break;
                default:
                    return false;
            }
        }
        return contains1 && contains4;
    }


}
