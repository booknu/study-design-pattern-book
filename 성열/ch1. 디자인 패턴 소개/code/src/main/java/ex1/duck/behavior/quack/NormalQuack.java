package ex1.duck.behavior.quack;

public class NormalQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("꽥꽥");
  }
}
