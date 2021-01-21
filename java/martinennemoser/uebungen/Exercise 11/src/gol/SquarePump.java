package src.gol;

public class SquarePump implements Transitionable {

    @Override
    public Cell[][] nextState(Cell[][] cells) {
        // Initialisierung
        Cell[][] newCells = new Cell[cells.length][cells[0].length];
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                newCells[i][j] = (Cell) cells[i][j].clone();
                newCells[i][j].setState(Cell.STATE.DEAD);
            }
        }
        Cell[] corners = this.getCorners(cells);
        Cell upperLeftCorner = corners[0];
        Cell upperRightCorner = corners[1];
        Cell lowerRightCorner = corners[2];
        Cell lowerLeftCorner = corners[3];


        // upper horizontal line
        for(int t = upperLeftCorner.getPosY();  t <= upperRightCorner.getPosY(); t++) {
            newCells[upperLeftCorner.getPosX()][t].setState(Cell.STATE.ALIVE);
        }

        // lower horizontal line
        for(int b = lowerLeftCorner.getPosY(); b <= lowerRightCorner.getPosY(); b++) {
            newCells[lowerLeftCorner.getPosX()][b].setState(Cell.STATE.ALIVE);
        }

        // left vertical line
        for(int l = upperLeftCorner.getPosX(); l <= lowerLeftCorner.getPosX(); l++) {
            newCells[l][upperLeftCorner.getPosY()].setState(Cell.STATE.ALIVE);
        }

        // rigtht vertical line
        for(int r = upperRightCorner.getPosX(); r <= lowerRightCorner.getPosX(); r++) {
            newCells[r][upperRightCorner.getPosY()].setState(Cell.STATE.ALIVE);
        }

        return newCells;
    }

    private Cell[] getCorners(Cell[][] cells) {
        Cell[] corners = new Cell[4];
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                // if we reached the edges => continue
                if(i == 0 || i == cells.length-1 || j == 0 || j == cells.length-1)
                    continue;

                // upper left corner
                if(cells[i][j].getState() == Cell.STATE.ALIVE &&
                        cells[i][j-1].getState() == Cell.STATE.DEAD &&
                        cells[i-1][j].getState() == Cell.STATE.DEAD) {
                    corners[0] = cells[i-1][j-1];
                }

                // upper right corner
                if(cells[i][j].getState() == Cell.STATE.ALIVE &&
                        cells[i-1][j].getState() == Cell.STATE.DEAD &&
                        cells[i][j+1].getState() == Cell.STATE.DEAD) {
                    corners[1] = cells[i-1][j+1];
                }

                // lower right corner
                if(cells[i][j].getState() == Cell.STATE.ALIVE &&
                        cells[i+1][j].getState() == Cell.STATE.DEAD &&
                        cells[i][j+1].getState() == Cell.STATE.DEAD) {
                    corners[2] = cells[i+1][j+1];
                }

                // lower left corner
                if(cells[i][j].getState() == Cell.STATE.ALIVE &&
                        cells[i+1][j].getState() == Cell.STATE.DEAD &&
                        cells[i][j-1].getState() == Cell.STATE.DEAD) {
                    corners[3] = cells[i+1][j-1];
                }
            }
        }
        return corners;
    }

}