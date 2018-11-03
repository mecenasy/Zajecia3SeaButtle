package sample.Ships;

public abstract class Ship{
    protected int mastCount;
    protected ShipStatus status;
    protected Mast[] sails;
    private boolean isEnemy;

    public Ship (int sailCount ){
        this(sailCount,false);
    }

    public Ship (int sailCount, boolean isEnemy ){
        this.isEnemy = isEnemy;
        this.mastCount = sailCount;
        this.status = ShipStatus.Healthy;
        this.sails = new Mast[sailCount];

        for (int i = 0; i < sailCount; i++){
            this.sails[i] = new Mast(isEnemy);
        }
    }
    public int GetMastCount(){
        return this.mastCount;
    }

    public ShipStatus GetShipStatus (){
        return this.status;
    }

    public Mast GetMast(int mastIndex){
        return this.sails[mastIndex];
    }

    public abstract ShipStatus SetStatus();

    public  void Shot(int mastIndex){
        GetMast(mastIndex).SetBrokenMast();
    };
}
