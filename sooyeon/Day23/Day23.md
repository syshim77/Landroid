# Day 23

#### Using Handler
1. 멀티 스레드
  - 메인 액티비티
    + 애플리케이션이 실행될 때 하나의 프로세스에서 처리
    + 이벤트를 처리하거나 필요한 메소드를 정의하여 기능을 구현하는 경우에도 동일한 프로세스 내에서 실행
  - 문제점
    + 대기 시간이 길어지는 네트워크 요청 등의 기능을 수행할 때는 화면에 보이는 UI도 멈춤 상태로 있게 됨
  - 해결 방안
    + 하나의 프로세스 안에서 여러 개의 작업이 동시 수행되는 멀티 스레드 방식을 사용
  - 멀티 스레드
    + 같은 프로세스 안에 들어 있으면서 메모리 리소스를 공유하게 되므로 효율적인 처리가 가능
    + 동시에 리소스를 접근할 경우 데드락(DeadLock) 발생
    + 안드로이드의 자바는 표준 자바와 다르므로 동시 접근의 문제가 생기는 것은 개발자가 처리해야함
2. 핸들러 사용하기
  - 서비스 사용
    + 백그라운드 작업은 서비스로 실행하고 사용자에게는 알림 서비스를 이용해 알려줌
  - 스레드 사용
    + 스레드는 동일 프로세스 내에 있기 때문에 작업 수행의 결과를 바로 처리할 수 있음
3. Demo

#### Cannot Understand