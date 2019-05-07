# 안드로이드 앱 프로그래밍 Day 5
레이아웃

## 15강
상대 레이아웃 (R)
- 상대적인 위치를 통해서 레이아웃을 배치하는 것
- 부모 레이아웃의 배치를 이용하여 배치하는 것
- 별도로 뷰의 위치를 지정하지 않으면 왼쪽 상단에 자리잡게된다.

화면에 xml: 별도의 화면 구성을 위해서 분리된 것이고, 실제 기능은 source가해준다.
xml에 버튼이 구현되어있으면 그 기능의 구현은 실제로 source에서 해주고, 실제 버튼을 위해서는 (메모리에 올라가서 실제 객체가 되는) 인플레이션으로 (자바에서는 new)해주고 find로 메모리에 올라간 버튼을 찾아주어야한다.

PlainTextView : 글자를 표시해주는
background : #ff - 알파값은 투명도, ff는 투명도를 전혀 주지 않겠다는 의미

xmlns: xml namespace - xml 하나에 하나씩만 필요하다.
모든 layout은 layout_width와 layout_height를 하나씩 가진다.
---
### 부모의 위/아래쪽에 갖다 붙여라
~~~java
// 위에 붙이기
//   <button
android:layout_alignParentBottom="true"
//   />

// 아래에 붙이기
//   <button
android:layout_alignParentTop="true"
//   />
~~~

#### 위쪽 버튼의 밑에서 아래쪽 버튼의 위까지 채우는 텍스트 뷰
~~~java
// <button1 />
<EditText
            android:id="@+id/editText5"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#ff0000ff"
            android:layout_below="@+id/button"// 위쪽 버튼의 아래부터 채운다.
            android:layout_above="@+id/button2"/>
// button2 />
~~~

*RelativeLayout의 장점이다. linearlayout은 누구 하나가 화면을 꽉 채우면 나머지는 안보이게 되기 떄문*
android:layout 을 치면 뒤에 쓸 수 있는 속성이 나온다.
android:layout_centerInParent="true"; 부모의 중앙에 배치해라
---
## 16강
id라는 것이 중요하다. id를 이용해서 인플레이션 과정을 거쳐서 메모리에 실제 매모리에 올라가고 MainActivity에서 찾아주고, 찾아준상태에서 이벤트 처리를 해야한다.
onClick을 넣는 것은 코드가 길어지지 않게 하기위해서 제공해주는

*OnClickListener의 내부 함수를 자동으로 생성할 수 있음*
마우스 우키 -> generate -> Implement Method -> onClick

새로운 프로젝트를 만들지 않고 MyRelativeLayout 프로젝트에서 만들어서 적용시키려고함.
그 방법은 java>res>layout

*R.layout.activity_main에서의 R은 res를 뜻하고, layout은 그 아래 폴더, activity_main은 xml을 뜻한다. activity_main을 화면에서 setContentView로 설정했기 때문에 해당 레이아웃을 적용한 것으로 프로젝트를 나타낸다.*

#### TableLayout
~~~java
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <TableRow
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView"
            android:layout_column="0"
             />

        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="New Button"
            android:layout_column="1"/>
    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

        <TextView
            android:id="@+id/textView3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView" />

        <Button
            android:id="@+id/button4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="New Button" />
    </TableRow>

</TableLayout>
~~~
- 버튼을 디자인 화면에 추가하기가 힘드므로 팔레트에서 Component Tree로 드래그해야 추가 가능/혹은/ 코드로 직접 작성 가능
- fill_parent와 match_parent는 같은 용어이다. fill_parent가 옛날 용어이긴 하지만 사용해도 별 지장은 없다. 현재 버전에서는 match_parent가 자동으로 나타난다.  

#### scrollview
글을 너무 많이 써서 화면을 넘어간다면 스크롤뷰로 감싸주기만 해도 스크롤 바가 자동으로 생성된다.
~~~java
####
// acvivity_main.xml
<ScrollView
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:layout_above="@+id/button2" // TextView가 가지던 속성
  android:layout_below="@+id/button"> // TextView가 가지던 속성

   <TextView
       android:id="@+id/TextView5"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       // above, below 속성이 있던 자리
       android:background="#ff0000ff"
       android:text="hello" />
</ScrollView>
~~~
스크롤 뷰가 텍스트 뷰를 감싸고 있기 떄문에 TextView가 가지던 above, below의 특징은 ScrollView가 가져가게 된다.
세로 스크롤이 기본이지만 가로 스크롤(HorizontalScrollView)도 할 수 있다.

#### 이미지를 보여줄때 (ImageView)
~~~java
<ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_column="1"

            // 아래 중요
            // 방법1 --> 강의
            android:src="@drawable/ic_launcher_foreground"
            // drawable이라는 폴더 아래의 기본으로 들어가있는 이미지를 설정 가능 // 이미지를 보여주는 속성

            // 방법2 --> 실습때 따라서 해보니 xml 디자인 파트에서 처음에 지정하지 않으면 안되길래 시도한 것
            app:srcCompat="@android:drawable/btn_dialog"
            // src라는 속성의 값으로 설정해줄 수 있다
/>
~~~
alt+enter하지 않아도 이미지 뷰를 가져오면 자동으로 팝업되는 화면의 project 영역에서 drawable 폴더의 사진을 선택하여 삽입할 수 있다.

#### 가시성 속성을 이용하여 이미지 뷰를 전환하는 효과
~~~java
package com.androidtown.myframelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 위에서 객체로 할당해주어야 onClick에서 사용가능
    ImageView imageView;
    ImageView imageView2;

    boolean selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 두개의 이미지 뷰 중에 하나만 보여주고 하나는 안 보여줄것이다.
        // 이미지 뷰를 찾아주어야한다. 이미지뷰는 레이아웃에 들어가는 것이고 소스에서 고치기 위해서는
        // 이미지 찾기
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);

        // 버튼 찾기
        Button button = (Button) findViewById(R.id.button);
        // 클릭시 이벤트 처리
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(selected) {
                    imageView.setVisibility(View.VISIBLE); // 보이게 된다.
                    imageView2.setVisibility(View.GONE); // 보이게 된다.
                } else{
                    imageView2.setVisibility(View.VISIBLE); // 보이게 된다.
                    imageView.setVisibility(View.GONE); // 보이게 된다.
                }

                selected = !selected; // 비트 반전을 사용해서 버튼이 누를때마다 selected 값이 변경
            }
        });

    }
}

~~~
활용하면 이미지가 아니라 레이아웃/화면등이 전환되는 효과를 보여줄수도 있다.

####visibility method
객체는 있으나 보이거나 자리를 차지하지 않는다. (레이아웃에 없는 상태로 만듬)
android:visibility="gone"

####




---
알아낸 것
alt + enter 로 연관 어구 사용 가능

더 알아보기
constraint ?? 어려워
// table layout에서
왜 드래그 하지 못하는가?-> constraint때문???!
왜 layout_column이 나오지 않는가 // 내가 직접 침
폰트를 바꿀 수 있는 typeface는 어디에..?
