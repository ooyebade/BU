import java.util.LinkedList;
import java.util.Queue;

public class ClassExperiment {

    public static void main(String[] args) {
        Queue<String> elements = new LinkedList<>();

        elements.add("x");
        elements.add("y");
        elements.add("z");

        elements.remove("x");
        elements.remove("y");

        System.out.println(elements);
    }
}