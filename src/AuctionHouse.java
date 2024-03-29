
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AuctionHouse {

    /*
    Variables to store information about auction houses
     */
    private String name;
    private String[] address = new String[2];
    int numOfItems;
    private double averagePrice;

    //List containing items in auction house
    private ArrayList<Item> itemsInAuctionHouse;


    /**
     * Constructor that represents an Auction House
     * @param name - Relates to the name of the Auction House
     * @param firstLineAddress - Relates to the First-line of the address of the Auction House
     * @param postCode - Relates to the post code of the Auction House
     */
    AuctionHouse(String name, String firstLineAddress, String postCode){
        this.name = name;
        this.address[0] = firstLineAddress;
        this.address[1] = postCode;
        this.itemsInAuctionHouse = new ArrayList();
        this.averagePrice = averagePrice;
    }

    /**
     * This method is used in conjunction with the bestAuctionHouseAverageYear method in the Reporting class
     * to get the average of how well an auction house did in a particular year
     * @return The average price from sold items at an Auction house
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * This getter is used to get the name of an Auction House
     * @return The name of an auction house
     */
    public String getName() {
        return name;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * Returns the items stored in an auction house
     * @return Items in the auction house
     * **/
    public ArrayList<Item> getItemsInAuctionHouse() {
        return itemsInAuctionHouse;
    }

    /***
     *
     * @return The number of items in an auction house
     */
    public int amountOfItemsInAuctionHouse(){
        numOfItems = getItemsInAuctionHouse().size();
        return numOfItems;
    }


    /***
     *
     * @return A String representation of the Auction House details
     */
    @Override
    public String toString() {
        return "Auction House: \n" +
                "Name: " + name + "\n" +
                "Address: " + Arrays.toString(address) + "\n"+
                "Items in Auction House: " + amountOfItemsInAuctionHouse() + "\n" + "\n";
    }


    /**
     * This method adds an item to the itemsSoldByAuctionHouse ArrayList
     * @param item
     * **/
    public void addSoldItem(Item item){
        //Adds to itemsInAuctionHouse list
        itemsInAuctionHouse.add(item);
    }

    /**
     * Code adapted from [source] https://github.com/newcastleuniversity-computing/csc1035-csc1036_practicals_2022/blob/solutions/part1/practical-9/src/Garage.java
     * This method takes a price from a user and adds it to the itemsGreaterPrice list if the item price is > than the user input price
     * @param price
     * @return Arraylist with items greater than inputted price
     * **/
    public ArrayList<Item> filterItemsByPrice(double price){
        //Temp array list to store items > thank inputted price
        ArrayList<Item> itemsGreaterThanPrice = new ArrayList<>();
        //Returns null if no items are found
        if(itemsInAuctionHouse.size() == 0){
            return null;
        }
        for (Item item : itemsInAuctionHouse){
            if(item.getPrice() > price){
                //Adds to temp arraylist if condition is met
                itemsGreaterThanPrice.add(item);
            }
        }
        return itemsGreaterThanPrice;
    }


    /**
     * References [source] https://www.youtube.com/watch?v=ofDV5Ywdgl8&ab_channel=KKJavaTutorials(Java 8 Comparator’s comparing() methods, 2017)
     * This method returns the most expensive product from the itemsInAuctionHouse list.
     * @return Most expensive product.
     * **/
    public Item mostExpensiveItem() {
        //Return null if no items are found
        if(itemsInAuctionHouse.size() == 0){
            return null;
        }
        //This creates a comparator for the getPrice method in the Item class
        Comparator<Item> comp = Comparator.comparing(Item::getPrice);
        //This uses the comparator to get the max get price item from the items list
        Item mostExpensiveItem = Collections.max(itemsInAuctionHouse, comp);
        return mostExpensiveItem;
    }


    /**
     * This returns the average price of the Items stored in the itemsInAuctionHouse Array
     * Formula: Average = sum of values/number of values
     * @param year
     * @return Average price of items
     * **/
    public double averageItemPriceGivenYear(int year){
        double price = 0;
        int itemCount = 0;
        for (Item item: itemsInAuctionHouse){
            if(year == item.getYearSold()){
                //Adds the values obtained from the getPrice method and updates the price variable
                price += item.getPrice();
                //Updates the itemCount variable by 1 each iteration
                itemCount++;
            }
        }
        //Returns the average values/number of values
        return price/itemCount;
    }

}