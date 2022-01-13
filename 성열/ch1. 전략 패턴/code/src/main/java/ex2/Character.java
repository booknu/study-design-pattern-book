package ex2;

import lombok.Setter;

public abstract class Character {

  @Setter
  private WeaponBehavior weapon;

  public void fight() {
    weapon.useWeapon();
  }
}
