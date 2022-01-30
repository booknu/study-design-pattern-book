package gumballmachine;

/**
 * 상태에서 가능한 행동들을 인터페이스화
 *
 * 해당 State 에서 가능하지 않은 동작에 대한 정의를 해두면, concrete state 에서는 가능한 동작에 대해서만 구현을 하면 된다.
 *
 * concrete state 쪽에서 context 를 객체 구성을 통해 가지도록 할 수 있지만, 그렇게 되면 state instance 를 여러 context 에서공유해서 사용하지 못한다.
 * 파라미터로 context 를 받으면 상태가 stateless 가 되지만, 인터페이스가 context 에 의존적으로 된다는 단점이 있다.
 *
 * 여러 상황을 고려할 때 어떤 방식이 더 좋을지는 선택의 영역인듯.
 *
 */
public interface State {
	/**
	 * 뽑기 기계가 전자식이라 여러 종류의 금액을 받을 수 있다면?
	 * @param machine
	 */
	default void insertCoin(GumballMachine machine, int coin) {
		System.out.println("동전을 넣을 수 없습니다.");
	}

	default void ejectCoin(GumballMachine machine) {
		System.out.println("동전을 반환할 수 없습니다.");
	}

	default boolean turnCrank(GumballMachine machine) {
		System.out.println("손잡이를 돌릴 수 없습니다.");
		return false;
	}

	default void dispense(GumballMachine machine) {
		System.out.println("볼을 내보낼 수 없습니다.");
	}

	default void refill(GumballMachine machine, int balls) {
		System.out.println("볼을 리필 할 수 없습니다.");
	}
}
