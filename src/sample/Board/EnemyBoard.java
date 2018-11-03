package sample.Board;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.Ships.Direction;

import java.util.Random;

public class EnemyBoard extends Board {
    private boolean isPosibleShot = false;
    public EnemyBoard(VBox board){
        super(board, true);
        InitializeEnemyShipsOnBoard();
    }

    @Override
    protected void OnMouseClicked(MouseEvent event) {
        if (this.isPosibleShot) {
            Cell cell = (Cell) event.getSource();
            Shot(cell);
        }
    }

    public void SetPosibleShots(){
        this.isPosibleShot = true;
    }
    public void InitializeEnemyShipsOnBoard() {
        while (!this.ships.isEmpty()){
            Random random = new Random();
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (random.nextBoolean() == true){
                this.directionShip = Direction.Horizontal;
            } else {
                this.directionShip = Direction.Vertical;
            }
            SetShip(x,y);

        }
    }
}
