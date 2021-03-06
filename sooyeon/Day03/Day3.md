# Android Project & Development Tool

#### Recent Android version's main feature
1. 안드로이드 주요 기능
  - 안드로이드 버전이 변화했음에도 여전히 있는 기능들은 중요한 기능
  - 프로요(2.2)
    + 플래시(Flash) 지원
      * 보안 문제 등 때문에 플래시 기능을 없앰
    + SD카드에 설치 지원
    + 백업 API 지원
      * ex) 클라우드
    + 푸쉬 메시지 지원
      * 서버 쪽에서 일방적으로 보내주는 메시지
  - 진저브레드(2.3.3)
    + NFC 지원
    + 전면 카메라 지원
    + 자이로스코프 센서 지원
      * 건강 관리(health care)에서 주로 사용
      * 가속도계 센서 보완(정확도 높음)
    + 인터넷 전화 지원
  - 허니콤(3.0)
    + 태블릿 UI
      * 태블릿용 OS로 새로 만들어짐
    + 화면 분할 지원
    + HTTP 라이브 스트리밍 지원
  - 아이스크림 샌드위치(4.0)
    + 홀로그래픽 UI와 버추얼 키
    + 얼굴인식 언락과 음성인식 텍스트 입력
    + NFC 빔 공유와 WiFi 다이렉트
      * 테더링 등
  - 젤리빈(4.2)
    + 그래픽 성능 향상
      * 성능이 굉장히 좋아지는 시점
    + 확장 가능한 알림 메시지
    + 위젯과 네트워킹 기능 강화
  - 킷캣(4.4)
    + 프린팅 프레임워크
      * PC 수준의 프린팅
    + 저장공간 접근 프레임워크
    + 배터리 소모가 적은 센서
      * 점점 센서가 중요해짐
  - 롤리팝(5.0)
    + 새로운 디자인
      * 요즘 UI 트렌드를 따라서 바꿈
    + 시스템과 그래픽 성능 향상
    + 강력해진 멀티미디어 기능
    + 업데이트 가능한 웹뷰

#### Android Project folder
1. 안드로이드 프로젝트 폴더
  - /java
    + 자바 소스 파일이 들어있는 폴더(/app/src/main)
  - /res
    + 리소스 파일이 들어있는 폴더(/app/src/main)
    + XML 레이아웃, 그림 파일, 문자열을 정의한 XML 파일 등
  - /build
    + 개발환경이 자동으로 만들어 내는 소스 파일이 들어가는 폴더(/app/build)
  - /assets
    + 폴더에 넣어서 처리하는 파일들을 저장(동영상 파일 등)
  - AndroidManifest.xml
    + 앱에 대한 정보를 담고 있는 파일(/app/src/main)
    + 매니페스트라고 부르며 애플리케이션 구성요소나 권한 등의 정보를 정의함
2. 프로젝트 빌드 과정
  - 안드로이드 스튜디오에서 앱 작성
    + 프로젝트 구성
  - 자바에서 빌드(컴파일)
    + 소스 컴파일
      * javac compiler
      * dx tool
  - 바이트코드로 변환 및 패키징
    + aapt tool
      * apk unsigned -> apk signed
  - ART 런타임
    + 안드로이드 커널(LINUX)
3. 애플리케이션 프레임워크
  - 표준 자바와 안드로이드의 가장 큰 차이점
    + 화면 구성 API
    + 핸드폰은 PC보다 사양이 낮기 때문에 그래픽 부분에서 표준 자바의 성능이 현저히 떨어짐
  - 안드로이드 architecture
    + kernel -> library -> application framework -> application
4. 안드로이드 개발도구
  - 안드로이드 스튜디오(안드로이드 SDK manager)
    + UI 뷰어
    + 디버그 브리지
    + 나인패치 그리기 도구
    + **디버그 모니터 서비스**(DDMS)
      * log, file 등 볼 수 있음
      * 실제 단말을 연결할 때
    + 에뮬레이터

#### Cannot Understand
