import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Stream;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static List<List> lists = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "numbers.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(a ->  addList(a));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Chunks> ");
        int eingabe1 = scanner.nextInt();
        System.out.println("Divider> ");
        int eingabe2 = scanner.nextInt();

        int sub = list.size()/eingabe1;
        int tmp = 0;

        for (int i = 0; i<eingabe1; i++)
        {
                lists.add(list.subList(tmp, sub));
                tmp = sub;
                sub = sub + list.size()/eingabe1;
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        for (int i = 0; i<lists.size(); i++)
        {
            List<Integer> a = lists.get(i);
            Task task = new Task(a, eingabe2);
            executor.execute(task);
        }
        executor.shutdown();
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