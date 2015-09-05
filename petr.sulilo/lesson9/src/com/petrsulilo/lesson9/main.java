package com.petrsulilo.lesson9;

/**
 * Created by Petr on 11.08.2015.
 */
public class main  {

        static int counter;

        public static void main (String[] args) throws InterruptedException {

            Runnable runnable = new Runnable()
            {
                @Override
                public void run()
                {

                    for(int i = 0; i < 10; i++)
                    {
                        try {
                            Thread.sleep(10);
                        }
                        catch (InterruptedException e)
                        {
                            throw new RuntimeException(e);
                        }
                        System.out.println(incriment() + " " +
                            Thread.currentThread().getName());
                    }
                }

            };
            Thread thread = new Thread(runnable);
            System.out.println(thread.getName() + " " + thread.getState());
            thread.start();
            System.out.println(thread.getName() + " " + thread.getState());
            for(int i = 0; i < 10; i++)
            {
                Thread.sleep(10);
                System.out.println(incriment() + " " +
                        Thread.currentThread().getName());
            }


        }
    static synchronized int incriment()
    {
        return ++counter;
    }
}
