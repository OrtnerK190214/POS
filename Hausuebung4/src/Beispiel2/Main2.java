package Beispiel2;

import Beispiel1.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Number> ");
        int eingabe1 = scanner.nextInt();

        int untergrenze = 1;
        int test = 100;
        int threads = 1;

        List<Task2> callables = new ArrayList<>();

        for (int i = 0; i < eingabe1; i++) {
            if (i == test) {
                test = test + 100;
                callables.add(new Task2(i, untergrenze));
                untergrenze = untergrenze + 100;
                threads++;
            }
        }

        callables.add(new Task2(eingabe1, untergrenze));

        ExecutorService pool = Executors.newFixedThreadPool(threads);
        int result = 0;
        try {
            for (Future<Integer> future : pool.invokeAll(callables)) {
                int tmp = future.get();
                System.out.println(tmp);
                result += tmp;
            }
        } catch (ExecutionException | InterruptedException ex) {
        }
        pool.shutdown();
        System.out.println("Ergebniss: " + result);
        System.out.println("Gaussische Summenformel: " + (eingabe1 * eingabe1 + eingabe1) / 2);
    }
}