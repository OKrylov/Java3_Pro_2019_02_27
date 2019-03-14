package collection.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class Example4 extends MapExample<Long> {

    @Override
    public void run() {
        String word;
        try {
            word = reader.readLine();
            if (word == null)
                return;
        } catch (IOException e) {
            return;
        }

        storage.merge(word,1L, Long::sum);
    }
}
