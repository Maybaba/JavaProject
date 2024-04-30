package user;

import java.util.List;

// Function to iterate over accounts and update balances
public class AccountBalanceAccessorYJ {

    private static long savingAccountBalance = 0;
    private static long transferAccountBalance = 0;
    private static long fixedAccountBalance = 0;

    public static void updateBalances(List<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountType() == AccountType.SAVING) {
                savingAccountBalance = account.getBalance();
            } else if (account.getAccountType() == AccountType.TRANSFER) {
                transferAccountBalance = account.getBalance();
            } else if (account.getAccountType() == AccountType.FIXED) {
                fixedAccountBalance = account.getBalance();
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
