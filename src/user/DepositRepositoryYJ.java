package user;

import static user.DayAccountsYJ.*;
import static util.SimpleInput.*;

//created saving, fixed, transfer
class DepositRepositoryYJ {
    //다른 함수에서 참조해도 값 유지 위해 static 으로 선언
    private static long savingBalance; //제훈님 코드에 가입금액작성
    private static long fixedBalance; //제훈님 코드에 가입금액작성
    private static long transferBalance; //한솔님 코드에서 가져오기

    //내 적금에 추가로 입금하는 코드
    static long addSavingAccountBalance(User testUser) {
        int addSaving = 0;

        try {
            addSaving = Integer.parseInt(input(" 추가로 입금하실 금액을 입력해주세요 ... \n" +
                    "추가 입금액 : "));
            //입출금계좌의 돈 > 입금하려는 돈
            for (Account account2 : testUser.getMyAccount()) {
                if (account2.getAccountType().equals(AccountType.TRANSFER)) {
                    if(account2.getBalance() >= addSaving)
                        transferBalance = account2.getBalance();
                        transferBalance -= addSaving;

                        System.out.printf("%s 원이 정상적으로 추가입금되었습니다. \n", addSaving);
                        System.out.printf("입출금계좌 잔액 : %d 원 \n", transferBalance);


                } else System.out.println("입출금계좌 잔액이 부족합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("입금 금액은 정수로 입력해 주세요 \n" +
                    "press any key ...");
        }

        // addSaving 을 적금계좌에 누적
        for (Account account : testUser.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                savingBalance = account.getBalance();
                savingBalance += addSaving;
                //계좌변경사항 업데이트
                account.setBalance(savingBalance);

                System.out.println("... 현재 적금계좌 잔액 : " + savingBalance);
            }
        }
        DepositViewYJ.depositMenu(testUser);
        return savingBalance;
    }

    //if saving account
    public static void userDepositAccount(User testUser) {
        //다음날로 넘어가는 함수 갖고오기
        int dayAccounts = getDayAccount();

        for (Account account : testUser.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.SAVING)) {

                long monthlySaveBalance = 20; //매달 넣는 금액
                double monthlyInterestRate = 0.01; //적금계좌 이자율 : 1%
                savingBalance = account.getBalance();

                //하루 지나면 쌓이는 이자
                if (flagNextDay()) {
                    //1일치 이자 계산 시스템
                    double interest = savingBalance * monthlyInterestRate;
                    //계좌에 쌓이는 이자
                    savingBalance += interest;
                    //계좌잔액변경사항 업데이트
                    account.setBalance(savingBalance);
                    System.out.printf("하루가 지남에 따라 적금계좌에 [ %d 원 ]의 이자가 쌓였습니다. " + interest);
                }
                    //한달주기 자동이체적금
                    if (dayAccounts % 3 == 0) { //4일 (한달)이 지났는가?
                        if (monthlySaveBalance <= savingBalance) {
                            // 입출금계좌에서 이체하기
                            savingBalance += monthlySaveBalance;
                            account.setBalance(transferBalance - monthlySaveBalance);
                            System.out.printf("sesesebank와 함께한지 %d 일 \n" , dayAccounts );
                            System.out.printf("3일이 지남에 따라 적금계좌에 %d 원이 자동이체 되었습니다. \n ", monthlySaveBalance);
                            System.out.printf(" 현재 적금계좌 잔액 [%d 원] \n", savingBalance);

                        } else System.out.printf(" ⁉️입출금계좌에 잔액이 부족하여 자동이체 적금을 실패하였습니다. \n");
                    }

                //if fixed Account 코드
            } else if (account.getAccountType().equals(AccountType.FIXED)) {

                double fixedInterestRate = 0.05; //예금계좌 이자율 : 5%
                //계좌가입시 받아오는 코드
                fixedBalance =  200; //account.getBalance();
                //계좌잔액변경사항 업데이트
                account.setBalance(fixedBalance);

                //하루 지났을때 예금 코드
                if (flagNextDay()) {
                    //1일치 이자 계산 시스템
                    double interest = fixedBalance * fixedInterestRate;
                    fixedBalance += interest;
                    //계좌잔액변경사항 업데이트
                    account.setBalance(fixedBalance);

                    System.out.printf("하루가 지남에 따라 예금계좌에 [ %f 원 ]의 이자가 쌓였습니다. " + interest);
                    System.out.printf("하루가 지남에 따라 예금계좌 잔고는 [ %f 원 ] 입니다 " + fixedBalance);

                }
            }
        }
    }

    public static long getSavingBalance() {
        return savingBalance;
    }

    public static long getFixedBalance() {
        return fixedBalance;
    }

    public static long getTransferBalance() {
        return transferBalance;
    }

    public static void setSavingBalance(long savingBalance) {
        DepositRepositoryYJ.savingBalance = savingBalance;
    }

    public static void setFixedBalance(long fixedBalance) {
        DepositRepositoryYJ.fixedBalance = fixedBalance;
    }

    public static void setTransferBalance(long transferBalance) {
        DepositRepositoryYJ.transferBalance = transferBalance;
    }
}

   /*
        //입출금계좌에서 출금 가능 여부 판단
        for (Account account1 : testUser.getMyAccount()) {
            if (account1.getAccountType().equals(AccountType.TRANSFER) &&
                    addSaving <= account1.getBalance()) {
                System.out.printf("%s 원이 정상적으로 추가입금되었습니다. \n", addSaving);
                //계좌변경사항 업데이트 , 입출금계좌 설정하기
                account1.setBalance(savingBalance);
            } else System.out.println("현재 입출금 계좌 잔액이 입금하려는 잔액보다 부족합니다. ");
        }

         */



