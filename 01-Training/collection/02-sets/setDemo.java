import java.util.HashSet;
import java.util.Set;

public class setDemo {
    public static void main(String[] args) {
        Set<String> usernames = new HashSet<>();

        usernames.add("admin");
        usernames.add("guest");
        usernames.add("admin");

        System.out.println(usernames);
    }
}
