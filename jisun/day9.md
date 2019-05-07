# LandVibe Android Study week3
###### day9
#### 서비스
## **서비스**
> 백그라운드에서 실행되는 애플리케이션 구성 요소  
> 매니페스트 파일(AndroidManifest.xml) 안에 <service> 태그를 이용하여 선언  
> 시스템이 종료시키더라도  다시 실행됨

```java
//MyService.java
//Service class를 상속하는 MyService class
public class MyService extends Service {
public MyService() { } //상속자
//액티비티의 상태는 사용자가 제어할 수 있는 것이 아님(서비스)
//callback method 중 몇가지를 override
}
```
```java
public class MainActivity extends ActionBarActivity {
  public void onButtonClicked(View v) {
    Intent intent = new Intent(getApplicationContext(), MyService.class);
    intent.putExtra("command","start");
    startService(intent);
  }
}
```
```java
public int onStartCommand(Intent intent, int flags, int startId) {
  Log.d(TAG, "onStartCommand() 호출됨.");

  if(intent != null) {
    Srtring command = intent.getStringExtra("command");
    if(command != null) {
      if(command.equals("start")) {
        PrintThread thread = new PrintThread();
        thread.start();
      }
    }
  }
  return super.onStartCommand(intent, flags, startId);
}
```
```java
class PrintThread extends Thread {
//start를 실행하면 run이 호출
  public void run() {
    for (int i=0; i<100; i++) {
      Log.d(TAG, "#"+i+"서비스에서 반복됨.");
      try{
        Thread.sleep(500);
      } catch(Exception e) {
        e.pringStackTrace();
      }
    }
  }
}
```
### **브로드캐스트 수신자**
+ **일반 브로드캐스트**  
동시에 순서없이 실행됨  
+ **순차 브로드캐스트**  
순차적으로 하나씩 실행됨

```java
//MySMSReceiver.java

public class MySMSReceiver extends BroadcastReceiver {
  private static final String TAG = "MySMSReceiver";
  public MySMSReceiver() { }
  public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "onReceive() 호출됨.");
  }
}
```
```java
//Manifest.xml
//receiver 자동으로 등록된다
<receiver
android:name=".MySMSReceiver"
android:enabled="true"
android:exported="true" >
//어떤걸 받을지 filter 지정
<intent-filter>
<action android:name="android.provider.Telephony.SMS_RECEIVED" />
</intent-filter>
</receiver>
//RECEIVE_SMS를 받을 권한 추가
<uses-permission android:name="android.permission.RECEIVE_SMS" />
```
```java
//MySMSReceiver.java
public class MySMSReceiver extends BroadcastReceiver {
  private static final String TAG = "MySMSReceiver";
  public MySMSReceiver() { }
  public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "onReceive() 호출됨.");
    // 문자를 받으면 mainActivity 화면 띄우기
    //context - 동작하는 기능의 주변정보를 담고 있는 객체
    Intent myIntent = new Intent(context , MainActivity.class);
    //intent 이용하기 전에 option 추가
    myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    context.startActivity(myIntent);
  }
}
```
***
#### 리소스와 매니페스트
## **매니페스트**
###### 매니페스트의 태그항목

```java
[Reference]
<action><permission>
<activity><permission-group>
<activity-alias>
<application><provider>
<category><receiver>
<data><service>
<grant_uri_permission><uses_configuration>
<instrumentation><uses-library>
<intent-filter><uses-permission>
<manifest><uses-sdk>
<meta-data>
```

###### 메인 액티비티 정의
```java
<activity android:name="org.androidtown.basicMainActivity" android:label="@string/app_name">
<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category androit:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>
```
#### 리소스  
[/res], [/assests]  

### 토스트와 대화상자
#### 토스트
>간단한 메시지를 잠깐 보여주었다가 없어지는 뷰  
>애플리케이션 위에 떠 있는 뷰라 할 수 있음

```java
Toast.makeText(Context context, String message, int duration)

public void setGravity(int gravity, int xOffset, int y Offset)
public void setMargin(float horizontalMargin, float verticalMargin)
```

#### 대화상자
```java
//MainActivity.java

public class MainActivity extends ActionBarActivity {
  public void onButtonClicked (View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setTitle("안내");
    builder.setMessage("종료하시겠습니까?");
    builder.setIcon(android.R.drawable.ic_dialog_alert); // 경고 아이콘

    builder.serPositiveButton("예", new OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(), "예 버튼이 눌렸습니다.", Toast.LENGTH_LONG.show());
      }
    });
    AlertDialog dialog = builder.create();
    dialog.show();
  }
}
```
