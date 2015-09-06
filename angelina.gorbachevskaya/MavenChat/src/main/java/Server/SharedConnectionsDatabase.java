package Server;

import Utils.UserID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 9/4/15.
 */
public class SharedConnectionsDatabase<E extends UserID> {
    private static final Logger logger = LogManager.getLogger(SharedConnectionsDatabase.class);

    private final ConcurrentHashMap<E, String> users;

    public SharedConnectionsDatabase() {
        this.users = new ConcurrentHashMap<>();
    }

    public void put(E e) {
        if (!users.containsKey(e)) {
            users.put(e, "");
            logger.info("User " + e.toString() + " add to database.");

//            System.out.println("Клиент добавлен в базу");
        }
    }

    public E take(String name) {
        for (Map.Entry<E, String> entry : users.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Set<Map.Entry<E, String>> all() {
        return users.entrySet();
    }

    public void remove(E e) {
        logger.info("User "+e.toString()+" removed.");
        users.remove(e);
    }

    @Override
    public String toString() {
        return "SharedConnectionsDatabase{" +
                "users=" + users +
                '}';
    }
}
