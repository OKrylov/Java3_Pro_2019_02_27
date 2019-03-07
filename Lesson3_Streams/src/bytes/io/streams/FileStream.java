package bytes.io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileStream {

    public static final String FILE_NAME = "12345.txt";
    public static final String IMAGE_FILE_NAME = "c:\\Users\\OKrylov\\Google Диск\\GeekBrains\\перерыв.jpg";

    public static void main(String[] args) {
        byte[] bw = {71, 72};
        byte[] br = new byte[20];
//
//        writeData(bw);
//        readData(br);

        testImage();
    }

    private static void testImage() {
        byte[] bytes = readImages();
        modifyImages(bytes);
        writeImages(bytes);
    }

    private static void writeImages(byte[] bw) {
        try (FileOutputStream out = new FileOutputStream(IMAGE_FILE_NAME.replace(".png", "-new.png"))) {
            out.write(bw);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static void modifyImages(byte[] bytes) {
        Random rand = new Random();
        for (int i = bytes.length - 1; i > bytes.length - 500; i--) {
            bytes[i] = (byte) (rand.nextInt(255) - 127);
        }
    }

    private static byte[] readImages() {
        try (FileInputStream in = new FileInputStream(IMAGE_FILE_NAME)) {
            byte[] bytes = in.readAllBytes();

            System.out.println("Прочитано " + bytes.length + "байт");
            for (byte b : bytes) {
                System.out.print(b + " ");
            }
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void readData(byte[] br) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(FILE_NAME);
            int count = in.read(br);
            System.out.println("Прочитано " + count + "байт");
            for (byte b : br) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeData(byte[] bw) {
        try (FileOutputStream out1 = new FileOutputStream(FILE_NAME, true)) {
            out1.write(bw);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
