# 안드로이드 스튜디오 Day 9
서비스와 브로드캐스트 수신자

MyService

# 32강
카카오톡과같이 누군가와 메시지를 주고받는다고 생각할때, 내가 보고있지않을때, 메시지가 온다면 상태바와같은 곳에 메시지가 왔다는 알림을 띄워준다.  
(화면이 없는 상태에서도 백그라운드에서 실행중임을 알 수 있다. 이런 구성요소는 서비스이다. -> 시스템이 관리한다.)

서비스를 만들면 manifast에 추가해주어야한다. 혹은 자동으로 manifast에 추가된다.  
activity는 화면에 보이는 것이니 따로 구성했지만 서비스는 화면이 필요없으니 액티비티 만들지않고 자바 소스에 추가하면되는 것.  

화면을 눌렀을때 서비스를 실행시키고자한다면, onClick에 startService, 멈추고자하면 stopService를 추가하면된다.  

서비스라고하는 것은 카카오톡과같이 뒤에서 ..  
계속 대기해야하니 메모리 많이 먹는다고 그냥 죽이며 안되고 죽어서도 다시 실행되어야하는 특징이있다.  

브로드캐스트 수신자: 메시지를 전달할 수 있는 방법 (브로드캐스팅되는 것을 받는 것)  
문자를 받았을때, 신용카드 앱이 파싱을하여 필요한정보를 가져올수있다.  
sms정보를 받아와야한다. (단말 -> 브로드캐스팅 통해 던져준다.(시스템이 이해할 수 있는 인텐트 형식으로 던짐)) 브로드캐스트 수신자가 sms가 담긴 인텐트 받을 수 있다.  

logcat? ddms????!?!

# 34강 : 실습
서비스가 들어가있으면 자동으로 다시 실행된다. -> 다시 로그가 생긴다.  
서비스로 요청, 데이터를 받거나 하면 인텐트로 받게된다.  
서비스로 명령을 받는 것을 보조하는 것이 onStartContent  
스레드를 생성할 수 있음  

# 35강
브로드캐스트 수신자
MySMSReviever

브로드캐스팅으로 던져지는 인텐트를 받고자 등록하는 것  
app구성요소이므로 등록해주어야한다.  
manifast에 자동으로 등록된다.  

- 일반: 동시에 던진다  
- 순차: 순차적으로 던진다  

브로드캐스트 수신자는 원하는 거 왔을때 onRecieve로 받을 수 있다.  

버튼을 누를 필요가 없다->필요할때 호출하기때문  

manifast reciever안에 아래를 추가해주어서 브로드캐스트하는 것을 걸러서 가져와야한다.
~~~java
<intent-filter>
    <action android:name="android.provider.Telephony.SMS_REVIEVED"/>
</intent-filter>
~~~

<uses-permission android:name="android.permission.RECEIVE_SMS" /> 이걸로 권한을 주어야한다.

# 36강
가짜로 메시지 보내는 방법?? 디바이스 모니터  
editfilterconfiguration통해서 패키지와 태그등을 로그를 걸러서 볼 수 있다.  

content는 주변 정보를 가지고있는 객체라고 볼 수 있다. 버튼(화면 구성요소)의 주변 정보 -> 화면  
intent, UI등이 context등의 정보를 항상 알고있어야한다.  
일반적인 context 호출하고자하면 getApplicationContext을 전달하면된다.  

?? 둘의 차이는 ??

# 37강
리소스와 매니페스트
MyDialog

// 다시 듣기
리소스: res안에 있는 것들

#### 매니페스트  
<application> : 어플리케이션의 등록정보  
android:기본 api에 들어가있는 속성을 쓰는 것  

~~~java
<activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" /> // 중요

                <category android:name="android.intent.category.LAUNCHER" /> // 중요
            </intent-filter>
        </activity>
~~~
이게 들어가있으면 main이라는 것  
위에 중요 표시가 MainActivity(첫화면)를 지정하는 속성 두개이다.  

#### 리소스
res
asset: 원본데이터를 저장할 수 있다.

스타일
플랫폼마다 화면의 버튼등을 미리 정한것이 있음 이러한 스타일을 사용자가 지정할 수 있다.  
Alert: 대화상자  

토스트와 대화상자  
토스트: 아래에 간단하게 생성되었다가 사라지는 것  
토스트의 모양은 바꿀 수 있다.  

대화상자: 하겠냐고 물어보는 것
