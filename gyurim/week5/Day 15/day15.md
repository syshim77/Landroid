## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 54강 - 56강
## Day 15

### 선택위젯의 사용과 커스텀뷰 만들기

#### 나인패치 이미지
* 나인패치 이미지란?
  - 이미지가 늘어나거나 줄어들 때 생기는 이미지 왜곡을 해결하는 방법을 정의한 것
  - 서로 다른 해상도를 가진 여러 단말에 dp 단위로 뷰의 크기를 맞추다 보면 이미지 크기가 자동 조절되면서 왜곡되는 현상 발생 -> 나인패치 이미지로 해결


#### 비트맵 버튼 만들기
* 비트맵 버튼을 직접 만들어 normal일 경우와 clicked일 경우의 이미지를 표시
  * 단점 : 나인패치 이미지를 적용하는 대표적인 경우가 바로 버튼인데 이렇게 배경부분을 이미지로 지정하여 만든 버튼은 눌러도 이미지의 변화가 없어 사용자가 버튼을 눌렀는지 안 눌렀는지 알 수 없다.
  * 비트맵 이미지를 이용해 버튼의 상태를 표시하려면 버튼이 눌렸을 때와 떼어졌을 때를 이벤트로 구분하여 처리함.


--------
#### Want to more know
