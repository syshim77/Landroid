# 안드로이드 스튜디오 Day 8
인텐트와 수명주기

## 26강
MyIntent
Intent
: 화면은 Activity. 이 activity는 시스템에서 관리하고 있으니 요청을 해야하고, 이를 위해서는 시스템에서 이해할 수 있는 형태를 갖추어야함  
이러한 형태를 가지는 상자를 인텐트라고 부른다.  
액티비티, 서비스(화면이 없는 것), 브로드캐스트 수신자, 내용 제공자의 4가지 주요 구성요소로 이루어져있다.  
위 4가지는 인텐트를 통해 내용을 주고받을 수 있다.  
정보/명령을 주고받을 때, 인텐트를 사용  
화면간 정보를 주고받을 때, 인텐트  

<3요소 중요..>  
startActivity() -> 화면간 intent 전달 (응답 결과등..)  
startService() -> 화면이 없는 상태에서 프로그램이 동작하도록 설정 가능  
broadcastIntent() -> 브로드캐스트 수신자를 통해 intent를 주고받을 수 있도록 한다.  

인텐트: 액션 + 데이터  
액션 정보: 인텐트는 어떠한 일을 해달라고 요청하는 것이므로  무슨일을 할지 정하는 액션정보가 중요하다.  
action_view: 액션정보  
action_dial: 명령 ==> 뒤에 들어가는 것은 데이터! 이러한 액션을 동작할 때 필요한 데이터!  

intent객체를 반드는 방법도 여러가지가 있다.  
암시적 인텐트: 액션과 데이터를 지정하긴 했지만 호출할 대상이 달라질 수 있는 경우 - 약간 디폴트 클래스가 불려온다고 생각하려구  
명시적 인텐트: 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우  

인텐트가 화면/서비스/브로드캐스트 수신자 사이에 데이터를 주고받는 방법인데, 부가데이터를 사용하여(주고받도록) 시스템이 개입하지 않도록 할 수 있다.  

## 27강
action view는 무엇을 보여달라고 하는 것인데, 이것이 번호를 띄워달라고 하는 것이면 dial과 똑같은 일을 하는 것과같이 보일 수 있다.

AndroidManifast.xml: 새로운 화면을 만들면 여기에 등록해야한다. 권한을 등록할 수 있다.
gradle: 최소와 현재 버전을 지정할 수 있다. (gradle(Module.app))  

권한: app이 권한을 요청하는 것은 AndroidManifast안에 넣어놓아야하고, 권한 요청에 사용자가 동의를 하여야 app이 해당 기능을 사용할 수 있다.  

~~~java
<uses-permission android:name="android.permission.CALL_PHONE" /> // ok
<uses-permission android:name="android.permission.CALL_PRIVILEGED" /> // warning
~~~
CALL_PRIVILEGED의 경우, Permission is only granted to system app이라는 것을 볼 수 있다.(system app으로 등록된 어플리케이션만 접근 가능. 루팅이라는 것이 있어야한다.)  
system app: 제조사는 접근할 수 있지만 일반 개발자는 접근 불가능  

xml: 눈에 보이는 기능  
java: 기능을 구성  
--> 한쌍으로 이루어진다.

java 파일을 먼저 만들면 레이아웃을 자동으로 만들어준다.  
만약 java파일을 먼저 만들게 되면, onCreate함수에서 지정하게되는 레이아웃 파일의 이름을 만들어놓은 레이아웃 파일의 이름으로 특정해주어야한다.  
~~~java
setContentView(R.layout.activity_menu);
~~~
java 파일을 만들면 layout폴더안에 content라는 이름을 포함한 xml파일이 만들어지는데 이를 지우면 안된다..  

## 28강
~~~java
<application ... >
        <activity
            android:name=".MenuActivity"
            android:label="@string/title_activity_menu"
            android:theme="@style/AppTheme.NoActionBar" />
</application>
~~~
java src파일을 만들고 나면, manifast파일에 자동으로 activity tag가 추가된다.(application 태그 안의 activity태그를 만들어서 수동으로 추가할 수도 있다.)

