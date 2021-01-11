package src.gol;

public class Blinking implements Transitionable {
    @Override
    public Cell[][] nextState(Cell[][] cells) {
        Cell[][] newCells = new Cell[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells[0].length; j++) {
                newCells[i][j] = (Cell) cells[i][j].clone();
                if (cells[i][j].getState() == Cell.STATE.DEAD)
                    newCells[i][j].setState(Cell.STATE.ALIVE);
                else
                    newCells[i][j].setState(Cell.STATE.DEAD);
            }
        return newCells;
    }
}
