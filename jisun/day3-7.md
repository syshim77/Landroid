# LandVibe Android Study week 1
###### day 3
#### 안드로이드 최근 버전의 주요 특징
> ###### 프로요(2.2)  
- 플래시 지원   
*현 모바일에서는 지원 안됨   
아이폰 "보안때문에 쓸수가 없다"  
따라서 안드로이드도 자연스레 플래시 버리게됨*
- SD카드에 설치 지원  
*앱이 SD카드에 저장할 수 있는 권한을 부여함  
 -> 어떤 앱이든 접근 가능해 보안문제 발생*  
- 백업 API 지원
- push message 지원  
*서버에서 일방적으로 보내는 메세지*

> ###### 진저브레드(2.3)
- NFC 지원  
*안드로이드가 아이폰보다 부가기능을 더 빨리 적용했다*
- 전면 카메라 지원
- 자이로스코프 센서 지원 (xyz)
- 인터넷 전화 지원  

> ###### 허니콤(3.0)
- 태블릿 UI  
*이전의 안드로이드는 작은 화면 기준이었다.
큰 화면으로 표현하기 위해 os 새로 만들었음
->허니콤 (태블릿용os라서 휴대폰에서 작동 안됨)*

> ###### 아이스크림샌드위치(4.0)  
- 홀로그램픽 UI와 버추얼 키  
- 얼굴인식 언락과 음성인식 텍스트 입력  
- NFC 빔 공유와 WIFI 다이렉트  

> ###### 젤리빈(4.2)
- 그래픽 성능 향상  
- 확장 가능한 알림 메시기  
- 위젯과 네트워킹 기능 강화  

> ###### 킷캣(4.4)  
- 직접 프린팅 가능  
- 저장공간 접근 프레임 워크  
- 배터리 소모가 적은 센서  

> ###### 롤리팝(7.0)  
- 새로운 디자인  
- 시스템과 그래픽 성능 향상   
- 강력해진 멀티미디어 기능

#### 안드로이드 프로젝트 폴더
+ /java [/app/src/main]  
  - 소스파일
+ /res
  - 리소스, XML 파일
+ /build  
  - 빌드과정
+ /assets
  - 안드로이드 스튜디오에서는 기본적으로 없음  
  - 원본 파일 저장
+ Manifest.xml  

#### 애플리케이션 프레임 워크
###### 안드로이드 아키텍쳐  
      리눅스커널 -> 라이브러리(+안드로이드 런타임 ART runtime)
           -> 애플리케이션 프레임워크 -> 애플리케이션
#### 안드로이드 개발도구
1. UI뷰어
2. 디버그브리지(ADB)
3. 나인패치 그리기 도구
4. 디버그 모니터 서비스
***
***
###### day 4-6
### **안드로이드의 화면**
#### view와 view group
1. view  
화면을 구성하는 요소
2. view group  
view들을 담고있는 것
3. widget  
버튼처럼 눈에 확실히 보이는 요소들  
4. layout  
요소들을 배치하는 역할  

> view에 공간을 할당 받으면 그 공간안에 또 view group이 들어갈 수 있음  
즉, view가 들어가는 공간에 view group이 들어갈 수 있음   
상속 : 부모의 특성을 그대로 물려받는 것으로 변수나 메소드 재사용 가능

###### *버튼을 화면에 어떻게 들어가게 할까?*
+ layout_width, layout_height  
  - match_parent : 무조건 남아 있는 여유 공간을 채움  
  - wrap_content : 뷰에 들어 있는 내용물의 크기에 따라 뷰의 크기가 결정됨  
  - 크기 값 지정 : 크기를 고정된 값으로 직접 지정하고 싶을 때 사용함
+ id    
  - 뷰의 ID 지정  
  - XML 레이아웃에 정의한 뷰를 자바 소스에서 참조하는데 사용  
  - XML 레이아웃 안에서 다른 뷰를 참조하는데 사용  
+ background  
  - 뷰의 배경을 설정
+ 뷰의 크기 지정에 사용되는 단위  
  - px, dp/dip, sp/sip, in, mm, em

