package user;
//TODO : 1. 다음날 넘김에 따른 이전날 / 다음날 개별 카운트 진행  2. 이전날 equals 다음날 boolean 값에 따른 예적금 계좌 이율 계산

/**
 * 1. 다음날로 넘어가기 누르면 movetonextday 함수 호출됨
 * 1-1. pre 에 현재 dayacc 호출
 * 1-2. 그리고 addaccount 함수도 호출
 * 결과 : 넘어가기 전의 int는 pre 에 저장, 넘어가는 함수 호출하면서 dayaccount 만 ++ 업데이트되고
 * 다음날로 넘어가는 버튼을 누를때마다 그 int 값이 누적됨
 * static으로 설정하여서 전역에서 참조 및 접근 가능
 */
class DayAccountsYJ {
    //field
    static int dayCount;
    static int previousDayCount;
    //하루가 지났는지 확인 및 초기화 필드
    static int nextDay; // CHECKNEXTDAY가 계속 0으로 초기화 되어야 함

    // 현재 날짜를 이전 날짜로 업데이트하고 현재 날짜를 새로운 날짜로 설정
    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    static void moveToNextDay() {
        previousDayCount = dayCount;
        addDayAccount();
    }

    //하루 지날때마다 dayAccuont에 +1 추가
   private static void addDayAccount() {
       dayCount ++;
    }

    //int 값이 다른지 여부로 참, 거짓으로 여부 확인
    public static boolean flagNextDay() {
        if(dayCount == previousDayCount) return false; //다음날로 넘어가지 않았음 , 초기 0일 째일때는 false 반환하도록 설정
        else return dayCount > previousDayCount;
    }
//    // 하루가 지났는지 확인하고 코드 실행하는 메서드
//    static void executeCodeIfDayChanged() {
//        if (checkNextDay()) {
//            System.out.println("하루가 지났습니다.");
//        } else {
//            System.out.println("하루가 아직 지나지 않았습니다.");
//        }
//    }

    // 다음날로 넘어갔는지 확인하는 메서드
    static boolean checkNextDay() {
        if (nextDay == 0) {
            if(dayCount > 0) {
                nextDay++;
            } return false; // 첫 호출일 때는 다음날로 넘어가지 않은 것으로 간주
        } else {
            nextDay = 0; //이미 1인 값을 0으로 초기화
            System.out.println("실험 로그 : 하루가 초기화되었습니다.");
            return true; // 이미 다음날로 넘어간 상태
        }
    }

    // 하루를 초기화하는 메서드
    static void resetDay() {
        nextDay = 0;
        System.out.println("실험 로그 : 하루가 초기화되었습니다.");
    }


    public static void setDayAccount(int dayAccount) {
        DayAccountsYJ.dayCount = dayAccount;
    }

    public static void setPreviousDayAccount(int previousDayAccount) {
        DayAccountsYJ.dayCount = previousDayAccount;
    }

    public static int getDayAccount() {
        return dayCount;
    }

    public static int getPreviousDayAccount() {
        return previousDayCount;
    }

    @Override
    public String toString() {
        return "DayAccountsYJ{" +
                "dayAccount=" + dayCount +
                ", previousDayAccount=" + previousDayCount +
                '}';
    }
}
