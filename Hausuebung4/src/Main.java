import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = "numbers.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(a ->  addList(a));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("chunks> ");
        int eingabe1 = scanner.nextInt();
        System.out.println("divider> ");
        int eingabe2 = scanner.nextInt();

        for (int i = 0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    public static void addList(String a)
    {
        String[] splitted = a.split(":");
        for (int i = 0; i<splitted.length; i++)
        {
            try {
                list.add(Integer.parseInt(splitted[i]));
            }
            catch (Exception e) {}
        }
    }
}