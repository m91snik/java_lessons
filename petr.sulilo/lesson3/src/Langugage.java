import java.lang.annotation.RetentionPolicy;

/**
 * Created by Petr on 21.07.2015.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Langugage {
    langtype lang() default langtype.FR;

    int maxLength();
}
