## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 91강 - 93강
## Day 27

#### 트윈 애니메이션

##### Tweened Animation
+ Tweened Animation
  - 뷰 애니메이션이라고도 하며, 보여줄 대상을 적절하게 연산한 후, 그 결과를 연속적으로 디스플레이하는 방식임
  - 애니메이션 대상과 변환 방식을 지정하면 애니메이션 효과를 낼 수 있도록 만들어 줌
  - 따라서 프레임 애니메이션처럼 변경하면서 보여줄 각각의 이미지를 추가할 필요 없이 대상만 지정하면 시스템이 내부적으로 적절하게 연산하는 과정을 거치게 됨

+ 트윈 애니메이션을 위한 액션 정보
  - XML 리소스로 정의하거나 자바 코드에서 직접 객체로 만듦
  - 애니메이션을 위한 XML 파일은 [/res/anim] 폴더의 밑에 두어야 하며 확장자를 xml로 함
  - 리소스로 포함된 애니메이션 액션 정의는 다른 리소스와 마찬가지로 빌드할 때 컴파일되어 설치 파일에 포함됨

##### 트윈 애니메이션 대상과 애니메이션 효과
* 대상
  + 뷰
    - View는 위젯이나 레이아웃을 모두 포함
    - ex) 텍스트뷰나 linear layout에 애니메이션 적용 가능

  + 그리기 객체
    - 다양한 Drawable에 애니메이션을 적용할 수 있음
    - ShapeDrawable은 캔버스에 그릴 도형을 지정할 수 있음
    - BitmapDrawable은 비트맵 이미지를 지정할 수 있음

* 효과
  + 위치 이동
    - Translate로 정의되는 액션은 대상의 위치를 이동하기 위해 사용되는 효과
  + 확대 / 축소
    - Scale로 정의되는 액션은 대상의 크기를 크게 하거나 작게 하기 위해 사용되는 효과
  + 회전
    - Route로 정의되는 액션은 대상을 회전하기 위해 사용되는 효과
  + 투명도
    - Alpha로 정의되는 액션은 대상의 투명도를 조절하는데 사용되는 효과

##### 애니메이션 <scale> 태그 사용
- startOffset
  + 시작할 시간을 지정하는 것
  + 애니메이션이 시작한 지 얼마 후에 이 액션이 수행될 것인지를 알 수 있도록 함
- duration
  + 애니메이션이 지속되는 시간으로 여기에서는 2.5초 동안 지속되도록 되어 있음
- <scale> 태그
  + 대상을 확대하거나 축소하는데 사용
  + 크기를 변경하기 위한 축의 정보는 X축과 Y축에 대하여 각각 pivotX와 pivotY로 지정됨
- fromXScale과 fromYScale
  + 시작할 때의 확대/ 축소 비율
- toXScale과 toYSclae
  + 끝날 때의 확대/축소 비율

##### 트윈 애니메이션 - 회전 액션
+ 회전은 한 점을 중심으로 대상을 회전시키는 효과를 만드는 액션으로써 시작 각도와 종료 각도를 지정할 수 있음
+ 한 바퀴 회전시키려 한다면 fromDegrees 속성의 값을 0으로 하고 toDegrees 속성의 값을 360으로 함
+ 시계 반대 방향으로 회전시키고 싶을 경우에는 toDegrees 속성의 값을 -360으로 함. 회전의 중심이 되는 점은 디폴트 값이 (0, 0)이므로 대상의 왼쪽 상단 끝 지점이 됨.
+ 대상의 중앙 부분을 회전의 중심으로 만들고 싶다면 pivotX와 pivotY 속성의 값을 지정함
+ 값의 단위는 좌표 값 또는 %을 사용할 수 있음
+ duration 속성의 값이 10000으로 설정되어 있으므로 10초 동안 애니메이션이 진행된 후 원래대로 돌아오게 됨

##### 트윈 애니메이션 - 투명도 액션
+ 투명도를 결정하는 알파 값도 뷰나 그리기 객체의 투명도를 점차적으로 바꿀 수 있는 애니메이션 액션으로 정의
+ 알파 값을 이용한 투명도 변환은 대상을 천천히 보이게 하거나 보이지 않게 하고 싶을 때 또는 하나의 뷰 위에 다른 뷰를 겹쳐 보이게 할 경우에 사용됨
+ 알파 값의 범위는 0.0부터 1.0까지이며 0.0은 알파 값이 0일 때와 마찬가지이므로 완전히 투명한 상태(뷰나 그리기 객체가 보이지 않음)이며 1.0은 알파 값이 1일 때와 마찬가지이므로 완전히 보이는 상태임

##### 트윈 애니메이션 - 인터폴레이터
+ accelerate_interpolator
  - 애니메이션 효과를 점점 빠르게 나타나도록 만듦
+ decelerate_interpolator
  - 애니메이션 효과를 점점 느리게 나타나도록 만듦
+ accelerate_decelerate_interpolator
  - 애니메이션 효과를 점점 빠르다가 느리게 나타나도록 만듦
+ anticipate_interpolator
  - 애니메이션 효과를 시작 위치에서 조금 뒤로 당겼다가 시작하도록 만듦
+ overshoot_interpolator
  - 애니메이션 효과를 종료 위치에서 조금 지나쳤다가 종료되도록 만듦
+ anticipate_interpolator
  - 애니메이션 효과를 시작 위치에서 조금 뒤로 당겼다가 시작한 후 종료 위치에서 조금 지나쳤다가 종료되도록 만듦
+ bounce_interpolator
  - 애니메이션 효과를 종료 위치에서 튀도록 만듦

```
위치 이동 : <translate> -> TranslateAnimation
회전 : <rotate> -> RotateAnimation
확대/축소 : <scale> -> ScaleAnimation
투명도 : <alpha> -> AlphaAnimation
애니메이션 집합 : <set> -> AnimationSet
```

#### 그래프 애니메이션 만들기
+ 그래프
  - 안드로이드에서도 그래프 형태로 결과를 보여주는 앱이 많이 있는데, 그래프의 형태 중에 가장 단순한 것은 progressBar를 이용해 간단한 통계 수치를 막대 형태로 보여주는 것임
+ 그래프를 보여주는 Activity를 새로 만들고 싶은 경우
  - 이 Activity를 위한 XML 레이아웃에 여러 개의 progressBar를 정의해 둔 후 화면에 표시하거나 자바 코드에서 필요한 개수만큼 동적으로 생성하여 레이아웃에 추가하는 방법을 사용할 수 있음
+ 그래프 라이브러리 사용
  - 꺾은선 그래프, 막대 그래프 등을 사용하려면 라이브러리들을 사용할 수 있음
--------
#### Want to more know