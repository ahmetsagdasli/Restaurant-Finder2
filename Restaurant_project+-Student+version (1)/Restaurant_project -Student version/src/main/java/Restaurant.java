import java.time.*;
import java.util.*;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        boolean isRestaurantOpen = false;
        if(getCurrentTime().isAfter(openingTime)&&getCurrentTime().isBefore(closingTime))
            isRestaurantOpen = true;
        else if(getCurrentTime().equals(openingTime))
            isRestaurantOpen = true;

        return isRestaurantOpen;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {
        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());
    }

    public String getName() {
        return name;
    }

    public int total_value_of_selected_items(List<Item> selectedItems) {
        int orderTotal = 0;
        for (Item item : selectedItems) {
            orderTotal = orderTotal + item.getPrice();

        }

        return orderTotal;
    }


}

/*
 * The code defines a Restaurant class that represents
 * a restaurant with a name, location, opening time, 
 * closing time, and a menu of items. It provides methods
 *  to check if the restaurant is open, get the current time,
 *  get the menu, add and remove items from the menu, and display
 *  restaurant details. It also includes a method to calculate the
 *  total value of selected items in the menu.
 */
