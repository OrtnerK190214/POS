import java.util.concurrent.locks.ReentrantLock;

public class Ork implements Runnable{

    private final int id;
    private final Fork rightFork;
    private final Fork leftFork;

    private ReentrantLock lock;

    public Ork(int id, Fork rightFork, Fork leftFork, ReentrantLock lock) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true)
        {
            drinking();
            lock.lock();
            grabRightDagger();
            grabLeftDagger();
            feasting();
            lock.unlock();
            releaseLeftDagger();
            releaseRightDagger();
        }
    }

    public int getId() {
        return id;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void drinking()
    {
        int random = (int) (Math.random() * (10 + 1)) * 1000;
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            System.out.println("Ork " + id + " is drinking");
    }

    public void grabRightDagger()
    {
        if (rightFork.isCurrentlyused() == false && leftFork.isCurrentlyused() == false)
        rightFork.setCurrentlyused(true);
        rightFork.setCurrentlyusedby(id);
        System.out.println("Ork " + id + " grabs right dagger " + rightFork.getId());
    }

    public void grabLeftDagger()
    {
        if (leftFork.isCurrentlyused() == false && rightFork.getCurrentlyusedby() == id) {
            leftFork.setCurrentlyused(true);
            leftFork.setCurrentlyusedby(id);
            System.out.println("Ork " + id + " grabs left dagger " + leftFork.getId());
        }
    }

    public void feasting()
    {
        if (leftFork.getCurrentlyusedby() == id && rightFork.getCurrentlyusedby() == id) {
            int random = (int) (Math.random() * (10 + 1)) * 1000;
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ork " + id + " is feasting");
        }
    }

    public void releaseLeftDagger()
    {
        if (leftFork.getCurrentlyusedby() == id)
        leftFork.setCurrentlyused(false);
        leftFork.setCurrentlyusedby(-1);
        System.out.println("Ork " + id + " releases left dagger " + leftFork.getId());
    }

    public void releaseRightDagger()
    {
        if (rightFork.getCurrentlyusedby() == id)
        rightFork.setCurrentlyused(false);
        rightFork.setCurrentlyusedby(-1);
        System.out.println("Ork " + id + " releases right dagger " + rightFork.getId());
    }
}
