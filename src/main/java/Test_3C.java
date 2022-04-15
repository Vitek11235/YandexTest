import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test_3C {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static long[][] numArr;
    private static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
//        System.out.println(simpleNumbers(54));
//        System.out.println(greatestCommonDivisor2(36,54));
        reedFile();
        run();
    }

    private static void run() throws IOException {
        for (int i = 0; i < n; i++) {
            List<Long> list_1 = new ArrayList<>();
            List<Long> list_2 = new ArrayList<>();
            long A = numArr[i][0];
            long B = numArr[i][1];
//            System.out.println(A + " " + B);
            for (long y : simpleNumbers(A)) {
                if (A % y == 0) {
                    list_1.add(y);
                }
            }
            for (long x : simpleNumbers(B)) {
                if (B % x == 0) {
                    list_2.add(x);
                }
            }
            long maxNOD = 0;
            long currentNOD = 0;
            for (long x : list_2) {
                currentNOD = greatestCommonDivisor2(A * x, B);
                if (maxNOD < currentNOD) {
                    maxNOD = currentNOD;
                }
            }
            for (long y : list_1) {
                currentNOD = greatestCommonDivisor2(A, B * y);
                if (maxNOD < currentNOD) {
                    maxNOD = currentNOD;
                }
            }
//            System.out.println(maxNOD);
            bw.write(String.valueOf(maxNOD));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void reedFile() throws IOException {
        n = Integer.parseInt(br.readLine());
//        if (n < 1 || n > 20) return;
        numArr = new long[n][2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            for (int j = 0; j < strArr.length; j++) {
                numArr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
//        for (int i = 0; i < numArr.length; i++) {
//            for (int j = 0; j < numArr[i].length; j++) {
//                System.out.print(numArr[i][j] + " "); // 5 7 3 17 // 7 0 1 12 // 8 1 2 3
//            }
//            System.out.println();
//        }
    }

    private static List<Long> divisorsSimpleNumbers(long number) {
        List<Long> list = new ArrayList<>();
        if (number <= 1) {
            list.add(1l);
            return list;
        }
        for (long i = 1; i <= number; i++) {
            if ((number % i) == 0) {
                list.add(i);
//                System.out.print(i + " ");
            }
        }
        List<Long> listNew = list;
        for (int i = 0; i < list.size(); i++) {
            boolean a = false;
            for (long y : list) {
                if (list.get(i) <= y) {
                    continue;
                }
                else if (list.get(i) % y == 0 && y != 1) {
                    a = true;
                }
            }
            if (a) {
                listNew.remove(i);
                a = false;
            }
        }
//        numList.removeIf(i -> (i > 10 && i < 20));
//        System.out.println();
        for (long x : listNew) {
            System.out.print(x + " ");
        }
        System.out.println();
        return listNew;
    }

    private static List<Long> simpleNumbers(long maxNumber) {
        List<Long> list = new ArrayList<>();
        list.add(2l);
        list.add(3l);
        for (long i = 6; i <= maxNumber + 5; i = i + 6) {
            boolean a = true, b = true;
            for (long x : list) {
                if ((i - 1) % x == 0) {
                    a = false;
                }
                if ((i + 1) % x == 0) {
                    b = false;
                }
            }
            if (a) {
                list.add(i - 1);
                a = true;
            }
            if (b) {
                list.add(i + 1);
                b = true;
            }
        }
        return list;
    }

    private static long greatestCommonDivisor2(long a,
                                               long b) { // Алгоритм Евклида для нахождения НОД (двух чисел)(https://www.youtube.com/watch?v=CVBe39P2hwk&t=1s).
        long nod = 1;
        if (a == b) { // Если числа равны, возвращаем любое из них.
            nod = b;
        }
        if (b > a) { // Если b > a , меняем их местами.
            long c = a;
            a = b;
            b = c;
        }
        if (a > b) { // Пусть а > b.
            long r1 = a % b; // a = b * q1 + r1 (r1 остаток от деления, который < b).
            if (r1 == 0) {
                nod = b;
            }
            else { //(r1 != 0). // b = r1 * q2 + r2 (r2 остаток от деления, который < r1).
                nod = greatestCommonDivisor2(b, r1); // рекурсия.
            }
        }
        return nod;
    }
}
