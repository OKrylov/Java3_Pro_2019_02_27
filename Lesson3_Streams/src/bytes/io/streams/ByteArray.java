package bytes.io.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArray {

    public static void main(String[] args) {
        readByteArray();
        System.out.println();
        writeByteArray();

    }

    private static void writeByteArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(11);
        byte[] bytes = out.toByteArray();
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }
    }

    private static void readByteArray() {
        byte[] arr = {100, 25, 50};
        ByteArrayInputStream is = new ByteArrayInputStream(arr);
        int x;
        while ( (x = is.read()) != -1 ) {
            System.out.print(x + " ");
        }
    }
}
