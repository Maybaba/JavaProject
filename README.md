# ### SeSeSe Bank ### ###
<br></div>

<div align ="right"><b>7조 김은지 임제훈 김한솔 박진우 신윤종</b></div>


---
## 목차
- 프로젝트 개요
- 팀원 소개
- 기술 스택
- 프로젝트 소개
- 트러블 슈팅
- 개발 일정
- 예시 화면
- 업데이트 예정

## 프로젝트 개요
<div align ="center">
  
<img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/12e438a8-b9e9-45d4-ba90-10ff856692aa" alt="bank">

</div>
제테크와 같은 금융 서비스의 성장은 디지털화된 금융 서비스에 대한 수요 증가와 관련이 있습니다.<br>은행 서비스를 개발하는 프로젝트는 이러한 금융 서비스의
디지털화를 지원하고 사용자에게 편리한 금융 서비스를 제공하는 데 도움이 될 것으로 예상됩니다.<br><br>
기존의 은행 서비스에는 많은 기능들이 있지만 보다 많은 기능으로 복잡해진 시스템에 불편이 있는 사용자를 위해 간소화 되었으며 사용자의 가입을 받고<br>
은행의 주된 기능인 예적금, 입출금 계좌개설 기능을 보다 효율적이고 정확한 전달을 할 수있는 시스템을 만드는 것을 목표로 진행되었습니다.<br><br><br>



## 팀원 소개
|팀원|담당|깃허브|
|:---:|---|---|
|김은지(팀장)|BACK|https://github.com/eeungji|
|박진우|BACK|https://github.com/JinWooP98|
|김한솔|BACK|https://github.com/hansolkim9|
|임제훈|BACK|https://github.com/jehoonje|
|신윤종|BACK|https://github.com/Maybaba|

## 기술 스택
<div align ="center">
<img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/b584e417-3f78-45b6-8efb-417bd0d5fdb5" alt="java">
<img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/56a071ae-bc25-4adb-a204-d3df63184904" alt="git">
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fei6Ehe%2FbtrbQbiTB7X%2FPxE6GEx9XudbZ8A3kTRpj1%2Fimg.png" alt="git">

</div>

## 트러블 슈팅
### * 관리자 페이지 기능(은행 전체 계좌 잔액 및 은행 전체 회원 조회), PPT 제작 - 김은지 (팀장)
  1. 내 컴퓨터(local)에서 a파일을 수정함. 이후 github에 수정한 a파일의 내용을 push하려 했을 때 error: failed to push some refs to 에러 발생<br>
     ➟ 팀원이 b파일을 올려놓아, 나의 push가 제한되었다. 원격저장소의 b파일을 pull해서 내 로컬로 가져온다. 그리고 나서 add, commit, push 를 통해 나의 수정사항을 반영하여 해결
  2. 메뉴 번호 입력시 문자 제한 (숫자만 입력 가능하게 하는 문제)<br>
     ➟ NumberFormatException 을 통해 숫자 이외의 문자를 입력할 경우 “숫자를 입력해주세요” 메시지 출력


### * 회원가입, 로그인, 마이페이지 출력, 아이디 찾기, 비밀번호 변경, README 제작 - 박진우
  1. 로그인이나 회원가입시 조건에 맞지 않는 값을 입력했을 때 잘못 입력한 부분이 아닌 처음으로 돌아가는 현상<br>
      ➟ 입력받고 검증하는 부분에 while문을 만들어 조건이 맞을 경우만 빠져나가게 함
  
  2. 1번 문제를 해결하기 위해 각 입력 검증마다 while문을 만들어 중간에 그만두고 싶을 때 break를 하여도 로그인, 회원가입 메서드가 종료되지 않는 현상<br>
      ➟ 가장 바깥 while문에 라벨을 붙여 그 while문을 종료시킴

### * 계좌별 계좌 개설기능 (적금, 예금, 입출금), README  제작 - 임제훈
  1. input값 공백받을 시 뜨는 오류  
    ➟  trim().replace()를 활용해 입력된 공백을 삭제 
  2. Thread 딜레이 시간에 과도한 입력시 오류  
    ➟  try/catch 문을 활용하여 메세지 출력 
  3. 입출금 계좌를 생성하였으나 적금계좌 생성이 안됨 
    ➟  부모요소 필드에 static으로 되있는 속성과 생성자를 수정 
  4. 입금 금액을 int로 받아서 뜨는 오류  ➟  long으로 바꾸어 입력범위를 넓혀줌
     
