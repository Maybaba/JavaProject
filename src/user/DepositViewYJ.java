package user;

import util.SimpleInput;

import java.util.Scanner;

import static user.DayAccountsYJ.addDayAccount;
import static user.DayAccountsYJ.dayAccount;
import static util.SimpleInput.*;

class DepositViewYJ {
    public void depositMenu() {
        System.out.printf(" ======== 나의 예적금 ==== sesese-bank와 [ %s일 째 ]==== \n",dayAccount);
        System.out.println(" 1. 나의 적금 ");
        System.out.println(" 2. 나의 예금 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        System.out.println(" *. 다음날로 ");

        String menuNum = input(" >>🧼 ");

        switch (menuNum) {
            case "1": //나의 적금 현황
                System.out.println("적금 현황으로 접속합니다 ...");
                 viewSavingAccountStatus();
                break;

            case "2": //나의 예금 현황
                System.out.println("예금 현황으로 접속합니다 ...");

                viewFixedAccountStatus();
                break;

            case "0": // 뒤로 가기
                System.out.println("이전 메뉴로 돌아갑니다 ...");
                depositMenu(); //이거 이전의 메뉴
                break;

            case "*": // 뒤로 가기
                addDayAccount();
                System.out.println(" 잠 드는 중 ... \n press any key ...");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                depositMenu(); //이거 이전의 메뉴
                break;

            default: //이외의 값을 선택했을 때
                System.out.println("1, 2, 0 번중 하나를 선택해주세요 \n press any key ...");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                depositMenu();
        }

    }


    private void viewSavingAccountStatus() {
        DepositRepositoryYJ dr = new DepositRepositoryYJ();
        //자동넘어감 방지 stop 하기 위한 코드
        Scanner s = new Scanner(System.in);
        //나의 적금 현황
        System.out.println("나의 적금액 [] 나의 ㄱ");
        System.out.println(" 1. 적금계좌에 추가입금하기 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        String menuNum = input(" >>🧼 ");

        switch (menuNum) {
            case "1": //적금계좌에 더 입금하고 싶을 때
                dr.addSavingAccountBalance();
                break;

            case "0": //뒤로 가기
                depositMenu();
                break;

            default: //이외의 값을 선택했을 때
                System.out.println("1, 0 번중 하나를 선택해주세요 \n press any key ...");
                s.nextLine();
            }
    }

    private void viewFixedAccountStatus() {
        DepositRepositoryYJ dr = new DepositRepositoryYJ(1000,1000);
        dr.UserFixedAccount();
        System.out.println("나의 예금액 : 4000000000");
        System.out.println( " 금일 이자 " );
        System.out.println( " 만기 일, 만기 시 이자 " );
        System.out.println( " 해지하기 " );
        //dr.mysaving();
        //System.out.println("*** 나의 %s ***");
        //System.out.println(" 1. 나의 %s 현황 ");
        //System.out.println(" 2. %s에 입금하기 ");


        System.out.println("0. 뒤로 가기 (나가기) ");
        String menuNum = input("# 메뉴선택 >> ");
        if (menuNum.equals("0")) {
            depositMenu();
        }
    }
}


