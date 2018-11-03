package sample.Ships;

public class Frigate extends Ship {
    public Frigate(boolean isEnemy) {
        super(1, isEnemy);
    }

    @Override
    public ShipStatus SetStatus() {
        this.status = ShipStatus.Dertroyed;
        return this.status;
    }

    @Override
    public void Shot(int mastIndex) {
        super.Shot(mastIndex);
        SetStatus();
    }
}
