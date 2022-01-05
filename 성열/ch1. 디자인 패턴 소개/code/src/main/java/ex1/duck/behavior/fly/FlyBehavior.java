package ex1.duck.behavior.fly;

public interface FlyBehavior {

  void fly();

  static FlyBehavior normal() {
    return new NormalFly();
  }

  static FlyBehavior unable() {
    return new UnableToFly();
  }
}
