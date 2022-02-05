package study.designpattern.state;

public interface State {

    /**
     * 돈전을 넣는다
     */
    default void insertCoin(){
        throw new UnsupportedOperationException("현재 상태에서 지원하지 않습니다");
    }

    /**
     * 동전 반환
     */
    default void ejectCoin(){
        throw new UnsupportedOperationException("현재 상태에서 지원하지 않습니다");
    }

    /**
     * 손잡이 돌리기
     */
    default void turnCrank(){
        throw new UnsupportedOperationException("현재 상태에서 지원하지 않습니다");
    }

    /**
     * 알맹이 꺼내기
     */
    default void dispense(){
        throw new UnsupportedOperationException("현재 상태에서 지원하지 않습니다");
    }
}
