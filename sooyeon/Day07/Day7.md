# Components

#### Application Composition Intro
1. Review
2. 애플리케이션 구성하기
  - ex) 화면, activity 등

#### Layout Inflation(1)
1. 인플레이션
  - XML 레이아웃에 정의된 내용이 메모리에 객체화되는 과정
  - setContentView() 메소드의 역할
    + 화면에 나타낼 뷰를 지정
    + XML 레이아웃의 내용을 메모리 상에 객체화
  - LayoutInflater
    + 전체 화면 중에서 일부분만을 차지하는 화면 구성요소들을 XML 레이아웃에서 로딩하여 보여줌
    + 제공되는 클래스
2. 화면 전체와 화면 일부
  - 안드로이드에서 화면
    + 소스와 화면 구성이 분리되어있음
      * 자바 소스 1개
      * XML 레이아웃 1개
  - 화면 전체
    + 액티비티 -> setContentView에서 인플레이션
      * 액티비티를 위한 자바 소스 1개(MainActivity.java)
      * 액티비티를 위한 XML 레이아웃 1개(activity_main.xml)
  - 부분 화면
    + 수동으로 인플레이션
      * 부분화면을 위한 자바 소스 1개 또는 뷰(뷰가 1개의 소스 파일로 분리될 수 있음)
      * 부분화면을 위한 XML 레이아웃 1개(singer.xml)
3. Demo

#### Layout Inflation(2)
1. Demo.

#### Layout Inflation(3)
1. 레이아웃 인플레이션 메소드(reference)
  - View inflate(int resource, ViewGroup root)
  - static LayoutInflater LayoutInflater.from(Context context)
  - static View inflate(Context context, int resource, ViewGroup root)
2. Demo

#### Screen Composition & Movement between Screen(1)
1. 안드로이드 애플리케이션을 구성하는 네가지 구성요소
  - 액티비티(activity)
  - 서비스(service)
  - 브로드캐스트 수신자(broadcast receiver)
  - 내용 제공자(content provider)
2. 액티비티
  - 하나의 화면으로 구성
  - intent를 가지고 시스템에 보내야 시스템이 알 수 있음
3. 화면 구성과 화면간 이동 과정
  - 메소드(reference)
    + startActivityForResult()
    + setResult()
    + protected void onActivityResult(int requestCode, int resultCode, Intent Data)
4. Demo

#### Screen Composition & Movement between Screen(2)
1. Demo

#### Screen Composition & Movement between Screen(3)
1. Demo

#### Cannot Understand
