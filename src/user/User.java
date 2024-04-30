package user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class User {

    //이름
    private String name;
    //계좌정보
    private static List<Account> myAccount;
    // 아이디
    private String bankId;
    // 비밀번호
    private String bankPassword;
    // 가입일자
    private LocalDate nowDate;
    // 잔액 -
    private int myMoney;

    public User(String name, String bankId, String bankPassword) {
        this.name = name;
        this.myAccount = new ArrayList<>();
        this.bankId = bankId;
        this.bankPassword = bankPassword;
        this.nowDate = LocalDate.now();
        this.myMoney = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Account> getMyAccount() {
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
    public int getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(int myMoney) {
        this.myMoney = myMoney;
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
