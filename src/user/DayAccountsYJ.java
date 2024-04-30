package user;
//TODO : 1. 다음날 넘김에 따른 카운트 진행  2. 이전날 = 다음날 boolean >> 계좌 이율 계산

/**
 * 1. 다음날로 넘어가기 누르면 movetonextday 함수 호출됨
 * 1-1. pre 에 현재 dayacc 호출
 * 1-2. 그리고 addaccount 함수도 호출
 * 결과 : 넘어가기 전의 int는 pre 에 저장, 넘어가는 함수 호출하면서 dayaccount 만 ++ 업데이트되고
 * 다음날로 넘어가는 버튼을 누를때마다 그 int 값이 누적됨
 * static으로 설정하여서 전역에서 참조 및 접근 가능
 */
public class DayAccountsYJ {
    //field
    static int dayAccount;
    static int previousDayAccount;

    // 현재 날짜를 이전 날짜로 업데이트하고 현재 날짜를 새로운 날짜로 설정
    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    static void moveToNextDay() {
        previousDayAccount = dayAccount;
        addDayAccount();
    }

    //하루 지날때마다 dayAccuont에 +1 추가

   private static void addDayAccount() {
        dayAccount ++;
    }

    //int 값이 다른지 여부로 참, 거짓으로 여부 확인
    public static boolean flagNextDay() {
        if(dayAccount == previousDayAccount) return false; //다음날로 넘어가지 않았음 , 초기 0일 째일때는 false 반환하도록 설정
        else return dayAccount > previousDayAccount;
    }

    public static void setDayAccount(int dayAccount) {
        DayAccountsYJ.dayAccount = dayAccount;
    }

    public static void setPreviousDayAccount(int previousDayAccount) {
        DayAccountsYJ.dayAccount = previousDayAccount;
    }

    public static int getDayAccount() {
        return dayAccount;
    }

    public static int getPreviousDayAccount() {
        return previousDayAccount;
    }

    @Override
    public String toString() {
        return "DayAccountsYJ{" +
                "dayAccount=" + dayAccount +
                ", previousDayAccount=" + previousDayAccount +
                '}';
    }
}
