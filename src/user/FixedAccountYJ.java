package user;

import java.util.Scanner;
import static user.AccountBalanceAccessorYJ.*;

class FixedAccountYJ {

    //다른 함수에서 참조해도 값 유지 위해 field -> static 으로 선언
    private static long fixedBalance = getFixedAccountBalance();
    //예금계좌 이자율 : 5%
    private static double fixedInterestRate = 0.05;

    //fixed Account
    public static void userFixedAccount(User user) {
        if (getFixedAccountBalance() != 0) {
            //계좌 잔액 업데이트
            fixedBalance = getFixedAccountBalance();

            Scanner s = new Scanner(System.in);

            //하루 지났을때 원금에 예금 이자 더해주기
            if (NextdayCountYJ.getInstance().checkNextDay()) {

                double interest = fixedBalance * fixedInterestRate;
                fixedBalance += (long) interest;
                updateFixedBalances(user, fixedBalance);

                System.out.printf(" ◇ 하루가 지남에 따라 예금계좌에 [ %.2f 원 ]의 이자가 쌓였습니다. \n", interest);
                System.out.printf(" ♦︎ 하루가 지남에 따라 예금계좌 잔고는 [ %d 원 ] 입니다 \n\n", fixedBalance);
                System.out.println("\n \npress any key ...\n");
                s.nextLine();
                }
            } else {
            System.out.println("⁉️ 예금 통장을 아직 만들지 않았습니다. ");
        }
    }
}



