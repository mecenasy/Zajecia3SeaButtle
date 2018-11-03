package sample.Board;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PlayerBoard  extends  Board{

    public PlayerBoard(VBox board) {
        super(board, false);
    }

    @Override
    protected void OnMouseClicked(MouseEvent event) {
        if (!this.ships.isEmpty()) {
            Cell cell = (Cell) event.getSource();
            if ("SECONDARY" == event.getButton().toString()) {
                ChangeDirectionShip();
            } else {
                SetShip(cell.x, cell.y);
            }
        }
    }
}
