public class Player extends App {
    boolean isBankrupt;
    private boolean inJail;
    private winStatus winner;
    private final Order playerOrder;
    public int money;
    public int propertiesOwned;
    public int playerPosition;

    public Player(Order order){
        playerOrder = order;
        isBankrupt = false;
        inJail = false;
        money = 1500;
        playerPosition = 0;
        propertiesOwned = 0;
    }

    public Order getPlayOrder(){
        return playerOrder;
    }

    public void bankruptPlayer(){
        this.isBankrupt = true;
        propertiesOwned = 0;
    }
    
    public boolean isBankrupt(){
        return isBankrupt;
    }

    public void jailPlayer(){
        this.inJail = true;
    }

    public boolean inJail(){
        return inJail;
    }

    public void setWinType(winStatus winner) {
        this.winner = winner;
    }
    
    public winStatus isWinner(){
        return winner;
    }

}
