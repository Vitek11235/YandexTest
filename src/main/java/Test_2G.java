import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Test_2G {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[][] coordCities;
    private static double[][] distCities;
    private static int numbersOfCities;
    private static int maxDistance;
    private static int from;
    private static int to;
    private static List<Integer> ex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new FileWriter("output.txt"));
        reedFile();
        arrayDistanceCalculation();
        if (distCities[from - 1][to - 1] != 0) {
            bw.write(String.valueOf(ex.size()));
        }
        else {
            run(from);
        }
        bw.close();
    }

    private static void reedFile() throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        numbersOfCities = Integer.parseInt(br.readLine());
        coordCities = new int[numbersOfCities][2];
        for (int i = 0; i < coordCities.length; i++) {
            String str = br.readLine();
            coordCities[i][0] = Integer.parseInt(str.substring(0, str.indexOf(' ')));
            coordCities[i][1] = Integer.parseInt(str.substring((1 + str.indexOf(' '))));
        }
        System.out.println(Arrays.deepToString(coordCities));
        maxDistance =
                Integer.parseInt(br.readLine()); // максимальное расстояние между городами, которое можно преодолеть
        String str = br.readLine();
        br.close();
        from = Integer.parseInt(str.substring(0, str.indexOf(' ')));
        to = Integer.parseInt(str.substring((1 + str.indexOf(' '))));
        System.out.println(maxDistance + " " + from + " " + to);
    }

    private static double distanceСalculation(int from, int to) {
        double distance = Math.sqrt(
                Math.pow((coordCities[from - 1][0] - coordCities[to - 1][0]), 2) +
                        Math.pow((coordCities[from - 1][1] - coordCities[to - 1][1]), 2));
        return distance;
    }

    private static void arrayDistanceCalculation() {
        distCities = new double[numbersOfCities][numbersOfCities];
        for (int i = 0; i < distCities.length; i++) {
            for (int j = 0; j < distCities[i].length; j++) {
                double dist = distanceСalculation(i + 1, j + 1);
                if (dist <= maxDistance) {
                    distCities[i][j] = dist;
                }
            }
        }
        for (int i = 0; i < distCities.length; i++) {
            for (int j = 0; j < distCities[i].length; j++) {
                System.out.print(distCities[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void run(int a) throws IOException {
        ex.add(a);
        for (int i = 0; i < numbersOfCities; i++) {
            if (i == a - 1) {
                continue;
            }

            if (distCities[a - 1][i] != 0 && i == to - 1) {
                bw.write(String.valueOf(ex.size()));
                break;
            }
            else if (distCities[a - 1][i] != 0 && i != to) {
                run(i);
            }
            else {
                ex.remove(a);
            }
        }
    }
}
