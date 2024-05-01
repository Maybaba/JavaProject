package user;


import java.util.Random;
import java.util.Scanner;
import static user.SimpleInput.*;



public class CreateAccountLJH extends Account  {

    public static Scanner sc;
    private AccountType accountType;
    private static Account accountNum;



    //    List<User> users = TempAccountLJH.getUsers();
    public CreateAccountLJH(long balance, User user, int accountPassword, AccountType type, String accountNum ) {
        super(balance, user, accountPassword, type, String.valueOf(accountNum));
        Scanner sc;
    }
    public void Account(AccountType accountType) {
        this.accountType = accountType;
    }

    static {
        sc = new Scanner(System.in);

    }

    public static void createView() {
        System.out.println("\n=====================================");
        System.out.println("계좌를 개설합니다.\n사용하실 계좌의 종류를 선택해주세요.\n1. 예금 2. 적금 3. 입출금 4. 뒤로가기");
        System.out.println("=====================================");
    }






    public static void createTransfer(User user) throws InterruptedException {
        while (true) {
            if (userHasAccountOfType(user, AccountType.TRANSFER)) {
                Thread.sleep(1000);
                System.out.println("이미 생성된 적금 계좌가 있습니다.");
                Thread.sleep(1000);
                createView();
                break;
            }
            // 계좌 잔액은 0으로 시작
            long balance = 0;
            // 계좌 비밀번호 생성
            int transferPassword = Integer.parseInt(input("\n사용하실 비밀번호를 입력해주세요.\n>> "));

            // 입출금 계좌 생성
            String accountNum = generateAccountNumber();  // 랜덤 계좌번호
            Account transferAccount = new Account(balance, user, transferPassword, AccountType.TRANSFER, accountNum);

            // 초기 입금 설정
            System.out.println("\n초기 납입 금액을 설정합니다. 초기 금액은 30만원 이하로 입금이 가능합니다.");
            Thread.sleep(1500);
            long firstDepositSav;
            while (true) {
                while (true) {
                    long userMoney = user.getMyMoney();
                    firstDepositSav = Integer.parseInt(input("\r금액을 입력해주세요.\n>> "));
                    if (firstDepositSav < 300000 && firstDepositSav <= userMoney) {     // 금액확인
                        break;
                    } else if (userMoney < firstDepositSav) {
                        System.out.println("잔고가 부족합니다. 올바른 금액을 입력해주세요.");
                    }
                }
                break;
            }
            long finalBalance = transferAccount.getBalance() + firstDepositSav;
            transferAccount.setBalance(finalBalance);

            // 사용자에게 알림
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("..");
            Thread.sleep(700);
            System.out.println("...");
            Thread.sleep(1200);
            System.out.println("....");
            Thread.sleep(700);
            System.out.println("요청하신 입출금 계좌가 생성되었습니다.\n감사합니다.\n");
            Thread.sleep(1800);
            System.out.println("=====================================");

            // 사용자 정보는 로그인한 해당 회원으로 지정
            user.getMyAccount().add(transferAccount);
            System.out.println("계좌번호 : " + transferAccount.getAccountNum());
            System.out.println("현재잔액 : " + transferAccount.getBalance());
            System.out.println("=====================================\n\n");
            createView();
            break;
        }
    }

