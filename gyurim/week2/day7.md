## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 19강 - 25강
## Day 7

### Layout Inflation
###### Xml layout에 정의된 내용이 메모리에 객체화되는 과정
~~~java
	public void onButtonClicked(View v){
    LinearLayout container = (LinearLayout) findViewById(R.id.container); // container라고 하는 id 찾기

    //inflation 하는 법
    LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   // inflate() : sub_layout에 있는 내용을 메모리에 객체화해줌->container layout에다 붙이기
    inflater.inflate(R.layout.sub_layout, container, true);
}
~~~

###### 화면 내 부분화면의 버튼이 눌렸을때
~~~java
public void onButtonClicked(View v){
        LinearLayout container = (LinearLayout) findViewById(R.id.container); // container라고 하는 id 찾기

        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub_layout, container, true);

        Button button2 = (Button) container.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "부분화면의 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            }
        })
    }
~~~

### 화면 구성과 화면 간 이동
안드로이드 애플리케이션을 구성하는 4가지 요소 => 하나의 화면으로 구성
1. Activity
2. Service
3. Broadcast 수신자
4. 내용 제공자

#### Cannot Understand
