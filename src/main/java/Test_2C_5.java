import java.io.*;

public class Test_2C_5 {
    static final int MAX_INT_LENGTH = 12;

    static final String input = "input.txt";
    static final String output = "output.txt";

    static BufferedReader r;
    static BufferedWriter w;

    static final char[] curr = new char[MAX_INT_LENGTH];
    static final char[] prev = new char[MAX_INT_LENGTH];

    public static void main(String... args) throws IOException {
        r = new BufferedReader(new FileReader(input));
        w = new BufferedWriter(new FileWriter(output));

        int n = Integer.parseInt(r.readLine());
        if (n < 1) return;

        readCurr();
        copyCurrToPrev();
        printCurr();

        for (int i = 0; i < n - 1; i++) {
            readCurr();
            if (!currEqualsPrev()) {
                printCurr();
                copyCurrToPrev();
            }
        }
        r.close();
        w.close();
    }

    private static void readCurr() throws IOException {
        int b = 0;
        for (int i = 0; i < MAX_INT_LENGTH; i++) {
            b = r.read();
            if (b < 0) {
                curr[i] = '\n';
                break;
            }
            curr[i] = (char) b;
            if (b == '\n') break;
        }
    }

    private static void printCurr() throws IOException {
        for (int i = 0;; i++) {
            w.write(curr[i]);
            if (curr[i] == '\n') break;
        }
    }

    private static boolean currEqualsPrev() {
        for (int i = 0; i < MAX_INT_LENGTH; i++) {
            if (curr[i] != prev[i]) return false;
            if (curr[i] == '\n') break;
        }
        return true;
    }

    private static void copyCurrToPrev() {
        for (int i = 0; i < MAX_INT_LENGTH; i++) {
            prev[i] = curr[i];
            if (curr[i] == '\n') break;
        }
    }
}