package user;

import java.util.Scanner;

import static user.AccountBalanceAccessorYJ.*;
import static user.DayAccountsYJ.*;
import static user.DepositCtrlYJ.depositMenu;
import static user.SavingAccountYJ.*;
import static util.SimpleInput.*;

public class DepositViewYJ {

    //나의 적금계좌 보기
    public static void viewSavingAccountStatus(User testUser) {
    getBalances(testUser);
        //자동넘어감 방지 stop 하기 위한 코드
        Scanner s = new Scanner(System.in);

        //나의 적금 현황
        System.out.printf("\n 🎏 %s 님의 적금계좌 🎏 \n", testUser.getName());

        System.out.printf("\n 🧼========== 마이적금 sesese-bank 와 [ %s일 째 ] ========== 🧼 \n", dayCount);

        System.out.printf(" ✦ 나의 적금계좌 잔액 [%d]원 \n\n", getSavingAccountBalance());
        System.out.printf(" ♦︎ 매달 [%d 원] 적금하고 있어요 \n\n", getSavingAccountBalance());
        System.out.println(" ✧ 나의 적금계좌 이율 [ 1 % ] \n");
        System.out.println("(하루, 삼일이 지날때마다 이율은 중복으로 계산됩니다.)\n");
        System.out.println("press any key ...");
        s.nextLine();

        //이자 계산 함수
        //userSavingAccount(testUser);

        d:  while (true) {
            System.out.println(" 1. 적금계좌에 추가입금하기 ");
            System.out.println(" 0. 뒤로 가기 (나가기) ");
            String menuNum = input(" >>🧼 ");

            switch (menuNum) {
                case "1": //적금계좌에 더 입금하고 싶을 때
                    addSavingAccountBalance(testUser);

                case "0": //뒤로 가기
                    depositMenu(testUser);
                    break d;

                default: //이외의 값을 선택했을 때
                    System.out.println(" 👻 1, 0 번중 하나를 선택해주세요 \n press any key ...");
                    s.nextLine();
            }
        }
    }
    //나의 예금계좌 보기
    public static void viewFixedAccountStatus(User testUser) {

        //자동넘어감 방지 코드
        Scanner s = new Scanner(System.in);

        System.out.printf("🎏 %s 님의 예금 현황 🎏", testUser.getName());

        System.out.printf("\n 🧼 ========== 마이예금 sesese-bank 와 [ %s일 째 ] ========== 🧼 \n",dayCount);

        System.out.printf(" ♦︎ 나의 예금계좌 잔액 [%d 원] \n", getFixedAccountBalance());
        System.out.println(" ✧ 나의 예금계좌 이율 [ 5 % ] \n");
        System.out.println("(하루가 지날때마다 이율은 중복으로 계산됩니다.)\n");
        System.out.println("press any key ...");
        s.nextLine();

        //userFixedAccount(testUser);

        d: while (true) {
            System.out.println(" 1. 예금계좌 해지하기 (서비스 준비중) ");
            System.out.println(" 0. 뒤로 가기 (나가기) ");
            String menuNum = input(" >>🧼 ");
            try {
                switch (menuNum) {
                    case "1":
                        System.out.println(" 🫧 준비중 입니다. . .");
                        break;

                    case "0": //뒤로 가기
                        depositMenu(testUser);
                        break d;

                    default: //이외의 값을 선택했을 때
                        System.out.println("⁉️ 1, 0 번중 하나를 선택해주세요 \n press any key ...");
                        s.nextLine();
                }
            } catch (Exception e) {
                System.out.println(" .... 🪬 \n press any key ...");
                s.nextLine();
            }
        }
    }
}




