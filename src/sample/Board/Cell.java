package sample.Board;

import sample.Ships.Ship;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import sample.Ships.ShipStatus;

public class Cell extends Rectangle  {
    public Ship ship = null;
    int x, y;
    private int mostNumber;
    public boolean wasShot = false;
    public boolean isEnemy = false;
    private Color color;


    public Cell (int x, int y, boolean isEnemy) {
        this(x,y,isEnemy, Color.LIGHTGRAY);
    }

    public Cell (int x, int y, boolean isEnemy, Color defaultColor) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.isEnemy = isEnemy;
        setStroke(Color.BLACK);
        this.color = defaultColor;
        setFill(color);
    }

    public void SetShip(Ship ship, int mostIndex) {
        this.mostNumber = mostIndex;
        this.ship = ship;
        this.color = this.isEnemy? Color.LIGHTGRAY : Color.GREEN ;
        setFill(this.color);
    }

    public void SetColor (Color color){
        setFill(color);
    }

    public void SetDefaultColor () {
        setFill(this.color);
    }

    public void Shot (){
        if(!wasShot){
            this.wasShot = true;
            if (this.ship != null){
                this.ship.Shot(this.mostNumber);
                if(this.ship.GetShipStatus() == ShipStatus.Dertroyed){
                    this.color = Color.RED;
                    setFill(Color.RED);
                } else {
                    this.color = Color.YELLOW;
                    setFill(Color.YELLOW);
                }
            } else {
                    this.color = Color.GREY;
                    setFill(Color.GRAY);

            }
        }
    }
}
