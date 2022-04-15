import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test_B {

    public static void main(String[] args) {
        int result = -1;
        try {
            File file = new File("E:/Programming/all_tests/input.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                // считываем остальные строки в цикле
//                line = reader.readLine();
//            }
            String[] numbers = line.split(" ");
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(result);
        try (FileWriter writer = new FileWriter("E:/Programming/all_tests/output.txt",
                                                false)) {
            // запись всей строки
            writer.write(String.valueOf(result));
//            // запись по символам
//            writer.append('\n');
//            writer.append('E');
            writer.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
