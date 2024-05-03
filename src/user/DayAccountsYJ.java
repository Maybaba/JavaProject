package user;
//TODO : 1. 다음날 넘김에 따른 이전날 / 다음날 개별 카운트 진행  2. 이전날 equals 다음날 boolean 값에 따른 예적금 계좌 이율 계산

/**
 * 1. 다음날로 넘어가기 누르면 movetonextday 함수 호출됨
 * 1-1. pre 에 현재 dayacc 호출
 * 1-2. 그리고 addaccount 함수도 호출
 * 다음날로 넘어가는 버튼을 누를때마다 int 값이 누적됨
 * static으로 설정하여서 전역에서 참조 및 접근 가능
 */
class DayAccountsYJ {
    //field
    static int dayCount; //실제 지난 날 카운트
    static int nextDay; // CHECKNEXTDAY가 계속 0으로 초기화 되어야 함
    static int nextDaya; // CHECKNEXTDAY가 계속 0으로 초기화 되어야 함



    // 현재 날짜를 이전 날짜로 업데이트하고 현재 날짜를 새로운 날짜로 설정
    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    static void moveToNextDay() {
        addDayAccount();
        nextDay++;
        nextDaya++;
    }

    //하루 지날때마다 dayAccuont에 +1 추가
   private static void addDayAccount() {
       dayCount ++;
    }

    // 다음날로 넘어갔는지 확인하는 메서드
    static boolean checkNextDay() {
        if (nextDay == 0) {
            if(dayCount > 0) {

            } return false; // 첫 호출일 때는 다음날로 넘어가지 않은 것으로 간주
        } else {
            nextDay = 0; //이미 1인 값을 0으로 초기화
            // System.out.println("실험 로그 : 하루 재 초기화 됨.");
            return true; // 이미 다음날로 넘어간 상태
        }
    }
    static boolean checkNextDay2() {
        if (nextDaya == 0) {
            if(dayCount > 0) {
            } return false; // 첫 호출일 때는 다음날로 넘어가지 않은 것으로 간주
        } else {
            nextDaya = 0; //이미 1인 값을 0으로 초기화
            //System.out.println("실험 로그 : 하루가 초기화되었습니다.");
            return true; // 이미 다음날로 넘어간 상태
        }
    }


    // 하루를 초기화하는 메서드
    static void resetDay() {
        nextDay = 0;
        dayCount = 0;
    }

    public static int getDayAccount() {
        return dayCount;
    }



    @Override
    public String toString() {
        return "DayAccountsYJ{" +
                "dayAccount=" + dayCount +
                '}';
    }
}
