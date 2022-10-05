import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");

        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };

        list.forEach((String s) -> System.out.println(s));

        list.forEach(consumer);

        list.forEach(System.out::print);

        NumberTester numberTester = new NumberTester("Test.txt");
        numberTester.testFile();
    }
}