package sample;

        import javafx.event.ActionEvent;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.VBox;
        import sample.Board.EnemyBoard;
        import sample.Board.PlayerBoard;
        import sample.Game.Game;

        import javafx.scene.input.MouseEvent;
        import java.net.URL;
        import java.util.*;

public class Controller implements Initializable {
    public VBox playerBoard = new VBox();
    public VBox enemyBoard = new VBox();
    public GridPane gridPane;
    public Button button;
    public Label label;

    private PlayerBoard player;
    private EnemyBoard enemy;
    private Game game;

    public void OnMouseClicked(MouseEvent event){
        if (game.IsPossibleStartGame() &&!game.IsEndGame() && event.getSource() == enemyBoard){
            game.EnemyShot();
            this.label.setText(game.ResultGame());
        }
        if (player.IsSprededShips()){
            enemy.SetPosibleShots();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.player = new PlayerBoard(this.playerBoard);
        this.enemy = new EnemyBoard(this.enemyBoard);
        this.game = new Game(this.player, this.enemy);
        this.label.setText(game.ResultGame());
    }

    public void OnStartNewGame(ActionEvent actionEvent) {
        game.StartNewGame();
    }
}