    public static void createSaving(User user) throws InterruptedException {
        while (true) {
            if (userHasAccountOfType(user, AccountType.SAVING)) {
                Thread.sleep(1000);
                System.out.println("이미 생성된 적금 계좌가 있습니다.");
                Thread.sleep(1000);
                createView();
                break;
            }
            // 계좌 잔액은 0으로 시작
            long balance = 0;
            // 계좌 비밀번호 생성
            int savingPassword = Integer.parseInt(input("\n사용하실 비밀번호를 입력해주세요.\n>> "));

            // 적금 계좌 생성
            String accountNum = generateAccountNumber();  // 랜덤 계좌번호
            Account savingAccount = new Account(balance, user, savingPassword, AccountType.SAVING, accountNum);
            // 납입금액 제한 걸어야함

            // 초기 입금 설정
            System.out.println("\n초기 납입 금액을 설정합니다. 초기 금액은 30만원 이하로 입금이 가능합니다.");
            Thread.sleep(1500);
            long firstDepositSav;
            while (true) {
                while (true) {
                    long userMoney = user.getMyMoney();
                    firstDepositSav = Integer.parseInt(input("\r금액을 입력해주세요.\n>> "));
                    if (firstDepositSav < 300000 && firstDepositSav <= userMoney) {
                        break;
                    } else if (userMoney < firstDepositSav) {
                        System.out.println("잔고가 부족합니다. 올바른 금액을 입력해주세요.");
                    }
                }
                break;
            }
            long finalBalance = savingAccount.getBalance() + firstDepositSav;
            savingAccount.setBalance(finalBalance);

            // 사용자에게 알림
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("..");
            Thread.sleep(700);
            System.out.println("...");
            Thread.sleep(1200);
            System.out.println("....");
            Thread.sleep(700);
            System.out.println("요청하신 적금 계좌가 생성되었습니다.\n감사합니다.\n");
            Thread.sleep(1800);
            System.out.println("=====================================");

            // 사용자 정보는 로그인한 해당 회원으로 지정
            user.getMyAccount().add(savingAccount);
            System.out.println("계좌번호 : " + savingAccount.getAccountNum());
            System.out.println("현재잔액 : " + savingAccount.getBalance());
            System.out.println("=====================================\n\n");
            createView();
            break;
        }
    }

    public static void createFixed(User user) throws InterruptedException {


        // 예금 계좌 생성
        while (true) {
            if (userHasAccountOfType(user, AccountType.FIXED)) {
                Thread.sleep(1000);
                System.out.println("이미 생성된 예금 계좌가 있습니다.");
                Thread.sleep(1000);
                createView();
                break;
            }
            // 계좌 잔액은 0으로 시작
            long balance = 0;
            // 계좌 비밀번호 생성
            int fixedPassword = Integer.parseInt(input("\n사용하실 비밀번호를 입력해주세요.\n>> "));
            String accountNum = generateAccountNumber();  // 랜덤 계좌번호
            Account fixedAccount = new Account(balance, user, fixedPassword, AccountType.FIXED, accountNum);


            // 초기 입금 설정
            System.out.println("\n초기 납입 금액을 설정합니다. 초기 금액은 30만원 이하로 입금이 가능합니다.");
            Thread.sleep(1500);
            long firstDepositSav;
            while (true) {
                while (true) {
                    long userMoney = user.getMyMoney();
                    firstDepositSav = Integer.parseInt(input("\r금액을 입력해주세요.\n>> "));
                    if (firstDepositSav < 300000 && firstDepositSav <= userMoney) {
                        break;
                    } else {
                        System.out.println("잔고가 부족합니다. 올바른 금액을 입력해주세요.");
                    }
                }
                break;
            }
            long finalBalance = fixedAccount.getBalance() + firstDepositSav;
            fixedAccount.setBalance(finalBalance);

            // 사용자에게 알림
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("..");
            Thread.sleep(700);
            System.out.println("...");
            Thread.sleep(1200);
            System.out.println("....");
            Thread.sleep(700);
            System.out.println("요청하신 예금 계좌가 생성되었습니다.\n감사합니다.\n");
            Thread.sleep(1800);
            System.out.println("=====================================");

            // 사용자 정보는 로그인한 해당 회원으로 지정
            user.getMyAccount().add(fixedAccount);
            System.out.println("계좌번호 : " + fixedAccount.getAccountNum());
            System.out.println("현재잔액 : " + fixedAccount.getBalance());
            System.out.println("=====================================\n\n");
            createView();
            break;
        }
    }


    // 계좌번호를 생성하는 함수
    static String generateAccountNumber() {
        Random random = new Random();
        String accountNum = String.format("%03d-%06d-%03d", random.nextInt(1000), random.nextInt(1000000), random.nextInt(1000));
        return accountNum;
    }


    // 사용자가 이미 해당 타입의 계좌를 가지고 있는지 확인
    private static boolean userHasAccountOfType(User user, AccountType type) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType() == type) {
                return true;
            }
        }
        return false;
    }
}
