import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock rLock = new ReentrantLock();
        Fork[] forks = new Fork[5];
        for (int i = 0; i<forks.length; i++)
        {
            forks[i] = new Fork(i, false);
        }

        Thread Ork1 = new Thread(new Ork(1, forks[0], forks[1], rLock));
        Thread Ork2 = new Thread(new Ork(2, forks[1], forks[2], rLock));
        Thread Ork3 = new Thread(new Ork(3, forks[2], forks[3], rLock));
        Thread Ork4 = new Thread(new Ork(4, forks[3], forks[4], rLock));
        Thread Ork5 = new Thread(new Ork(5, forks[4], forks[0], rLock));

        Ork1.start();
        Ork2.start();
        Ork3.start();
        Ork4.start();
        Ork5.start();
    }
}