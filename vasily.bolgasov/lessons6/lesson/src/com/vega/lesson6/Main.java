package com.vega.lesson6;

/**
 * Created by Veg'Zul on 30.07.2015.
 */
public class Main {

    public static void main(String[] args) {
//        while(true){
//            main(null);
//        }

//        while(true) {
//            try {
//                main(null);
//            } catch (Throwable t){
//                t.printStackTrace();
//                throw t;
//            }
//        }

//        int i = 0;
//        while(true) {
//            try {
//                System.out.println( 10 / i );
//                break;
//            } catch (ArithmeticException t){
//                t.printStackTrace();
//                i = 1;
//            }
//        }

//        Integer i = null;
//        while(true) {
//            try {
//                System.out.println( 10 / i );
//                break;
//            } catch (NullPointerException t){
//                t.printStackTrace();
//                i = 0;
//            } catch (ArithmeticException t){
//                t.printStackTrace();
//                i = 1;
//            } finally {
//                System.out.println("worked for "+i);
//            }
//        }

        System.out.println(process());

    }

    private static Integer process() {
        Integer i = 0;
//        while(true) {
            try {
                i++;
                throw new NullPointerException("Just for fun");
//                System.out.println( 10 / i );
//                break;
            } catch (NullPointerException t){
                i++;
                return i;
            } finally {
                i++;
               return i;
            }
//        }
//        return -1;
    }
}
