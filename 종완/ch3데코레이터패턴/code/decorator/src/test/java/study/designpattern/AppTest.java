package study.designpattern;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import study.designpattern.cake.Cake;
import study.designpattern.cake.CheeseCake;
import study.designpattern.cake.ChocoCake;
import study.designpattern.cake.CreamCake;
import study.designpattern.decorator.Candle;
import study.designpattern.decorator.Chocolate;
import study.designpattern.decorator.Strawberry;

public class AppTest {
    Cake cheeseCake, chocoCake, creamCake;
    Cake decoratedCheeseCake, decoratedChocoCake, decoratedCreamCake;

    @Before
    public void getInstances(){
        cheeseCake = new CheeseCake();
        chocoCake = new ChocoCake();
        creamCake = new CreamCake();
        decoratedCheeseCake = new Chocolate(cheeseCake);
        decoratedChocoCake = new Candle(new Candle(new Candle(new Candle(chocoCake))));
        decoratedCreamCake = new Candle(new Strawberry(new Chocolate(creamCake)));
    }

    @Test
    public void testDescription(){
        System.out.println(cheeseCake);
        System.out.println(chocoCake);
        System.out.println(creamCake);
        System.out.println(decoratedCheeseCake);
        System.out.println(decoratedChocoCake);
        System.out.println(decoratedCreamCake);
    }

    @Test
    public void testPlainCost(){
        assertEquals(creamCake.getCost(), 40000);
        assertEquals(cheeseCake.getCost(), 29000);
        assertEquals(chocoCake.getCost(), 27000);
    }

    @Test
    public void testDecoratedCost(){
        assertEquals(creamCake.getCost(), 40000);
        assertEquals(cheeseCake.getCost(), 29000);
        assertEquals(chocoCake.getCost(), 27000);
    }
}
