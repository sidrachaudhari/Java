import java.util.ArrayList;
import java.util.List;

class UserService {

    public void registerUser(String username, int age) {
        if (age < 18) {
            System.out.println("User not eligible: " + username);
            return;
        }

        User user = new User(username, age);
        DataStore.getRepository().add(user);
    }

    public void printAllUsers() {
        for (User user : DataStore.getRepository().findAll()) {
            System.out.println(user.getUsername() + " (" + user.getAge() + ")");
        }
    }
}

class UserRepository {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }
}

class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

class DataStore {
    private static UserRepository repository = new UserRepository();

    public static UserRepository getRepository() {
        return repository;
    }
}


public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        service.registerUser("alice", 20);
        service.registerUser("bob", 16);

        service.printAllUsers();
    }
}
