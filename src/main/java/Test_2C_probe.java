import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test_2C_probe {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
//        String str = "123456789012";
//        char[] c = new char[str.length()];
//        System.out.println(c.length);
//        for (int i = 0; i < str.length(); i++) {
//            c[i] = str.charAt(i);
//        }
//        System.out.println(c);
//
//        char[] c2 = new char[2];
//        c2[0] = '1';
//        c2[1] = '2';
//
//        c = new char[c2.length];
//        for (int j = 0; j < c2.length; j++) {
//            c[j] = c2[j];
//        }
//        System.out.println(c);
//        System.out.println(c2);

        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        System.out.println(convert());
        System.out.println(convert());
        System.out.println(convert());
        System.out.println(convert());
        System.out.println(convert());
    }
    private static char[] convert() throws IOException {
        char[] c = new char[13];
        char[] d;
        int b = 0;
        for (int i = 0; ; i++) {
            b = br.read();
            if (b < 0 || (char) b == '\n') {
                d = new char[i];
                for (int j = 0; j < d.length; j++) {
                    d[j] = c[j];
                }
                break;
            }
            c[i] = (char) b;
        }
        return d;
    }
}
