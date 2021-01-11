package src.gol;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class GameOfLife extends Application {
    // cells array
    Cell[][] cells;
    // Button for pausing the animation
    Button playButton = new Button("Pause");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int gridSize = 100;
        Canvas canvas = new Canvas();

        canvas.setHeight(Cell.size*gridSize);
        canvas.setWidth(Cell.size*gridSize);

        primaryStage.setWidth(Cell.size*gridSize);
        primaryStage.setHeight(Cell.size*gridSize+100);

        cells = new Cell[gridSize][gridSize];

        createCells(canvas, gridSize);
        initCellState();
        createAnimation();
        createActionListeners();

        VBox vbox = new VBox();
        vbox.setSpacing(30);
        Scene scene = new Scene(vbox);

        ObservableList list = vbox.getChildren();

        //Adding all the nodes to the observable list
        list.addAll(canvas, this.playButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initCellState() {
        // Note: If you want to have "new" sequences then remove the seed argument
        Random rand = new Random(1);
        for(int i = 0; i < this.cells.length; i++)
            for(int j = 0; j < this.cells[0].length; j++) {
                int v = rand.nextInt(2);
                if(v == 0)
                    cells[i][j].setState(Cell.STATE.ALIVE);
                else
                    cells[i][j].setState(Cell.STATE.DEAD);
            }
    }

    private void createCells(Canvas canvas, int gridSize) {
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        for(int i = 0; i < gridSize; i++)
            for(int j = 0; j < gridSize; j++) {
                cells[i][j] = new Cell(graphicsContext2D, i, j);
            }
    }

    private void createAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    if(GameOfLife.this.playButton.getText().equals("Pause")) {
                        // TODO replace Blinking with your own implementation
                        GameOfLife.this.cells = new Blinking().nextState(GameOfLife.this.cells);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        timer.start();
    }

    private void createActionListeners() {
        this.playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(GameOfLife.this.playButton.getText().equals("Pause"))
                    GameOfLife.this.playButton.setText("Continue");
                else
                    GameOfLife.this.playButton.setText("Pause");
            }
        });
    }

}