#### Inflation
+ XML레이아웃에 정의된 정보를 메모리 상에서 객체로 만드는 객체화 과정  
+ 애플리케이션이 시작될 때 이 과정을 거쳐 메모리 상에 만들어진 객체들을 참조하기 위해 ID 지정함

***
## **Layout**
#### 1. 리니어 레이아웃
> + box 배치  
+ 순서대로 추가  
+ orientation이라는 속성을 지정해야함  
+ gravity : 버튼 안 내용물 위치 지정  
+ layout gravity : 버튼 자체의 부모 공간내에서 위치 지정  
+ padding : 버튼 안에서 내용물의 여유공간 설정  
+ layout margin : 버튼이 바깥쪽으로 얼마나 여유공간 띄울건지  
+ onClick : 버튼을 클릭했을 때 호출할 method 지정  

(-> *setContentView는 항상 button 찾기 전에 해야함*)

#### 2. 상대 레이아웃
> + 다른 뷰나 부모 뷰의 상대적인 위치를 이용해 뷰를 배치  
+ 위아래 버튼 사이 공간을 textview로 채우고 싶다
```android
layout_below="@+id/button"; // 위에 있는 버튼의 아래영역부터 채워라
layout_above="@+id/button"; // 아래 있는 버튼의 위 영역부터 채워라
```
**-> relative layout의 장점!**

#### 3. 프레임 레이아웃
>+ 한 번에 하나의 뷰만 보여줌, 다른 뷰들은 그 아래에 중첩되어 쌓인다.  
(보이는 화면을 바꿀 수 있음, 부분 화면을 바꾸어 줄 때 유용하게 사용)  
+ 중첩되는 효과와 함께 뷰의 가시성 속성을 이용해 다양한 화면 구성  
(가시성 visibility-어떤건 보여주고 어떤건 안보여준다)
```android
button.setOnClickListener(new View.OnClickListener) {
  public void onClick(view v) {
  }
}
// 버튼 누르면 이미지 전환하는 코드 작성 위한 함수
```
#### 4. 테이블 레이아웃
> + 격자형태로 추가 (table 형태로 생성-한줄을 row 태그로 감싼다)  
+ fill_parent == match_parent
#### 5. 스크롤 뷰
> + 영역을 벗어나면 자동으로 스크롤 생성  
+ 해당 영역을 <ScrollView>태그로 감싸서 사용
***
###### day 7
#### 애플리케이션 구성하기
*"화면을 만들었다면 앱에 기능을 부여해야한다."*

### 레이아웃 인플레이션
>인플레이션 : XML 레이아웃에 정의된 내용이 메모리에 객체화되는 과정  
setContentView() : 내부적으로 인플레이션함  
부분 레이아웃일 때는 setcontentview 안됨->직접해줘야함 -> layoutInflater

*(-> activity_main.xml 은 mainActivity.java 하고 쌍으로 움직이면서 첫 화면을 보여주는 역할)*

###### 레이아웃 인플레이션 메소드
```android
// resource가 어디가서 붙을지 결정, 파라미터가 달라지면서 기능이 약간씩 달라짐
View inflate(int resource, ViewGroup root)
static LayoutInflater LayoutInflater.from(Context context)
static View inflate(Context context, int resource, ViewGroup root)
```
###### 화면 구성과 화면간 이동
안드로이드 애플리케이션 구성요소  
: 액티비티(화면), 서비스, 브로드캐스트 수신자, 내용 제공자
```android
//다른 사람이 만든 액티비티를 띄워줌-intent를 통해서 data를 전달하는 것
protected void inActivityResult(int requestCode, int resultCode, Intent Data)
```
새로운 화면은 시스템에서 관리하는 거라서 우리가 띄울 수 없고, 시스템에 전달해서 띄워야함  
**->Intent를 만들어서 시스템에 보냄**
```android
//새로 만든 액티비티(MenuActivity) 띄워달라고 요청
Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
startActivity(intent);
```
```android
Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
Intent.putExtra("title", "값"); // intent에 값 넣기
startActivityForResult(intent, 1001); //activity가 여러개일 때 누구한테 요청하는건지 구분, 1001이 요청코드
```
