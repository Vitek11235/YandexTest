import java.util.Scanner;

public class Test_G {
    public static void main(String[] args) {
//        String j = "ab"; // xxo
//        String s = "aabbccd"; // ukzxlzxlnqoplmvwltlkvatmnnlllxrzcuqlhgomacnpeudfjpvliodepczv
        Scanner scanner = new Scanner(System.in);
        String text_j = scanner.nextLine();
        String text_s = scanner.nextLine();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        int idx;
        for (int i = 0; i < text_j.length(); i++) {
            char c = text_j.charAt(i);
            idx = text_j.indexOf(c, i + 1);
            if (idx == -1) {
                sb.append(c);
            }
        }
        text_j = sb.toString();
        for (int i = 0; i < text_j.length(); i++) {

            for (int j = 0; j < text_s.length(); j++) {
                if (text_s.charAt(j) == text_j.charAt(i)) {
//                    System.out.println(text_j.charAt(i));
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
