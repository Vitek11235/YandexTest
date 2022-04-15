import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Test_2C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNumber = scanner.nextInt();
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < countNumber; i++) {
            set.add(scanner.nextInt());
        }
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
