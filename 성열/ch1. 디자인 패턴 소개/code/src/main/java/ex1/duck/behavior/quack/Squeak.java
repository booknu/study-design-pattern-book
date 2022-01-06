package ex1.duck.behavior.quack;

public class Squeak implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("삑삑");
  }
}
