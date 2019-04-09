## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 10강 - 18강
## Day 4, 5, 6

### 기본 위젯과 레이아웃

  1.	뷰와 뷰 그룹
    *	뷰
	        - 화면(activity)에 보이는 각각의 것들 (버튼, 텍스트 등등)
	        - UI 구성 요소
          - 뷰가 공간을 할당을 받으면 그 공간 안에 뷰 그룹이 들어갈 수 있다.
          -	만약 하나의 버튼이 차지하고 있던 공간이 있다고 하면 그걸 버튼이 여러 개 들어가 있는 뷰 그룹으로 대체가능 => 뷰 그룹이 뷰가 가진 공간을 대체할 수 있다. 이유) 뷰 그룹이 뷰를 상속했기 때문

   * 뷰 그룹 (View Group)
          -	눈에 보이진 않지만 할당되어 있는 공간
          -	뷰들을 여러 개 포함하고 있음.
          -	뷰 그룹도 뷰에서 상속하여 뷰가 됨. 즉, 위의 뷰는 버튼, 텍스트 뿐만 아니라 이것들을 포함하는 눈에 보이지 않는 영역을 포함함

    *	위젯 (Widget)
          -	화면을 구성하는데 눈에 확실하게 보이는 것들
          -	뷰 중에서 일반적인 컨트롤의 역할을 하고 있는 것
          -	버튼, 텍스트 등등

    *	레이아웃 (Layout)
          - 뷰 그룹 중에서 내부에 뷰들을 포함하고 있으면서 그것들을 배치하는 할을 하는 것

    *	상속
          -	객체지향의 가장 기본적인 개념 중 하나
          -	부모의 특성을 그대로 물려받는 것으로 변수나 메소드를 그대로 가지고 있음

    *	Activity의 상속
          -	처음 만들어 본 activity에서 extends 키워드 사용

    *	재정의한 메소드를 시스템에서 호출하는 방법
          -	표준 자바를 그대로 따라함

    *	**layout_width, layout_height**
          -	가장 기본적이면서도 필수 속성으로 뷰의 폭과 높이를 설정함
          - (1) match_parent : 무조건 남아있는 여유 공간을 채움
	        - (2) wrap_content: 뷰에 들어있는 내용물의 크기에 따라 뷰의 크기가 결정됨
          -	(3) 크기 값 지정: 크기를 고정된 값으로 직접 지정하고 싶을 때 사용함. Ex) “100px”, “200dp”

    *	Id
          -	뷰의 id를 지정함
          -	XML 레이아웃에 정의한 뷰를 자바 소스에서 참조하는 데 사용 -> 자바 source에선 id를 찾아야함
          -	화면을 동작시키는 건 mainActivity.java인데 안드로이드는 화면을 xml로 분리시켰다(편리함).
          -	XML 레이아웃 안에서 다른 뷰를 참조하는 데 사용

    *	Background
          -	뷰의 배경을 설정함(배경색, 배경 이미지 등)

    *	뷰의 크기 지정단위
	       - Px : 픽셀
         -	dp(dpi) : 밀도 독립적 픽셀 (160dpi 화면을 기준으로 한 픽셀) => 권장

    *	뷰의 ID 속성
	       - Xml layout에 있는 걸 source에서 기능을 부여하려고 하면, 먼저 찾아야함. 왜냐하면 xml layout은 source가 아니기 때문에! 자세하게 말하면 xml layout에 있는 버튼을 프로그램이 자동으로 메모리에 올려주는데 이 버튼에 대해서 찾아줘야함.
    *	뷰의 background 속성
	       - XML 레이아웃에서 색상을 지정할 때는 # 기호를 앞에 붙인 후, ARGB의 순서대로 색상의 값을 기록하면 됨. A의 값이 ff로 시작하면 색상 그대로, 88으로 시작하면 반투명, 00으로 시작하면 투명


2.	레이아웃
    -	대표적인 레이아웃
	      - LinearLayout
        -	RelativeLayout
        -	Frame layout
        -	Table layout
        - 스크롤 뷰


3.	Linear layout
    - 아래 쪽 설명 참조


4.	Relative layout
      -	상대 레이아웃에서 사용할 수 있는 속성들
        1.	상대 레이아웃에서 부모 컨테이너와의 상대적 위치를 이용하는 속성
            -	Layout_alignParentTop, layout_alignParentBottom
        -	상대 레이아웃에서 다른 뷰와의 상대적 위치를 이용하는 속성
            -	android:layout_alignParentBottom=”true” : 부모의 아래쪽에 붙음
	          - android:layout_alignParentTop=”true” : 부모의 위쪽에 붙음
	          - android:layout_below=”버튼” : 버튼의 아래쪽부터 배치
	          - android:layout_above=”버튼” : 버튼의 위쪽까지 배치


