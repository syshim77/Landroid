## [60강] 스피너 사용하기
##### 스피너
+ 선택위젯의 종류 중 하나
+ 콤보박스 처럼 여러가지 중에 선택할 수 있음

>**이해되지 않은 부분:**
  - MySpinner 프로젝트 실행 오류 해결
  --> click이 아니라 selected을 사용해야한다.
  ~~~java
  // 이후
  spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "선택된 아이템: " + names[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// 이전
  spinner.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "선택된 아이템 : " + names[position], Toast.LENGTH_LONG).show();
            }

        });

  ~~~

## [61강] 리스트뷰 만들기
어댑터를 정의하지 않고 기존 API를 사용하여 리스트뷰를 만들 수 있음  
그러나 API를 사용하여 만들면 화면 전체가 리스트뷰가 되야하며, 다른 위젯은 보이지 않음
>API를 잘 사용하지 않고 직접 만들어서 쓰는 것을 추천

>**이해되지 않은 부분:**  
오류를 해결하기 위해서는 아래의 변경사항을 적용해야하는데, 이유를 모르겠음  
1. 아래의 코드를 삭제해야함  
`setContentView(R.layout.activity_main);`
2. 리스트에 id를 부여  
-> `public class MainActivity extends ListActivity`를 통해서 ListActivity를 상속받았기 때문에
`<ListView
        android:id="@+id/list" /> `미리 구현되어 있던 list라는 아이디를 가져와서 쓰고자 id를 list로 부여하는 것이고
`setContentView(R.layout.activity_main);`도 중복으로 선언하면 안되기때문에 지워준 것이다.

## [62강] 갤러리 사용하기
+ 사진을 나열해서 볼 수 있도록 하는 간단한 '선택위젯'
+ 어댑터를 사용해서 구성할 수 있음
+ `<Gallery>`라는 태그를 사용
+ 가로방향으로 스크롤 가능
+ 권장하지 않음 (갤러리가 가지는 특징이 있어서 사용하기도 함)
+ 앨범: 프로바이더 / 개발자: 컨슈머
> 갤러리를 뷰 페이저 같은 것으로 대체한다.

단말의 사진을 갤러리로 가져와 사용할 떄, 이러한 요소를 사용한다.

##### 내용 제공자
+ 어플리케이션의 4가지 구성요소 중 하나
  - 액티비티, 서비스, 브로드캐스트 수신자, 내용 제공자
+ 앨범에 들어있는 사진을 가져가는 방법을 정의
+ 데이터 베이스와 비슷하게 정의된 방법으로 쿼리
+ 사용방법
  1. MediaStore.Images.Thumbnail
    - 미디어가 저장된 공간 중, 사진의 썸네일이 저장된 공간을 나타내는 상수
    - 필요한 정보를 넣어주면 커서를 리턴
  2. getCount
    - 커서에서 정보가 몇개 있는지 가져올 수 있음
  3. actualImageCursor.moveToPosition
    - 커서의 위치를 움직이며 데이터 추출 가능

##### 그리드 뷰 사용하기
+ 테이블 형태로 보여주는 데이터를 관리할 어댑터 정의 필요
+ 각각의 아이템 중에 선택 가능한 선택위젯

>선택위젯은 모두 어댑터를 사용하기 때문에 어댑터에 익숙해지면 선택위젯을 쉽게 사용할 수 있음

>**이해되지 않은 부분:**
  - MyGrid 프로젝트 실행시, 버튼과 그리드뷰가 겹쳐서 보이는 현상
  --> constraint layout의 버튼을 먼저 놓고, 4면을 전부 연결
  --> 이후 하단을 제외하여 레이아웃을 버튼 아래에 붙이고 양사이드를 화면에 붙인다.
