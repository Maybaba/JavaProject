package admin;

import user.Account;
import user.User;

import java.util.List;
import java.util.Map;

// 조회 기능
public class OutputView {

    // 메뉴 조회 기능
    public void showMenu() {
        System.out.println("===== 관리자 페이지 입니다 =====");
        System.out.println("# 1. 총 잔고 확인");
        System.out.println("# 2. 전체 회원 정보 조회");
//        System.out.println("# 0. 이전으로 돌아가기");
    }

    // 은행 전체 고객들의 계좌 잔액 조회
    public void getTotalMoney(Map<String, User> users) {
        long totalBalance = 0;
        for (String s : users.keySet()) {
            List<Account> accounts = users.get(s).getMyAccount();
            for (Account account : accounts) {
                totalBalance += account.getBalance();
            }
        }
        System.out.println("# 은행 잔고 = " + totalBalance);

    }

    // 회원 정보 조회 기능
    public void getCustomerInfo(Map<String, User> users) {
        for (String key : users.keySet()) {
            User user = users.get(key);
            System.out.println("이름 : " + user.getName() + ", 아이디: " + user.getBankId() + ", 가입일자: " + user.getNowDate());

        }
    }
}


// 개설 된 계좌 수
// 총 예금액
// 총 적금액

