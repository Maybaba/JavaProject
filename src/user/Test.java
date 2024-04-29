package user;

public class Test {

	public static void main(String[] args) {

		DepositWithdrawalHS test = new DepositWithdrawalHS();
		test.acc = new Account(100000, new User("a", "b","123", 0), 1234); // 예시로 초기 계좌 정보를 넣어줍니다.
		test.depositToAccount();
		test.withdrawalFromAccount();
	}
}
