import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test_2E_2 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static Map<Character, Integer> map_1;
    private static Map<Character, Integer> map_2;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
        String text_1 = br.readLine();
        String text_2 = br.readLine();
        br.close();
        map_1 = method(text_1);
        map_2 = method(text_2);
        if (map_1.equals(map_2)) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }
        bw.close();
    }

    private static Map<Character, Integer> method(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
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