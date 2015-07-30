/**
 * Created by Anry on 28.07.2015.
 */
// внутренние классы
public class Outer {
    public class Inner {
        public class inner1 {
        }
        public int counter = outerCounter;
        private int i = 10;

        public Inner() {
        }

        public Inner(int counter) {
            this.counter = counter;
        }
    }

    private int outerCounter;

    private int calc(int i) {
        return i;
    }

}

