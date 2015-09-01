package lesson11;

public class Main {

    public static void main (String[] args)  {

        Calculator <Double> summator = (i, j) -> i + j;
        System.out.println(summator.calc(10.0, 20.0));


        Printer printer = (strings -> {
         for (String string : strings) {
             System.out.println(strings);
         }
        }); printer.print( new String[] {"a", "b", "c"});
    }
}
