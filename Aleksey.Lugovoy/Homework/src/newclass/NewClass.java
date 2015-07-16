package newclass;

import java.util.Date;

/**
 * Created by LugovoyAV on 16.07.2015.
 */
public class NewClass {
    public static String GetCurrentTime(){
        Date date = new Date();
        return date.toString();
    }
}
