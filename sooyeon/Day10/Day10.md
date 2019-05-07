# Fragment

#### Fragment(1)
1. 프래그먼트
  - 화면의 일정 영역을 독립적으로 처리하기 위해 만들어진 특별한 화면 구성 요소
  - 스마트폰에서는 프래그먼트 간 화면 전환, 태블릿에서는 두 개의 프래그먼트를 하나의 액티비티 위에서 동시에 보여주는 화면 분할이 가능함
  - 주의할 점
    + 코드의 양이 많아지고 복잡해질 수 있음
  - 기본 목적
    + 하나의 프래그먼트가 XML 레이아웃과 자바 소스로 구성되도록 하고 독립적으로 관리되도록 하기 위함
  - 사용되는 개념
    + 프래그먼트 매니저: 프래그먼트를 관리하는 객체
    + 트랜젝션: 프래그먼트의 처리를 위해 만든 단위
2. Demo

#### Fragment(2)
1. 싱글 프래그먼트
  - 하나의 액티비티 안에 하나의 프래그먼트가 들어가 있는 형태
  - 하나의 액티비티 안에서 프래그먼트를 교체하거나 하기 좋음
  - PlaceholderFragment 라는 이름으로 만들어짐
2. 프래그먼트 전환
  - 프래그먼트 매니저와 트랜젝션을 이용해 추가나 제거 가능
  - 한 번에 교체도 가능
3. 프래그먼트 처리 순서
  ```
  1) 프래그먼트 매니저 객체 참조
  2) 트랜젝션 시작
  3) 프래그먼트의 추가, 삭제 또는 교체
  4) 트랜젝션 커밋(commit)
  ```
4. 프래그먼트를 만들어 사용하는 과정
  ```
  1) 프래그먼트를 위한 XML 레이아웃 만들기
  2) 프래그먼트 클래스 만들기(클래스 정의)
  3) 프래그먼트 객체 만들기
  4) 프래그먼트 매니저를 참조하여 필요한 작업 실행하기
  ```
5. Demo

#### Cannot Understand
1. Blank with Fragment 라는 activity가 존재하지 않음
  - Fragement(2) Demo 불가