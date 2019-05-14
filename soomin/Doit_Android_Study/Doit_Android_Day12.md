# 안드로이드 앱 프로그래밍 Day 12
다양한 위젯과 이벤트 활용

## 44강
웹브라우저 사용하기
MyWebView

웹브라우저로 크롬브라우저가 들어감: 크롬이 아닌 상태에서 HTML을 제대로 띄우지 못함  
나의 앱의 어떠한 액티비티(화면)에 웹 브라우저를 집어넣는다.  
장점: 매거진, 뉴스, 쇼핑몰은 안의 내용물이 자주 바뀐다.  
이를 가져오는 것은 메모리가 많이 필요하다.  

데이터를 가져와서 뿌려주는 것이 아니라 웹서버에 두고 관리를 하고싶으면 웹 브라우저로 띄워주는 것이 좋다.  

컨텐츠가 많은 데이터는 웹브라우저를 그 안에 집어넣고, 웹페이지를 만들어 웹서버에 두고 가져다 보여주는 방식이 좋다 (embed 시킨다.)  
###### 장점
- 컨텐츠 관리하기 좋음  
- webView: 웹페이지를 보여줄 수 있는 위젯  
INTERNET이라는 상수로 정의된 권한을 manifest에 지정해주어야한다.  

###### 주요 코드
- manifest: 인터넷 사용 권한 추가
- xml: webView 추가
- java: 이벤트 추가

?? 웹뷰와 버튼이 제대로 띄워지지 않음
?? 메모리 사이즈를 수정할 수 없음

## 45강
외부의 웹 서버에 연결하지 않고 내부적으로 HTML을 띄울 수 있음
로컬 페이지를 띄워줄 수 있다.
- (file system) app 우클릭 > new > Folder > Assets folder  

###### assets folder: 웹사이트, 이미지등의 원본 파일을 넣었다가 앱에서 가져다 보여준다.

tab을 project로 변경하면, >MyWebView>app>src>main>assets 의 위치에 만들어진 폴더를 볼 수 있다.  
assets 우클릭 > new > file에서 이름을 sample.html 이런식으로 생성해주면 assets folder 아래에 html을 만들수있다.  

앱<->웹 정보를 교환하는 기능을 추가하면 매우 유용하게 사용 가능  
--> 하이브리드 앱의 가장 기본적인 원리이다.

<애니메이션 적용>
- 애니메이션 - 안드로이드에서 트윈 애니메이션이 사용된다.  
각 프레임을 연속적으로 보여주면.. 프레임을 전부 준비해야하는 문제점이 생긴다.  
이미지를 바꾸지않고 위치만 바꿀 수 있음 = 트윈 애니메이션(투명도, 확대, 움직임)  
res>anim폴더를 만든다. 이 아래에 있는 것은 애니메이션을 위한 액션 정보가 들어간다.  
액션정보: 애니메이션이 어떤 동작을 할지 정의한 것  
이후 자바 소스에서 anim 안의 xml파일을 로딩해서 객체를 만든다.  
start animation하면 view객체를 움직일 수 있다.  

?? 웹페이지 샘플도 안띄워짐..메모리 문제는 아닌듯하다..

## 46강
애니메이션 사용하기
MyAnim
res 폴더 아래에 anim directory를 만들고 그 안에 value xml을 생성한다.
(new > XML > Values XML File)

translate.xml
~~~java
<set xmlns:android="http://schemas.android.com/apk/res/android"> // xmlns를 안써서 에러났었음
    <translate
        android:fromXDelta="100%p" // x 방향에서 위젯이 있을 수 있는 100퍼센트 위치에 있으라  // 어떤 뷰가 있을 위치의 오른쪽 끝
        android:toXDelat="0%p" // 왼쪽의 0%(원래위치)까지 와라
        android:duration="1500" // 1.5초동안 지속
        android:fillAfter="true" // 애니메이션의 마지막 위치에 고정할 것인가
        /> // action 정보이다.
</set>
// 오른쪽 끝에서 원래 위치까지 (<-)움직인다.
~~~

translate 이동
scale 확대/축소
lotate 회전
alpha 투명도

?? MyAnim의 MainActivity.xml에서의 textview위치와 실제 단말의 textview위치가 다름
~~~java
// 애니메이션 액션정보를 로딩
Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
~~~
###### translate.xml에 있는 내용이 로딩이되면서 애니메이션 액션 정보를 로딩가능
+ 방법1
  - textView.startAnimation(translate);
  - activity_main.xml의 android:id="@+id/content"를 가지고도 가능
  - 화면 전체가 오른쪽에서 원래 위치로 이동하며 애니메이션을 추가시킬 수 있다.
+ 방법2
  - ViewGroup container = (ViewGroup) findViewById(R.id.container); // 가장 상위태그를 가지면 이 액티비티를 나타낼 수 있다.
  - container.startAnimation(translate);

animation listener를 사용하면 해당 애니메이션이 언제 끝나는지 알 수 있다.  
-->이를 가지고 더 복잡한 애니메이션을 만들 수 있다.  
anim 폴더와 속에 들어갈 xml 파일은 resource derectory 와 resource file을 사용하여 만들 수도 있다.
