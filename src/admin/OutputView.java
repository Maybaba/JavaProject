package admin;

import user.Account;
import user.User;

import java.util.List;
// 조회 기능
public class OutputView {

    // 메뉴 조회 기능
    public void showMenu() {
        System.out.println("===== 관리자 페이지 입니다 =====");
        System.out.println("# 1. 총 잔고 확인");
        System.out.println("# 2. 전체 회원 정보 조회");
        System.out.println("# 0. 이전으로 돌아가기");
    }

    // 은행 전체 고객들의 계좌 잔액 조회
    public void getTotalMoney(List<Account> accounts) {
        long totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        System.out.println("totalBalance = " + totalBalance);
    }


    // 회원 정보 조회 기능
    public void getCustomerInfo(User testUser) {
        System.out.println(testUser.getMyAccount());
    }


}
