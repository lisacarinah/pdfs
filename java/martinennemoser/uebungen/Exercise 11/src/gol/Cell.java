package src.gol;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Cell implements Cloneable {
    private final int posY;
    private final int posX;
    public static final int size = 5;

    public enum STATE {
        ALIVE,
        DEAD
    }

    private STATE state = null;
    private final GraphicsContext graphicsContext2D;
    public Cell(GraphicsContext graphicsContext2D, int posX, int posY) {
        this.graphicsContext2D = graphicsContext2D;
        this.posX = posX;
        this.posY = posY;
    }

    public void setState(STATE state) {
        this.state = state;
        if(state == STATE.ALIVE)
            graphicsContext2D.setFill(Color.valueOf("#ff0000"));
        else
            graphicsContext2D.setFill(Color.valueOf("#ffffff"));
        graphicsContext2D.fillRect(this.posX*Cell.size, this.posY*Cell.size, Cell.size, Cell.size);
    }

    public STATE getState() {
        return this.state;
    }

    public Object clone()
    {
        Cell c = new Cell(this.graphicsContext2D, this.posX, this.posY);
        c.setState(this.state);
        return c;
    }
}
