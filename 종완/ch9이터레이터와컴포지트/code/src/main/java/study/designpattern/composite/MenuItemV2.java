package study.designpattern.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuItemV2 implements MenuComponent {
    private String name, description;
    private boolean vegetarian;
    private double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() { return vegetarian; }

    @Override
    public void print() {
        if (isVegetarian()) {
            System.out.print("[V] ");
        }
        System.out.printf("%s, %g\n", getName(), getPrice());
        System.out.println(getDescription());
        System.out.println("---------------------------------------------------------------------");
    }
}
