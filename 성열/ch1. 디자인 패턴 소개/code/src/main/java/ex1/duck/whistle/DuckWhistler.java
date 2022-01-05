package duck.whistle;

import duck.behavior.quack.QuackBehavior;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuckWhistler {
  private QuackBehavior quackBehavior;

  public void whistle () {
    quackBehavior.quack();
  }
}
