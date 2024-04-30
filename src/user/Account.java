package user;


import java.time.LocalDate;

import static user.CreateAccountLJH.generateAccountNumber;


public class Account  {

    //field
    private static AccountType accountType;
    private String accountNum; //계좌번호
    private long balance;  // 계좌잔액
//    private User user;  // 나의정보
    private LocalDate openAccountDate; // 날짜
//    accountStatus;// 계좌 상태
    private long singleTransferLimit;// 일회 이체 한도
    private int accountPassword; // 계좌 비번

    public Account( long balance, User user, int accountPassword, AccountType type, String accountNum) {
        this.accountNum = generateAccountNumber(); //나중에 랜덤값
        this.balance = balance;
//        this.user = user;
        this.openAccountDate = LocalDate.now();
        this.singleTransferLimit = 1000000;
        this.accountPassword = accountPassword;
        this.accountType = type;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public static AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDate getOpenAccountDate() {
        return openAccountDate;
    }

    public void setOpenAccountDate(LocalDate openAccountDate) {
        this.openAccountDate = openAccountDate;
    }

    public long getSingleTransferLimit() {
        return singleTransferLimit;
    }

    public void setSingleTransferLimit(long singleTransferLimit) {
        this.singleTransferLimit = singleTransferLimit;
    }

    public int getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(int accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", accountNum=" + accountNum +
                ", balance=" + balance +
                ", openAccountDate=" + openAccountDate +
                ", singleTransferLimit=" + singleTransferLimit +
                ", accountPassword=" + accountPassword +
                '}';
    }
}


