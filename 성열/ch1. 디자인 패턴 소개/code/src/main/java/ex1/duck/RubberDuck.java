package duck;

import duck.behavior.fly.FlyBehavior;
import duck.behavior.quack.QuackBehavior;
import lombok.Getter;

public class RubberDuck extends Duck {
  @Getter
  private final FlyBehavior flyBehavior = FlyBehavior.unable();

  @Getter
  private final QuackBehavior quackBehavior = QuackBehavior.squeak();

  @Override
  public void display () {
    System.out.println("[ 고무오리 모양 ]");
  }
}
