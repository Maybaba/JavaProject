<div align ="center"><br>SeSeSe Bank</div>

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

## 팀원 소개
|팀원|담당|깃허브|
|:---:|---|---|
|김은지(팀장)|BACK|https://github.com/eeungji|
|박진우|BACK|https://github.com/JinWooP98|
|김한솔|BACK|https://github.com/hansolkim9|
|임제훈|BACK|https://github.com/jehoonje|
|신윤종|BACK|https://github.com/Maybaba|

## 기술 스택
JAVA - INTELLI J
## 프로젝트 소개

## 트러블 슈팅
### * 적금, 예금, 입출금 계좌개설 및 입금 - 임제훈
  1. input값 공백받을 시 뜨는 오류  
    ➟  trim().replace()를 활용해 입력된 공백을 삭제 
  2. Thread 딜레이 시간에 과도한 입력시 오류  
    ➟  try/catch 문을 활용하여 메세지 출력 
  3. 입출금 계좌를 생성하였으나 적금계좌 생성이 안됨 
    ➟  부모요소 필드에 static으로 되있는 속성과 생성자를 수정 
  4. 입금 금액을 int로 받아서 뜨는 오류  ➟  long으로 바꾸어 입력범위를 넓혀줌

### * 회원가입,로그인,마이페이지,아이디&비밀번호 찾기 - 박진우
  1. 로그인이나 회원가입시 조건에 맞지 않는 값을 입력했을 때 잘못 입력한 부분이 아닌 처음으로 돌아가는 현상<br>
      ➟ 입력받고 검증하는 부분에 while문을 만들어 조건이 맞을 경우만 빠져나가게 함
  
  2. 1번 문제를 해결하기 위해 각 입력 검증마다 while문을 만들어 중간에 그만두고 싶을 때 break를 하여도 로그인, 회원가입 메서드가 종료되지 않는 현상<br>
      ➟ 가장 바깥 while문에 라벨을 붙여 그 while문을 종료시킴
     
### * 예적금 이자 및 추가납입 시스템, 다음날로 넘어감에 따른 이자 업데이트, 콘솔창 디자인 - 신윤종
  1. 반복문을 돌려서 계좌 타입을 얻는 로직을 반복해서 사용하지 않고 해당 로직의 클래스를 만들어 메서드로 계좌별 잔액 누적 및 불러오는데 누적이 안되는 문제<br>
     → 새로운 클래스에서 변수를 선언하고 그 값에 저장이 되기 때문에 반복문을 메서드 안에서 직접 실행하는 것과 클래스 메서드를 통해 얻는 값이 다름<br>
     → 해당 값을 불러오고, 저장하는 메서드를 따로 만들어서 이자가 쌓일 때마다 메서드를 실행해서 해결
     
  2. 다른 user로 로그인하면 이전에 로그인했던 user account balance 가 불러와지는 문제<br>
     → 이율을 계산하는 메서드 별 최신 금액 업데이트 메서드를 불러오지 않아서 잔액최신업데이트가 되지 않았음<br>
     → 업데이트하는 메서드를 이율 메서드에 추가함으로서 해결함

### * 입출금 기능, ppt 작성 - 김한솔
     → 없음.

   
## 개발 일정
- 2024.04.25 ~ 2024.05.07
  
## 예시 화면

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

