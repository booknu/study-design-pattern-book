package gumballmachine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 여러 상태값을 보유하고 현재 상태를 가지는 Context
 */
public class GumballMachine {

	private static final int COIN_PER_GAME = 100;

	@Getter
	@Setter(AccessLevel.PACKAGE)
	private State state;

	@Getter
	private int coin;

	@Getter
	private int balls;

	public GumballMachine() {
		this.state = States.READY;
		this.balls = 10;
	}

	// --- 클라이언트 쪽과 상호작용하는 메소드 --- //
	public void insertCoin(int coin) {
		this.state.insertCoin(this, coin);
	}

	public void ejectCoin() {
		this.state.ejectCoin(this);
	}

	public void refill(int balls) {
		this.state.refill(this, balls);
	}

	public void turnCrank() {
		if (this.state.turnCrank(this)) {
			this.state.dispense(this);
		}
	}

	// --- state 쪽에서 context 상태를 조작하기 위한 메소드 --- //
	protected void addCoin(int coin) {
		this.coin += coin;
	}

	protected int ejectAllCoin() {
		int coin = this.coin;
		this.coin = 0;

		if (coin > 0) {
			System.out.println(coin + " 코인이 반환되었습니다");
		}

		return coin;
	}

	protected boolean startGame() {
		if (this.coin < COIN_PER_GAME) {
			return false;
		}

		this.coin -= COIN_PER_GAME;

		return true;
	}

	protected void addBalls(int balls) {
		this.balls += balls;
	}

	protected void releaseBall() {
		if (balls <= 0) {
			System.out.println("공이 없어서 나가지 못했습니다. 원래는 없어야 하는 일인데, 주인장에게 문의해주세요.");
			return;
		}

		--balls;
		System.out.println("공이 나갔습니다.");
	}
}
