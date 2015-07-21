import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[10][5];
        mainFor :
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
                if ((i + j)  == 10){
                    break mainFor;
                }
            }
        }

        System.out.print(CardType.DP.calTex(100));

    }

}
/*
Alt +Ctl + l = форматированиа
Alt + Ctl + o = вынос переменной
Alt + Enter
*/