#### intent 만드는 방법
onClick을 담당하는 함수 안에 아래의 코드를 넣는다. 아래는 명시적 intent를 만드는 방법이다.  
장점은 동적으로 참조하게될때, 이름만가지고있다가 참조할 수 있는 점이다.  
~~~java
// method1
Intent intent = new Intent(getApplicationContext(), menuActivity.class); // 명시적
startActivityForResult(intent, ACTIVITY_MENU);

// method2
Intent intent = new Intent();
ComponentName name = new ComponentName("com.androidtown.myintent","com.androidtown.myintent.MenuActivity"); // 명시적
intent.setComponent(name);
startActivityForResult(intent, ACTIVITY_MENU);
~~~

(content_menu.xml과 activity_menu.xml의 레이아웃이 일치해야한다.)  
DeviceMonitor 없음 문제 해결 -> (toolbar)view > ToolWindows > Device File   Explorer 으로 들어가서 에뮬레이터를 실행시키면 파일시스템을 볼 수 있다.  

# 29강
activity stack: 실행 액티비티가 정지하면 이전 실행 액티비티를 보여줄 수 있는 구조. 새로운 액티비티가 실행되면 이전의 액티비티는 정지된 상태로 액티비티 스택에 들어감. 쉽게 생각하면 새로운 화면의 뒤에 이전 화면이 숨어있는 것과 같음.  
FLAG_ACTIVITY_SINGLE_TOP: 새로운 액티비티를 실행할 때마다 메모리에 새로운 객체를 만들고 이전 화면 위에 쌓는 방식은 비효율적이므로 동일한 화면이 이미 만들어져 있는 경우에는 그 화면을 그대로 보여주고싶을 때, 플래그를 사용하여 중복을 방지할 수 있다.  
CLEAR_TOP: 쌓인것을 다 지운다.  
~~~java
intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
~~~

시스템을 건들지않고 데이터를 보내고싶을때  
~~~java
Intent putExtra(String name, String value)
int getIntExtra(String name )
~~~

java src파일끼리 데이터를 주고받기 위해서는 put과 get intent를 사용한다.  
intent 객체를 만들어서 put하고 intent 객체를 만들어서 get한다.  

class의 객체를 만들어서 보낼수도 있다.  
extra로 전달하고자할때는 해당 클래스를 Serializable로 만드는것이 가장 쉽다   (implements)

모든 데이터는 byte[] - primitive type로 변환해서 넣을 수 있다. 쉽게는 Serializable, Parcilable(안드로이드 내부에서 객체 형태로 만들어서 intent로 전달가능)로 전달할 수 있다.  

MyIntent 프로젝트에서 ?? 왜 toast 메시지 안떠? -> 마지막에서  
Toast.makeText(getApplicationContext(), "Person name: "+ person01.getName(), Toast.LENGTH_LONG).show();  
여기서 .show()를 안써서..  

-----
# 30강
MyLifeCycle
수명주기: activity라는 화면을 보면, 다른 어플리케이션이 실행중에 전화가 오면, 전화를 우선순위로 두고 실행되게된다. (안드로이드 단말기는 전화기이므로 전화와 문자를 우선순위로 두어야한다.) 기본적인 기능을 위해 모든 리소스를 다 쓸 수 없다. 가능한 리소스 이상으로 쓰게되면 강제로 kill(강제종료). 갑자기 중지되는 상황이 올지모르니까 저장해야.. 알려주고 (sys -> app)

onClick method는 call back method이다. 자동으로 호출되는 것

어플을 켰을때 create(실제 메모리에 만들어지는 것. 화면마다 메모리에 만들어지는 시점이 있다.) start(내부적으로 동작할 준비가 되는 것) resume(화면에 보여지기 바로 전단계) 순서로 호출된다.  
어플을 껐을때 pause(화면이 사라지는 것) stop(중지) destroy(메모리에서 없어지는 것) 순서로 호출된다.  
manifast에 등록된 것중에 첫 create되는 것이 해당 어플리케이션의 시작점이라고 볼 수 있다.  
이중에서 가장 중요한 수명주기 method는 onResume(전화가 끝나고 다시 어플로 돌아갈 - 점수를 복원)과 onPause(어플 실행중에 전화가 왔을때 - 점수등을 저장)이다.  

// 함수 설정  
// save score: on pause일때 단말에 저장되는 것 // 앱이 종료되어도 저장  
// load score: 앱이 시작될때 가져온다.  
