## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 38강 - 39강
## Day 10

### 프래그먼트

* 프래그먼트
 * 화면의 일정 영역을 독립적으로 처리하기 위해 만들어진 특별한 화면 구성 요소
 * 태블릿의 대화면에서 화면 분할이 필요하게 되면서 만들어짐

* 프래그먼트의 기본 목적
 * 하나의 화면이 XML 레이아웃과 자바 소스로 구성된다는 점에 착안하여 하나의 프래그먼트가 XML 레이아웃과 자바 소스로 구성되도록 하고 독립적으로 관리되도록 하기 위함
 * 주의할 점 : 프래그먼트를 사용하지 않고 일반 XML 레이아웃으로 구성하는 경우에 비해 코드의 양이 많아지고 복잡해질 수 있음.

* 사용되는 개념
 * 프래그먼트 매니저 : 프래그먼트를 관리하는 객체
 * 트랜젝션 : 프래그먼트의 처리를 위해 만든 단위


* 화면 전환과 화면 분할
 * 두 개의 화면을 액티비티로 만들고 액티비티 간 전환
 * 하나의 액티비티 위에 프래그먼트를 두고 프래그먼트 간 전환
 * 프래그먼트로 만들어 두면 스마트폰에서 프래그먼트 간 화면 전환, 태블릿에서는 두개의 프래그먼트를 하나의 액티비티 위에서 동시에 보여주는 화면 분할이 가능함.

* 싱글 프래그먼트
 * 하나의 액티비티 안에 하나의 프래그먼트가 들어가 있는 형태
 * 하나의 액티비티 안에서 프래그머느를 교체하거나 하기 좋음
 * PlaceholderFragment라는 이름으로 만들어짐

* 프래그먼트 전환
 * 프래그먼트 매니저와 트랜젝션을 이용해 추가나 제거 가능
 * 한 번에 교체도 가능

* 액티비티와 프래그먼트 간 의사소통 (프래그먼트 처리 순서)
 1. 프래그먼트 매니저 객체 참조
 2. 트랜젝션 시작
 3. 프래그먼트의 추가, 삭제 또는 교체
 4. 트랜젝션 commit

* Fragment 클래스
 * Public final Activity getActivity() : 이 프래그먼트를 포함하는 액티비티를 리턴함
 * Public final fragmentManager getFragmentManager () : 이 프래그먼트를 포함하는 액티비티에서 프래그먼트 객체들과 의사소통하는 프래그먼트 매니저를 리턴함.
 * Public final Fragment getParentFragment() : 이 프래그먼트를 포함하는 부모가 프래그먼트일 경우 리턴함. 액티비티면 null을 리턴함.
 * Public final int getId () : 이 프래그먼트의 id를 리턴함
 * Public abstract FragmentTransaction beginTransaction () : 프래그먼트를 변경하기 위한 트랜젝션을 시작함
 * Public abstract fragment findFragmentById (int id) : ID를 이용해 프래그먼트 객체를 찾음.
 * Public abstract Fragment findFragmentByTag(String tag) : 태그 정보를 이용해 프래그먼트 객체를 찾음.
 * Public abstract Boolean executePendingTransactions () : 트랜젝션은 commit () 메소드를 호출하면 실행되지만 비동기 방식으로 실행되므로 즉시 실행하고 싶다면 이 메소드를 추가로 호출해야함

* 프래그먼트를 만들어서 사용하는 과정
 1. 프래그먼트를 위한 xml 레이아웃 만들기
 2. 프래그먼트 클래스 만들기
 3. 프래그먼트 객체 만들기
 4. 프래그먼트 매니저를 참조하여 필요한 작업 실행하기

 --------
#### Want to more know
1. MyLayoutInflater (부분화면 부분) 프로젝트 만들기!
2. Blank activity with fragment & Blank activity
