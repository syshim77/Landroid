## [63강] 복합위젯 만들기
##### 복합위젯
+ 여러개의 뷰를 조합하여 만든 새로운 위젯  
+ 부분화면을 만드는 것과 과정이 비슷

>**알게된 점:**
resource file의 파일명은 소문자밖에 되지 않음

## [64강]
##### 복합위젯 만들기 예제
+ 두개의 체크 박스를 하나의 리스너로 제어


1. 두개를 한번에 처리하기위한 인터페이스 만들기
  - 인터페이스가 하나의 리스너처럼 동작
2. 하나의 리스너만 설정해도 하나의 이벤트를 처리하는 메소드가 호출되어, 한번에 처리 가능

## [65강] 월별 캘린더 만들기
+ 격자 형태로 그리드뷰(격자의 수를 제외하면 리스트뷰와 사용방법이 같다)를 사용하는 가장 대표적인 뷰
+ 복합위젯을 만들때 처럼 extends GridLayout하고, 리스너를 지정할 수 있다.

##### 월별 캘린더 만들기 예제
1. 선택 위젯이므로 어댑터를 이용하여 7x6 형태의 격자 모양 구성
2. data와 calender 클래스를 이용해 선택한 월의 정보를 확인
3. 1일이 시작되는 요일을 확인하고 끝나는 일수를 확인하는 계산 작업 필요
