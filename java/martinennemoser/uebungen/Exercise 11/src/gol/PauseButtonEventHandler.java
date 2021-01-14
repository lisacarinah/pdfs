package src.gol;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PauseButtonEventHandler implements EventHandler<ActionEvent> {
    @Override public void handle(ActionEvent e) {
        if(GameOfLife.playButton.getText().equals("Pause"))
            GameOfLife.playButton.setText("Continue");
        else
            GameOfLife.playButton.setText("Pause");
    }
}
