# Day 20

#### Intro of Graphic part & Draw Rectangle
1. 뷰 위에 그래픽을 그리는 순서
  1) 새로운 클래스를 만들고 뷰를 상속받음
  ```java
  public class CustomView extends View {
    public CustomView(Context context) {  // 생성자는 늘 2개여야함
      super(context);
    }
  }
  ```
  2) 페인트 객체를 초기화하고 필요한 속성을 설정함
  ```java
  public class CustomView extends View {
    private Paint paint;
    public CustomView(Context context) {
      super(context);
      paint = new Paint();
      paint.setColor(Color.RED);
    }
  }
  ```
  3) onDraw() 메소드 내에 사각형을 그리는 메소드를 호출함
  ```java
  public class CustomView extends View {
    ...
    protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      canvas.drawRect(100, 100, 200, 200, paint);
    }
  }
  ```
  4) onTouch() 메소드 내에 터치 이벤트를 처리하는 코드를 넣음
  ```java
  public class CustomView extends View {
    ...
    public boolean onTouchEvent(MotionEvent event) {
      if (event.getAction() == MotionEvent.ACTION_DOWN) {
        Toast.makeText(super.getContext(),
          "MotionEvent ACTION_DOWN: " + event.getX() + ", " + event.getY(), 1000).show();
      }

      return super.onTouchEvent(event);
    }
  }
  ```
  5) 새로 만든 뷰를 메인 액티비티에 추가함
  ```java
  public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      CustomView myView = new CustomView(this);
      setContentView(myView);
    }
  }
  ```
2. 그래픽을 그리는데 사용되는 주요 클래스
  - 캔버스(Canvas)
    + 뷰의 표면에 직접 그릴 수 있도록 만들어주는 객체
    + 그래픽 그리기를 위한 메소드가 정의되어있음
  - 페인트(Paint)
    + 그래픽 그리기를 위해 필요한 색상 등의 속성을 담고 있음
  - 비트맵(Bitmap)
    + 픽셀로 구성된 이미지로 메모리 상에 그래픽을 그리는데 사용함
  - 그리기객체(Drawable)
    + 사각형, 이미지 등의 그래픽 요소가 객체로 정의되어있음
3. Demo

#### Draw using Drawing Object
1. 그리기 객체로 만들어 그리기
  - 리소스 파일의 사용
    + 프로젝트 리소스에 이미지와 같은 파일을 포함시킨 후 읽어 들여 사용함
  - XML로 정의하여 사용
    + 그리기 객체의 속성을 정의한 XML 파일을 정의하여 사용함
  - 자바 코드에서 객체를 만들어 사용
    + 자바 코드에서 new 연산자를 이용하여 그리기 객체를 만든 후 사용함
    + 비트맵 이미지를 주어진 좌표값에 그림
2. Demo

#### Cannot Understand
