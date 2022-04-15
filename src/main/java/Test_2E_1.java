import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test_2E_1 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("E:/Programming/all_tests/input.txt"));
        bw = new BufferedWriter(new FileWriter("E:/Programming/all_tests/output.txt"));
        String text_1 = br.readLine();
        String text_2 = br.readLine();
        br.close();

        Map<Character, Integer> map_1 = method(text_1);
        Map<Character, Integer> map_2 = method(text_2);
        if (map_1.equals(map_2)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
        bw.close();
    }
    private static Map<Character, Integer> method(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put(text.charAt(0), 1);
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        return map;
    }
}