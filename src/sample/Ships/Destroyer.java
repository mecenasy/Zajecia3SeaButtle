package sample.Ships;

public class Destroyer extends  Ship{
    public Destroyer(boolean isEnemy) {
        super(3, isEnemy);
    }

    @Override
    public ShipStatus SetStatus() {
        boolean isDestroyed = this.sails[0].IsBrokenMast() && this.sails[1].IsBrokenMast() &&this.sails[2].IsBrokenMast();
        if (isDestroyed) {
            this.status = ShipStatus.Dertroyed;
        } else {
            this.status = ShipStatus.Hit;
        }
        return this.status;
    }

    @Override
    public void Shot(int mastIndex) {
        super.Shot(mastIndex);
        SetStatus();
    }
}
