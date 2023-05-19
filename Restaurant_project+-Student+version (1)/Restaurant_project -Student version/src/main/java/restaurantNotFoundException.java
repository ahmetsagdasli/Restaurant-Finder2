public class restaurantNotFoundException extends Throwable {
    public restaurantNotFoundException(String restaurantName) {
        super(restaurantName);
    }
}



/*
 * 
The RestaurantNotFoundException is a custom exception class
 that extends the Throwable class. It is used to handle 
 situations when a restaurant cannot be found. The class has 
 a constructor that accepts the name of the restaurant as a 
 parameter and passes it to the superclass constructor for 
 appropriate exception handling.
 */
