# 19강
화면은 xml layout이라는 파일에서 하도록 분리해놓았다.
HTML 페이지에서 눈에 보이는 것을 구성하고

Linear 위->아래/왼->오른 으로 차례대로 배치
RelativeLayout 부모의 상대적인 위치(위, 아래, 중앙)에 배치
TableLayout 격자로 배치
- 어떻게 배치하는지 알면 화면을 구성할 수 있다.

화면에 있는 버튼을 동작시키는 방법
1. onClick이라는 속성에 집어넣고, 소스 코드의 동일한 이름의 메소드를 정하는 방법
2. xml레이아웃에 있는 것을 가져다가 버튼을 찾아서 버튼에 clickevnt라는 이벤트를 처리하는 방법

#### 애플리케이션 구성하기
화면을 만드는 것 뿐만아니라 앱에 기능을 부여하기
앱이 어떻게 구성되는 지 알아야한다. 기능부여, 구성을 알아야하므로 앱의 구성을 알아보자

화면: xml layout 은 화면을 구성한다(눈에 보이는)
화면을 띄워주는 것이 activity이고, activity는 앱을 구성하는 구성요소이다.

# 20강
버튼이라고 하는 것을 소스에서 찾아서 이벤트 처리를 분할해준다 여기서 인플레이션?!
버튼이라고 하는 태그는 단순한 xml 태그
프로그램을 화면에 실제로 그려주기 위해서 메모리에 올려야하고 xml 파일에 있는 버튼의 정보를 가지고 실제로 button을 그려준다. 소스코드에서 기능을 구현하겠다 하면 actiity라고 하는 화면이 필요하다고 했음.이 activity라는 화면의 가장 상위 레이아웃에 레이아웃 파일에 있는 정보를 메모리에 올리고 이를 붙여준다. 이때 버튼을 올리고 싶은데, 이를 찾는 방법이 id를 가지고 찾는 것
--> 정리) 인플레이션: XML 레이앙웃에 정의된 ㅇ내용이 메모리에 객체화되는 과정

- onCreate: 앱이 시작될때 맨 처음 실행되는 부분이다.
- setContentView: 내부적으로 인플레이션 하는 것 - 내부에 객체화, 화면에 나타낼 뷰를 지정하는 역할
이후에 activity가 화면을 나타내는데 xml을 이 화면에 붙여준다. (가장 상위 레이아웃에)
setContentView이후에 findViewById하면 아이디가 올라가 있으니 찾을 수 있지만
먼저 setContentView을 하지 않으면 null이되어있을것. 메모리에 올라가지 않았을 것이므로

부분화면을 레이아웃으로 만들어놓으면 setContentView를 사용할 수 없다. 따라서 직접 인플레이션 하기 위해서는 아래를 사용한다.
LayoutInflater: System 서비스
System 서비스: 단말을 시작하면 뒤에서 뭔가 계속 돌고있는것. 우리가 서비스를 시작하기위해 준비해주는것

안드로이드에서 화면: 소스와 화면 구성이 분리되어있음
- 화면에 보이는 내용을 구성하려면 xml 레이아웃과 자바 소스 각각 하나씩 필요하다.

화면 전체: 액티비티 -> setContentView 에서 인플레이션
- 액티비티를 위한 자바소스 1개: MainActivity
- 액티비티를 위한 xml 레이아웃 1개: activity_main

부분화면: 수동으로 인플레이션
- 부분화면을 위한 자바 소스 1개 또는 뷰
- 부분화면을 위한 XML 레이아웃 1개

# 22강
- 부분 화면을 담는 레이아웃은 container 이라고 불린다.
- container가 되는 레이아웃에 id를 붙여서 id를 통해 부분 화면을 붙여준다.
- layout_inflater라는 것이 시스템 서비스로 제공된다.

+ 레이아웃 인플레이션 함수
  - View inflate (int resource, ViewGroup root)
  - static LayoutInflater LayoutInflater.from (Context context)
  - static View inflate (Context context, int resource, ViewGroup root)

# 23강
+ 액티비티
  - 액티비티
  - 서비스로
  - 브로드캐스트 수신자
  - 내용 제공자

intent를 통해서 요청을 해야한다.
화면을 띄우는 방법: startActivity -> intent액티비티를 던져준다.
intent안에 extra를 같이 넣어서 던져줄 수 있다.
start activity result가 받아서 던져준다.

# 24강


---실습
# 20강, 21강, 22강
activity 일부에 레이아웃을 지정하고 이것을 인플레이션해서 화면에 올려볼것이다.
공간을 넣는것은 뷰그룹 또는 레이아웃을 넣는 것이라고 할 수 있다.

새로운 layout xml만드는 방법: 파일 탐색기 layout에 대고 우클릭 -> new > xml > Layout XML File

#### 부분 레이아웃 화면에 띄우기
- activity_main과 MainActivity.java는 한 쌍으로 맨 처음 화면을 구성하는 것이고 이 안에는 sub_layout.xml을 통해서 부분적인 레이아웃을 띄워주게 된다.
- 원래는 xml 레이아웃 파일 하나에 자바 소스 파일 하나로 이루어져 있어야하는데 아래의 프로젝트는 activity_main의 부분 레이아웃으로 자리를 만들어 준 것이기 떄문에 따로 java 소스 파일을 만들지않아도 된다.

~~~java
~~~
