import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        //Beispiel 2
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

        //Beispiel 3
        NumberTester numberTester = new NumberTester("C:\\Users\\kai17\\Desktop\\Hausuebung2 Test.txt");
        numberTester.testFile();

        //Beispiel 4

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int eingabe = 0;
        do {
            System.out.println("Choose calculator: ");
            System.out.printf("1 - Relational calculator");
            System.out.printf("2 - Vector calculator");
            System.out.printf("3 - Complex calculator");
            System.out.printf("4 - Exit program");
            eingabe = scanner.nextInt();

            System.out.println("Enter number x a> 1");
            int a1 = scanner.nextInt();
            System.out.println("Enter number x b> 1");
            int a2 = scanner.nextInt();
            System.out.println("Enter number y a> 1");
            int b1 = scanner.nextInt();
            System.out.println("Enter number y b> 1");
            int b2 = scanner.nextInt();
            Number number1 = new Number(a1, a2);
            Number number2 = new Number(b1, b2);

            System.out.println("Choose operation: ");
            System.out.println("1 - add");
            System.out.println("2 - subtract");
            System.out.println("3 - multiply");
            System.out.println("4 - divide");
            System.out.println("5 - enter numbers again");
            int eingabe2 = scanner.nextInt();
        } while (eingabe != 4);
    }
}