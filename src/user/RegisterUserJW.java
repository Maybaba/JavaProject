package user;

import java.util.*;

import static util.Colors.*;
import static util.SimpleInput.input;

public class RegisterUserJW {

    private String menuNum;
    private Scanner sc = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<>();

    public RegisterUserJW () {
        users.put("qwe", new User("김철수", "qwe", "1234", "돈"));
    }
    public void test () {
        System.out.println("\n 🧼 ------------ SeSeSe Bank ---------- 🧼 ");

        System.out.println(" 1. 회원가입");
        System.out.println(" 2. 로그인");
        System.out.println(" 3. 프로그램 종료");
        System.out.println("\n 🧼 ------- 원하는 메뉴를 선택해 주세요 ------- 🧼 ");
        System.out.print(" □▫∙︎ ︎");
        menuNum=sc.nextLine();
        System.out.println(menuNum);
        if(menuNum.equals("1")) {
            registerUser();
        }
    }

    /**
     * 회원가입을 담당하는 메서드
     */
    public void registerUser () {
        String bankId;
        String bankPassword1;
        String userTreasure;
        String userName;
        System.out.println("\n 🧼 -------------- 회원 가입 -------------- 🧼 ");
        System.out.println(" 회원가입을 시작합니다.");
        System.out.println(" 회원가입을 중지하시려면 'x'를 입력해 주세요.");
        exit: while(true) {
            while (true) {
                System.out.print("🧼 이름 :");
                // 이름, 아이디, 비밀번호를 입력받을 시 trim 을 통해 공백(띄워쓰기)을 없앤 상태로 저장
                userName = sc.nextLine().trim().replace(" ", "");
                if (userName.equals("x")) break exit;
                // 1. 입력한 이름이 공백이거나, 띄워쓰기만 했을경우 경고문 출력 후 다시 이름 입력받음
                if (userName.isEmpty()) {
                    System.out.println(" ⁉️ 이름을 제대로 입력해 주세요");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("🧼 아이디 :");
                bankId = sc.nextLine().trim().replace(" ", "");
                if (bankId.equals("x")) break exit;
                // 2. 아이디도 이름과 마찬가지로 공백, 띄워쓰기 여부를 검증함
                if (bankId.isEmpty()) {
                    System.out.println("⁉️ 아이디를 제대로 입력해 주세요");
                    // 3. 입력받은 아이디가 존재할 경우 경고문 출력 후 다시 입력받음
                    // 아이디가 존재하지 않을경우 비밀번호를 입력받음
                } else if (isNewAccount(bankId)) {
                    System.out.println("⁉️ 이미 존재하는 아이디 입니다");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("🧼 비밀번호 입력 (8~12자) :");
                bankPassword1 = sc.nextLine().trim().replace(" ", "");
                if (bankPassword1.equals("x")) break exit;

                if (bankPassword1.trim().isEmpty()) {
                    System.out.println(" ⁉️ 비밀번호를 입력해 주세요.");
                } else if (bankPassword1.length() < 8 || bankPassword1.length() > 12) {
                    System.out.println(" ⁉️ 비밀번호를 8~12자로 입력해 주세요");
                } else {
                    // 비밀번호, 비밀번호 확인 총 2번을 입력받는다.
                    // 2번에 걸쳐 입력받은 비밀번호들이 일치하는지에 대한 여부를 검증
                    // 일치한다면 회원가입 성공, 불일치 할 경우 다시 비밀번호를 입력받는다.
                    System.out.print("🪬🪬 비밀번호를 확인 :");
                    String bankPassword2 = sc.nextLine().trim().replace(" ", "");
                    if (bankPassword2.equals("x")) break exit;
                    if (isSamePassword(bankPassword1, bankPassword2)) {
                        break;
                    } else {
                        System.out.println(" ⁉️ 비밀번호가 일치하지 않습니다");
                    }
                }
            }
            while (true) {
                System.out.print("🧼 자신의 보물 1호(비밀번호 힌트)를 입력하세요\n □▫∙︎");
                // 이름, 아이디, 비밀번호를 입력받을 시 trim 을 통해 공백(띄워쓰기)을 없앤 상태로 저장
                userTreasure = sc.nextLine().trim().replace(" ", "");
                if (userTreasure.equals("x")) break exit;
                // 1. 입력한 이름이 공백이거나, 띄워쓰기만 했을경우 경고문 출력 후 다시 이름 입력받음
                if (userTreasure.isEmpty()) {
                    System.out.println("⁉️ 자신의 보물 1호를 입력해 주세요.");
                } else {
                    break;
                }
            }

            // 입력받은 이름, 아이디, 비밀번호를 가지고 새로운 User 객체를 생성 후
            // Map<String, User>에 저장
            users.put(bankId, new User(userName, bankId, bankPassword1, userTreasure));
            System.out.printf(blue + " ☐ □ %s님의 회원가입이 완료되었습니다. □ ∙ \n" + exit, userName);
            input("\n       press any key . . . ");
            break;
        }
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