package study.designpattern.abstractfactory.factory;

import study.designpattern.abstractfactory.ingredient.Cheese;
import study.designpattern.abstractfactory.ingredient.Dough;
import study.designpattern.abstractfactory.ingredient.MarianaSauce;
import study.designpattern.abstractfactory.ingredient.Pepperoni;
import study.designpattern.abstractfactory.ingredient.ReggianoCheese;
import study.designpattern.abstractfactory.ingredient.Sauce;
import study.designpattern.abstractfactory.ingredient.SlicePepperoni;
import study.designpattern.abstractfactory.ingredient.ThinCrustDough;

public class NYPizzaIndegredientFactory implements PizzaIndegredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarianaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Pepperoni creatPepperoni() {
        return new SlicePepperoni();
    }
    
}
