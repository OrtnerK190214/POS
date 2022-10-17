import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {

    private List<Integer> list;
    private int divider;

    public Task(List<Integer> list, int divider) {
        this.list = list;
        this.divider = divider;
    }

    @Override
    public void run() {
        for (int j = 0; j < list.size(); j++) {
            try {
                int ergebnis = list.get(j) / divider;
                if (list.get(j) % divider == 0) {
                    System.out.println(list.get(j) + " ergebnis: " + ergebnis);
                }
            } catch (Exception e) {
            }
        }
    }
}
