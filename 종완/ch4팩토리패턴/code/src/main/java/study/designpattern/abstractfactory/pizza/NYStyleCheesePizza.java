package study.designpattern.abstractfactory.pizza;

import study.designpattern.abstractfactory.factory.PizzaIndegredientFactory;
import study.designpattern.abstractfactory.ingredient.MarianaSauce;
import study.designpattern.abstractfactory.ingredient.ReggianoCheese;
import study.designpattern.abstractfactory.ingredient.SlicePepperoni;
import study.designpattern.abstractfactory.ingredient.ThinCrustDough;

public class NYStyleCheesePizza extends AbstractPizza {


    public NYStyleCheesePizza(PizzaIndegredientFactory indegredientFactory){
        super.indegredientFactory = indegredientFactory;
    }


    @Override
    public void prepare() {
        cheese = new ReggianoCheese();
        dough = new ThinCrustDough();
        pepperoni = new SlicePepperoni();
        sauce = new MarianaSauce(); 
    }
    
}
