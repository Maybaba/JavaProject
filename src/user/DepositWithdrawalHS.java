	package user;

	import static util.SimpleInput.input;

	public class DepositWithdrawalHS {

		// 입출금 실행 메서드
		public void run (User user) {
			while (accountVerification(user) != null) {
				switch (showMenu()) {
					case "1":
						depositToAccount(user);
						break;
					case "2":
						withdrawalFromAccount(user);
						break;
					case "0":
						System.out.println("이전 화면으로 돌아갑니다.");
						return;
					default:
						System.out.println("올바른 번호를 입력해 주세요\n입금: 1, 출금 2, 나가기 0");
				}
			}
		}

		/**
		 * 입출금 계좌 유무 확인 메서드
		 * 있으면 해당 계좌 리턴 > 입출금시 리턴된 계좌 이용
		 * 없으면 null 리턴
		 * @param user
		 * @return
		 */
		public Account accountVerification (User user) {
			try {
				for (Account account : user.getMyAccount()) {
					if (account.getAccountType() == AccountType.TRANSFER) {
						return account;
					}
				}
			} catch (Exception e) {
				System.out.println("유저 정보를 찾을 수 없습니다.");
				return null;
			}
			System.out.println("입출금 가능한 계좌가 없습니다.");
			return null;
		}

		// 입출금 메뉴 출력 메서드
		public String showMenu () {
			System.out.println("\n# 메뉴를 선택하세요");
			System.out.println("1. 입금하기");
			System.out.println("2. 출금하기");
			System.out.println("0. 돌아가기");
			return input(">> ");
		}

		// 입금 메서드
		public void depositToAccount (User user) {
//			System.out.println(acc.getBalance()); // 현재 계좌 잔액 출력
			while (true) {
				System.out.println("\n# 입금할 금액을 입력하세요\n# 취소하려면 [X]를 입력하세요");
				String depositAmountStr = input(">> ");
				if (depositAmountStr.toUpperCase().equals("X")) break;
				try {
					long depositAmount = Long.parseLong(depositAmountStr);
					if (depositAmount <= 0) {
						System.out.println("# 0보다 큰 정수를 입력해 주세요");
						continue;
					}

					accountVerification(user).setBalance(accountVerification(user).getBalance() + depositAmount);
					System.out.println("\n입금 후 잔액: " + accountVerification(user).getBalance());
					break;
				} catch (NumberFormatException e) {
					System.out.println("# 0보다 큰 정수를 입력해 주세요");
				}
			}
		}

		// 출금 메서드
		public void withdrawalFromAccount (User user) {
			if(accountVerification(user).getBalance() == 0) {
				System.out.println("출금 할 수 없습니다.(잔액 : 0원)");
				return;
			}
			while (true) {
				System.out.printf("\n# 출금할 금액을 입력하세요\n# 현재 잔액: %d\n# 취소하려면 [X]를 입력하세요\n", accountVerification(user).getBalance());
				String withdrawalAmountStr = input(">> ");
				if (withdrawalAmountStr.toUpperCase().equals("X")) break;
				try {
					long withdrawalAmount = Long.parseLong(withdrawalAmountStr);
					if (withdrawalAmount <= 0) {
						System.out.println("# 0보다 큰 정수를 입력해 주세요");
						continue;
					}
					if (accountVerification(user).getBalance() >= withdrawalAmount) { // 출금액이 잔액보다 적은지 확인
						accountVerification(user).setBalance(accountVerification(user).getBalance() - withdrawalAmount);
						System.out.printf("%d원이 출금되었습니다.\n", withdrawalAmount);
						System.out.println("남은 잔액: " + accountVerification(user).getBalance()); // 출금 후 남은 잔액 출력
						break;
					} else {
						System.out.println("잔액이 부족합니다.");
					}
				} catch (NumberFormatException e) {
					System.out.println("# 0보다 큰 정수를 입력해 주세요.");
				}
			}
		}

	}
