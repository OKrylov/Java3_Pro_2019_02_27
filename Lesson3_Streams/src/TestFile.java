import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TestFile {


    public static void main(String[] args) {
        File file = new File("TestFile.txt");
        System.out.println("Is exist: " + file.exists());
        System.out.println("Name: " + file.getName());
        System.out.println("Name: " + file.getAbsolutePath());
        System.out.println("Is dir: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
        System.out.println("File length: " + file.length());

        File dir = new File("TestDir/test/test");
        dir.mkdirs();

        LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dir.lastModified()), ZoneId.systemDefault());

        System.out.println("Last modified:" + date);
//        System.out.println("Last modified:" + new Date(dir.lastModified()));
    }
}
