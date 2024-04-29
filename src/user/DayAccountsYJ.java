package user;
//TODO : 다음날로 넘어가는 기능
public class DayAccountsYJ { //전체에서 적용되는 기능
    //필드
    static int dayAccount;
    static int previousDayAccount;

    //생성자
    public DayAccountsYJ(int dayAccount) {
        this.dayAccount = dayAccount;
        this.previousDayAccount = 0; //이전날이 없을 수도 있으므로 기본값 설정
    }

    //method
    //nextday로 넘어갔는지 여부 확인
    public static boolean flagNextDay() {
        return dayAccount > previousDayAccount;
    }

    //dayAccuont에 +1 추가
    static void addDayAccount() {
        dayAccount ++;
    }


    public void setDayAccount(int dayAccount) {
        this.dayAccount = dayAccount;
    }

    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    public void setPreviousDayAccount(int previousDayAccount) {
        this.previousDayAccount = previousDayAccount;
    }

    public int getDayAccount() {
        return dayAccount;
    }

    public int getPreviousDayAccount() {
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
