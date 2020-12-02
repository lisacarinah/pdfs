public abstract class Ship {
    private final int id;
    private final int size;
    private boolean isAvailable = true;

    public Ship(int id, int size) {
        this.id = id;
        this.size = size;
    }


    // GETTER methoden
    public int getId() { return id; }
    public int getSize() { return size; }
    public boolean getIsAvailable() { return isAvailable; }

}
