package user;

import util.SimpleInput;

public class BankController {

    RegisterUserJW ru = new RegisterUserJW();
    LoginJW login = new LoginJW();
    UserInfoJW userInfo = new UserInfoJW();
    FindUserInfo fu = new FindUserInfo();

    public void startMenu () {
        User loginUser;
        while (true) {
            System.out.println("\n========== SeSeSe Bank! ==========");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 아이디 & 비밀번호 변경");
            System.out.println("4. 프로그램 종료");
            System.out.println("==================================");
            System.out.println("메뉴를 선택하세요.");
            String menuNum = SimpleInput.input(">> ");
            switch (menuNum) {
                case "1":
                    ru.registerUser();
                    break;
                case "2":
                    loginUser = login.login();
                    System.out.println(RegisterUserJW.getUsers());
                    mainMenu(loginUser);

                    break;
                case "3":
                    fu.findUserInfo();
                    break;
                case "4":
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
            System.out.println("# 2. ...");
            System.out.println("# 3. 로그아웃");
            System.out.println("=====================================");
            System.out.println("메뉴를 선택하세요.");
            String mainMenuNum = SimpleInput.input(">> ");
            switch (mainMenuNum) {
                case "1":
                    userInfo.userInfo(user);
                    break;
                case "2":
                    break;
                case "3":
                    return;
                default:
                    System.out.println("정확한 메뉴 번호를 입력해 주세요.");
                    break;
            }
        }

    }

}
