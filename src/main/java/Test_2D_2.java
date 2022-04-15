import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2D_2 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        run();
    }
    private static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n < 2) return;
        br.close();
        String strLastNumber = "10".repeat(n-1);
        String strFirstNumber = "0".repeat(n-1) + "1".repeat(n-1);
        int lastNumber = Integer.parseInt(strLastNumber, 2); //из двоичного в десятичный
        int firstNumber = Integer.parseInt(strFirstNumber, 2);
        for (int j = firstNumber; j <= lastNumber ; j++) {
            String str = String.format("%" + (2 * (n - 1)) + "s", Integer.toBinaryString(j))
                               .replace(' ', '0');
            short countNulls = 0, countOnes = 0;
            for (char element : str.toCharArray()){
                if (element == '0') countNulls++;
                if (element == '1') countOnes++;
                if (countOnes > (countNulls + 1)) break;
            }
            if (countNulls == countOnes) {
                str = str.replace('0', '(');
                str = str.replace('1', ')');
                bw.write('(' + str + ')');
                bw.newLine();
            }
        }
        bw.close();
    }
}