import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_550 {
    public static void main(String[] args) {
        try {
            String sepor = File.separator;
            int year = Read(sepor);
            boolean isLeapYear = Leap_Year(year);
            String data = Data(isLeapYear, year);
            Write(data, sepor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int Read(String sepor) {
        int year = 0;
        Scanner sc = null;
        try {
            String path = "D:" + sepor + "input.txt";
            File file = new File(path);
            sc = new Scanner(file);
            year = sc.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return year;
    }

    static boolean Leap_Year(int year) {
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
        return isLeapYear;
    }

    static String Data(boolean LeapYear, int year) {
        String data = "";
        if (LeapYear) {
            data = "12/09/" + year;
        } else
            data = "13/09/" + year;
        return data;
    }

    static void Write(String data, String sepor) throws IOException {
        FileWriter writer = null;
        try {
            String pathOut = "D:" + sepor + "output.txt";
            writer = new FileWriter(pathOut);
            writer.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}

