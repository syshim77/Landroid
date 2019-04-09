# LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 1강 - 7강
## Day 1

### 안드로이드에 대한 이해
1. 정전 방식 터치 패널 구조 (만지는 터치 패널)
  - 동작 원리 : 화면을 누르면 손가락을 통해 전달되는 우리 몸의 정전기를 감지
  - 장점 : 부드러운 터치 입력 가능, 멀티 터치 가능, 화질 저하 없음, 터치 패널의 내구성이 좋음
  - 단점 : 스타일러스 펜 이용 불가(전기가 통하지 않는 물질은 터치가 불가능)
2. 구글의 안드로이드 - 오픈을 통해 스마트폰 대중화

### 안드로이드의 특징
- 오픈 소스
- 완벽한 컴포넌트
- 뛰어난 성능
- 무료
- 자바

### 안드로이드의 흐름
- 전체 스마트폰 시작에서 안드로이드 단말의 점유율 80% 이상 (2014년 2분기)
- 안드로이드 폰과 아이폰이 스마트폰 시장의 대부분을 점유하고 있음

## Day 2

### toast 메세지가 뜨도록 하는 코드
~~~Java
public void onButton1Clicked(View v) {
Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
}
~~~

### button의 action view 설정 (naver 모바일 화면으로 이동)
~~~Java
public void onButton2Clicked(View v) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
    startActivity(intent);
}
~~~

## Git 문법
- **ls** : 현재 디렉토리 안에 있는 것들을 다 보여줌 (list short : list는 나열)
- **cd dir_name** : change directory => 디렉토리로 들어감

- **cd ..** : 뒤로가기 (상위폴더로 감)

- **mkdir dir_name** : 디렉토리 생성

- **vi text_name.txt** : txt 파일 생성 (vi 는 편집상태로 들어가는 명령어)
  - 편집 상태로 들어간 뒤, **i** : insert의 약자로, 파일에 내용 추가

  -	다 쓴 뒤, esc 누르고 **:wq**  : 내용 저장 뒤, 나오는 것

- **Touch text_name.txt** : 파일만 생성

- **rm text_name.txt** : 파일 지우기

- **rmdir dir_name** : 디렉토리 지우기

- **git add dir_name**

- **git commit -m “내용”**

- **git pull**

#### Cannot Understand
