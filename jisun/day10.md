# LandVibe Android Study week3
###### day10
## **프래그먼트**
> 화면의 일정 영역을 독립적으로 처리하기 위해 만들어진 특별한 화면 구성 요소  
> 태블릿의 대화면에서 화면 분할이 필요하게 되면서 만들어짐  
> + 화면 전환 - 두개의 화면을 액티비티로 만들고 액티비티 간 전환  
> + 화면 분할 - 하나의 액티비티 위에 프래그먼트를 두고 프래그먼트 간 전환

```java
//SubLayout.java

public class SubLayout extends LinearLayout {
  //생성자
  public SubLayout (Context context) {
    super(context);
    init(context);
  }
  public SubLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }
  private void init(Context context) {
    LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.sub_layout, this, true);
  }
}
```
```java
//MainActivity.java

public void onButtonClicked(view v) {
  SubLayouy layout1 = new SubLayout(this);
  LinearLayout contaier = (LinearLayout) findViewById(R.id.container);
  container.addView(layout1);
}
```

#### 싱글 프래그먼트
+ 하나의 액티비티 안에 하나의 프래그먼트가 들어가 있는 형태  
+ 하나의 액티비티 안에서 프래그먼트를 교체하거나 하기 좋음

#### 프래그먼트 전환
+ 프래그먼트 매니저와 트랜젝션을 이용해 추가나 제거 가능
+ 한번에 교체도 가능

#### 프래그먼트 처리 순서
1. 프래그먼트 매니저 객체 참조 : getFragmentManager()
2. 트랜젝션 시작 : beginTransaction()
3. 프래그먼트의 추가, 삭제, 교체
4. 트랜젝션 커밋(commit)

*FragmentManager Class*
```java
//프래그먼트를 변경하기 위한 트랜젝션을 시작
public abstract FragmentTransaction beginTransaction()
//ID를 이용해 프래그먼트 객체를 찾음
public abstract Fragment findFragmentById(int id)
//태그 정보를 이용해 프래그먼트 객체를 찾음
public abstract Fragment findFragmentByTag(String tag)
//트랜젝션은 commit() 메소드를 호출하면 실행되지만 비동기방식으로 실행되므로
//즉시 실행하고 싶다면 이 메소드를 추가로 호출해야함
public abstract boolean executePendingTransactions()
```
```java
//MenuFragment.java

package org.androidtown.myfragment;
import android.support.v4.app.Fragment;

public class MenuFragment extends Fragment {
  public MenuFragment() { }

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable) {
    View rootview = inflater.inflate(R.layout.fragment_menu, container, false);
    return rootView;
  }
}
```
```java
//MainActivity.java

public class MainActivity extends ActionBarActivity {
  PlaceholderFragment fragment1;
  MenuFragnemt fragment2;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fragment1 = new PlaceholderFragment();
    fragment2 = new MenuFragment();

    if(savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
    }
  }

  public void onButton1Clicked(View v) {
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction().replace(R.id.container, fragment2).commit();
  }
}
```
