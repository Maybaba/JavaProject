package user;

import java.util.HashMap;
import java.util.Map;

import static user.AccountBalanceAccessorYJ.*;
import static user.DepositCtrlYJ.depositMenu;
import static util.SimpleInput.*;

public class DepositViewYJ {
//    // 사용자별 적금 잔액을 저장하는 맵 (user 별로 매달 적금 납입금 따로 저장
//    private static Map<User, Long> monthlySavingBalances = new HashMap<>();
//
//    // 생성자를 통해 적금 값 초기화
//    public DepositViewYJ(User user) {
//        long initialMonthlySavingBalance = 0;
//
//        for (Account account : user.getMyAccount()) {
//            if (account.getAccountType().equals(AccountType.SAVING)) {
//                initialMonthlySavingBalance = account.getBalance();
//                break;
//            }
//        }
//        // 적금 계좌가 있을 경우에만 저장
//        if (initialMonthlySavingBalance != 0) {
//            monthlySavingBalances.put(user, initialMonthlySavingBalance);
//        } else {
//            // 적금 계좌가 없는 경우 기본값을 저장
//            monthlySavingBalances.put(user, 1111L);
//        }
//    }

//    // 적금 잔액 반환 메서드
//    public static final long getMonthlySavingBalance(User user) {
//     monthlySavingBalances.get(user);
//        System.out.println("monthlySavingBalances.get(user) : " + monthlySavingBalances.get(user));
//        //널값이면 0 리턴 -> 널값이 왜 나오는지 디버깅 하면 될듯 -> 계속 null 로 뜸
//        return monthlySavingBalances.get(user) != null ? monthlySavingBalances.get(user) : 10101010;
//    }

    //나의 적금계좌 보기
    public static void viewSavingAccountStatus(User user) {
        long savingAccountBalance = getInstance().getUserAccountBalance(user);
        if (savingAccountBalance != 0) {

            //나의 적금 현황
            System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 적금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n", user.getName());
            System.out.printf("\n              sesese-bank 와 [ %s일 째 ]🫧\n", user.getDayCount());

            System.out.printf(" ✦ 나의 적금계좌 잔액 [%d]원 \n\n", getInstance().getUserAccountBalance(user));
            System.out.printf(" ♦︎ 매달 [%d 원] 적금하고 있어요 \n\n", getInstance().getUserAccountBalance(user));
            //user 값이 만들어졌을때 변수 선언해서 그거 걍 매달 더하셈 어우 귀차나
            System.out.println(" ✧ 나의 적금계좌 이율 [ 1 % ] \n");
            System.out.println("(하루, 삼일이 지날때마다 이율은 중복으로 계산됩니다.)\n");
            input("press any key . . . ");

            d:
            while (true) {
                System.out.println(" 1. 적금계좌에 추가입금하기 ");
                System.out.println(" 0. 뒤로 가기 (나가기) ");
                String menuNum = input(" □▫∙︎ ︎");

                switch (menuNum) {
                    case "1": //적금계좌에 더 입금하고 싶을 때
                        SavingAccountYJ.addSavingAccountBalance(user);

                    case "0": //뒤로 가기
                        depositMenu(user);
                        break d;

                    default: //이외의 값을 선택했을 때
                        System.out.println(" ⁉️ 1, 0 번중 하나를 선택해주세요 \n press any key ...");
                        input(" press any key . . . ");
                }
            }
        } else {
            System.out.println("⁉️ 적금 통장이 아직 존재하지 않습니다. ");
            input(" press any key . . .");
            depositMenu(user);
        }
    }

    //나의 예금계좌 보기
    public static void viewFixedAccountStatus(User user) {
        long fixedAccountBalance = getInstance().getUserAccountBalance(user);
        if (fixedAccountBalance != 0) {

            System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 예금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n", user.getName());

            System.out.printf(" ♦︎ 나의 예금계좌 잔액 [%d 원] \n", getInstance().getUserAccountBalance(user));
            System.out.println(" ✧ 나의 예금계좌 이율 [ 5 % ] \n");
            System.out.println("(이율은 하루가 지날때마다 계산됩니다.)\n");
            input("press any key . . . ");


            d:
            while (true) {
                System.out.println(" 1. 예금계좌 해지하기 (서비스 준비중) ");
                System.out.println(" 0. 뒤로 가기 (나가기) ");
                String menuNum = input(" □▫∙︎ ︎");
                try {
                    switch (menuNum) {
                        case "1":
                            System.out.println(" 🪬 준비중 입니다. . . 🪬");
                            break;

                        case "0": //뒤로 가기
                            depositMenu(user);
                            break d;

                        default: //이외의 값을 선택했을 때
                            System.out.println("⁉️ 1, 0 번중 하나를 선택해주세요 ");
                            input("press any key . . . ");
                    }
                } catch (Exception e) {
                    input("press any key . . . ");
                }
            }
        } else {
            System.out.println("⁉️ 예금 통장이 아직 존재하지 않습니다. ");
            input(" press any key . . .");
        }
    }
}





