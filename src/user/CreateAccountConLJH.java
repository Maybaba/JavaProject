package user;

import static user.CreateAccountLJH.*;
import static util.SimpleInput.input;

public class CreateAccountConLJH extends Account {
    private AccountType accountType;

    public CreateAccountConLJH() {};

    // user에서 받아온 객체를 생성해주는 생성자
    public CreateAccountConLJH(long balance, User user, int accountPassword, AccountType type, Account accountNum, long initialDepositBalance) {
        super(balance, user, accountPassword, type, String.valueOf(accountNum), initialDepositBalance);
        this.accountType = AccountType.TRANSFER;
    }

    // user의 객체를 받아 계좌를 만드는 함수
    public static void createAccount(User user) throws InterruptedException {
        try {
        createView();

        while (true) {
            String menuNum = input(" □▫∙︎ ︎");

            switch (menuNum) {
                case "1":
                    System.out.println("\n            ∙ ◻︎ 저축 예금 계좌를 선택하셨습니다 ◻︎ ▫");
                    Thread.sleep(1000);     // 딜레이를 만들어주는 내장 함수
                    System.out.println(" ◻︎ ◻︎ 현재 가입하실 수 있는 예금 상품으로는 금리 일 5%의 상품이 있습니다 ▫︎ □ ");
                    Thread.sleep(1000);
                    while (true) {
                        int fixed = 0;
                        try {       // 숫자가 아닐 시 try catch 로 오류 방지처리
                            fixed = Integer.parseInt(input("        가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n □▫∙ ").replace(" ",""));
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력해주세요");
                        }
                        if (fixed == 1) {
                            System.out.println("\n예금 계좌를 생성합니다.");
                            Thread.sleep(800);
                            createFixed(user);
                            break;
                        } else if (fixed == 2) {
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            createView();
                            break;
                        } else {
                            System.out.println("⁉️ 올바른 메뉴번호를 입력해주세요.");
                        }
                    }break;

                case "2":
                    System.out.println("\n              ◆ ☐ 적금 계좌를 선택하셨습니다. ∙ ▫︎");
                    Thread.sleep(1000);
                    System.out.println("▫︎ ◻︎ 현재 가입하실 수 있는 적금 상품으로는 금리 일 1%의 상품이 있습니다. ・ ☐");
                    Thread.sleep(1000);
                    while (true) {
                        int saving = 0;
                        try {
                            saving = Integer.parseInt(input("        가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n □▫∙ ").replace(" ",""));
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력해주세요");
                        }
                        if (saving == 1) {
                            System.out.println("\n적금 계좌를 생성합니다.");
                            createSaving(user);
                            break;
                        } else if (saving == 2) {
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            createView();
                            break;
                        } else {
                            System.out.println("⁉️ 올바른 메뉴번호를 입력해주세요.");
                        }
                    } break;
                case "3":
                    System.out.println("\n         ▫︎ 입출금 계좌를 선택하셨습니다. ・");
                    Thread.sleep(1000);
                    while (true) {

                        int saving = 0;
                        try {
                            saving = Integer.parseInt(input("        가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n□▫∙ ").replace(" ",""));
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력해주세요");
                        }
                        if (saving == 1) {
                            System.out.println("\n입출금 계좌를 생성합니다.");
                            createTransfer(user);
                            break;
                        } else if (saving == 2) {
                            System.out.println("🪬 이전 메뉴로 돌아갑니다.");
                            createView();
                            break;
                            // 메뉴이동
                        } else {
                            System.out.println("⁉️ 올바른 메뉴번호를 입력해주세요.");
                        }
                    }break;

                case "4":
                    boolean flag = exitProgram();
                    if (flag) return;
                    break;
                default:
                    System.out.println("⁉️ 올바른 메뉴 번호를 입력하세요!");
            }
        }
        } catch (InterruptedException e) {
            System.out.println("처리중 입니다 . . . . .");
        }
    }



    static boolean exitProgram() {
        while (true) {
            String exit = input("🪬 이전화면으로 가시겠습니까? [y/n]\n □▫∙︎ ");
            if (exit.equals("y")) {
                System.out.println("🪬 이전화면으로 돌아갑니다. 🪬");

                return true;
            } else if (exit.equals("n")) {
                createView();
                break;
            } else {
                System.out.println("종료를 원하신다면 y 를, 원하지 않는다면 n 를 입력해주세요.");
            }
        }
        return false;
    }

}


//CreateAccountConLJH.createAccount(RegisterUserJW.getUsers().get(inputId));