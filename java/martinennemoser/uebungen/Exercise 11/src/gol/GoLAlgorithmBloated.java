package src.gol;

public class GoLAlgorithmBloated implements Transitionable{
    @Override
    public Cell[][] nextState(Cell[][] cells) {
        Cell[][] newCells = new Cell[cells.length][cells[0].length];
        for(int i = 0; i < cells.length; i++)
            for(int j = 0; j < cells[0].length; j++) {
                int aliveCells = this.aliveNeighbourCount(cells, i, j, cells.length);




            }

        return cells;
    }

    private int aliveNeighbourCount(Cell[][] cells, int i, int j, int gridSize) {

        int deadCounter = 0;
        int aliveCounter = 0;

        // here we are out of range, thus it must be dead!
        if(i-1 < 0 || j - 1 < 0) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellLeftUpper = cells[i - 1][j - 1];
            Cell.STATE state = cellLeftUpper.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(i-1 < 0) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellMiddleUpper = cells[i-1][j];
            Cell.STATE state = cellMiddleUpper.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(i-1 < 0 || j + 1 >= gridSize) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellRightUpper = cells[i-1][j+1];
            Cell.STATE state = cellRightUpper.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(j - 1 < 0) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellLeftMiddle = cells[i][j-1];
            Cell.STATE state = cellLeftMiddle.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(j+1 >= gridSize) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellRighMiddle = cells[i][j+1];
            Cell.STATE state = cellRighMiddle.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(i+1 >= gridSize || j - 1 < 0) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellLeftLower = cells[i+1][j-1];
            Cell.STATE state = cellLeftLower.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(i+1 >= gridSize) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellMiddleLower = cells[i+1][j];
            Cell.STATE state = cellMiddleLower.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        // here we are out of range, thus it must be dead!
        if(i+1 >= gridSize || j+1 >= gridSize) {
            deadCounter++;
        } else { // our cell exists, check its state
            Cell cellRightLower = cells[i+1][j+1];
            Cell.STATE state = cellRightLower.getState();
            if(state == Cell.STATE.ALIVE) {
                aliveCounter++;
            } else {
                deadCounter++;
            }
        }

        return aliveCounter;
    }

}
