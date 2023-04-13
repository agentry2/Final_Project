public class Railroad extends App{
    
    public int boardSpace;
    public Order propertyOwner;
    int propertyValue;
    int propertyRent;
    String propertyName;
    boolean isOwned;

    public Railroad(Order order){
        propertyOwner = order;
        propertyName = "";
        isOwned = false;
    }
}
