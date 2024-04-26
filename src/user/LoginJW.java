package user;

import java.util.Scanner;

import static user.RegisterUserJW.getUsers;

public class LoginJW {

    Scanner sc = new Scanner(System.in);
    public User login () {
        String inputId;
        while(true) {
            System.out.println("========== 로그인 ==========");
            System.out.println("# 로그인을 시작합니다.");
            System.out.print("# 아이디 : ");
            inputId = sc.nextLine();
            if(!isHasId(inputId)) {
                System.out.println("존재하는 아이디가 아닙니다.");
            } else {
                while (true) {
                    System.out.print("# 비밀번호 : ");
                    String inputPassword = sc.nextLine();
                    if (!isPassword(inputPassword, inputId)) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    } else {
                        String userName = RegisterUserJW.getUsers().get(inputId).getName();
                        System.out.printf("%s님 SeSeSeBank에 오신것을 환영합니다.\n", userName);
                        break;
                    }
                }
                break;
            }

        }
        return RegisterUserJW.getUsers().get(inputId);
    }

    public boolean isHasId (String inputId) {
        return RegisterUserJW.getUsers().containsKey(inputId);
    }

    public boolean isPassword (String inputPassword, String inputId) {
        return RegisterUserJW.getUsers().get(inputId).getBankPassword().equals(inputPassword);
    }
}
