package user;

import static user.CreateAccountLJH.*;
import static user.SimpleInput.input;

public class CreateAccountConLJH extends Account {
    private AccountType accountType;

    public CreateAccountConLJH(long balance, User user, int accountPassword, AccountType type) {
        super(balance, user, accountPassword, type);
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
                    createFixed(user);
                    break;
                case "2":
                    createSaving(user);
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