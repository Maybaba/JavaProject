package user;

import static user.CreateAccountLJH.*;
import static user.SimpleInput.input;

public class CreateAccountConLJH extends Account {
    private AccountType accountType;

    public CreateAccountConLJH(long balance, User user, int accountPassword, AccountType type, Account accountNum) {
        super(balance, user, accountPassword, type, String.valueOf(accountNum));
        this.accountType = AccountType.SAVING;
        this.accountType = AccountType.FIXED;
        this.accountType = AccountType.TRANSFER;
    }


    public static void createAccount(User user) throws InterruptedException {
        createView();

        while (true) {
            String menuNum = input(" >>");

            switch (menuNum) {
                case "1":
                    System.out.println("\n저축 예금 계좌를 선택하셨습니다.");
                    Thread.sleep(1000);
                    System.out.println("현재 가입하실 수 있는 예금 상품으로는 금리 일 5%의 상품이 있습니다.");
                    Thread.sleep(2000);
                    int fixed = Integer.parseInt(input("가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n>>"));
                    if (fixed == 1) {
                        System.out.println("예금 계좌를 생성합니다.");
                        createFixed(user);
                        break;
                    } else if (fixed == 2){
                        System.out.println("이전 메뉴로 돌아갑니다.");
                        // 메뉴이동
                    }

                case "2":
                    System.out.println("적금 계좌를 선택하셨습니다.");
                    Thread.sleep(1000);
                    System.out.println("현재 가입하실 수 있는 적금 상품으로는 금리 일 1%의 상품이 있습니다.");
                    Thread.sleep(2000);
                    int saving = Integer.parseInt(input("가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n>>"));
                    if (saving == 1) {
                        System.out.println("적금 계좌를 생성합니다.");
                        createSaving(user);
                        break;
                    } else if (saving == 2){
                        System.out.println("이전 메뉴로 돌아갑니다.");
                        // 메뉴이동

                    }

                    break;
                case "3":
                    createTransfer(user);
                    break;
                case "4":
                    boolean flag = exitProgram();
                    if (flag) return;
                    break;
                default:
                    System.out.println("# 올바른 메뉴 번호를 입력하세요!");
            }
        }
    }


    static boolean exitProgram() {
        String exit = input("- 프로그램을 종료합니까? [y/n]\n>> ");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다!");
            return true;
        }
        else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }
    }
}


//CreateAccountConLJH.createAccount(RegisterUserJW.getUsers().get(inputId));