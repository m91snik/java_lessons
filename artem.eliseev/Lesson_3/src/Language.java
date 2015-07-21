import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Anry on 21.07.2015.
 */
@Target(ElementType.FIELD);
@Retention(RetentionPolicy.RUNTIME)
public @interface Language{
    LangType lang () default LangType.FR;

    int maxLengh ();

}
