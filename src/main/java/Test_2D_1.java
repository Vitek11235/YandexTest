import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2D_1 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        int n = Integer.valueOf(br.readLine());
        if (n < 2) return;
        String strLastNumber = "10".repeat(n-1);
        int lastNumber = Integer.parseInt(strLastNumber, 2);
        for (int j = 1; j <= lastNumber ; j++) {
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
                bw.write("(" + str + ")\n");
            }
        }
        br.close();
        bw.close();
    }
}
