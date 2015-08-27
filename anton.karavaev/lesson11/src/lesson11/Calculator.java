package lesson11;

/**
 * Created by HP on 20.08.2015.
 */
public interface Calculator <T extends Number> {
    T calc (T i, T j);
}
