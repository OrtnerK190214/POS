package Beispiel2;

public class Task2 implements Runnable{

    private int zahl;
    private int obergrenze;
    private int untergrenze;

    public Task2(int obergrenze, int untergrenze) {
        this.obergrenze = obergrenze;
        this.untergrenze = untergrenze;
        this.zahl = 0;
    }

    @Override
    public void run() {
        for (int i = untergrenze; i<obergrenze; i++)
        {
            zahl = zahl + i;
        }
        System.out.println(zahl);
    }

    public int getZahl() {
        return zahl;
    }
}
