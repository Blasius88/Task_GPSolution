import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_254 {
    public static void main(String[] args) {
        try {
            String sepor = File.separator;
            List<String> line = Read(sepor);
            String str = Voiting_Result(line);
            Write(str, sepor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<String> Read(String sepor) {
        List<String> line = new ArrayList<String>();
        try {
            String path = "D:" + sepor + "input.txt";
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line.add(sc.nextLine());
            }
            System.out.println(line);
            return line;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return line;
    }

    static String Voiting_Result(List<String> line) {
        String str = "";
        int shire = 0;
        String[] arrStr = line.toArray(new String[0]);
        for (int i = 0; i < arrStr.length; i++) {
            shire = Integer.parseInt(arrStr[0]);
            break;
        }
        int[] priesе_Shire = new int[shire];
        int applications = 0;
        for (int i = 0; i < arrStr.length; i++) {
            if (i == 1) {
                String[] strArr_1 = arrStr[i].split(" ");
                for (int j = 0; j < strArr_1.length; j++) {
                    priesе_Shire[j] = Integer.parseInt(strArr_1[j]);
                }
            }
            if (i == 2) {
                applications = Integer.parseInt(arrStr[i]);
            }
            if (i > 2) {
                break;
            }
        }
        int[][] replacement = new int[2][applications];
        int count = 0;
        for (int i = arrStr.length - 1; i > 0; i--) {

            if (count == applications) {
                break;
            } else {
                String[] arrStr_one = arrStr[i].split(" ");
                for (int j = 0; j < arrStr_one.length; j++) {
                    replacement[j][count] = Integer.parseInt(arrStr_one[j]);
                    System.out.println(replacement[j][count]);
                }
            }
            count++;
        }
        for (int i = 0; i < priesе_Shire.length; i++) {
            boolean flag = false;
            for (int j = 0; j < applications; j++) {
                if (priesе_Shire[i] == replacement[0][j]) {
                    str += replacement[1][j];
                    flag = true;
                }

            }
            if (!flag) str += priesе_Shire[i];

        }
        System.out.println(str);
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