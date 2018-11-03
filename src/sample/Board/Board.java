package sample.Board;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.Ships.*;

import java.util.LinkedList;

public abstract class Board {
    private VBox board;
    protected LinkedList<Ship> ships;
    protected Direction directionShip = Direction.Horizontal;
    int shipsAlive = 0;
    boolean isEnemy;
    public Board (VBox board, boolean isEnemy){
        this.isEnemy = isEnemy;
        this.board = board;
        this.ships = new LinkedList<>();
        InitializeBoard();
    }

    public boolean IsSprededShips(){
        return this.ships.isEmpty();
    }
    public int GetShipsAlive (){
        return  this.shipsAlive;
    }

    public Cell GetCell(int x, int y) {
        return (Cell)((HBox)this.board.getChildren().get(x)).getChildren().get(y);
    }

    public void Shot(Cell cell) {
        if(this.ships.isEmpty()){
            cell.Shot();
            if (cell.ship != null && cell.ship.GetShipStatus() == ShipStatus.Dertroyed){
                this.shipsAlive--;
            }
        }
    }

    protected void ChangeDirectionShip() {
        if (this.directionShip != Direction.Horizontal) {
            this.directionShip = Direction.Horizontal;
        } else {
            this.directionShip = Direction.Vertical;
        }
    }

    public void InitializeBoard() {

        if (this.board.getChildren().size() != 0){
            this.board.getChildren().remove(0,10);
        }

        for (int i = 0; i < 10; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 10; j++) {
                Cell cell = new Cell(i, j, this.isEnemy);
                cell.setOnMouseClicked(event -> OnMouseClicked(event));
                cell.setOnMouseEntered(event -> OnOnMouseEntered(event));
                cell.setOnMouseExited(event -> OnOnMouseExited(event));
                row.getChildren().add(cell);
            }
            this.board.getChildren().add(row);
        }
        InitialiseShips();
    }

    private void OnOnMouseEntered(MouseEvent event){
        Cell cell = (Cell) event.getSource();
        cell.SetColor(Color.ALICEBLUE);
    }

    private void OnOnMouseExited(MouseEvent event){
        Cell cell = (Cell) event.getSource();
        cell.SetDefaultColor();
    }

    protected abstract void OnMouseClicked(MouseEvent event);

    protected void SetShip(int x, int y) {
        Cell cell = GetCell(x, y);
        int sailsCount = this.ships.peekFirst().GetMastCount();
        boolean isPossibleSetShip = true;

        if (this.directionShip == Direction.Horizontal) {
            if (sailsCount + cell.x > 10) return;

            for (int i = 0; i < sailsCount; i++) {
                isPossibleSetShip = GetCell(cell.x + i, cell.y).ship == null;
                if (!isPossibleSetShip){
                    break;
                }
            }
            if (isPossibleSetShip) {
                Ship ship = ships.pollFirst();
                cell.SetShip(ship, 0);
                for (int w = 1; w < ship.GetMastCount(); w++) {
                    Cell neighborhoodCell = GetCell(cell.x + w, cell.y);
                    neighborhoodCell.SetShip(ship, w);
                }
            }
        } else {
            if (10 < sailsCount + cell.y) return;

            for (int i = 0; i < sailsCount; i++) {
                isPossibleSetShip = GetCell(cell.x, cell.y + i).ship == null;
                if (!isPossibleSetShip)
                    break;
            }
            if (isPossibleSetShip) {
                Ship ship = ships.pollFirst();
                cell.SetShip(ship, 0);
                for (int w = 1; w < ship.GetMastCount(); w++) {
                    Cell neighborhoodCell = GetCell(cell.x, cell.y + w);
                    neighborhoodCell.SetShip(ship, w);
                }
            }
        }
    }

    protected void InitialiseShips() {
        ships.add(new Submarine( this.isEnemy));
        ships.add(new Destroyer( this.isEnemy));
        ships.add(new Destroyer( this.isEnemy));
        ships.add(new Cruiser( this.isEnemy));
        ships.add(new Cruiser( this.isEnemy));
        ships.add(new Cruiser( this.isEnemy));
        ships.add(new Frigate( this.isEnemy));
        ships.add(new Frigate( this.isEnemy));
        ships.add(new Frigate( this.isEnemy));
        ships.add(new Frigate( this.isEnemy));
        this.shipsAlive = ships.size();
    }
}
