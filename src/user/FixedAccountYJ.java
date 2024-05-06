package user;

import java.util.Scanner;
import static user.AccountBalanceAccessorYJ.*;
import static user.SimpleInput.input;
class FixedAccountYJ {

    //fixed Account
    static void userFixedAccount(User user) {
        for (Account account : user.getMyAccount() ) {
            if(account.getAccountType().equals(AccountType.FIXED)) {
                if (account.getBalance() != 0L) {
                    //계좌 잔액 업데이트
                    long fixedBalance = AccountBalanceAccessorYJ.getInstance().getUserAccountBalance(user);

                    Scanner s = new Scanner(System.in);

                    //하루 지났을때 원금에 예금 이자 더해주기
                    if (NextdayCountYJ.getInstance().checkNextDay2()) {

                        double fixedInterestRate = 0.05; //예금계좌 이자율 : 5%
                        double interest = fixedBalance * fixedInterestRate;
                        fixedBalance += (long) interest;
                        AccountBalanceAccessorYJ.getInstance().updateFixedAccountBalance(user, fixedBalance);

                        System.out.printf(" ◇ 하루가 지남에 따라 예금계좌에 [ %.2f 원 ]의 이자가 쌓였습니다. \n", interest);
                        System.out.printf(" ♦︎ 하루가 지남에 따라 예금계좌 잔고는 [ %d 원 ] 입니다 \n\n", fixedBalance);
                        SimpleInput.input("press any key . . . ");
                    }
                } else {
                    System.out.println("⁉️ 예금 통장을 아직 만들지 않았습니다. ");
                    SimpleInput.input("press any key . . . ");
                }
            }
        }
    }
}



