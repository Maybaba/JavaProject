package user;

import java.util.Scanner;

import static user.RegisterUserJW.getUsers;
import static util.SimpleInput.input;

public class LoginJW {

    Scanner sc = new Scanner(System.in);

    // 로그인을 담당하는 메서드
    public User login () {
        // 입력받는 아이디를 저장하는 변수
        String inputId;
        boolean isLogin = false;
        // 아이디, 비밀번호 검증 반복문
        login : while(true) {

            System.out.println("\n 🧼 ------------ 로그인 ----------- 🧼 ");
            System.out.println(" 로그인을 시작합니다.");
            System.out.println(" 로그인을 중단하려면 'x'를 입력해 주세요.");
            System.out.print(" 🧼 아이디 : ");
            inputId = sc.nextLine();
            if(inputId.equals("x")) break login;
            // 아이디가  유저 정보 저장소에 있는지 확인
            // 있다면 비밀번호 입력창으로 이동
            // 없다면 경고문 후 다시 아이디를 입력받음
            if(!isHasId(inputId)) {
                System.out.println(" ⁉️ 존재하는 아이디가 아닙니다.");
            } else {
                while (true) {
                    // 비밀번호를 입력받아 아이디가 가지는 비밀번호와 일치 여부 검사
                    // 일치하지 않다면 다시 비밀번호를 입력받음
                    // 일치한다면 로그인 성공 메세지 전송
                    System.out.print(" 🧼 비밀번호 : ");
                    String inputPassword = sc.nextLine();
                    if(inputPassword.equals("x")) break login;
                    if (!isPassword(inputPassword, inputId)) {
                        System.out.println(" ⁉️ 비밀번호가 일치하지 않습니다.");
                    } else {
                        String userName = RegisterUserJW.getUsers().get(inputId).getName();
                        System.out.printf(" □ ▫ %s님 SeSeSeBank에 오신것을 환영합니다. ▫ ∙︎\n", userName);
                        isLogin = true;
                        input("\n           press any key . . .");
                        break;
                    }
                }
                break;
            }

        }
        // 로그인 성공시 이 아이디와 비밀번호를 가지는 유저 정보 객체를 반환
        if(isLogin) {
            return RegisterUserJW.getUsers().get(inputId);
        } else {
            return null;
        }
    }


    // 아이디가 존재하는지 여부를 검사하는 메서드
    public boolean isHasId (String inputId) {
        return RegisterUserJW.getUsers().containsKey(inputId);
    }

    // 비밀번호가 입력한 아이디의 비밀번호와 일치하는지의 여부를 검사하는 메서드
    public boolean isPassword (String inputPassword, String inputId) {
        return RegisterUserJW.getUsers().get(inputId).getBankPassword().equals(inputPassword);
    }
}
