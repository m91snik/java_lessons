/**
 * Created by HP on 08.08.2015.
 */
public enum Znack {
    plus("+"),
    minus("-"),
    multiply("*"),
    transpose("~");

    public String name;

     private Znack(String name) {
        this.name = name;
    }
}
