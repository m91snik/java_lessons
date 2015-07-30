import java.util.Arrays;

/**
 * Created by Anry on 21.07.2015.
 */
public class Lesson3 {
    public static void main(String... args) {
        for (int i = 0; i < 10; ) {
            i++;
            int j = 1;
            System.out.print(i);
            System.out.print(j);

        }
        System.out.print("\n");
        int[][] mas = new int[10][5];
        mainFor:
        for (int k = 0; k < mas.length; k++) {
            for (int l = 0; l < mas[k].length; l++) {
                mas[k][l] = k + l;

            }
        }
        System.out.println(Arrays.deepToString(mas));
        int[][][] mas2 = new int[10][5][7];
        System.out.println(Arrays.deepToString(mas2));

        // enum:
        System.out.println(CardType.DP.calculateTaxAmount(100.0));

        // Annotations


    }
}