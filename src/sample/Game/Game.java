package sample.Game;

import sample.Board.Cell;
import sample.Board.EnemyBoard;
import sample.Board.PlayerBoard;

import java.util.Random;

public class Game {
    private PlayerBoard playerBoard;
    private EnemyBoard enemyBoard;
    private String resultGame = "Nowa gra";
    private boolean isEndGame = false;
    public Game(PlayerBoard playerBoard, EnemyBoard enemyBoard) {
        this.playerBoard = playerBoard;
        this.enemyBoard = enemyBoard;
    }

    public void EnemyShot(){
        Random random = new Random();
        Cell cell;
        do {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            cell = playerBoard.GetCell(x,y);
        } while (cell.wasShot);

        playerBoard.Shot(cell);
    }

    public String ResultGame(){
        if (playerBoard.GetShipsAlive() == 0){
            this.resultGame= "Niestety przegraleś";
            this.isEndGame = true;
        } else if (enemyBoard.GetShipsAlive() == 0){
            this.resultGame="Wygraleś";
            this.isEndGame = true;
        } else {
            this.resultGame= "Gra trwa nadal";
        }
        return this.resultGame;
    }

    public void StartNewGame (){
        this.isEndGame = false;
        playerBoard.InitializeBoard();
        enemyBoard.InitializeBoard();
        enemyBoard.InitializeEnemyShipsOnBoard();
    }

    public boolean IsEndGame() {
        return isEndGame;
    }

    public boolean IsPossibleStartGame(){
        return playerBoard.IsSprededShips() && enemyBoard.IsSprededShips();
    }
}
