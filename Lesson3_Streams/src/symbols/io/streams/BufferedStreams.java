package symbols.io.streams;

import java.io.*;
import java.nio.charset.Charset;

public class BufferedStreams {

    public static void main(String[] args) throws IOException {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"))) {
//            for (int i = 0; i < 20; i++) {
//                bw.write("Java\n");
//            }
//        }
//
//        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
//            String str;
//            while ((str = br.readLine()) != null) {
//                System.out.println(str);
//            }
//        }

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"), Charset.forName("UTF-8"))) {

            byte[] bytes = new byte[5];
            int chr;
            int count = 0;

            while ((chr = isr.read()) != -1) {
                bytes[count % 5] = (byte) chr;
                count++;
                if (count > 0 && count % 5 == 0) {
                    System.out.println(new String(bytes));
                }
            }
        }


    }
}
