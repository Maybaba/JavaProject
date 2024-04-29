package user;

import util.SimpleInput;

import java.util.List;

import static user.DayAccountsYJ.flagNextDay;
import static util.SimpleInput.*;

public class DepositRepositoryYJ {

    //getter setter, toString 아직임
    private long savedAccountBalance;
    private long fixedAccountBalance;
    private int dayAccounts;
    // 임의로 만든 생성자
    Account account = new Account(100, new User("may", "abc123", "1234", 1000), 1234);

    public DepositRepositoryYJ(long savedAccountBalance, long fixedAccountBalance) {
        this.savedAccountBalance = savedAccountBalance;
        this.fixedAccountBalance = fixedAccountBalance;
        this.dayAccounts = dayAccounts;
    }

    //적금계좌 기본 코드
    void UserSavedAccount() {
        // this.savedAccountBalance = 20; //임의로 넣은 금액임, 조건에 따라 값이 추가됨
        long monthlySaveBalance = 20; //매달 넣는 금액
        double monthlyInterestRate = 0.01; //적금계좌 이자율 : 1%

        //하루 지나면 쌓이는 이자
        if (flagNextDay()) {
            //1일치 이자 계산 시스템
            double interest = savedAccountBalance * monthlyInterestRate;
            this.savedAccountBalance += interest;

            System.out.println("하루가 지남에 따라 적금계좌에 [ %d 원 ]의 이자가 쌓였습니다. " + interest);

            //한달주기 자동이체적금
            if (dayAccounts % 4 == 0) { //한달이 지났는가?
                if (monthlySaveBalance <= account.getBalance()) {
                    // 입출금계좌에서 이체하기
                   this.savedAccountBalance += 100;
                    account.setBalance(account.getBalance() - monthlySaveBalance);
                    System.out.printf("적금계좌에 %d 원이 자동이체 되었습니다. ", monthlySaveBalance);

                } else System.out.println("입출금계좌에 잔액이 부족하여 적금을 실패하였습니다.");
            }

        } else return;
    }

    //내 적금에 추가로 입금하는 코드
    void addSavingAccountBalance() {
        //입출금계좌의 돈 > 입금하려는 돈
        try { int addSaving = Integer.parseInt(input(" 추가로 입금하실 금액을 입력해주세요 ... \n" +
                "추가 입금액 : " ));
            //돈을 추가할지 말지 판단 후 입금
            if(addSaving <= account.getBalance()) {
                System.out.printf("%s 원이 정상적으로 추가입금되었습니다.", addSaving);
            } else System.out.println("현재 입출금 계좌 잔액이 입금하려는 잔액보다 부족합니다. ");

        } catch (NumberFormatException e) {
            System.out.println("입금 금액은 숫자로만 입력해 주세요 \n" +
                    "press any key ...");
        }
    }

    //내 예금계좌 코드
    void UserFixedAccount() {
        // 임의로 만든 생성자
        Account account = new Account(100, new User("may", "abc123", "1234", 1000), 1234);
        // this.fixedAccountBalance = 50; //임의로 넣은 금액임, 조건에 따라 값이 추가됨
        double fixedInterestRate = 0.05; //예금계좌 이자율 : 1%

        if (flagNextDay()) {
            //1일치 이자 계산 시스템
            double interest = fixedAccountBalance * fixedInterestRate;
            this.savedAccountBalance += interest;

            System.out.println("하루가 지남에 따라 예금계좌에 [ %d 원 ]의 이자가 쌓였습니다. " + interest);
        } else return;


        // 입금한 후 잔액 리스트 (1회차, 2회차 )

    }

    public long getSavedAccountBalance() {
        return savedAccountBalance;
    }

    public long getFixedAccountBalance() {
        return fixedAccountBalance;
    }

    public int getDayAccounts() {
        return dayAccounts;
    }

    public void setSavedAccountBalance(long savedAccountBalance) {
        this.savedAccountBalance = savedAccountBalance;
    }

    public void setFixedAccountBalance(long fixedAccountBalance) {
        this.fixedAccountBalance = fixedAccountBalance;
    }

    public void setDayAccounts(int dayAccounts) {
        this.dayAccounts = dayAccounts;
    }
}