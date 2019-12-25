import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_195 {
    public static void main(String[] args) {
        try {
            String sepor = File.separator;
            String str = Read(sepor);
            int[] arr = Pars_Str(str);
            String calcul = Calculation(arr);
            Write(calcul, sepor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String Read(String sepor) {
        String str = "";
        Scanner sc = null;
        try {
            String path = "D:" + sepor + "input.txt";
            File file = new File(path);
            sc = new Scanner(file);
            str = sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return str;
    }

    static int[] Pars_Str(String str) {
        String[] numbers = str.split(" ");
        int[] num = new int[3];
        int counter = 0;
        for (String number : numbers) {
            num[counter++] = Integer.parseInt(number);
        }
        return num;
    }

    static String Calculation(int[] arr) {
        String str = "";
        int sum = 1;
        for (int i = 0; i < arr.length; i++) {
            sum *= arr[i];
        }
        sum *=2;
        str += sum;
        return str;
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
