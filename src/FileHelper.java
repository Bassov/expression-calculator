import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileHelper {

    public void write(String input, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(input);
            writer.close();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