##### Linear layout vs Relative layout
- Linear layout : 현재 화면이 가득 찬 경우 다른 넣고 싶은 걸 넣지 못한다.
-	Relative layout : 현재 화면이 가득 찼더라도 편하게 추가 가능 ( 장점 )


5.	테이블 레이아웃.
    -	**격자 모양** 형태로 추가할 수 있게 해주며 생성 시, 한 줄을 TableRow 태그로 감싸게 된다


6. Scroll view
    - 글자가 너무 길어 자동으로 스크롤이 되게 하려면 스크롤 뷰 안에 넣으면 됨
    - textview 태그를 ScrollView 태그가 감싼다.
    - *주의*
      - 기존의 TextView 태그 안에 있었던 android:layout_below=" " 와 android:layout_above 태그를 ScrollView 속성 밑에 놔둬야함.

    - 스크롤 방향을 가로로 하고 싶으면 horizontal scrollview 쓰면 됨.


7.	Frame layout
    -	프레임 레이아웃과 뷰의 전환
        -	한 번에 하나의 뷰만 보여주며, 다른 뷰들은 그 아래에 중첩되어 쌓임
        -	중첩되는 효과와 함께 뷰의 가시성(Visibility) 속성을 이용해 다양한 화면 구성이 가능함


*주의사항*
 파일을 생성할 때 application name에 my가 포함되도록 name을 짓자!
 Class와 이름이 충돌할 수 있기 때문에.

### Button의 property
 - layout_width를 wrap_content로 설정 : 버튼 속 message 크기만큼 버튼의 가로
 - layout_width를 match_parent로 설정 : 버튼의 가로가 디바이스 가로 만큼 설정
 - android::visibility=”gone” : 버튼 안보이게 하는 속성

### Plain text의 속성
 Text Fields의 plain text : 입력 상자
 - hint : 입력 상자의 설명 (ex. 아이디를 입력해주세요)
 	- input type : type이 textPassword면 사용자가 입력시 별표로 표시됨


### Linear layout
- linear layout의 **방향** (orientation)
    1. horizontal(세로 방향)
      - *주의사항* : 3개의 버튼 중 첫번째 버튼의 가로를 wrap_content가 아닌 match_conten로 하면 나머지 버튼 사라짐.
    2. vertical(가로 방향)
- Gravity
  - 버튼 속 내용 정렬 속성 -> 버튼 안에 여유공간이 있을 때, 정렬 가능
	- Layout::gravity : 버튼 자체를 정렬 -> 화면 여유공간이 있을 때, 정렬 가능
-	Padding : 버튼 경계선과 버튼의 내용
-	Layout::Margin : 버튼을 바깥 공간
-	Layout::weight : 화면 분할을 해서 각각에 공간을 할당. 작은 숫자일수록 많은 공간할당
- onClick : onClick의 값엔 소스코드에서 사용할 method 이름이 들어감 -> 버튼이 클릭되었을 때, 이 method를 실행

- onClick 방법

###### 1) Onclick의 속성에 입력 후, source코드에 동일한 이름의 method(함수) 정함
  ~~~java
  Public void onButton1Clicked(View v) { Toast.makeText(getApplicationContext(),”시작버튼이 눌렸어요”, Toast.Length_Long).show();}
  ~~~

###### 2)	Xml layout에 버튼을 찾은 뒤, 버튼에 Click Event를 처리
    ~~~java
    Button button2 = (button) findCiewById(R.id.button2);
     button2.setOnClickListener(new View.OnClickListener()){ public void onClick(View v) { Toast.makeText(getApplicationContext(),”중지버튼이 눌렸어요”, Toast.Length_Long).show(); }
    ~~~

### Image View
  - 이미지를 사용
  - Android:src=”@drawble/ic_launcher” : drawble 폴더 안에 ic_launcher이름을 가진 사진을 첨부 (확장자는 생략)
  - 버튼을 클릭해 2개의 이미지뷰가 번갈아가면서 출력되게 하는 코드 ( mainactivity.java)
      ~~~java
      public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    boolean selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(selected){
                    imageView.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                }
                selected = !selected;
            }
        });
      }
}
~~~

--------

#### Want to more know
강의에선 default로 relative layer로 설정이 되어있었는데 내 안드로이드 스튜디오에는 constrain layer로 되어있음. Constrain layer와 relative layer, linear layer의 차이점이 궁금하다
-> <https://academy.realm.io/kr/posts/constraintlayout-it-can-do-what-now/>
-> <https://medium.com/@futureofdev/android-constraintlayout-쉽게-알아가자-62d2ded79c17>
