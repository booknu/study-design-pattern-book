package duck;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DuckTest {
  private List<Duck> ducks;

  @BeforeEach
  public void init () {
    ducks = List.of(Duck.mallard(), Duck.rubber());
  }

  @Test
  public void display () {
    ducks.forEach(Duck::display);
  }

  @Test
  public void swim () {
    ducks.forEach(Duck::swim);
  }

  @Test
  public void performFly () {
    ducks.forEach(Duck::performFly);
  }

  @Test
  public void performQuack () {
    ducks.forEach(Duck::performQuack);
  }
}
