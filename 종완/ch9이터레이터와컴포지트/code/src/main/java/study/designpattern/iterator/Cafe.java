package study.designpattern.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cafe implements Menu {
    private Map<String, MenuItem> menuItems;

    {
        menuItems = new HashMap<>();
        addItem("베지 버거와 에어 프라이",
            "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거",
            true,
            3.99);
        addItem("오늘의 스프",
            "날마다 달라요",
            false,
            3.69);
        addItem("베리또",
            "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또",
            true,
            4.29);
    }

    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.put(name, new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.values().iterator();
    }
}
