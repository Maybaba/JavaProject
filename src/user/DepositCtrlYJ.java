package user;

import static user.FixedAccountYJ.*;
import static user.SavingAccountYJ.*;
import static util.SimpleInput.input;
import static user.AccountBalanceAccessorYJ.*;

public class DepositCtrlYJ {
    //계좌 유무 확인 불리안 값
    static boolean hasFixedAccount = false;
    static boolean hasSavingAccount = false;

    public static void depositMenu(User user) throws InterruptedException {

        System.out.printf("\n 🧼 --------- 마이 예금 ∙ 적금 --------- 🧼 \n", user.getDayCount());
        System.out.printf("               sesese-bank 와 [ %s일 째 🎔 ]\n", user.getDayCount());

        System.out.println(" 1. 나의 적금 ");
        System.out.println(" 2. 나의 예금 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        System.out.println(" *. 다음날로 ");

        String menuNum = input("  □▫∙︎ ︎");

        switch (menuNum) {

            case "1": //나의 적금 현황
                System.out.println("적금 현황으로 접속합니다 ...");

                for (Account account : user.getMyAccount()) {
                    if (account.getAccountType().equals(AccountType.SAVING) && (account.getBalance() > 0)) {
                        account.getBalance();
                        hasSavingAccount = true;
                        DepositViewYJ.viewSavingAccountStatus(user);
                        return;
                    }
                }
                if (!hasSavingAccount) {
                    System.out.println(" ⁉️적금 통장을 아직 만들지 않았습니다.");
                    input("\n  press any key . . . ");
                    depositMenu(user);
                    break;
                }
                break;

            case "2": //나의 예금 현황
                System.out.println("예금 현황으로 접속합니다 ...");

                for (Account account : user.getMyAccount()) {
                    if (account.getAccountType().equals(AccountType.FIXED) && (account.getBalance() > 0)) {
                        hasFixedAccount = true;
                        DepositViewYJ.viewFixedAccountStatus(user);
                        return;
                    }
                }
                System.out.println(" ⁉️예금 통장을 아직 만들지 않았습니다.");
                input("\n  press any key . . . ");
                depositMenu(user);
                break;

            case "0": // 뒤로 가기
                System.out.println("이전 메뉴로 돌아갑니다 ...");
                return;//이거 이전의 메뉴로 돌아가기

            case "*": // 다음날로 넘어감, nextday 분기점 설정
                for (Account account : user.getMyAccount()) {
                    if (account.getAccountType().equals(AccountType.SAVING)) {
                        hasSavingAccount = true;
                    } else if (account.getAccountType().equals(AccountType.FIXED)) {
                        hasFixedAccount = true;
                    }
                }
                if (hasSavingAccount && hasFixedAccount) {
                    user.moveToNextDay();
                    NextdayCountYJ.getInstance().nextDay();

                    System.out.println(" 잠 드는 중 . . . ");
                    input("\n press any key . . . ");

                    //예적금 이율계산코드
                    System.out.println("\n 🧼 마이 예금 ∙ 적금 오늘의 이율 연동중 . . .  sesese-bank 🧼 \n");
                    userSavingAccount(user);
                    userFixedAccount(user);

                    depositMenu(user); //이전의 메뉴 돌아가기
                    break;
                } else {
                    System.out.println("⁉️아직 예금 혹은 적금통장을 만들지 않아 이자율을 확인 할 수 없습니다. ");
                    input(" press any key . . . ");
                    depositMenu(user);
                    break;
                }

            default: //이외의 값을 선택했을 때
                System.out.println("⁉️  1, 2, 0 번중 하나를 선택해주세요 ");
                input("\n  press any key . . . ");
                depositMenu(user);
        }
    }
}



