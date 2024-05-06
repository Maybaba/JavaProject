package user;

import util.SimpleInput;

import java.util.Map;

public class FindUserInfo {

    public void findUserInfo() {
        while (true) {
            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 아이디 & 비밀번호 찾기 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            System.out.println(" 1. 아이디 찾기");
            System.out.println(" 2. 비밀번호 찾기");
            System.out.println(" 0. 뒤로 가기");
            System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎ 원하시는 메뉴를 선택해주세요 ▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
            String menuNum = SimpleInput.input(" □▫∙︎ ︎");
            switch (menuNum) {
                case "1":
                    findId();
                    break;
                case "2":
                    findPassword();
                    break;
                case "0":
                    return;
            }
        }
    }

    private void findId() {
        Map<String, User> users = RegisterUserJW.getUsers();
        System.out.println("\n이름을 입력하세요.");
        System.out.println("아이디 찾기를 중단하시려면 'x'를 입력해 주세요.");
        String inputName = SimpleInput.input(" □▫∙︎ ");
        if(inputName.equals("x")) return;
        boolean exit = false;

            for (String s : users.keySet()) {
                if (users.get(s).getName().equals(inputName)) {
                    exit = true;
                    break ;
                }
            }

        if(!exit) {
            System.out.printf("⁉️ %s님의 가입정보가 존재하지 않습니다.", inputName);
            return;
        }
        boolean isTreasure = false;
        System.out.println("\n 🧼 자신의 보물 1호를 입력하세요.");
        String inputTreasure = user.SimpleInput.input(">> ");
        findId : for (String s : users.keySet()) {
            if(users.get(s).getMyTreasure().equals(inputTreasure)) {
                System.out.printf(" %s님의 아이디는 [ %s ]입니다.\n", inputName, s);
                isTreasure = true;
                break findId;
            }
        }
        if(!isTreasure) {
            System.out.printf("⁉️ %s님의 보물 1호는 [ %s ]가 아닙니다.", inputName, inputTreasure);
        }
    }

    private void findPassword () {
        System.out.println("\n비밀번호를 입력하세요.");
        System.out.println("비밀번호 변경을 중단하시려면 'x'를 입력해 주세요.");
        String inputId = SimpleInput.input(" □▫∙︎ ");
        Map<String, User> users = RegisterUserJW.getUsers();
        if(inputId.equals("x")) return;
        if(!users.containsKey(inputId)) {
            System.out.println("⁉️ 해당 비밀번호는 존재하지 않습니다.");
        } else {
            System.out.println("\n자신의 보물 1호를 입력해 주세요.");
            String inputTreasure = SimpleInput.input(" □▫∙︎ ");
            if(inputTreasure.equals("x")) return;
            if(!users.get(inputId).getMyTreasure().equals(inputTreasure)) {
                System.out.println(inputTreasure + "는 보물 1호가 아닙니다.");
            } else {

                while (true) {
                    System.out.printf("[ %s ]아이디의 비밀번호를 변경합니다.\n", inputId);
                    System.out.println("변경할 비밀번호를 입력하세요.(8~12자)");
                    String inputPassword = SimpleInput.input(">> ").trim().replace(" ", "");
                    if (inputPassword.equals("x")) return;
                    if (inputPassword.isEmpty()) {
                        System.out.println("비밀번호를 입력해 주세요.(공백, 띄워쓰기 제외)");
                    } else if (inputPassword.length() < 8 || inputPassword.length() > 12) {
                        System.out.println("비밀번호를 8~12자로 입력해 주세요.");
                    }else {
                        System.out.println("비밀번호 확인");
                        String inputPassword2 = SimpleInput.input(" □▫∙︎ ").trim();

                        if (inputPassword.equals(inputPassword2)) {
                            users.get(inputId).setBankPassword(inputPassword);
                            System.out.println(" ☐ □ 비밀번호 변경이 완료되었습니다 □ ∙ ");
                            break;
                        } else {
                            System.out.println("⁉️ 비밀번호가 일치하지 않습니다");
                        }
                    }

                }
            }

            }

        }


}
