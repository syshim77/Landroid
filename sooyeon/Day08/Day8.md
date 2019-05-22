# Intent & Life Cycle

#### Intent & Data Transmission(1)
1. 인텐트
  - 안드로이드 애플리케이션의 4가지 구성요소 사이에 데이터를 주고 받을 때 사용하는 것
    + 구성요소: activity, service, broadcast receiver, content provider
  - 액티비티 간의 인텐트 전달
    + 인텐트: 액션 + 데이터
    + 결과: 선택적
2. 명시적 인텐트 vs 암시적 인텐트
  - 명시적 인텐트(Explicit Intent)
    + 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우
  - 암시적 인텐트(Implicit Intent)
    + 액션과 데이터를 지정하긴 했지만 호출할 대상이 달라질 수 있는 경우
    + 범주(category), 타입(type), 컴포넌트(component), 부가 데이터(extra)
3. Demo

#### Intent & Data Transmission(2)
1. Demo

#### Intent & Data Transmission(3)
1. PDF 문서 보기
  - 스스로 한 번 해볼 것
  - PDF 파일 복사하는 방법만 같이 해봄
2. Demo

#### Intent & Data Transmission(4)
1. 액티비티 스택
  - 새로운 액티비티가 실행되면 이전의 액티비티는 정지된 상태로 액티비티 스택에 들어감
  - 새로운 화면의 뒤에 이전 화면이 숨어있는 것과 같음
  - **플래그 사용**
    + 동일한 화면이 이미 만들어져 있는 경우에 그 화면을 그대로 보여주고 싶을 때 사용
2. 부가 데이터 전달하기
  - 화면과 화면 간에 데이터를 전달하고 싶다면 인텐트의 부가 데이터로 넣어서 전달하는 방법
  - 화면과 화면 간, 화면과 서비스 간, 브로드캐스트 수신자와 화면 간 등 애플리케이션 구성요소 간에 부가 데이터로 넣어 데이터를 전달할 수 있음
3. Demo

#### Life Cycle(1)
1. 액티비티의 대표적인 상태 정보
  - 실행(running)
    + 화면 상에 액티비티가 보이면서 실행되어있는 상태
    + 액티비티 스택의 최상위에 있으며 포커스를 가지고 있음
  - 일시중지(paused)
    + 사용자에게 보이기는 하지만 다른 액티비티가 위에 있어 포커스를 받지 못하는 상태
    + 대화상자가 위에 있어 일부가 가려져 있는 경우에 해당
  - 중지(stopped)
    + 다른 액티비티에 의해 완전히 가려져 보이지 않는 상태
2. Demo

#### Life Cycle(2)
1. Demo

#### Cannot Understand