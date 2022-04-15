import java.io.*;
import java.util.Arrays;

public class Test_2C_3 {
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String... args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        int countNumber = Integer.parseInt(br.readLine());
        String previousElement = br.readLine();
        String nextElement;
        char[] next;
        char[] prev = stringToChar(previousElement);
        writeChar(prev);
        for (int i = 1; i < countNumber; i++) {
            nextElement = br.readLine();
            next = stringToChar(nextElement);
            if (!Arrays.equals(next, prev)) {
                bw.write('\n');
                writeChar(next);
            }
            prev = new char[next.length];
            for (int j = 0; j < next.length; j++) {
                prev[j] = next[j];
            }
        }
        br.close();
        bw.close();
    }

    private static char[] stringToChar(String str) throws IOException {
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i);
        }
        return c;
    }
    private static void writeChar(char[] chars) throws IOException {
        for (int i = 0; i < chars.length; i++) {
            bw.write(chars[i]);
        }
    }
}