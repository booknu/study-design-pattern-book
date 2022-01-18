package abstractfactory.ingredientfactory;

import common.pizza.ingredients.Cheese;
import common.pizza.ingredients.Dough;
import common.pizza.ingredients.Sauce;
import common.pizza.ingredients.Veggie;

public interface IngredientFactory {
	Cheese createCheese();
	Dough creteDough();
	Sauce createSauce();
	Veggie[] createVeggies();
}
