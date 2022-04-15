import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_2C_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        int countNumber = Integer.parseInt(br.readLine());
        String previousElement = br.readLine();
        String nextElement =  previousElement;
        bw.write(previousElement);
        for (int i = 1; i < countNumber; i++) {
            nextElement = br.readLine();
            if (!nextElement.equals(previousElement)) {
                bw.write('\n');
                bw.write(nextElement);
            }
            previousElement = nextElement;
        }
        br.close();
        bw.close();
    }
}