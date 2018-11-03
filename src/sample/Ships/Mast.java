package sample.Ships;

public class Mast {
    private boolean broken;
    private boolean isEnemy;


    public Mast(boolean isEnemy) {
        this.isEnemy = isEnemy;
        this.broken = false;
    }

    public void SetBrokenMast(){
        this.broken = true;
    }

    public boolean IsBrokenMast() {
        return this.broken;
    }
}
