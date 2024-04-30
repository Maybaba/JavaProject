package user;
//TODO : 1. 다음날 넘김에 따른 카운트 진행  2. 이전날 = 다음날 boolean >> 계좌 이율 계산
public class DayAccountsYJ {
    //field
    static int dayAccount;
    static int previousDayAccount;

    // constructor
    public DayAccountsYJ() {
        dayAccount = 1; //시작일을 1로 초기화
        previousDayAccount = 0; //이전날이 없을 수도 있으므로 기본값 설정
    }

    //int 값이 다른지 여부로 참, 거짓으로 여부 확인
    public static boolean flagNextDay() {
        return dayAccount > previousDayAccount;
    }

    //하루 지날때마다 dayAccuont에 +1 추가
    static void addDayAccount() {
        dayAccount ++;
    }

    // 현재 날짜를 이전 날짜로 업데이트하고 현재 날짜를 새로운 날짜로 설정
    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    public static void moveToNextDay() {
        previousDayAccount = dayAccount;
        addDayAccount();
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
