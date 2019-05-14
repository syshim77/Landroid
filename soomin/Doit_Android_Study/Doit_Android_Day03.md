# 안드로이드 앱 프로그래밍 Day 3
안드로이드 프로젝트와 개발도구

### 안드로이드 최근 버전의 주요 특징
+ 프로요(2.2)  
  - 플래시 지원, SD 카드에 설치 지원, 백업 API 지원, 푸쉬 메시지 지원   

+ 진저브레드(2.3)  
  - NFC 지원, 전면 카메라 지원, 자이로스코프 센서 지원, 인터넷 전화 지원   

+ 허니콤(3.0)  
  - 태블릿 UI, 화면 분할 지원, HTTP 라이브 스트리밍 지원  
  - 허니콤은 태블릿의 큰 화면을 위한 OS를 만든 것이므로 스마트폰에서 돌아가지 않음    

+ 아이스크림 샌드위치(4.0)  
  - 태블릿과 스마트폰 둘다 에서 사용 가능  

+ 젤리빈(4.2)  
 - 그래픽 성능 향상, 확장 가능한 알림메시지, 위젯과 네트워킹 기능 강화  

+ 킷캣(4.4)  
 - 프린팅 프레임워크, 저장공간 접근 프레임워크, 배터리 소모가 적은 센서  

+ 롤리팝(5.0)  
 - 새로운 디자인, 시스템과 그래픽 성능 향상, 강력해진 멀티미디어 기능, 업데이트 가능한 웹뷰  


### 안드로이드 프로젝트 폴더
+ /java : 자바 소스 파일이 들어있는 폴더  
+ /res : xml 레이아웃, 이미지 파일, string 정의 xml 파일등이 들어가있는 폴더  
+ /build : 결과물이 컴파일/빌드되어야 프로그램으로 만들어져서 실행가능. 개발환경이 자동으로 만들어내는 소스파일이 들어가있는 폴더  
+ /assets : 처음에는 만들어져있지 않음. 이 폴더에 넣어서 처리하는 파일들을 저장. (원본 파일을 저장)  
+ AndroidManifest.xml : app 설정을 저장.   

##### 프로젝트 빌드 과정
+ 안드로이드 스튜디오에서 앱 작성
+ 빌드/컴파일(apk확장자의 파일 생성, .class->.dex)
+ 바이트 코드로 변환/패키징 인증
+ ART 런타임(안드로이드 커널-LINUX)  

### 애플리케이션 프레임워크
리눅스 위에 자바가 올라간 것.  
안드로이드가 자바와 다른 이유는 화면을 만드는 방법이 다르다  
안드로이드는 화면을 간단하게 만들 수 있고, 화면을 띄워주는 API를 다르게 구성하여 빠르게 했다. AWT와 SWING을 쓰지 않음  
자바는 VM을 쓰기때문에 느리다.  
(그래픽이 특히 느림)  

### 안드로이드 아키텍쳐
리눅스 -> ART (런타임), 라이브러리 -> 애플리케이션 프레임워크 -> 애플리케이션

### 안드로이드 개발도구
안드로이드 스튜디오는 개발도구(개발 툴)  
SDK Manager에는 버전별로 안드로이드를 더 선택해서 설치할 수 있다.  
모듈등을 더 설치할 수 있다.  

SDK Path: C:\Users\OOO\AppData\Android\sdk
SDK Path 아래에 필요한 support data들이 설치되어있다.  

system.img: 용량이 엄청 큰데, 에뮬레이터를 실행하기 위한 것들을 담은 것  

##### tools
UI 뷰어(앱을 구성하는 버튼이 어떻게 구성되어있는지)
디버그 브리지(ADB/ 명령어를 통해 애뮬레이터나 실제 단말에 안드로이드 패키지 파일 설치
애뮬레이터나 실제 단말에서 실행되고있는 애플리케이션에 표준 디버거를 연결)  
나인패치 그리기 도구(크기에 따라서 이미지를 늘리게 되는지 어떤것을 늘리고 늘리지말지 결정 가능)
디바이스 모니터(DDMS/ 단말.에뮬레이터의 내용을 확인하거나 단말에서 뿌려주는 로그를 확인할 수 있다./ 안드로이드 스튜디오 3.1 이하 버전에서는 Tools-DeviceMonitor로 테스트 디바이스 정보를 가져올 수 있었는데, 업데이트 이후로는 View-Tool Windows-Device Flie Explorer로 열면 된다.)

애뮬레이터 단축키 -이미지 넣기

단말기의 디바이스 드라이버는 디바이스 제조사에서 받을 수 있다.


안드로이드를 개발하기 위해 안드로이드 스튜디오가 필요
안드로이드 개발을 할 대상(대상 플랫폼이 무엇이냐)에 따라 SDK Manager에서 설치하고
추가 tool, extra내 항목을 설치하면 쓸 수 있음!

---
### 실습
아래의 코드를 MainActivity.java의 MainActivity.class안에 넣고 버튼의 onClick속성에 이러한 함수의 이름을 적어넣어주면 연결이 가능하다.

##### 웹페이지를 띄우는 기능
~~~java
/// MainActivity.java
public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌렸어요", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
        startActivity(intent);
    }
~~~
##### 전화를 거는 기능
~~~java
// MainActivity.java
    public void onButton2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(intent);
    }
~~~

##### 다른 화면을 띄우는 기능 - 추가 필요
~~~java
// MainActivity.java
    public void onButton3Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        startActivity(intent);
    }
~~~
