# 2장. Observer Pattern

# 내용 정리

## 옵저버 패턴이란

한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의한다.

- 주제(subject): 데이터 관리 객체, 데이터가 변경되면 observer에게 연락을 돌린다.
- 구독자(observer): 주제 객체를 구독(등록)되어 있으며, 갱신된 내용을 전달받는다.

실제 구현은 Subject 인터페이스와 Observer 인터페이스를 구현하는 클래스 디자인을 바탕으로 한다.

![observer-pattern-class-diagram.png](markdown-resource/observer-pattern-class-diagram.png)

<aside>
💡 **디자인 원칙**
1. 바뀌는 부분과 바뀌지 않는 부분을 분리한다
2. 구현체가 아니라 인터페이스에 맞춰 프로그래밍한다.
3. 상속보다는 구성을 활용한다
4. 상호작용하는 객체 사이는 느슨하게 결합한다

</aside>

# 적용 예시