package gumballmachine;

/**
 * State 를 싱글턴으로 사용 가능하고, stateless 이며, 그렇게 복잡하지 않은 경우 enum 으로 한 번에 관리 가능할듯.
 * 책에서는 각각을 클래스로 만들고, 그 인스턴스들을 machine 내에 가지고 있어서 concrete state 쪽에서는 machine.getReadyState() 와 같이 가져와서 사용했음.
 *
 * (그렇게 규모가 크지 않은 경우)
 */
public enum States implements State {
	READY() {
		@Override
		public void insertCoin(GumballMachine machine, int coin) {
			if (!validateInsertedCoin(coin)) {
				return;
			}

			System.out.println(coin + " 코인을 넣었습니다.");
			machine.addCoin(coin);

			if (machine.getCoin() > 0) {
				machine.setState(COIN_INSERTED);
			}
		}
	},

	COIN_INSERTED() {
		@Override
		public void refill(GumballMachine machine, int balls) {
			System.out.println("주인장이 갑자기 난입해서 볼을 추가했습니다.");
			machine.addBalls(balls);
		}

		@Override
		public void insertCoin(GumballMachine machine, int coin) {
			if (!validateInsertedCoin(coin)) {
				return;
			}

			System.out.println(coin + " 코인을 넣었습니다. (현재 투입된 총 코인: " + machine.getCoin() + ")");
			machine.addCoin(coin);
		}

		@Override
		public void ejectCoin(GumballMachine machine) {
			machine.ejectAllCoin();
			machine.setState(READY);
		}

		@Override
		public boolean turnCrank(GumballMachine machine) {
			if (!machine.startGame()) {
				System.out.println("코인이 부족합니다.");
				return false;
			}

			System.out.println("손잡이를 돌렸습니다. 남은 코인 : " + machine.getCoin());

			if (Math.random() < 0.1 && machine.getBalls() > 1) {
				machine.setState(DOUBLE_SOLD);
			} else {
				machine.setState(SOLD);
			}

			return true;
		}
	},

	SOLD() {
		@Override
		public void dispense(GumballMachine machine) {
			if (machine.getBalls() < 1) {
				System.out.println("공을 내보내려는데 수가 부족합니다. 주인장에게 리필해달라고 하세요.");
				return;
			}

			machine.releaseBall();

			this.setProperStateAfterSold(machine);
		}

		@Override
		public void refill(GumballMachine machine, int balls) {
			// 이걸 쓸 일은 없겠지만, 만약 기계 내부가 잘못돼서 공이 안 나갔다면 리필해줄 수 있음
			refillBalls(machine, balls);
		}
	},

	DOUBLE_SOLD() {
		@Override
		public void dispense(GumballMachine machine) {
			if (machine.getBalls() < 2) {
				System.out.println("공을 내보내려는데 수가 부족합니다. 주인장에게 리필해달라고 하세요.");
				return;
			}

			System.out.println("운이 좋군요. 10% 확률로 공 2개에 당첨됐습니다.");
			machine.releaseBall();
			machine.releaseBall();

			this.setProperStateAfterSold(machine);
		}

		@Override
		public void refill(GumballMachine machine, int balls) {
			// 이걸 쓸 일은 없겠지만, 만약 기계 내부가 잘못돼서 공이 안 나갔다면 리필해줄 수 있음
			refillBalls(machine, balls);
		}
	},

	SOLD_OUT() {
		@Override
		public void refill(GumballMachine machine, int balls) {
			refillBalls(machine, balls);
		}
	};


	protected final void refillBalls(GumballMachine machine, int balls) {
		if (balls == 0) {
			System.out.println("공이 없는데 뭘 리필하겠다는거지?");
			return;
		}

		machine.addBalls(balls);
		System.out.println(balls + "개의 공을 리필했습니다. (총 " + machine.getBalls() + "개)");
		machine.setState(READY);
	}

	protected final boolean validateInsertedCoin(int coin) {
		if (coin == 0) {
			System.out.println("코인을 넣지 않았습니다.");
			return false;
		}

		return true;
	}

	protected final void setProperStateAfterSold(GumballMachine machine) {
		// 볼이 없으면 sold out 으로 설정
		// 이 때 남은 코인이 있으면 돌려준다.
		if (machine.getBalls() <= 0) {
			System.out.println("공이 모두 동났습니다. 더 이상의 게임은 진행이 불가능합니다.");
			if (machine.getCoin() > 0) {
				machine.ejectAllCoin();
			}

			machine.setState(SOLD_OUT);
			return;
		}

		// 볼이 남아있으면 게임이 진행 가능한 상태이므로 준비모드로
		if (machine.getCoin() > 0) {
			machine.setState(COIN_INSERTED);
		} else {
			machine.setState(READY);
		}
	}
}
