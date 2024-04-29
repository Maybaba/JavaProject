	package user;

	import static util.SimpleInput.input;

	public class DepositWithdrawalHS {

		Account acc;

		// 입금 메서드
		public void depositToAccount() {
			System.out.println("==========입금==========");
//			System.out.println(acc.getBalance()); // 현재 계좌 잔액 출력
			System.out.println("# 입금할 금액을 입력하세요");
			String depositAmountStr = input(">> ");
			long depositAmount = Long.parseLong(depositAmountStr);
			acc.setBalance(acc.getBalance() + depositAmount);
			System.out.println("입금 후 잔액: " + acc.getBalance());
		}

		// 출금 메서드
		public void withdrawalFromAccount () {
			System.out.println("==========출금==========");
			System.out.printf("# 출금할 금액을 입력하세요\n# 현재 잔액: %d\n", acc.getBalance());
			String withdrawalAmountStr = input(">> ");
			long withdrawalAmount = Long.parseLong(withdrawalAmountStr);
			if (acc.getBalance() >= withdrawalAmount) { // 출금액이 잔액보다 적은지 확인
				acc.setBalance(acc.getBalance() - withdrawalAmount);
				System.out.println("출금이 완료되었습니다.");
				System.out.println("남은 잔액: " + acc.getBalance()); // 출금 후 남은 잔액 출력
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		}

	}
