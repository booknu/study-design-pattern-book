package duck.behavior.fly;

public class NormalFly implements FlyBehavior {

  @Override
  public void fly () {
    System.out.println("일반적으로 남.");
  }
}
