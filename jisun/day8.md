# LandVibe Android Study week3
###### day8
#### 인텐트와 데이터 전달
## **인텐트**
>시스템에서 관리하고 있는 화면을 띄우려면 시스템쪽으로 요청을 보내야한다.  
이 때, 시스템이 알고 있는 데이터 포맷을 사용해야 하는데 이 포맷을 인텐트라 한다.
> + '액티비티, 브로드캐스트 수신자, 서비스' 끼리 인텐트를 통해 전달  
> + 인텐트 = 액션 + 데이터

암시적 인텐트(implicit Intent)  
+ 특정한 화면을 지정한게 아닌 것(호출할 대상이 달라질 수 있는 경우)  

명시적 인텐트(Explicit Intent)  
+ 호출할 화면을 지정한 것

```java
public void onButton1Clicked(View v){
  // 전화를 걸겠다
  Intent intent=new Intent(Intent.ACTION_DIAL, Uri.phone("tel:010-1000-1000"));
  // 전화걸기 화면, 기존 단말에 있는 전화앱을 띄워주면서 전화걸기 시도
  startActivity(intent);
}
```
새로운 화면을 만들게 되면 AndroidManifest.xml에 등록해야한다.  
권한도 등록 가능하다.
```java
<uses-permission android:name="android.permissi=ion.CALL_PHONE" />
// 제조사에서만 사용가능한 권한, 일반 사용자는 사용 불가능
<uses-permission android:name="android.permissi=ion.CALL_PRIVILEGED" />
```

**intent를 만드는 여러가지 방법**
```java
//mainactivity에서 버튼을 클릭했을 때 전화걸기를 띄우는 것이 아니라 명시된 특정 화면 띄우기
//요청코드를 상수로 정의하고 싶을 때, 요청코드보다 위에 정의
private static final int REQ_MEMU=1001;
public void onButtonClicked(View v) {
  Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
  startActivity(intent);//명시된 화면 띄워짐
  startActivityForResult(intent,1001); //응답을 받고 싶을 때 , 1001-요청코드
}
```
```java
//intent 를 특정한 이름을 주어서 만드는 방법
public void onButtonClicked(View v) {
  Intent intent = new Intent();
  // 동적으로 처리하고 싶을 때 conponentName을 사용
  //(pakage name, pakage name을 포함한 class name)
  ComponentName name = new ComponentName("org.androidtown.myintent",
  "org.androidtown.myintent.MenuActivity");
  intent.setComponent(name);
  startActivityForResult(intent, ACTIVITY_MENU);
}
```
#### 액티비티 간의 데이터 전달 방법
**A: startActivityForResult()**   
->(requestCode)->  
**B: setResult()**  
->(requestCode, resultCode, optional data)->  
**A: onActivityResult()**

### **액티비티 스택**
> 새로운 액티비티가 실행되면 이전의 액티비티는 정지된 상태로 액티비티 스택에 들어간다.  
동일한 화면이 이미 만들어져 있는 경우에는 그 화면을 그대로 보여주고 싶다면 플래그를 사용한다.

```java
[Reference]
FLAG_ACTIVITY_SINGLE_TOP
FLAG_ACTIVITY_NO_HISTORY
FLAG_ACTIVITY_CLEAR_TOP
```
```java
// 인텐트 객체 생성
Intent intent = new Intent(getBaseContext(), AnotherActivity.class);
// 부가 데이터 넣기
intent.putExtra("startCount", Srting.valueOf(startCount));
// 인텐트 플래그 설정
intent.setFlags(Intent.FLAG.ACTIVITY_SINGLE_TOP);
// 인텐트 띄우기
startActivityForResult(intent,REQUEST_CODE_ANOTHER);
```
```java
//화면과 화면 간에 데이터를 전달하고 싶다면 인텐트의 부가데이터(Extra)로 넣어 전달하는 방법을 사용
[Reference]
Intent putExtra(String name, String value)
Intent putExtra(String name, int value)
Intent putExtra(String name, boolean value)

String getStringExtra(String name)
int getintExtra(String name, int defaultValue)
boolean getBooleanExtra(String name, boolean defaultValue)
```
```java
[Reference]
public abstract int describeContents()
public abstract void writeToParcel(Parcel dest, int flags)
```
```java
//intent 안에 Extra data 넣어서 전달하기
public void onButtonClicked(View v) {
  Intent intent = new Intent();
  ComponentName name = new ComponentName("org.androidtown.myintent","org.androidtown.myintent.MenuActivity");
  intent.setComponent(name);
  intent.putExtra("title", "소녀시대");
  intent.putExtra("age", 20);

  Person person01 = new Person("걸스데이", 21);
  intent.putExtra("person", person01);
// parcelable class
// 안드로이드 내부에서 객체단위를 만들어서 인텐트 간에 구성요소를 전달할 때 사용
// 용량이 커지는 문제 해결
  startActivityForResult(intent, ACTIVITY_MENU);
}
```

### **수명주기**
> **실행(Running)**  
> + 화면 상에 액티비티가 보이면서 실행되어 있는 상태
> + 액티비티 스택의 최상위에 있으며 포커스를 가지고 있음  
> **일시중지(Paused)**  
> + 사용자에게 보이기는 하지만 다른 액티비티가 위에 있어 포커스를 받지 못하는 상태  
> + 대화상자가 위에 있어 일부가 가려져 있는 경우에 해당함  
> **중지(Stopped)**  
> + 다른 액티비티에 의해 완전히 가려져 보이지 않는 상태
