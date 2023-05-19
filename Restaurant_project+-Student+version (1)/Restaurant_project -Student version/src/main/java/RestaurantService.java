import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {

        for(int i=0;i<restaurants.size();i++)
        {
            if(restaurants.get(i).getName().equals(restaurantName))
            {
                return restaurants.get(i);
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}

/*
 * The RestaurantService class provides methods to manage 
 * a list of restaurants. It has a static list of 
 * Restaurant objects. The class includes methods
 *  to find a restaurant by name, add a new restaurant
 *  to the list, remove a restaurant from the list, 
 * and get the list of all restaurants. It throws a 
 * restaurantNotFoundException if a requested restaurant
 *  is not found during the search process.
 */
