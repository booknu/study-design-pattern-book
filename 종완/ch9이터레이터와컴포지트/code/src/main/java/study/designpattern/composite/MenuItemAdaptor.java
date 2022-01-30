package study.designpattern.composite;

import study.designpattern.iterator.MenuItem;

public interface MenuItemAdaptor {
    public default MenuItemV2 upgrade(MenuItem menuItem){
        return new MenuItemV2(menuItem.name(), menuItem.description(),
            menuItem.vegetarian(), menuItem.price());
    }
}
