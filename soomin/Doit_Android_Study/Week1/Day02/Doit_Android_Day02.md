# 안드로이드 앱 프로그래밍 Day 2
나의 첫 번째 어플리케이션

#### 설정에 사용되는 용어 설명
~~~
- minimize : 지원해줄 최하위 버전
- gradle : build를 편리하게 해주는 역할

- 에뮬레이터: 실제 단말기와 똑같이 화면에 단말기를 띄워주는 것

- AVD(Android Virtual Device): 단말을 가상으로 만들 수 있게 돕는다. (어떤 형태의 단말기를 사용할 지 선택할 수 있음)  
- memory and storage: ram을 700 정도로 설정(너무 크거나 작으면 실행이 되지 않을 수 있음)

- keyboard: enable을 체크를 해제해주어야 스마트폰 상태의 키보드를 볼 수 있음
- app: 안드로이드 스튜디오에서 프로젝트를 부르는 단위  
- res: 화면을 구성할 때 필요한 xml파일을 포함
~~~
---
## 이론
#### 특징
  - 안드로이드는 화면을 xml로 구성한다.  
  - 실행하려면 실제 단말기로 할 수도 있고, 에뮬레이터를 사용해서 할 수도 있다.  
  - 플랫폼으로 만들어져있음

#### 각 구성의 역할
+ 화면을 구성하는 것은 MainActivity.java이다.  
+ MainActivity는 activity_main.xml을 참조한다.  
+ activity_main.xml의 string는 strings.xml을 가리킬 수 있다.  

#### 새로운 화면을 띄워주는 과정  
1. 새로운 화면(activity) 만들기 > 자바 소스 하나와 xml 파일 하나로 구성된다.  
2. 새로운 레이아웃 만들기  
3. manifest에 태그 추가하기   
4. 새로운 activity 시작 코드 넣기  
---
## 실습
#### string.xml을 사용하여 text 가져오기
~~~java
// string.xml
<resources>
    <string name="app_name">HelloWorld</string>
    <string name="action_settings">Settings</string>
    <string name="hello_world">안녕하세요</string> // 중요
</resources>
~~~
~~~java
// activity_main.xml
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="onButton1Clicked"
        android:text="@string/hello_world" /> // 중요 // string.xml중 hello_world라는 이름을 가진 string을 가져온다.
~~~

#### 버튼이 눌렸을 때 Toast 메시지 띄우기
*# Toast Message: 화면 하단에 잠시 메시지를 띄워준다.*
~~~java
// MainActivity.java
public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌렸어요", Toast.LENGTH_LONG).show();
    }
~~~

---
#### 더 알아볼 것
startIntent의 역할