### * 예적금 이자 및 추가납입 시스템, 다음날로 넘어감에 따른 이자 업데이트, 콘솔창 디자인 - 신윤종
  1. 계좌 타입을 순회하여 값에 접근하는 코드가 반복되어 동일한 패턴이 반복되는 코드<br>
     → 하나의 클래스에 반복되는 메서드를 모은 뒤 그 메서드에 접근하는 방식으로 구현<br>
     
  2. 한 기능을 담당하는 클래스에서 지정한 필드값을 user 간 독립적인 값을 설정하고, 그 값을 전역에서 접근하려 함(day count, 적금납입액)<br>
     → 싱글톤으로 접근 -> 하나의 인스턴스를 공유한다는 특징으로 콜백으로 접근 -> 메서드의 원하지 않는 부분까지 실행됨, 값을 제대로 접근할 수 없음 -> 결국 user 객체 필드에 독립적인 값을 가진 필드 생성<br>

  3. 다음날 넘어가는 로직에서, 다음날로 넘어갈 때 day count 변수 하나로 아직 다음날인지 아닌지 확인 어려움<br>
     → nextday라는 변수를 만들고 그 변수 값에 따른 Boolean 메서드 활용하여 다음날과 현재 구분 기능 구현<br>



### * 입출금 계좌 입출금 기능, PPT 제작 - 김한솔
  1. 출금 금액이 계좌 잔액보다도 높은데 출금이 되는 오류
     → continue 명령어를 이용해 넘겨 줌으로 써 해결함
  





   
## 개발 일정
- 2024.04.26 ~ 2024.05.03


  
## 프로젝트 소개

<div align="center">
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/bd7948b2-1424-4a0e-a5fb-b7ba2fb29823" alt="예시 화면">
      <h2>ID, PASSWORD, 이름, 회원정보 찾기위한 힌트 입력으로 회원가입을 합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/2e5cafda-0665-4b90-a041-020eb6114718" alt="로고인">
      <h2>로그인을 통해 메인메뉴로 접속합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/223fabe3-d228-41fb-919b-a5f63723675c" alt="아이디:비밀번호 창기">
      <h2>사용자가 아이디를 찾고 비밀번호를 찾아 변경할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/b4127ca6-2634-496d-8b7c-a1c08f4ee778" alt="계좌개설">
      <h2>입출금 계좌가 없을 시 입출금, 예적금계좌 생성이 제한됩니다.<br>사용자는 입출금계좌를 생성할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/8f117428-bde2-49b5-af16-2d55f8bd74df" alt="계좌개설2">
      <h2>사용자는 예금, 적금 상품에 가입할 수 있습니다..</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/f621eeed-eb7f-4dae-9df6-76098eff3aef" alt="예측금시스템1">
      <h2>사용자의 예금및 적금 현황을 확인할 수있습니다. 적금에는 추가입금이 가능합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/14baa760-df25-4142-8c58-8de8ea473e20" alt="예측금시스템2">
      <h2>예적금의 유동사항을 구현하기 위해 날짜기능을 추가했습니다.<br>다음날로 넘어가면 이율이 붙는 것을 확인 할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/222de2fc-a728-443a-ae17-19b50497c996" alt="입출금시스템">
      <h2>사용자가 입출금 계좌에 돈을 입금하거나 출금 할 수 있습니다.<br>잔액이 출금 요청보다 작을 경우 출금이 거부됩니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/4fa1fe82-a845-4585-a3d8-d47993873f35" alt="마이페이지">
      <h2>해당 사용자가 소유한 모든 계좌의 상태를 확인합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/a535fa37-a23c-4fa0-b42d-4b9ce2fc23f6" alt="관리자페이지">
      <h2>은행의 총잔고, 가입된 회원 조회기능을 관리자가 사용할 수 있는 시스템입니다. </h2><br>
</div>



## 업데이트 예정
1. 주식 시스템
   - 입출금 통장을 통해 주식 구매, 판매
   - 하루가 지날때 마다 주식 종목의 가격 랜덤 변동

2. 환전 시스템
   - 입출금 통장을 통해 환전
   - 매일 각 나라의 환률을 가져와 환류에 맞게 환전
  
3. 예적금 상품
   - 보다 다양한 상품을 만들어 사용자 선택의 폭을 넓히기
   - 계좌가 해지되었을 때 다시 개설이 가능하도록 구현
  
4. 로그인 시스템
   - 회원가입시 입력받을 정보들의 조건을 강화
   - 비밀번호 변경 시 이전에 사용하던 비밀번호 사용 막기

5. 예적금 시스템
   - 다양한 예적금 상품 개발
   - 계좌 (중도)해지 기능 개발
  
6. 입출금 시스템
   - 계좌 간 이체 기능 추가
   - 매월 특정 일자에 자동 이체 기능 추가

