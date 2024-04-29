package user;

import static user.AccountType.TRANSFER;

public class Test {

	public static void main(String[] args) {

		DepositWithdrawalHS test = new DepositWithdrawalHS();
		User user = new User("a", "b", "123"); // 사용자 생성
		user.getMyAccount().add(new Account(100000, user, 1234, TRANSFER)); // TRANSFER 계좌 생성 및 사용자에게 연결
		test.user = user; // DepositWithdrawalHS 객체에 사용자 설정
		test.acc = user.getMyAccount().get(0); // DepositWithdrawalHS 객체에 TRANSFER 계좌 설정
		test.run();
//		test.depositToAccount();
//		test.withdrawalFromAccount();
	}
}
