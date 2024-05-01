package admin;

import user.Account;
import user.User;

import java.util.List;

public class OutputView {

    // 메뉴 출력 기능
    public void MenuView() {
        System.out.println("===== 관리자 페이지 입니다 =====");
        System.out.println("# 1. 총 잔고 확인");
        System.out.println("# 2. 전체 회원 정보 조회");
    }

    // 총 잔액 확인 기능
    public void getTotalMoney(List<Account> accounts) {
        long totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        System.out.println("totalBalance = " + totalBalance);
    }


    //회원 정보 조회 기능
    public void getCustomerInfo(User testUser) {
        System.out.println(testUser.getMyAccount());
    }


}
