import com.example.Activity;
import com.example.my.*;

/**
 * Created by stanislav on 16.07.15.
 */
public class Main {
    public static void main (String[] args){
        System.out.println("Info");

        Person person = new Person();

        System.out.println(person.name + ", " + person.age);

        System.out.println(person.showGeoInfo());

        Activity activity = new Activity();

        System.out.println("Activity type: " + activity.type + ", count: " + activity.count);
    }
}
