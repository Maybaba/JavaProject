//한번에 반복문 돌려서 중복 없애기
package user;

import java.util.List;

//바꿀 금액 가져오기
public class AccountBalanceAccessorYJ {
    public static void getBalances(User user) {
        List<Account> accounts = user.getMyAccount();
        for (Account account : accounts) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                savingAccountBalance = account.getBalance();
            } else if (account.getAccountType().equals(AccountType.TRANSFER)) {
                transferAccountBalance = account.getBalance();
            } else if (account.getAccountType().equals(AccountType.FIXED)) {
                fixedAccountBalance = account.getBalance();
            }
        }
    }
    //계좌 잔액을 변수에 저장
    private static long savingAccountBalance;
    private static long transferAccountBalance;
    private static long fixedAccountBalance;

    // 바뀐 금액 업데이트
    public static void updateSavingBalances(User user, long balance) {
        List<Account> accounts = user.getMyAccount();
        for (Account account : accounts) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                account.setBalance(balance);
            }
        }
    }
    public static void updateFixedBalances(User user,long balance) {
        List<Account> accounts = user.getMyAccount();
        for (Account account : accounts) {
            if (account.getAccountType().equals(AccountType.FIXED)) {
                account.setBalance(balance);
            }
        }
    }
    public static void updateTransferBalances(User user, long balance) {
        List<Account> accounts = user.getMyAccount();
        for (Account account : accounts) {
            if (account.getAccountType().equals(AccountType.TRANSFER)) {
                account.setBalance(balance);
            }
        }
    }

    public static long getSavingAccountBalance() {
        return savingAccountBalance;
    }

    public static long getTransferAccountBalance() {
        return transferAccountBalance;
    }

    public static long getFixedAccountBalance() {
        return fixedAccountBalance;
    }
}
