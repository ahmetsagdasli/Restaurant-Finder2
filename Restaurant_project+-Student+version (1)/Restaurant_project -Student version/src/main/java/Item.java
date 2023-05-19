public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ":"
                + price
                + "\n";
    }

}


/* The Item class represents an item with a name and a price.
   It provides a constructor to initialize the name and price,
   and getter methods to access these properties.
   The toString() method is overridden to return a string
   representation of the item's name and price. */
