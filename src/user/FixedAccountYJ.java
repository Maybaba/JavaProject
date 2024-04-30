package user;

import static user.DayAccountsYJ.*;
import static user.AccountBalanceAccessorYJ.*;

public class FixedAccountYJ {
    //다른 함수에서 참조해도 값 유지 위해 field -> static 으로 선언
    private static long fixedBalance = getFixedAccountBalance();

    //if fixed Account 코드
    public static void userFixedAccount(User testUser) {

        System.out.printf("\n 🧼 ======== 마이예금 함수일자확인 ==== sesese-bank와 [ %s일 째 ]======== 🧼 \n",dayAccount);

        for (Account account : testUser.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.FIXED)) {

                double fixedInterestRate = 0.05; //예금계좌 이자율 : 5%

                System.out.printf("param 받아온 예금잔고 재확인 : [%d 원] \n",fixedBalance);
                //계좌잔액변경사항 업데이트
                account.setBalance(fixedBalance);

                //하루 지났을때 원금에 예금 이자 더해주기
                if (flagNextDay()) {
                    //1일치 이자 계산 시스템
                    double interest = fixedBalance * fixedInterestRate;
                    fixedBalance += (long) interest;
                    //계좌잔액변경사항 업데이트
                    account.setBalance(fixedBalance);

                    System.out.printf("하루가 지남에 따라 예금계좌에 [ %f 원 ]의 이자가 쌓였습니다. \n",interest);
                    System.out.printf("하루가 지남에 따라 예금계좌 잔고는 [ %d 원 ] 입니다 \n\n",fixedBalance);

                }
            }
        }
    }

    public static long getFixedBalance() {
        return fixedBalance;
    }

    public static void setFixedBalance(long fixedBalance) {
        FixedAccountYJ.fixedBalance = fixedBalance;
    }

}
