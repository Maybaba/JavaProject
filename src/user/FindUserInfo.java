package user;

import util.SimpleInput;

import java.util.Map;

public class FindUserInfo {

    public void findUserInfo() {
        while (true) {
            System.out.println("\n========== 아이디 & 비밀번호 찾기 ==========");
            System.out.println("# 1. 아이디 찾기");
            System.out.println("# 2. 비밀번호 찾기");
            System.out.println("# 3. << 이전 페이지");
            System.out.println("==================================");
            System.out.println("메뉴를 선택하세요.");
            String menuNum = SimpleInput.input(">> ");
            switch (menuNum) {
                case "1":
                    findId();
                    break;
                case "2":
                    findPassword();
                    break;
                case "3":
                    return;
            }
        }
    }

    private void findId() {
        System.out.println("\n이름을 입력하세요.");
        String inputName = SimpleInput.input(">> ");
        boolean isName = false;
        Map<String, User> users = RegisterUserJW.getUsers();
        for (String s : users.keySet()) {
            if(users.get(s).getName().equals(inputName)) {
                System.out.printf("%s님의 아이디는 %s입니다.\n", inputName, s);
                isName = true;
            }
        }
        if(!isName) System.out.printf("%s님의 가입 정보가 없습니다.", inputName);
    }

    private void findPassword () {
        System.out.println("\n아이디를 입력하세요.");
        String inputId = SimpleInput.input(">> ");

        Map<String, User> users = RegisterUserJW.getUsers();
        for (String s : users.keySet()) {
            if(users.get(s).getBankId().equals(inputId)) {
                while (true) {
                    System.out.printf("%s 아이디의 비밀번호를 변경합니다.\n", inputId);
                    System.out.println("변경할 비밀번호를 입력하세요.");
                    String inputPassword = SimpleInput.input(">> ").trim();
                    if (inputPassword.isEmpty()) {
                        System.out.println("비밀번호를 입력해 주세요.(공백, 띄워쓰기 제외)");
                    } else {
                        System.out.println("비밀번호 확인");
                        String inputPassword2 = SimpleInput.input(">> ").trim();

                        if(inputPassword.equals(inputPassword2)) {
                            users.get(s).setBankPassword(inputPassword);
                            System.out.println("비밀번호 변경이 완료되었습니다.");
                            break;
                        } else {
                            System.out.println("비밀번호가 일치하지 않습니다.");
                        }
                    }

                }
            }

        }
    }

}
