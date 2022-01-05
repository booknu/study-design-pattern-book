package duck.behavior.fly;

public class UnableToFly implements FlyBehavior {

  @Override
  public void fly () {
    System.out.println("날 수 없음!");
  }
}
