/*      C. Домашнее задание
Ограничение времени	2 секунды       |   Ввод	стандартный ввод или input.txt
Ограничение памяти	512Mb           |   Вывод	стандартный вывод или output.txt

Борис прошел в школе сразу две новых темы - наибольший общий делитель (НОД) и простые числа.
Определение: наибольшим общим делителем двух целых положительных чисел A и B
называют такое число G, что:
    1. A делится на G нацело (G является делителем A);
    2. B делится на G нацело (G является делителем B);
    3. не существует числа H такого, что G < H и H удовлетворяет условиям 1 и 2.
Определение: число P называется простым, если у него есть ровно два различных делителя:
1 и само число P.
К примеру:
    число 1 не является простым, так как у него только один делитель — 1;
    4 не простое, так как у 4 есть три делителя — 1, 2, 4;
    6 не простое, так как у 6 четыре различных делителя — 1, 2, 3, 6.
В качестве домашнего задания Борису необходимо решить T заданий следующего вида:
«Даны два целых числа A и B, можно ровно один раз умножить либо A, либо B на любое
простое число. Какого наибольшего значения НОД можно добиться с помощью такого умножения?»
Пример:
    Пусть A = 20, B = 45. НОД(20,45) = 5.
    При умножении числа A на простое число 3 итоговый НОД(20⋅3, 45) = 15.
    При умножении числа B на простое число 2 итоговый НОД(20,45⋅2)=10.
Пожалуйста, ознакомьтесь с примерами тестов и пояснениями к ним для лучшего понимания условия.

Формат ввода
В первой строке дано целое число T (1 ≤ T ≤ 20) — количество заданий.
В каждой из следующих T строк содержатся два целых числа A и B (1 ≤ A, B ≤ 10^12) — параметры задания.

Формат вывода
Для каждого задания выведите единственное целое число — наибольшее значение НОД,
которого можно добиться умножением одного из чисел A и B на любое простое число.

Пример
Ввод                        Вывод
3                           5
5 1                         18
12 54                       500100
500100 100500

Примечания
Рассмотрим детально пример входных данных:
    1. Необходимо умножить число B = 1 на простое число 5, тогда НОД(5, 1⋅5) = 5.
    2. НОД(12, 54) = 6. Для получения оптимального ответа необходимо умножить число
    A = 12 на простое число 3.
    В таком случае НОД(12⋅3, 54) = НОД(36, 54) = 18, так как 54 = 18⋅3, 36 = 18⋅2.
        Другой разрешенный, но неоптимальный вариант — умножить B = 54 на простое
        число 2.
        В таком случае итоговый НОД(12, 54⋅2) = НОД(12, 108) = 12, так как 108 = 12⋅9.
        Неразрешенный, пусть и более оптимальный вариант — умножить A = 12 на не
        простое число 9.
        В таком случае НОД(12⋅9, 54) = НОД(108, 54) = 54 > 18.
        Но так как 9 не является простым числом, такое умножение по условию задания делать нельзя.
    3. НОД (500100, 100500) = 300. Для получения оптимального ответа необходимо
    умножить число B = 100500 на простое число 1667.
    В таком случае НОД(500100, 100500⋅1667) = НОД(500100, 167533500) = 500100, так
    как 167533500 = 500100⋅335.     */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test_3C_1 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static long[][] numArr;
    private static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
//        System.out.println(simpleNumbers(54));
//        System.out.println(greatestCommonDivisor2(500100,100500));

//        Map<Long, Integer> map_NOD = factorization(500100);
//        for (Map.Entry<Long, Integer> entry : map_NOD.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        reedFile();
        run();
    }

    private static void run() throws IOException {
        for (int i = 0; i < n; i++) {
            long A = numArr[i][0];
            long B = numArr[i][1];
//            System.out.println(A + " " + B);
            Map<Long, Integer> map_NOD = factorization(greatestCommonDivisor2(A, B));
            Map<Long, Integer> map_A = factorization(A);
            Map<Long, Integer> map_B = factorization(B);
            for(Map.Entry<Long,Integer> entry_NOD : map_NOD.entrySet()){
                Long key = entry_NOD.getKey();
                if (map_A.containsKey(key)) {
                    map_A.put(key, (map_A.get(key) - entry_NOD.getValue()));
                }
                if (map_B.containsKey(key)) {
                    map_B.put(key, (map_B.get(key) - entry_NOD.getValue()));
                }
            }
            Long max_A = maxKeyinMap(map_A);
            Long max_B = maxKeyinMap(map_B);
            long maxNOD = 0;
            if (max_A > max_B) {
                maxNOD = greatestCommonDivisor2(A, B * max_A);
            }
            else if (max_B > max_A) {
                maxNOD = greatestCommonDivisor2(A * max_B, B);
            }
            bw.write(String.valueOf(maxNOD));
            bw.newLine();
        }
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
        br.close();
//        for (int i = 0; i < numArr.length; i++) {
//            for (int j = 0; j < numArr[i].length; j++) {
//                System.out.print(numArr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static Map<Long, Integer> factorization(long number) { // разложение на множители
        Map<Long, Integer> map = new LinkedHashMap<>();
        for (long i = 2; i <= number; i++) {
            for (int j = 1; ; j++) {
                if (number == 1) {
                    break;
                }
                else if (number % i == 0) {
                    map.put(i, j);
                    number = number / i;
                }
                else {
                    break;
                }
            }
        }
        return map;
    }

    private static Long maxKeyinMap(Map<Long,Integer> map) {
        Long max = 0l;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            if (entry.getValue() > 0 && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }

    private static long greatestCommonDivisor2(long a,
                                               long b) { // Алгоритм Евклида для нахождения НОД (двух чисел)(https://www.youtube.com/watch?v=CVBe39P2hwk&t=1s).
        long nod = 1;
        if (a == b) { // Если числа равны, возвращаем любое из них.
            nod = b;
        }
        if (b > a) { // Если b > a, меняем их местами.
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
