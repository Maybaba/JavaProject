package user;



import java.util.List;
import java.util.Scanner;
import static user.SimpleInput.*;



public class CreateAccountLJH extends Account  {

    public static Scanner sc;
    private AccountType accountType;
//    List<User> users = TempAccountLJH.getUsers();
    public CreateAccountLJH(long balance, User user, int accountPassword, AccountType type) {
        super(balance, user, accountPassword, type);
        Scanner sc;
    }
    public void Account(AccountType accountType) {
        this.accountType = accountType;
    }

    static {
        sc = new Scanner(System.in);

    }

    public static void createView() {
        System.out.println("=====================================");
        System.out.println("계좌를 개설합니다.\n사용하실 계좌의 종류를 선택해주세요.\n1. 예금 2. 적금 3. 입출금");
        System.out.println("=====================================\n");
    }

// 입금 추가해서 넣기
    //


    public static void createTransfer(User user) throws InterruptedException {
        // 계좌 잔액은 0으로 시작
        long balance = 0;
        // 계좌 비밀번호 생성
        int transferPassword = Integer.parseInt(input("사용하실 비밀번호를 입력해주세요.\n>>"));
        // 예금 계좌 생성
        Account transferAccount = new Account(balance, user, transferPassword, AccountType.TRANSFER);
        // 사용자에게 알림
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println("요청하신 예금 계좌가 생성되었습니다. 감사합니다.");
        System.out.println("==============================================");
        // 사용자 정보는 로그인한 해당 회원으로 지정
        user.getMyAccount().add(transferAccount);
        System.out.println(user);
        System.out.println("=============================");
        createView();




    }

    public static void createSaving(User user) throws InterruptedException {
        // 계좌 잔액은 0으로 시작
        long balance = 0;

        // 계좌 비밀번호 생성
        int savingPassword = Integer.parseInt(input("사용하실 비밀번호를 입력해주세요.\n>>"));
        // 예금 계좌 생성
        Account savingAccount = new Account(balance, user, savingPassword, AccountType.SAVING);
        // 사용자에게 알림
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println("요청하신 적금 계좌가 생성되었습니다. 감사합니다.");
        System.out.println("==============================================");
        // 사용자 정보는 로그인한 해당 회원으로 지정
        user.getMyAccount().add(savingAccount);
        System.out.println(user);
        System.out.println("=============================");
        createView();
    }

    public static void createFixed(User user) throws InterruptedException {
        // 계좌 잔액은 0으로 시작
        long balance = 0;
        // 계좌 비밀번호 생성
        int fixedPassword = Integer.parseInt(input("사용하실 비밀번호를 입력해주세요.\n>>"));
        // 예금 계좌 생성
        Account fixedAccount = new Account(balance, user, fixedPassword, AccountType.FIXED);
        // 사용자에게 알림
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("..");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println("요청하신 예금 계좌가 생성되었습니다. 감사합니다.");
        System.out.println("==============================================");
        // 사용자 정보는 로그인한 해당 회원으로 지정
        user.getMyAccount().add(fixedAccount);
        System.out.println(user);
        System.out.println("=============================");
        createView();

    }





}
