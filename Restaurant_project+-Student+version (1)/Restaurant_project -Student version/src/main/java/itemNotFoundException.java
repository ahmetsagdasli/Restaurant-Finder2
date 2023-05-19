public class itemNotFoundException extends Throwable {
    public itemNotFoundException(String itemName) {
        super(itemName);
    }
}


/*
 The itemNotFoundException class is a custom exception that
extends the Throwable class. It represents an exception 
that occurs when an item is not found. It has a constructor
that accepts the name of the item and passes it to the superclass
constructor for handling the exception.
 */
