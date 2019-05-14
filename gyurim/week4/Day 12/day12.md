## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 44강 - 46강
## Day 12

### 다양한 위젯과 이벤트 활용

#### 1. 웹 브라우저 사용하기
* 애니메이션 사용 방식
  * 전형적인 애니메이션 사용 방식은 애니메이션 액션 정보를 xml로 정의한 후 사용
  * Animation 객체로 만든 후 뷰의 startAnimation() 메소드를 사용하면 간단하게 애니메이션 동작
  * Twin animation :이동, 투명도조절, 확대, 축소 하는 animation
  * 만드는 방법
    1. res 폴더 안에 anim이라는 폴더를 만들어 애니메이션을 위한 action정보를 넣는다.
    2. java 소스에서 action정보가 들어있는 xml 파일을 로딩해, animation 객체를 만든다.
    3. 이걸 가지고 start animation하면 view 객체를 움직일 수 있다.

--------
#### Want to more know
1. Myanim 로딩 안됨
