	package user;

	import static util.SimpleInput.input;

	public class DepositWithdrawalHS {

		Account acc;
		User user;

		public void run () {
			while (accountVerification()) {
				switch (showMenu()) {
					case "1":
						depositToAccount();
						break;
					case "2":
						withdrawalFromAccount();
						break;
					case "3":
						return;
					default:
						System.out.println("올바른 번호를 입력해 주세요.\n입금: 1, 출금 2");
				}
			}
		}

		public boolean accountVerification () {
			for (Account account : user.getMyAccount()) {
				if (account.getAccountType() == AccountType.TRANSFER) {
					return true;
				}
			}
				System.out.println("입출금 가능한 계좌가 없습니다.");
			return false;
		}

		public String showMenu () {
			System.out.println("# 메뉴를 선택하세요");
			System.out.println("1. 입금하기");
			System.out.println("2. 출금하기");
			System.out.println("3. 나가기");
			return input(">> ");
		}

		// 입금 메서드
		public void depositToAccount () {
//			System.out.println("==========입금==========");
//			System.out.println(acc.getBalance()); // 현재 계좌 잔액 출력
			System.out.println("\n# 입금할 금액을 입력하세요");
			String depositAmountStr = input(">> ");
			long depositAmount = Long.parseLong(depositAmountStr);
			acc.setBalance(acc.getBalance() + depositAmount);
			System.out.println("\n입금 후 잔액: " + acc.getBalance());
		}

		// 출금 메서드
		public void withdrawalFromAccount () {
//			System.out.println("==========출금==========");
			System.out.printf("\n# 출금할 금액을 입력하세요\n# 현재 잔액: %d\n", acc.getBalance());
			String withdrawalAmountStr = input(">> ");
			long withdrawalAmount = Long.parseLong(withdrawalAmountStr);
			if (acc.getBalance() >= withdrawalAmount) { // 출금액이 잔액보다 적은지 확인
				acc.setBalance(acc.getBalance() - withdrawalAmount);
				System.out.printf("%d원이 출금되었습니다.", withdrawalAmount);
				System.out.println("남은 잔액: " + acc.getBalance()); // 출금 후 남은 잔액 출력
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		}

	}
