package user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    //이름
    private String name;
    //계좌정보
    private List<Account> myAccount;
    // 아이디
    private String bankId;
    // 비밀번호
    private String bankPassword;
    // 가입일자
    private LocalDate nowDate;
    // 잔액
    private long myMoney;
    // 비밀번호 힌트 - 보물 1호
    private String myTreasure;
    //다음날 넘어감
    private int dayCount;

    public User(String name, String bankId, String bankPassword, String myTreasure) {
        this.name = name;
        this.myAccount = new ArrayList<>();
        this.bankId = bankId;
        this.bankPassword = bankPassword;
        this.nowDate = LocalDate.now();
        this.myMoney = 0;
        this.myTreasure = myTreasure;
        this.dayCount = 0;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }
    //다음날로 넘어가는 코드
    public void moveToNextDay() {
        this.dayCount++;
    }

    public String getMyTreasure() {
        return myTreasure;
    }

    public void setMyTreasure(String myTreasure) {
        this.myTreasure = myTreasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getMyAccount() {
        return myAccount;
    }

    public void setMyAccount(List<Account> myAccount) {
        this.myAccount = myAccount;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public LocalDate getNowDate() {
        return nowDate;
    }

    public void setNowDate(LocalDate nowDate) {
        this.nowDate = nowDate;
    }


    //값 참조해야 해서 static 으로 바꿈
    public long getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(long myMoney) {
        this.myMoney = myMoney;
    }

    // 특정 유형의 계좌 잔액 조회
    public long getAccountBalance(AccountType accountType) {
        for (Account account : myAccount) {
            if (account.getAccountType() == accountType) {
                return account.getBalance();
            }
        }
        return 0; // 해당 유형의 계좌가 없는 경우
    }

    // 특정 유형의 계좌가 있는지 확인
    public boolean hasAccount(AccountType accountType) {
        for (Account account : myAccount) {
            if (account.getAccountType() == accountType) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return myMoney == user.myMoney && Objects.equals(name, user.name) && Objects.equals(myAccount, user.myAccount) && Objects.equals(bankId, user.bankId) && Objects.equals(bankPassword, user.bankPassword) && Objects.equals(nowDate, user.nowDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, myAccount, bankId, bankPassword, nowDate, myMoney);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", myAccount=" + myAccount +
                ", account='" + bankId + '\'' +
                ", password='" + bankPassword + '\'' +
                ", nowDate=" + nowDate +
                ", myMoney=" + myMoney +
                '}';
    }
}
