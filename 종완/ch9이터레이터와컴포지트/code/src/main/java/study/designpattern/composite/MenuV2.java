package study.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuV2 implements MenuComponent{
    private List<MenuComponent> menuComponents = new ArrayList<>();
    @NonNull private String name, description;

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("====================" + getName() + "====================");
        System.out.println(getDescription());
        System.out.println("----------------------------------------------------------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            if (menuComponent == null) {
                continue;
            }
            menuComponent.print();
        }
    }
}
