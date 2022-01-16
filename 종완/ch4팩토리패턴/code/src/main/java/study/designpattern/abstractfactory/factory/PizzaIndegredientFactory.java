package study.designpattern.abstractfactory.factory;

import study.designpattern.abstractfactory.ingredient.Cheese;
import study.designpattern.abstractfactory.ingredient.Dough;
import study.designpattern.abstractfactory.ingredient.Pepperoni;
import study.designpattern.abstractfactory.ingredient.Sauce;

public interface PizzaIndegredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Pepperoni creatPepperoni();
}
