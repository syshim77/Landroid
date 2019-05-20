# Day 17

#### Usage of Spinner
1. Demo

#### Usage of List View
1. Demo

#### Usage of Gallery & Grid View
1. Gallery
  - 레이아웃 만들기
    + 갤러리는 사진을 나열해서 볼 수 있도록 하는 간단한 위젯
    + 롤리팝 버전에서는 뷰페이저 사용을 권장하나 갤러리만의 특성이 있음
    + 갤러리는 Gallery 태그를 이용해 XML 레이아웃에 추가할 수 있음
  - 메인 액티비티 코드 만들기
    + 앨범에 있는 사진을 갤러리로 보여주기 위해 내용 제공자 사용
  ```
  1) 앨범 사진들에 대한 썸네일 이미지를 쿼리하여 Cursor 객체로 받음
  2) 갤러리 객체에 ImageAdapter 객체 설정
  3) 갤러리의 아이템을 클릭했을 떄의 리스너 설정
  4) 앨범에 있는 원본 이미지를 쿼리하여 Cursor 객체로 받음
  5) 이미지를 보기 위한 액티비티 띄우기
  6) ImageAdapter 클래스 정의
  7) 어댑터에서 리턴할 전체 아이템의 개수는 썸네일 이미지의 개수로 함
  8) 아이템으로 보일 뷰 객체를 리턴하는 getView() 메소드 정의
  9) 썸네일 이미지를 이미지뷰에 설정
  ```
2. Grid View
  - Demo

#### Cannot Understand
