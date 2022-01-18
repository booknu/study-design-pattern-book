package ex1.duck;

import ex1.duck.behavior.fly.FlyBehavior;
import ex1.duck.behavior.quack.QuackBehavior;

public abstract class Duck {

  protected abstract FlyBehavior getFlyBehavior();

  protected abstract QuackBehavior getQuackBehavior();

  public abstract void display();

  public void swim() {
    System.out.println("모든 오리들은 기본적으로 수영 가능!");
  }

  public void performFly() {
    getFlyBehavior().fly();
  }

  public void performQuack() {
    getQuackBehavior().quack();
  }

  public static Duck mallard() {
    return new MallardDuck();
  }

  public static Duck rubber() {
    return new RubberDuck();
  }
}
