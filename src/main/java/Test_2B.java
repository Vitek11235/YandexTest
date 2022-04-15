import java.util.Scanner;

public class Test_2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        if (n <= 10_000 && n > 0) {
            int count = 0;
            int maxCount = 0;
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (a == 1) {
                    count++;
//                    maxCount = Math.max(maxCount, count);
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
                else {
                    count = 0;
                }
            }
            System.out.println(maxCount);
//        }
//        else {
//            System.out.println("n > 10_000");
//        }
    }
}