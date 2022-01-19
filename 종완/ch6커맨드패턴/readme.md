# Ch6. 커맨드 패턴

## 커맨드 패턴 패턴이란

![Command_Design_Pattern_Class_Diagram.png](Command_Design_Pattern_Class_Diagram.png)

### 커맨드 패턴 = 호출 캡슐화
- 요청을 객체의 형태로 캡슐화하여 사용자가 보낸 요청을 나중에도 이용할 수 있도록 메서드 이름, 매개변수 등 요청에 필요한 정보를 저장, 로깅 또는 취소할 수 있도록 해주는 패턴이다.
- `Client`: `Invoker`와 `Invoker`의 인스턴수 변수가 될 `Command`를 설정한다.
- `Invoker`: `Command`에게 명령을 내린다. (이때 `execute()` 단 하나로만)
    - 목표를 설정한다는 느낌
    - 추상적이다 (사장, CEO?)
    - `CommandInvoker`라고 하는 것이 더 이해가 쉽지 않을까..
- `Command`: `Receiver`에게 명령을 내린다. (`Receiver`의 여러 명령어들을 사용한다)
    - 목표를 이루기 위한 계획을 수립한다.
    - 보다 구체적이다 (팀장?)
- `Receiver`:  (최종 명령 수신기)`Invoker`로부터 받은 명령을 수행한다.
    - 목표를 이루기 위한 행동을 실제로 한다.
    - 실무자 (나다)

### 식당의 예제에서
- `Client`: 손님
- `Invoker`: 웨이트리스
- `Invoker.setCommand()`: `takeOrder()`    
- `Invoker.execute()`: `orderUp()`
- `Command`: 주문서
- `Receiver`: 주방장
- `Receiver.makeBuger()`: `Reveiver`의 '규격없이 따로 노는' 여러 명령어들.

### 코드 예제

#### Client
```java
public class Client{
	public static void main(String[] args){
		//리시버 설정
		Light 전등 = new Light();
        //커맨드 설정
        Command 스위치_올릴때_명령 = new TurnOnLightCommand(전등);
        Command 스위치_내릴때_명령 = new TurnOffLightCommand(전등);
        //인보커 설정
        Switch 스위치 = new Switch(스위치_올릴때_명령, 스위치_내릴때_명령);

        //인보커 실행
        스위치.올리기();
        스위치.내리기();
	}

}
```
#### Invoker (목표 설정)

```java
public class Switch{
    private Command 스위치_올릴때_명령;
    private Command 스위치_내릴때_명령;

    public Switch(Command 스위치_올릴때_명령, Command 스위치_내릴때_명령){
        this.스위치_올릴때_명령 = 스위치_올릴때_명령;
        this.스위치_내릴때_명령 = 스위치_내릴때_명령;
    }

    public void 올리기(){
        스위치_올릴때_명령.실행하기();
    }

    public void 내리기(){
        스위치_내릴때_명령.실행하기();
    }
}
```

#### Command (명령 하달)

```java
/**
 * 인터페이스 
 */
public interface Command{
    void 실행하기();
}

public Class TurnOnLightCommand implements Command{
    private Light 전등;

    public TrunOnLightCommand(Light 전등){
        this.전등 = 전등;
    }

    public void 실행하기(){
        전등.켜기();
    }
}

public Class TurnOffLightCommand implements Command{
    private Light 전등;

    public TrunOffLightCommand(Light 전등){
        this.전등 = 전등;
    }

    public void 실행하기(){
        전등.끄기();
    }
}
```


#### Receiver (명령 수행)

```java
public class Light{
    public Light(){

    }

    public void 켜기(){
        System.out.println("불이 켜졌습니다");
    }

    public void 끄기(){
        System.out.println("불이 꺼졌습니다");
    }
}

```

### 전략 패턴과의 차이
- 전략 패턴: `Strategy` (어떻게)의 변화 초점을 두었다.
    - 행동 방법(전략=커맨드)에 대해서만 캡슐화.

- 커맨드 패턴: `Receiver`랑 `Command` 둘의 변화에 초점을 두었다.
    - 행동 방법 `Command`
    - 명령을 수행하는 객체 `Receiver`
    - 명령을 호출하는 객체 `Invoker` 각각에 대해 캡슐화

- `Strategy`의 변화는 생기더라도 `Receiver`가 바뀌지 않을 것 같다면 전략 패턴을
- `Strategy`는 같은데 `Receiver`가 달라져야 하는 경우가 생긴다면 커맨드 패턴(?)

## 적용
- (책에서) 작업 큐
- (책에서) 로깅 및 복구
- 웬만한 undo가 있는 Desktop Application은 다 적용했을듯....