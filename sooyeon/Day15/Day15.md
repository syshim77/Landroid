# Usage of Selected Widget & Build Custom View

#### Nine Patch
1. 나인패치 이미지
  - 이미지가 늘어나거나 줄어들 때 생기는 이미지 왜곡을 해결하는 방법을 정의한 것
  - 서로 다른 해상도를 가진 여러 단말에 dp 단위로 뷰의 크기를 맞추다 보면 이미지 크기가 자동 조절되면서 왜곡되는 현상
    + 나인패치 이미지로 해결 가능
    + 최대한 깨지는 현상을 줄여보자
  - 가장 가장자리에 있는 이미지의 픽셀은 흰색 or 검은색
    + 검은색 부분은 늘어날 수 있음을 의미
    + .9가 어떻게 늘어나면 되는지를 알려주는 정보라고 생각
  - 나인패치 이미지를 만들 수 있는 tool 이용하거나 그림판 등을 통해서 만들 수 있음

#### Making Bitmap Button
1. 비트맵 버튼
  - 비트맵 이미지를 이용해 버튼의 상태를 표시하려면 버튼이 눌렸을 때와 떼어졌을 때를 이벤트로 구분하여 처리함
  - 직접 만들어 normal일 경우와 clicked일 경우의 이미지를 표시
2. Demo

#### Making Button Demo
1. Demo

#### Cannot Understand
