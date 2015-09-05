package com.petrsulilo.lesson6;

/**
 * Created by Petr on 30.07.2015.
 */
public class Main {
    public static void main(String[] args)
    {
        process();

    }

    private static Integer process() {
        Integer i = null;
        //while (true)
        {
            try {
                System.out.println(10/i);
                //break;
            } catch (NullPointerException t)
            {
                return 0;
            }
            finally {
                return 1;
            }


        }
    }
}
