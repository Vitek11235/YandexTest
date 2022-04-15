import java.util.Scanner;

public class Test_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите текст"); // 123456789 673243342
        String text = scanner.nextLine();
        String[] numbers = text.split(" ");
        int result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        System.out.println(result);
    }
}
