package duck.behavior.quack;

public interface QuackBehavior {

  void quack ();

  static QuackBehavior normal () {
    return new NormalQuack();
  }

  static QuackBehavior mute () {
    return new MuteQuack();
  }

  static QuackBehavior squeak () {
    return new Squeak();
  }
}
