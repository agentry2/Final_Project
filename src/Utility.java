public class Utility extends App{

    public int boardSpace;
    public Order propertyOwner;
    int propertyValue;
    int propertyRent;
    String propertyName;
    boolean isMortgaged;
    boolean isOwned;    

        public Utility (Order order){
            propertyOwner = order;
            propertyName = "";
            isMortgaged = false;
            isOwned = false;
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
