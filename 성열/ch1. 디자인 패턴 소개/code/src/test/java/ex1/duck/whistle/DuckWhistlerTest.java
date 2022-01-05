package duck.whistle;

import duck.behavior.quack.QuackBehavior;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DuckWhistlerTest {
  private List<DuckWhistler> whistlers;

  @BeforeEach
  public void init () {
    whistlers = List.of(
        new DuckWhistler(QuackBehavior.normal()),
        new DuckWhistler(QuackBehavior.mute()),
        new DuckWhistler(QuackBehavior.squeak()));
  }

  @Test
  public void whistle () {
    whistlers.forEach(DuckWhistler::whistle);
  }

}
