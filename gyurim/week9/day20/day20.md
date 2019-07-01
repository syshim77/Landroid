## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 69강 - 71강
## Day 20

### Chapter 05. 그래픽

#### 빨간색 사각형 그리기

##### 뷰 위에 그래픽을 그리는 순서
  1. 새로운 클래스를 만들고 뷰를 상속받음
  2.	페인트 객체를 초기화하고 필요한 속성을 설정함
  3.	onDraw() 메소드 내에 사각형을 그리는 메소드를 호출함
  4.	onTouch() 메소드 내에 터치 이벤트를 처리하는 코드를 넣음
  5.	새로 만든 뷰를 메인 엑티비티에 추가함

###### 1단계 - 뷰 상속하기
```
public class CustomView extends View{
public CustomView(Context context){ super(context); } }
```

###### 2단계 - 페인트 객체 초기화하기
- paint 객체 정의, 속성(색, 선의 굵기) 설정
```
public class CustomView extends View {
private Paint paint;
public CustomView(Context context){
super(context);
paint = new Paint();
paint.setColor(Color.RED); } }
```

###### 3단계 - onDraw() 메소드 구현하기
```
public class CustomView extends View{
protected void onDraw(Canvas canvas){
super.onDraw(canvas);
canvas.drawRect(100, 100, 200, paint); } }
```

###### 4단계 - onTouch() 메소드 구현하기
```
public class CustomView extends View{
public Boolean onTouchEvent(MotionEvent event){
if(event.getAction() == MotionEvent.ACTION_DOWN){
Toast.makeText(super.getContext(), “MotionEventACTION_DOWN:”+event.getX() + “,” + event.getY(),1000).show(); } return super.onTouchEvent(event); } }
```

###### 5단계 - 메인 액티비티에 추가하기
- 만든 customView를 main Activity에 추가
```
public class MainActivity extends Activity{
public void onCreate(Bundle savedInstanceState) {
super.onCreate(saveInstanceState);
CustomView myView = new CustomView(this);
setContentView(myView); } }
```
#### 그래픽 그리기

##### 그래픽을 그리는 데 사용되는 주요 클래스
- Canvas
  + 뷰의 표면에 직접 그릴 수 있도록 만들어 주는 객체로 그래픽 그리기를 위한 메소드가 정의되어 있음
- Paint
  + 그래픽 그리기를 위해 필요한 색상 등의 속성을 담고 있음
- Bitmap
  + 픽셀로 구성된 이미지로 메모리 상에 그래픽을 그리는 데 사용함
- Drawable
  + 사각형, 이미지 등의 그래픽 요소가 객체로 정의되어 있음

##### 캔버스 객체의 대표적인 메소드
- 점 그리기
> void drawPoint(float x, float y, Paint paint)

- 선 그리기
> void drawLine(float startX, float startY, float stopX, float stopY, Paint paint)

- 사각형 그리기
> void drawRect(float left, float top, float right, float bottom, Paint paint)

- 둥근 모서리의 사각형 그리기
> void drawRoundRect(RectF rect, float rx, float ry, Paint paint)

- 원 그리기
> void drawCircle(float cx, float cy, float radius, Paint paint)

- 타원 그리기
> void drawOval(RectF oval, Paint paint)

- 아크 그리기
> void drawArc(RectF oval, float startAngle, float sweepAngle, Boolean useCenter, Paint paint)

- 패스 그리기
> void drawPath(Path path, Paint paint)

- 비트맵 그리기
> void drawBitmap(Bitmap bitmap, float left, float top, Paint paint)


#### 그리기 객체로 만들어 그리기
- 리소스 파일의 사용
  + 프로젝트 리소스에 이미지와 같은 파일을 포함시킨 후 읽어 들여 사용함
- XML로 정의하여 사용
  + 그리기 객체의 속성을 정의한 XML 파일을 정의하여 사용함
- 자바 코드에서 객체를 만들어 사용
  + 자바 코드에서 new 연산자를 이용하여 그리기 객체를 만든 후 사용함
  + 비트맵 이미지를 주어진 좌표값에 그림

--------
#### Want to more know
