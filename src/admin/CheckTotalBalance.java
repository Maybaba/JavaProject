package admin;

import user.Account;

import java.util.List;

// 은행 총 잔고 확인하는 기능
public class CheckTotalBalance {

//    은행 총 잔고 조회 기능
//    public void getTotalMoney(List<Long> balances) {
//        int totalBalance = 0;
//        for (long balance : balances) {
//            totalBalance += balance;
//        }

    public void getTotalMoney(List<Account> accounts) {
        long totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        System.out.println("totalBalance = " + totalBalance);
    }
}