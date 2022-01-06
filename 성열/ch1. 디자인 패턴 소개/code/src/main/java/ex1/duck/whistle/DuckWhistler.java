package ex1.duck.whistle;

import ex1.duck.behavior.quack.QuackBehavior;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuckWhistler {

  private QuackBehavior quackBehavior;

  public void whistle() {
    quackBehavior.quack();
  }
}
