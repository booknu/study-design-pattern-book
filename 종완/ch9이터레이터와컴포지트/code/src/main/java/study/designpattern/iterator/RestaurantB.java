package study.designpattern.iterator;


import java.util.Arrays;
import java.util.Iterator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RestaurantB implements Menu {
    private MenuItem[] menuItems;
    private int numberOfItems;
    private static final int MAX_ITEMS = 6;

    {
        numberOfItems = 0;
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("채식주의자용 BLT",
            "통밀 위에 (식물성) 베이컨, 상추 토마토를 얹은 메뉴",
            true,
            2.99);
        addItem("BLT",
            "통밀 위에 베이컨 상추 토마토를 얹은 메뉴",
            false,
            2.99);
        addItem("오늘의 스프",
            "감자 샐러드를 곁들인 오늘의 스프",
            false,
            3.29);
        addItem("핫도그",
            "사워크라우트, 갖은 양념, 양파, 치즈가 곁을여진 핫도그",
            false,
            3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price)
        throws ArrayIndexOutOfBoundsException{
        if(numberOfItems == MAX_ITEMS){
            throw new ArrayIndexOutOfBoundsException("최대 6개의 메뉴까지만 등록 가능합니다");
        }
        menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
        numberOfItems++;
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return Arrays.stream(menuItems).iterator();
    }
}
