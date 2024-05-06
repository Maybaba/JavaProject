package user;

public class AccountBalanceAccessorYJ {
    // 싱글톤 인스턴스
    private static AccountBalanceAccessorYJ instance;

    // 싱글톤 인스턴스 반환 메서드
    public static synchronized AccountBalanceAccessorYJ getInstance() {
        if (instance == null) {
            instance = new AccountBalanceAccessorYJ();
        }
        return instance;
    }
    //계좌 타입 별 initialdepositbalance 구하기
    public long getInitialSavingBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType() == AccountType.SAVING) {
                return account.getInitialDepositBalance();
            }
        }
        return 0L;
    }


    public long getSavingAccountBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                return account.getBalance();
            }
        }
        return 0L;
    }

    public long getFixedAccountBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.FIXED)) {
                return account.getBalance();
            }
        }
        return 0L;
    }

    public long getTransferAccountBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.TRANSFER)) {
                return account.getBalance();
            }
        }
        return 0L;
    }


    public void setSavingAccountBalance(User user, long balance) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                account.setBalance(balance);
            }
        }
    }
    public void setFixedAccountBalance(User user, long balance) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.FIXED)) {
                account.setBalance(balance);
            }
        }
    }
    public void setTransferAccountBalance(User user, long balance) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.TRANSFER)) {
                account.setBalance(balance);
            }
        }
    }
}
