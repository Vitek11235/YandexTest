import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2D {
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        run();
        br.close();
        bw.close();
    }

    private static void writeLine(char[] IntToFile) throws IOException {
        bw.write(IntToFile);
        bw.newLine();
    }

    private static void run() throws IOException {
        int n = Integer.valueOf(br.readLine()) * 2;
        if (n < 2) return;
        char[] chrs = new char[n];
        for (int i = 0; i < n/2; i++) {
            chrs[i] = '(';
        }
        for (int i = n/2; i < n; i++) {
            chrs[i] = ')';
        }
        writeLine(chrs);
        do {
            int i = n - 1;
            int c = 0;
            while (i >= 0) {
                c += chrs[i] == ')' ? -1 : 1;
                if ((c < 0) && (chrs[i] == '(')) break;
                --i;
            }
            if (i < 0) break;

            chrs[i++] = ')';
            int ind = i;
            for (; i < n; i++) {
                chrs[i] = (i<= (n-ind+c)/2+ind) ? '(' : ')';
            }
            writeLine(chrs);
        }while (true);
    }
}