# 선택위젯의 사용과 커스텀뷰 만들기

## [54강] 나인패치
##### 커스텀 뷰
  레이아웃, 버튼등을 상속해서 만드는 것 -> 보여지는 것, 동작 변경 가능  

##### 나인패치(Nine Patch) 이미지
+ 사용이유
  1. 위젯의 background에 적용되어 자동으로 위젯의 사이즈에 맞게 resize
  2. 이때 늘어나는 이미지의 왜곡되는 부분을 줄이고자 등장
+ 사용방법
  1. 한 픽셀씩 더 크게 만들어놓고, 가장자리에 흰색, 검정색으로 표시
    - 흰색: 늘어나지 않는 공간
    - 검정색: 늘어날 수 있는 공간
  2. 파일명: xxx.9.png지정
    - 가장자리에 있는 한 픽셀이 어떻게 늘어나야 하는지에 대한 정보를 알 수 있음

## [55강] 비트맵 버튼 만들기
selector 사용하여 버튼 만들기
###### selector xml 만들기
  + 생성: res > drawable > 우클릭 > new > drawable resource file > name: xxx_selector.xml
  + 특징
    - 어떤 이미지를 어떤 상태에 따라서 띄워주어야 하는지에 대한 정보를 가지고 있음
    - 버튼의 background에 이미지가 아닌 xml도 들어갈 수 있음 (이미지처럼 사용가능)
    - 해당 xml에는 눌리지 않았을 때와 눌렸을때에 대한 item을 지정해야함

> **Another_Method**  
> 버튼 상속해서 만들어, onTouchEvent 재정의해서 이벤트 처리를 통하여 background image를 바꿀수도 있음

---
###### arrow_left_selector.xml
~~~html
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- 버튼이 눌린 상태가 되었을때, 이미지를 바꾼다. -->
    <item
        android:state_pressed="true"
        android:drawable="@drawable/arrow_left_clicked" />

    <!--아무런 상태가 아닐때-->
    <item
        android:drawable="@drawable/arrow_left_normal" />
</selector>
~~~

>**알게된 점:**
  1. 아래의 item코드가 없으면 버튼에 해당되는 구역을 누르지 않았을때, 아무런 이미지도 뜨지 않는다.
  2. state_pressed="true"가 들어있는 item이 어떠한 state도 지정하지 않은 item의 아래에 들어갈 경우, press되었을때 아무런 동작도 하지 않음
  3. state_pressed="false"를 추가한 item을 위로 가져갔을때는 정상적으로 동작함
  - 결론: true가 위에 있을경우, 아래에 state_pressed속성을 넣지 않아도, if_else문과 같은 효과를 볼 수 있음


## [56강] 버튼만들기 실습
버튼을 상속하여 버튼만들기
뷰는 항상 두개의 생성자를 사용함

~~~
public BitmapButton(Context context) {
        super(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
~~~
