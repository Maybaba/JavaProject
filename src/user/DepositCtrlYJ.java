package user;

import java.util.Scanner;

import static user.FixedAccountYJ.*;
import static user.SavingAccountYJ.*;
import static util.SimpleInput.input;
import static user.AccountBalanceAccessorYJ.*;

public class DepositCtrlYJ {

    public static void depositMenu(User user) {
        //예적금 등  값 받아오는 메서드
        getBalances(user);

        System.out.printf("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 마이 예금 ∙ 적금 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 \n",  user.getDayCount());
        System.out.printf("               sesese-bank 와 [ %s일 째 ]🫧\n",  user.getDayCount());

        System.out.println(" 1. 나의 적금 ");
        System.out.println(" 2. 나의 예금 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        System.out.println(" *. 다음날로 ");

        String menuNum = input("  □▫∙︎ ︎");

        switch (menuNum) {
            case "1": //나의 적금 현황
                System.out.println("적금 현황으로 접속합니다 ...");
                DepositViewYJ.viewSavingAccountStatus(user);
                break;

            case "2": //나의 예금 현황
                System.out.println("예금 현황으로 접속합니다 ...");
                DepositViewYJ.viewFixedAccountStatus(user);
                break;

            case "0": // 뒤로 가기
                System.out.println("이전 메뉴로 돌아갑니다 ...");
//                BankController.mainMenu(user);
                return;//이거 이전의 메뉴

            case "*": // 다음날로, 하루 +
                if (getFixedAccountBalance() != 0 && getSavingAccountBalance() != 0) {
                    user.moveToNextDay();

                    System.out.println(" 잠 드는 중 ... \n press any key ...");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();

                    //예적금 이율계산코드
                    System.out.println("\n 🧼 마이 예금 ∙ 적금 오늘의 이율 연동중 . . .  sesese-bank 🧼 \n");
                    userSavingAccount(user);
                    userFixedAccount(user);

                    depositMenu(user); //이전의 메뉴 돌아가기
                } else {
                    System.out.println("⁉️아직 예금 혹은 적금통장을 만들지 않아 이자율을 확인 할 수 없습니다. ");
                    System.out.println(" press any key . . . ");
                    Scanner s = new Scanner(System.in);
                    s.nextLine();
                    break;
                }

            default: //이외의 값을 선택했을 때
                System.out.println("1, 2, 0 번중 하나를 선택해주세요 \n press any key ...");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                depositMenu(user);
        }
    }
}
