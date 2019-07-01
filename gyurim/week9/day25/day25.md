## LandVibe Android Study Summary
[Lecture](https://www.inflearn.com/course/do-it-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%B1-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C-2/) 85강 - 86강
## Day 25

#### AsyncTask

##### AsyncTask 사용하기
- 백그라운드 작업을 좀 더 쉽고 간단하게 하고 싶다면 AsyncTask 클래스를 사용할 수 있음
- AsyncTask 객체를 만들고 execute() 메소드를 실행하면 이 객체는 정의된 백그라운드 작업을 수행하고 필요한 경우에 그 결과를 메인 스레드에서 실행하므로 UI 객체에 접근하는데 문제가 없게 됨

##### AsyncTask의 주요 메소드
- doInBackground
  + 새로 만든 스레드에서 백그라운드 작업 수행
  + execute() 메소드를 호출할 때 사용된 파라미터를 배열로 전달받음

- onPreExecute
  + 백그라운드 작업 수행 전 호출
  + 메인 스레드에서 실행되며 초기화 작업에 사용

- onProgressUpdate
  + 백그라운드 작업 진행 상태를 표시하기 위해 호출
  + 작업 수행 중간 중간에 UI 객체에 접근하는 경우 사용
  + 이 메소드가 호출되도록 하려면 백그라운드 작업 중간에 publishProgress() 메소드를 호출

- onPostExecute
  + 백그라운드 작업이 끝난 후 호출
  + 메인 스레드에서 실행되며 메모리 리소스를 해제하는 등의 작업에 사용
  + 백그라운드 작업의 결과는 Result 타입의 파라미터로 전달

##### Asyn 메소드 사용하기
+ AsyncTask 객체의 cancel() 메소드
  - 작업을 취소함
  - 이 메소드를 통해 작업을 취소했을 경우에는 onCancelled() 메소드가 호출됨

+ AsyncTask 객체의 getStatus() 메소드
  - 작업의 진행 상황을 확인함
  - 메소드를 호출했을 때 리턴되는 AsyncTask.Status 객체는 상태를 표현함
  - 각각의 상태는 PENDING, RUNNING, FINISHED로 구분됨

+ PENDING : 작업이 아직 시작되지 않았다는 것을 의미함
+ RUNNING : 실행 중임을 의미함
+ FINISHED : 종료되었음을 의미함

--------
#### Want to more know
