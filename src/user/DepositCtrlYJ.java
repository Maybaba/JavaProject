package user;

import java.util.Scanner;

import static user.DayAccountsYJ.*;
import static user.DepositViewYJ.viewFixedAccountStatus;
import static util.SimpleInput.input;

public class DepositCtrlYJ {
    //controller
    public static void depositMenu(User testUser) {
        System.out.printf("\n 🧼 ======== 마이 예적금 페이지 ==== sesese-bank와 [ %s일 째 ] ======== 🧼 \n", dayCount);
        System.out.println(" 1. 나의 적금 ");
        System.out.println(" 2. 나의 예금 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        System.out.println(" *. 다음날로 ");

        String menuNum = input(" >>🧼 ");

        switch (menuNum) {
            case "1": //나의 적금 현황
                System.out.println("적금 현황으로 접속합니다 ...");
                DepositViewYJ.viewSavingAccountStatus(testUser);
                break;

            case "2": //나의 예금 현황
                System.out.println("예금 현황으로 접속합니다 ...");
                viewFixedAccountStatus(testUser);
                break;

            case "0": // 뒤로 가기
                System.out.println("이전 메뉴로 돌아갑니다 ...");
                depositMenu(testUser); //이거 이전의 메뉴
                break;

            case "*": // 다음날로, 하루 +
                moveToNextDay();
                System.out.println(" 잠 드는 중 ... \n press any key ...");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                depositMenu(testUser); //이전의 메뉴 돌아가기
                break;

            default: //이외의 값을 선택했을 때
                System.out.println("1, 2, 0 번중 하나를 선택해주세요 \n press any key ...");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                depositMenu(testUser);
        }
    }
}
