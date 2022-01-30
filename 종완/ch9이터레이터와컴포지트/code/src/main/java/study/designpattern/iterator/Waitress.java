package study.designpattern.iterator;

import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Waitress {
    @NonNull private Menu restaurantA, restaurantB, cafe;

    public void printMenu(){
        System.out.println("=====================레스토랑 A의 메뉴=====================");
        printMenu(restaurantA.iterator());
        System.out.println("=====================레스토랑 B의 메뉴=====================");
        printMenu(restaurantB.iterator());
        System.out.println("=====================카페 메뉴=====================");
        printMenu(cafe.iterator());
    }

    //forEach마렵다...
    private void printMenu(Iterator<MenuItem> iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = iterator.next();
            if (menuItem == null) {
                continue;
            }
            System.out.print(menuItem.name() + ", ");
            System.out.println(menuItem.price());
            System.out.println(menuItem.description());
            System.out.println("---------------------------------------------------------------");
        }
    }
}
