package user;

import util.SimpleInput;

public class BankController {
    RegisterUserJW ru = new RegisterUserJW();
    LoginJW login = new LoginJW();
    UserInfoJW userInfo = new UserInfoJW();
    FindUserInfo fu = new FindUserInfo();
    DepositWithdrawalHS dw = new DepositWithdrawalHS();

    public void startMenu () {
        User loginUser;
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "1"));

        while (true) {

            System.out.println("\n========== SeSeSe Bank! ==========");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 아이디 & 비밀번호 변경");
            System.out.println("0. 프로그램 종료");
            System.out.println("==================================");
            System.out.println("메뉴를 선택하세요.");
            String menuNum = SimpleInput.input(">> ");

            switch (menuNum) {
                case "1":
                    ru.registerUser();
                    break;
                case "2":
                    loginUser = login.login();
                    if(loginUser != null) mainMenu(loginUser);
                    break;
                case "3":
                    fu.findUserInfo();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("정확한 메뉴 번호를 입력해 주세요.");
                    break;
            }
        }

    }

    private void mainMenu(User user) {
        while (true) {
            System.out.println("\n========== SeSeSe Bank! ==========");
            System.out.println("# 1. 마이페이지");
            System.out.println("# 2. 입-출금");
            System.out.println("# 0. 로그아웃");
            System.out.println("=====================================");
            System.out.println("메뉴를 선택하세요.");
            String mainMenuNum = SimpleInput.input(">> ");
            switch (mainMenuNum) {
                case "1":
                    userInfo.userInfo(user);
                    break;
                case "2":
                    dw.run(user);
                    break;
                case "0":
                    System.out.printf("%s님 안녕히가세요!\n", user.getName());
                    return;
                default:
                    System.out.println("정확한 메뉴 번호를 입력해 주세요.");
                    break;
            }
        }

    }

}
