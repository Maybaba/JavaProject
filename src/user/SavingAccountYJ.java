package user;

import static user.AccountBalanceAccessorYJ.*;
import static user.DayAccountsYJ.*;
import static util.SimpleInput.*;

class SavingAccountYJ {
    private static long transferBalance; //한솔님 코드에서 가져오기
    private static long savingBalance; //제훈님 코드에 가입금액작성

    // Static constructor
    static {
        long transferBalance = getTransferAccountBalance(); // Initialize with appropriate values
        long savingBalance = getSavingAccountBalance();
    }

    //적금계좌 이율 계산
    static void userSavingAccount(User user) {

        System.out.printf("\n 🧼 ======== 마이적금 함수일자확인 ==== sesese-bank와 [ %s일 째 ]======== 🧼 \n", dayAccount);

        long monthlySaveBalance = 20; //매달 넣는 금액
        double monthlyInterestRate = 0.01; //적금계좌 이자율 : 1%

        //하루당 이자율 계산
        if (flagNextDay()) {
            //1일치 이자 계산 시스템
            double interest = savingBalance * monthlyInterestRate;
            //계좌에 쌓이는 이자
            savingBalance += (long) interest;

            System.out.printf("하루가 지남에 따라 적금계좌에 [ %.2f 원 ]의 이자가 쌓였습니다. \n", interest);
            System.out.printf("나의 현재 적금계좌 잔액 [%d 원]\n\n", savingBalance);
        }

        //한달주기 자동이체적금
        if ((dayAccount != 0) && (dayAccount % 3 == 0)) { //4일 (한달)이 지났는가?, 맨 처음엔 하루가 지나지 않았으므로 실행 ㄴ
            if (monthlySaveBalance <= savingBalance) {

                // 입출금계좌에서 적금계좌로 일정금액 송금기능
                savingBalance += monthlySaveBalance;
                transferBalance -= monthlySaveBalance;
                System.out.printf("sesesebank 적금계좌와 함께한지 %d 일 \n", dayAccount);
                System.out.printf("매달 적금 자동이체 시스템으로 입출금계좌에서 적금계좌로 %d 원이 이체되었습니다. \n ", monthlySaveBalance);
                System.out.printf(" 현재 적금계좌 잔액 [%d 원] \n", savingBalance);

            } else System.out.printf(" ⁉️입출금계좌에 잔액이 부족하여 자동이체 적금을 실패하였습니다. \n");
        }
    }

        //내 적금에 추가로 입금하는 코드
        static void addSavingAccountBalance (User user) {
            int addSaving = 0;

            try {
                addSaving = Integer.parseInt(input(" 추가로 입금하실 금액을 입력해주세요 ... \n" +
                        "추가 입금액 : "));
                //입출금계좌의 돈 > 입금하려는 돈
                if (transferBalance >= addSaving) {
                    transferBalance -= addSaving;

                    System.out.printf("%s 원이 정상적으로 추가입금되었습니다. \n", addSaving);
                    System.out.printf("입출금계좌 잔액 : %d 원 \n", transferBalance);

                } else System.out.println("입출금계좌 잔액이 부족합니다.");

            } catch (NumberFormatException e) {
                System.out.println("입금 금액은 정수로 입력해 주세요 \n" +
                        "press any key ...");
            }

            // addSaving 을 적금계좌에 누적
            savingBalance += addSaving;
            System.out.printf("... 현재 적금계좌 잔액 [%d 원] ", savingBalance);
            DepositViewYJ.depositMenu(user); //메뉴로 되돌아가기
        }
    }




