public abstract class Ship {
    private final int id;
    private final int size;
    private boolean isAvailable = true;
    private String name;

    public Ship(int id, int size, String name) {
        this.id = id;
        this.size = size;
        this.name = name;
    }


    // GETTER methoden
    public int getId() { return id; }
    public int getSize() { return size; }
    public boolean getIsAvailable() { return isAvailable; }
    public String getName() {return this.name;}

    // SETTER methoden
    public void setIsAvailable(boolean val) {
        this.isAvailable = val;
    }

}
