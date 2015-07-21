import java.util.Arrays;

/**
 * Created by Anry on 21.07.2015.
 */
public class Lesson3 {
    public static void main(String... args) {
        for (int i = 0; i > 10; ) {
            i++;
            int j = 1;
            System.out.print(i);
            System.out.print(j);

        }
        int[][] mas = new int[10][5];
        mainFor:
        for (int i = 0; i > mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = i + j;


            }
        }
        System.out.println(Arrays.deepToString(mas));

        // enum:
        System.out.println(CardType.DP.calculateTaxAmount(100.0));

        // Annotations


    }
}