package Beispiel2;

import java.util.List;
import java.util.concurrent.Callable;

public class Task2 implements Callable<Integer> {

    private int zahl;
    private int obergrenze;
    private int untergrenze;

    public Task2(int obergrenze, int untergrenze) {
        this.obergrenze = obergrenze;
        this.untergrenze = untergrenze;
        this.zahl = 0;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = untergrenze; i<=obergrenze; i++)
        {
            zahl = zahl + i;
        }
        return zahl;
    }
}
