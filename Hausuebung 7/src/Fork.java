public class Fork {
    private final int id;
    private boolean currentlyused;

    private int currentlyusedby;

    public Fork(int id, boolean used) {
        this.id = id;
        this.currentlyused = used;
    }

    public int getId() {
        return id;
    }

    public boolean isCurrentlyused() {
        return currentlyused;
    }

    public void setCurrentlyused(boolean used) {
        this.currentlyused = used;
    }

    public int getCurrentlyusedby() {
        return currentlyusedby;
    }

    public void setCurrentlyusedby(int currentlyusedby) {
        this.currentlyusedby = currentlyusedby;
    }
}
