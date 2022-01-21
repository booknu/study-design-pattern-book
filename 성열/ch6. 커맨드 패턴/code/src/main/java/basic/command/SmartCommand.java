package basic.command;

import lombok.Getter;

/**
 * 이렇게 command 에서는 receiver 를 굳이 받지 않아도 됨. (smart command)
 * 단, 이런 경우 smart command 자체가 receiver 역할까지 하게 되므로 단일 책임 원칙 관점에서는 좋지 않은 방법인듯.
 * 혹은, 외부 static 메소드나 변수, 싱글턴 인스턴스를 조작하게 할 수도 있을 것 같은데 이건 더 좋지 않은 방법인듯.
 * 어쨌든 command 내부에서 실행된 결과가 외부적으로 영향을 끼치기 힘든 방법.
 *
 */
public class SmartCommand implements BasicCommand{
	@Getter
	private int count;

	@Override
	public void execute() {
		System.out.println("ex) 싱글턴 인스턴스의 데이터를 API 호출을 통해 갱신하도록 할 수도 있음.");
		++count;
	}
}
