package ex1.duck;

import ex1.duck.behavior.fly.FlyBehavior;
import ex1.duck.behavior.quack.QuackBehavior;
import lombok.Getter;

public class MallardDuck extends Duck {

  @Getter
  private final FlyBehavior flyBehavior = FlyBehavior.normal();

  @Getter
  private final QuackBehavior quackBehavior = QuackBehavior.normal();

  @Override
  public void display() {
    System.out.println("[ 청둥오리 모양 ]");
  }
}
