import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_2C_4 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String... args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        int countNumber = Integer.parseInt(br.readLine());
        char[] next;
        char[] prev = reedToChar();
        writeChar(prev);
        for (int i = 1; i < countNumber; i++) {
            next = reedToChar();
            if (!currEqualsPrev(next, prev)) {
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

//    private static char[] reedToChar() throws IOException {
//        char[] c = new char[20];
//        char[] d;
//        int b = 0;
//        for (int i = 0; ; i++) {
//            b = br.read();
//            if (b < 0 || (char) b == '\n') {
//                d = new char[i];
//                for (int j = 0; j < d.length; j++) {
//                    d[j] = c[j];
//                }
//                break;
//            }
//            c[i] = (char) b;
//        }
//        return d;
//}
    private static char[] reedToChar() throws IOException {
        List<Character> listChar = new ArrayList<>();
        int b = 0;
        for (int i = 0; ; i++) {
            b = br.read();
            if (b < 0 || (char) b == '\n') {
                break;
            }
            listChar.add((char) b);
        }
        char[] d = new char[listChar.size()];
        for(int i = 0; i < d.length; i++) {
            d[i] = listChar.get(i);
        }
//        System.out.println(d);
        return d;
    }

    private static void writeChar(char[] chars) throws IOException {
        for (int i = 0; i < chars.length; i++) {
            bw.write(chars[i]);
        }
    }
    private static boolean currEqualsPrev(char[] next, char[] prev) {
        for (int i = 0; i < prev.length; i++) {
            if (next[i] != prev[i]) return false;
            if (next[i] == '\n') break;
        }
        return true;
    }
}
