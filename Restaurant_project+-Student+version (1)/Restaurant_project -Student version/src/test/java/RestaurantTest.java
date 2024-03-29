import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class


RestaurantTest {

    private LocalTime openingTime, closingTime;
    private Restaurant restaurant;

    @BeforeEach
    private void initialize() {
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }


    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        openingTime = LocalTime.parse("00:52:49");
        closingTime = LocalTime.parse("23:54:49");
        restaurant = new Restaurant("BarbeqNation","Bangalore",openingTime,closingTime);
        assertTrue(restaurant.isRestaurantOpen(), "Restaurant is not open Now");
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        openingTime = LocalTime.parse("00:52:49");
        closingTime = LocalTime.parse("00:52:59");
        restaurant = new Restaurant("MANVIKA",
                "MUMBAI",openingTime,
                closingTime);
        assertFalse(restaurant.isRestaurantOpen(), "Restaurant is open Now");

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }

    @Test
    public void verify_order_total_on_for_Selected_items(){
        List<Item> itemsSelected = new ArrayList<>();
        List<Item> restaurantMenu = restaurant.getMenu();
        itemsSelected.add(restaurantMenu.get(0));
        assertEquals(119,restaurant.total_value_of_selected_items(itemsSelected));
    }

}


/*
 * The RestaurantTest class is a unit testing class that
 *  verifies the functionality of the Restaurant class.
 *  It includes methods annotated with the @Test annotation
 *  that test the opening/closing status, menu operations,
 *  and order total calculation of a restaurant. 
 *  It uses the assertTrue, assertFalse, assertEquals, 
 *  and assertThrows methods to validate the expected behavior of
 *  the methods under test. The @BeforeEach annotation is used
 *  to set up the test environment before each test method.
 */
