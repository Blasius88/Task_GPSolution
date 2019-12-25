import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        try {
            String sepor = File.separator;
            int num = Read(sepor);
            int rez = Sum(num);
            Write(rez,sepor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int Read(String sepor) {
        Scanner sc = null;
        int num = 0;
        try {
            String path = "D:" + sepor + "input.txt";
            File file = new File(path);
            sc = new Scanner(file);
            num = sc.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return num;
    }

    private static int Sum(int num) {
        int rez = 0;
        for (int i = 0; i <= num; i++) {
            rez += i;
        }
        return rez;
    }

    private static void Write(int rez, String sepor) throws IOException {
        FileWriter writer = null;
        try {
            String rezStr ="";
            rezStr += rez;
            String pathOut = "D:" + sepor + "output.txt";
            writer = new FileWriter(pathOut);
            writer.write(rezStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}
