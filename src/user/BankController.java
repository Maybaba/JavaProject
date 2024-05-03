package user;

import admin.RunAdmin;
import util.SimpleInput;

import java.util.Scanner;

import static user.DepositCtrlYJ.depositMenu;

public class BankController {
    RegisterUserJW ru = new RegisterUserJW();
    LoginJW login = new LoginJW();
    UserInfoJW userInfo = new UserInfoJW();
    FindUserInfo fu = new FindUserInfo();
    DepositWithdrawalHS dw = new DepositWithdrawalHS();
    CreateAccountConLJH ca = new CreateAccountConLJH();
    RunAdmin admin = new RunAdmin();

    public void startMenu () throws InterruptedException {
        User loginUser;
        //테스트용 계정
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "1"));


            while (true) {

            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ SeSeSe Bank ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            System.out.println(" 1. 회원가입");
            System.out.println(" 2. 로그인");
            System.out.println(" 3. 아이디 & 비밀번호 찾기");
            System.out.println(" 0. 프로그램 종료");
            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎ 원하시는 메뉴를 선택해주세요 ▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            String menuNum = SimpleInput.input(" □▫∙︎ ︎");

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
                case "9999":
                    admin.play();
                    break;
                case "0":
                    System.out.println(" 🪬 프로그램을 종료합니다 🪬 ");
                    return;
                default:
                    System.out.println(" 👻 정확한 메뉴 번호를 입력해 주세요");
                    break;
            }
        }

    }

    private void mainMenu(User user) throws InterruptedException {
        while (true) {
            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ SeSeSe Bank ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            System.out.println(" 1. 마이페이지");
            System.out.println(" 2. 입금 ∙ 출금");
            System.out.println(" 3. 계좌 개설");
            System.out.println(" 4. 예금 ∙ 적금");
            System.out.println(" 0. 로그아웃");
            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎ 원하시는 메뉴를 선택해주세요 ▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            System.out.println("메뉴를 선택하세요.");
            String mainMenuNum = SimpleInput.input(" □▫∙︎ ︎");
            switch (mainMenuNum) {
                case "1":
                    userInfo.userInfo(user);
                    System.out.println(" \n press any key ...");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
                case "2":
                    dw.run(user);
                    break;
                case "3":
                    CreateAccountConLJH.createAccount(user);
                    break;
                case "4":
                    depositMenu(user);
                    break;
                case "0":
                    System.out.printf("\n ∙ ◻︎ %s님이 로그아웃 하였습니다 ◻︎ ▫\n\n    ◻︎ ▫ have a good day ∙ ◻︎ \n", user.getName());
                    Scanner s = new Scanner(System.in);
                    s.nextLine();
                    return;
                default:
                    System.out.println(" ⁉️ 정확한 메뉴 번호를 입력해 주세요");
                    break;
            }
        }

    }

}
