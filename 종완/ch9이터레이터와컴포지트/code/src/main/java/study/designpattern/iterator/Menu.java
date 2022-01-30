package study.designpattern.iterator;

import java.util.Iterator;

public interface Menu {
    public Iterator<MenuItem> iterator();
    public void addItem(String name, String description, boolean vegetarian, double price);
}
