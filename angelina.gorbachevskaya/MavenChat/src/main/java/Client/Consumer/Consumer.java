package Client.Consumer;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface Consumer<E> {
    public void consume(E e);
}
