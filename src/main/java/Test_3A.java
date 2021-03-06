/*      A. Числовые ребусы

Ограничение времени	1 секунда       |   Ввод	стандартный ввод или input.txt
Ограничение памяти	512Mb           |   Вывод	стандартный вывод или output.txt

Алиса изучает английский язык. Ей надоела обычная речь, поэтому она решила говорить
числовыми ребусами:
    1. Каждой строчной букве латинского алфавита Алиса сопоставила двоичный разряд,
    начиная с младшего: a — 0-й разряд, b — 1-й,…, z —25-й.
    2. Чтобы произнести букву, Алиса инвертирует соответствующий букве бит в специальной
    переменной W и сообщает новое значение W в десятичной системе.
    Определение: инверсия бита j в числе x — изменение значения j-го разряда числа x в
    двоичной системе на противоположное (0 становится 1, 1 становится 0).
    Пример: число 15 (1111) после инверсии бита 2 становится равным числу 11 (1011).
    3. Также Алиса произносит пробел, используя для этого 26-й разряд.
Значение переменной W перед произнесением Алисой первого символа равно 0.
Напишите программу, которая переведет сказанный Алисой числовой ребус.
Примечание: Алиса использует пробел наравне с буквами латинского алфавита — для
пробела не существует дополнительных ограничений и условий для его произнесения.

Формат ввода
В первой строке содержится единственное целое число n (1 ≤ n ≤ 500)  — количество чисел,
сказанных Алисой.
Во второй строке расположено n целых чисел Wi (0 ≤ Wi < 227) — значения переменной W
после произнесения Алисой i-го символа.

Формат вывода
В единственной строке выведите n символов — строчные буквы латинского алфавита или
пробел в порядке произнесения их Алисой.

Пример 1                        |   Пример 2
Ввод                            |   Ввод
5                               |   3
1 2049 2305 2309 2325           |   1 3 2
Вывод                           |   Вывод
alice                           |   aba

Пример 3
Ввод
12
4 132 148 262292 262164 262420 393492 393476 67502340 67502336 67502337 68026625
Вывод
cheshire cat

Примечания
Рассмотрим детально первый пример входных данных:
    1. Начальное значение переменной W равно 0 (по условию задачи).
    2. Сначала Алиса произносит символ a, поэтому значение переменной W становится
    равным 2^0 = 1.
    3. Затем произносится символ l, которому соответствует 11-й разряд, поэтому значение
    переменной W становится равным 2^0 + 2^11 = 2049.
    4. Далее следует символ i (8-й разряд), поэтому W = 2^0 + 2^11 + 2^8 = 2305.
    5. Предпоследним символом является c (2-й разряд) — W = 2^0 + 2^11 + 2^8 + 2^2 = 2309.
    6. Завершает фразу символ e (4-й разряд) — итоговое значение W равно
    2^0 + 2^11 + 2^8 + 2^2 + 2^4 = 2325.
Во втором входном примере последовательность W следующая:
    1. После первого символа a значение W = 2^0 = 1.
    2. После символа b значение W = 2^0 + 2^1 = 3.
    3. После произнесения второго символа a значение W будет равно 2^1 = 2, так как 0-й бит
    инвертируется из 1 в 0. */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test_3A {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
        run();
    }

    private static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());
//        if (n < 1) return;
        String str = br.readLine();
        String[] strArr = str.split(" ");
//        if (n != strArr.length) return;
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        String[] strA = {"a","b","c","d","e","f","g","h","i","j",
                "k","l","m","n","o","p","q","r","s","t",
                "u","v","w","x","y","z"," "};
        StringBuilder result = new StringBuilder();
        result.append(strA[binlog(numArr[0])]);
        for (int i = 1; i < numArr.length; i++) {
            result.append(strA[binlog(Math.abs(numArr[i] - numArr[i - 1]))]);
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }
    //скопировал binlog из интернета, я так не напишу...
    public static int binlog( int bits ) { // returns 0 for bits=0
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 );
    }
}