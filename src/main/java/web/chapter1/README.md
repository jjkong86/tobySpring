## 1장 오브젝트와 의존관계


##### UserDao 리팩토링 과정

1) 초난감 userDao

2) 팩토리 메소드 패턴으로 connection 분리
 * 상속관계이기 때문에 문제
 * 확장한 클래스 끼리 공유 불가능

3) connection을 클래스로 분리
 * userDao에서 구체적인 정보를 알고 있어야함

4) 인터페이스를 통해 관계를 느슨하게함
 * 그러나 userDao에서 객체를 생성하기 위해서 구현체의 이름이 들어가야함
 * Connection c = new DConnection();

5) userDao에서 클라이언트로 부터 넘어온(부여된) connection을 사용하게함(DI)
