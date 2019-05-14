## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 47강 - 49강
## Day 13

### 다양한 위젯과 이벤트 활용

#### 1. 페이지 슬라이딩 사용하기
* 뷰의 중첩과 애니메이션을 접목한 방식
  * 하나의 뷰 위에 다른 뷰를 올라가 있을 때 보이거나 보이지 않는 과정을 애니메이션으로 적용
  * 열기 : animation 객체 적용 왼쪽 방향으로 translate
  * 닫기 : animation 객체 적용 오른쪽 방향으로 translate

#### 2. 뷰플리퍼 사용하기
* 뷰페이저와 함께 하나의 화면에서 여러 개의 뷰가 전환되며 보이는 대표적인 위젯
* 뷰플리퍼와 같은 형태로 구현한 대표적인 화면이 바로 애플리케이션 런처 화면임
* 요즘은 뷰페이저 많이 사용


--------
#### Want to more know


--------
#### What I learned
1. (Relative layout에서) android:layout_alignParentStart="true" 대신, (Linear layout에서) android:layout_gravity="start"
