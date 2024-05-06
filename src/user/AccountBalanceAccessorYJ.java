package user;

import java.util.HashMap;
import java.util.Map;

public class AccountBalanceAccessorYJ {
    // 싱글톤 인스턴스
    private static AccountBalanceAccessorYJ instance;

    // 사용자별 계좌 잔액 맵
    private Map<User, Map<AccountType, Long>> accountBalances;

    // private 생성자
    private AccountBalanceAccessorYJ() {
        accountBalances = new HashMap<>();
    }

    // 싱글톤 인스턴스 반환 메서드
    public static synchronized AccountBalanceAccessorYJ getInstance() {
        if (instance == null) {
            instance = new AccountBalanceAccessorYJ();
        }
        return instance;
    }

    // 클래스 map 계좌 잔액 조회
    public long getAccountBalance(User user, AccountType accountType) {
        Map<AccountType, Long> balances = accountBalances.getOrDefault(user, new HashMap<>());
        return balances.getOrDefault(accountType, 0L);
    }

    // 계좌 잔액 업데이트
    public void updateAccountBalance(User user, AccountType accountType, long balance) {
        Map<AccountType, Long> balances = accountBalances.getOrDefault(user, new HashMap<>());
        balances.put(accountType, balance);
        accountBalances.put(user, balances);
    }

    // 사용자의 적금 잔액 반환
    public long getSavingAccountBalance(User user) {
        return getAccountBalance(user, AccountType.SAVING);
    }

    // 사용자의 이체 계좌 잔액 반환
    public long getTransferAccountBalance(User user) {
        return getAccountBalance(user, AccountType.TRANSFER);
    }

    // 사용자의 정기 예금 잔액 반환
    public long getFixedAccountBalance(User user) {
        return getAccountBalance(user, AccountType.FIXED);
    }

    // 사용자의 적금 잔액 업데이트
    public void updateSavingAccountBalance(User user, long balance) {
        updateAccountBalance(user, AccountType.SAVING, balance);
    }

    // 사용자의 이체 계좌 잔액 업데이트
    public void updateTransferAccountBalance(User user, long balance) {
        updateAccountBalance(user, AccountType.TRANSFER, balance);
    }

    // 사용자의 정기 예금 잔액 업데이트
    public void updateFixedAccountBalance(User user, long balance) {
        updateAccountBalance(user, AccountType.FIXED, balance);
    }
    //user 값 계좌 잔액 조회
    public long getUserAccountBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType().equals(AccountType.SAVING)) {
                updateAccountBalance(user, AccountType.SAVING, account.getBalance());
                return account.getBalance();
            } else if (account.getAccountType().equals(AccountType.FIXED)) {
                updateAccountBalance(user, AccountType.FIXED, account.getBalance());
                return account.getBalance();
            } else if (account.getAccountType().equals(AccountType.TRANSFER)) {
                updateAccountBalance(user, AccountType.TRANSFER, account.getBalance());
                return account.getBalance();
            }
        }//값을 찾지 못했을 경우
        System.out.println("반환할 계좌의 타입이 없어서 금액 조회가 안됩니다.");
        return 0L;
    }
}

//package user;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class AccountBalanceAccessorYJ {
//    // 싱글톤 인스턴스
//    private static AccountBalanceAccessorYJ instance;
//
//    // 사용자별 계좌 잔액 맵
//    private Map<User, Map<AccountType, Long>> accountBalances;
//
//    // private 생성자
//    private AccountBalanceAccessorYJ() {
//        accountBalances = new HashMap<>();
//    }
//
//    // 싱글톤 인스턴스 반환 메서드
//    public static synchronized AccountBalanceAccessorYJ getInstance() {
//        if (instance == null) {
//            instance = new AccountBalanceAccessorYJ();
//        }
//        return instance;
//    }
//
//    // 계좌 잔액 조회
//    public long getAccountBalance(User user, AccountType accountType) {
//        Map<AccountType, Long> balances = accountBalances.getOrDefault(user, new HashMap<>());
//        return balances.getOrDefault(accountType, 0L);
//    }
//
//    // 계좌 잔액 업데이트
//    public void updateAccountBalance(User user, AccountType accountType, long balance) {
//        Map<AccountType, Long> balances = accountBalances.getOrDefault(user, new HashMap<>());
//        balances.put(accountType, balance);
//        accountBalances.put(user, balances);
//    }
//
//    // 사용자의 적금 잔액 반환
//    public long getSavingAccountBalance(User user) {
//        return getAccountBalance(user, AccountType.SAVING);
//    }
//
//    // 사용자의 이체 계좌 잔액 반환
//    public long getTransferAccountBalance(User user) {
//        return getAccountBalance(user, AccountType.TRANSFER);
//    }
//
//    // 사용자의 정기 예금 잔액 반환
//    public long getFixedAccountBalance(User user) {
//        return getAccountBalance(user, AccountType.FIXED);
//    }
//
//    // 사용자의 적금 잔액 업데이트
//    public void updateSavingAccountBalance(User user, long balance) {
//        updateAccountBalance(user, AccountType.SAVING, balance);
//    }
//
//    // 사용자의 이체 계좌 잔액 업데이트
//    public void updateTransferAccountBalance(User user, long balance) {
//        updateAccountBalance(user, AccountType.TRANSFER, balance);
//    }
//
//    // 사용자의 정기 예금 잔액 업데이트
//    public void updateFixedAccountBalance(User user, long balance) {
//        updateAccountBalance(user, AccountType.FIXED, balance);
//    }
//}
//
