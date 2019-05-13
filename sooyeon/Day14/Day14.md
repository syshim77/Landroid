# Usage of Multiple Widget & Events

#### Using Progress Bar & Seek Bar
1. 프로그레스바 사용하기
  - 여러 가지 화면을 구성하고 그 안에 다양한 위젯을 사용하는데 있어서 대화상자처럼 중간 중간 상태 정보를 보여주는 가장 좋은 방법 중 하나
  - 막대 모양, 원 모양
2. 시크바 사용하기
  - 프로그레스바를 확장하여 만들어진 것
  - 프로그레스바의 속성을 가지고 있으면서도 사용자가 값을 조정할 수 있게 해줌
3. Demo

#### Adding Seek Bar
1. 안드로이드의 메뉴
  - 메뉴 버튼은 안드로이드가 아이폰과 다른 특징을 보여주는 것 중의 하나
  - 애플리케이션에서 구현할 때는 옵션 메뉴라고 부름
  - 안드로이드에서 제공하는 메뉴
    + 옵션 메뉴
      * 하느웨어 메뉴 버튼을 눌렀을 때 나타나는 메뉴로 각각의 화면마다 설정된 주요 메뉴
      * 최대 6개까지의 메뉴 아이템을 포함할 수 있으며 그 이상의 메뉴 아이템을 추가하면 More라는 메뉴 아이템으로 표시됨
    + 컨텍스트 메뉴
      * 화면을 길게 누르면 나타나는 메뉴로 텍스트뷰의 편집 상태를 바꾸거나 할 때 사용하는 메뉴
      * 뷰에 설정하여 나타나게 할 수 있음
2. 옵션 메뉴와 액션바를 이용한 메뉴
  - 동일한 옵션 메뉴가 안드로이드 버전에 따라 다른 형태로 보이게 됨
  - 최근 버전에서는 옵션 메뉴가 상단의 액션바로 통합
  - 액션바를 이용해 다양한 메뉴 기능을 사용할 수 있음
3. Demo

#### Using Action Bar & Tab(1)
1. Demo

#### Using Action Bar & Tab(2)
1. 키패드 설정하기
  - 키패드와 관련된 기능은 InputMethodManager 객체를 이용해 사용 가능
  - 이 객체는 시스템 서비스이므로 getSystemService() 메소드를 이용해 참조한 후 다음과 같은 메소드를 이요해 키패드를 열거나 닫을 수 있음
  ```
  boolean showSoftInput(View view, int flags)
  boolean hideSoftInputFromWindow(IBinder windowToken, int flags[, ResultReceiver ResultReceiver])
  ```
2. Demo

#### Cannot Understand
1. menu 폴더가 없어서 해당 Demo 못함
2. Import Module이 없어서 MyTab2 Demo 못함
