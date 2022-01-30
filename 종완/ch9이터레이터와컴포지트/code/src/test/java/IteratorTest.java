import org.junit.jupiter.api.Test;
import study.designpattern.iterator.Cafe;
import study.designpattern.iterator.RestaurantA;
import study.designpattern.iterator.RestaurantB;
import study.designpattern.iterator.Waitress;

public class IteratorTest {
    @Test
    public void 메뉴테스트1(){
        RestaurantA restaurantA = new RestaurantA();
        RestaurantB restaurantB = new RestaurantB();
        Cafe cafe = new Cafe();
        Waitress waitress = new Waitress(restaurantA, restaurantB, cafe);

        waitress.printMenu();
    }
}
