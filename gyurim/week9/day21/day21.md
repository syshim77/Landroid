## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 72강 - 74강
## Day 21

##### 선 그리기에 사용되는 속성
+ *setStrokeWidth* : Stroke의 폭을 설정함
+ *setStrokeCap* : Stroke의 시작과 끝 부분의 모양을 설정함. 설정할 수 있는 값은 Cap.BUTT, Cap.SQAURE이며, 디폴트 값은 Cap.BUTT임
+ *setStrokeJoin* : Stroke의 꼭짓점 부분에 사용되는 연결 모양을 설정함. 설정할 수 있는 값은 Join.MITER, Join.ROUND, Join.BEVEL이며, 디폴트 값은 Join.MITER임
+ *setStrokeMiter* : Stroke 폭의 절반에 대한 Miter 길이의 비율 제한을 설정함

#### 비트맵 이미지 사용하기

##### 더블 버퍼링
- 뷰 위에 그래픽을 그린 후 다시 그리기를 할 때 깜박임 현상 발생
-	좌표값을 이용해 그래픽을 그리는 시간을 줄이기 위해 메모리 상의 비트맵 객체에 미리 그린 후 비트맵 객체를 뷰에 그려주는 방식

##### BitmapFactory 클래스에 정의된 메소드들
- 파일에서 읽기
  + 파일 패스를 지정하면 해당 위치의 이미지 파일을 읽어옴
  > public static Bitmap decodeFile(String pathname)

- 리소스에서 읽기
  + 리소스에 저장한 이미지 파일을 읽어옴
  > public static Bitmap decodeResource(Resources res, int id)

- 바이트 배열에서 읽기
  + 바이트 배열로 되어 있는 이미지 파일을 읽어옴
  > public static Bitmap decodeByteArray(byte[] data, int offset, int length)

- 스트림에서 읽기
  + 입력 스트림에서 이미지 파일을 읽어옴
  > public static Bitmap decodeStream(InputStream is)

#### 페인트보드 만들기
- Bitmap
  + 외부가 아닌 이미지를 비트맵 객체로 만들 때 사용
- BitmapFactory
  + 외부의 이미지를 비트맵 객체로 만들 때 사용

--------
#### Want to more know
