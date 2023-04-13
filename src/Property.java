public class Property extends App {
    final Color propertyColor;
    public int boardSpace;
    public Order propertyOwner;
    int propertyValue;
    int propertyRent;
    String propertyName;
    boolean isMortgaged;
    boolean isOwned;
    int houses;
    int hotels;


    public Property (Color color, Order order){
        propertyColor = color;
        propertyOwner = order;
        propertyName = "";
        isMortgaged = false;
        isOwned = false;
        houses = 0;
        hotels = 0;
    }


    public void mortgagePropetry(){
        this.isMortgaged = true;
    }

    public boolean isMortgaged(){
        return isMortgaged;
    }

    public void buyProperty(){
        this.isOwned = true;
    }

    public boolean getIsOwned(){
        return isOwned;
    }
}
