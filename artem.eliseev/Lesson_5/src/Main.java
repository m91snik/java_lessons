/**
 * Created by Anry on 28.07.2015.
 */
public class Main {
    public static void main(String[] args) {
//List <Objects> objects = Arrays.list

//ошибка, нулевой масссив
//        System.out.println (args [0]);
        System.out.println(args.length);
        System.out.println(args);
        for (String arg : args) {
            System.out.println(args);

        }


        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.new Inner();

        inner.counter = 1;


    }
    //validation
    public void  process (String firstOrder, String... orderIds ){

    }




}
