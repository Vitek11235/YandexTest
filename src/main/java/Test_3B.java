/*      B. Шестиугольники
Ограничение времени	1 секунда       |   Ввод	стандартный ввод или input.txt
Ограничение памяти	512Mb           |   Вывод	стандартный вывод или output.txt

На клетчатом поле нарисовали некоторую картину, состоящую из одинаковых шестиугольников.
Шестиугольники, из которых состоит картина, задаются с помощью следующих символов:
    Нижнее подчеркивание (_) для верхней и нижней стороны.
    Слеш (/) для верхней левой и нижней правой стороны.
    Обратный слеш (\) для верхней правой и нижней левой стороны.
    Любая заглавная латинская буква (например, X) в центре шестиугольника.
Ниже представлен пример шестиугольника:
.....
.._..
./X\.
.\_/.
.....

Нарисованные шестиугольники не пересекаются и не накладываются друг на друга, но могут
иметь общую сторону (см. примеры).
Картина вписывается в клетчатое поле с наименьшими возможными высотой и шириной.
После этого добавляется первая и последняя строка, и первый и последний столбец,
состоящие из символов . (точка). Все клетки, которые не содержатся в картине, также
заполняются символом . (точка).
Вам необходимо отразить поле с шестиугольниками по вертикали и горизонтали, после чего
вывести итоговое отраженное поле.

Формат ввода
В первой строке вводятся числа n и m (5 ≤ n, m ≤ 100) — размеры поля. Далее в n строках
вводится поле, по m символов в каждой строке.
Формат вывода
Выведите n строк по m символов в каждой — отраженное поле.

Пример 1
Ввод                        Вывод
8 13                        .............
.............               ......_......
...._........               ...._/G\_....
.._/A\_..._..               .._/E\_/C\_..
./B\_/D\_/F\.               ./F\_/D\_/B\.
.\_/C\_/E\_/.               .\_/.\_/A\_/.
...\_/G\_/...               .......\_/...
.....\_/.....               .............
.............

Пример 2
Ввод	                    Вывод
5 5                         .....
.....                       .._..
.._..                       ./X\.
./X\.                       .\_/.
.\_/.                       .....
.....

Примечания
Рассмотрим первый тестовый пример:
Вот так будет выглядеть исходное поле, отраженное только по вертикали:

.............
........_....
.._..._/A\_..
./F\_/D\_/B\.
.\_/E\_/C\_/.
...\_/G\_/...
.....\_/.....
.............

А вот так  — отраженное только по горизонтали:
.............
......_......
...._/G\_....
.._/C\_/E\_..
./B\_/D\_/F\.
.\_/A\_/.\_/.
...\_/.......
.............

Во втором примере входных данных единственный многоугольник сохраняет свой начальный
вид при любом способе отражения.
 */
public class Test_3B {
}
