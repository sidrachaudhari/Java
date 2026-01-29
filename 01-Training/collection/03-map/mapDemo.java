import java.util.HashMap;
import java.util.Map;

public class mapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(1, "Charlie");

        System.out.println(students);
        System.out.println("Student 2: " + students.get(2));
    }
}
