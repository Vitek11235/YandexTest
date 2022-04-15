import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test_2E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text_1 = scanner.nextLine();
        String text_2 = scanner.nextLine();

        Map<Character, Integer> map_1 = method(text_1);
        Map<Character, Integer> map_2 = method(text_2);
        if (map_1.equals(map_2)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
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