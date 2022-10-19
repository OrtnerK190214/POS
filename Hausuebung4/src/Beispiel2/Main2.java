package Beispiel2;

import Beispiel1.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Number> ");
        int eingabe1 = scanner.nextInt();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        int untergrenze = 1;
        int test = 100;
        List<Task2> tasks = new ArrayList<>();
        for (int i = 0; i<eingabe1; i++)
        {
            if (i == test)
            {
                test = test + 100;
                tasks.add(new Task2(untergrenze, i));
                untergrenze = untergrenze + 100;
            }
        }
        tasks.add(new Task2(untergrenze, eingabe1-test));
        for (int i = 0; i<tasks.size(); i++)
        {
            executor.execute(tasks.get(i));
        }
        executor.shutdown();
        int ergebnis = -1;

        for (int i = 0; i<tasks.size(); i++)
        {
            ergebnis = ergebnis + tasks.get(i).getZahl();
        }
        System.out.println(ergebnis);
        System.out.println((eingabe1 * eingabe1 + eingabe1) / 2);
    }
}