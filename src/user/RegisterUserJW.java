package user;

import java.util.*;

public class RegisterUserJW {
    private String menuNum;
    private Scanner sc = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<>();

    public RegisterUserJW () {
        users.put("qwe", new User("김철수", "qwe", "1234"));
    }

    public void test () {
        System.out.println("========== SeSeSe Bank! ==========");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 프로그램 종료");
        System.out.println("==================================");
        System.out.println("메뉴를 선택하세요.");
        System.out.print(">> ");
        menuNum=sc.nextLine();
        System.out.println(menuNum);
        if(menuNum.equals("1")) {
            registerUser();
        }
    }


    public void registerUser () {
        String bankId;
        String bankPassword1;
        System.out.println("========== 회원 가입 ==========");
        System.out.println("# 회원가입을 시작합니다.");
        System.out.print("이름를 입력하세요\n >> ");
        String userName = sc.nextLine();
            while(true) {
                System.out.print("아이디를 입력하세요\n >> ");
                bankId = sc.nextLine();
                if (isNewAccount(bankId)) {
                    System.out.println("이미 존재하는 아이디입니다.");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("비밀번호를 입력하세요\n >> ");
                bankPassword1 = sc.nextLine();
                System.out.print("비밀번호를 확인\n >> ");
                String bankPassword2 = sc.nextLine();
                if (isSamePassword(bankPassword1, bankPassword2)) {
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            }

            users.put(bankId, new User(userName, bankId, bankPassword1));
        System.out.printf("%s님의 회원가입이 완료되었습니다.\n", userName);

        System.out.println(users.get(bankId));
        System.out.println(users);
    }

    public boolean isNewAccount (String newAccount) {
        return users.containsKey(newAccount);
    }

    public boolean isSamePassword (String password1, String password2) {
        return password1.equals(password2);
    }

    public static Map<String, User> getUsers() {
        return users;
    }
}