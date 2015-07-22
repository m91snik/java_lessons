import com.annotation.example.MaxLength;
import com.annotation.example.Message;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by stanislav on 21.07.15.
 */

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
        Message message = new Message();
        Field[] fields = message.getClass().getDeclaredFields();

        System.out.println(Arrays.toString(fields));

        MaxLength maxLengh = message.getClass().getDeclaredField("text").getAnnotation(MaxLength.class);
        if (maxLengh.value() < message.getText().length()) {
            message.setText(message.getText().substring(0, maxLengh.value()));
        }
    }
}
