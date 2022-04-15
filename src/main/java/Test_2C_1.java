import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_2C_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countNumber = scanner.nextInt();
        List<Integer> array = new ArrayList<>();
        int previousElement = scanner.nextInt();
        int nextElement =  previousElement;
        array.add(previousElement);
        for (int i = 1; i < countNumber; i++) {
            nextElement = scanner.nextInt();
            if (nextElement != previousElement) {
                array.add(nextElement);
            }
            previousElement = nextElement;
        }
        for (Integer i : array) {
            System.out.println(i);
        }
    }
}