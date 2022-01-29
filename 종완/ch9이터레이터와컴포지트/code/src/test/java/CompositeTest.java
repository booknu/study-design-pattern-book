import java.util.Iterator;
import org.junit.jupiter.api.Test;
import study.designpattern.composite.MenuItemAdaptor;
import study.designpattern.composite.MenuItemV2;
import study.designpattern.composite.MenuV2;
import study.designpattern.composite.WaitressV2;
import study.designpattern.iterator.Cafe;
import study.designpattern.iterator.Menu;
import study.designpattern.iterator.MenuItem;
import study.designpattern.iterator.RestaurantA;
import study.designpattern.iterator.RestaurantB;

public class CompositeTest {
    private static MenuItemAdaptor menuItemAdaptor = new MenuItemAdaptor() {};
    @Test
    public void test(){
        MenuV2 allMenu = new MenuV2("전체 메뉴", "");

        MenuV2 menu1 = new MenuV2("식당A의 메뉴", "아침메뉴");
        MenuV2 menu2 = new MenuV2("식당B의 메뉴", "점심메뉴");
        MenuV2 menu3 = new MenuV2("카페의 메뉴", "카페메뉴");

        allMenu.add(menu1);
        allMenu.add(menu2);
        allMenu.add(menu3);
        //메뉴 갖고오기
        Menu menuA = new RestaurantA();
        Menu menuB = new RestaurantB();
        Menu cafe = new Cafe();

        //메뉴 모두 더하기
        Iterator<MenuItem> menuAIter = menuA.iterator();
        Iterator<MenuItem> menuBIter = menuB.iterator();
        Iterator<MenuItem> menuCafeIter = cafe.iterator();

        while(menuAIter.hasNext()){
            MenuItem item = menuAIter.next();
            if (item != null) {
                menu1.add(menuItemAdaptor.upgrade(item));
            }
        }
        while(menuBIter.hasNext()){
            MenuItem item = menuBIter.next();
            if (item != null) {
                menu2.add(menuItemAdaptor.upgrade(item));
            }
        }
        while(menuCafeIter.hasNext()){
            MenuItem item = menuCafeIter.next();
            if (item != null) {
                menu3.add(menuItemAdaptor.upgrade(item));
            }
        }

        //웨이트리스!
        WaitressV2 waitress = new WaitressV2(allMenu);
        waitress.print();
    }

}
