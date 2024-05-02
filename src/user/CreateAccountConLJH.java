package user;

import static user.CreateAccountLJH.*;

import static user.SimpleInput.input;

public class CreateAccountConLJH extends Account {
    private AccountType accountType;

    public CreateAccountConLJH() {};

    public CreateAccountConLJH(long balance, User user, int accountPassword, AccountType type, Account accountNum) {
        super(balance, user, accountPassword, type, String.valueOf(accountNum));
        this.accountType = AccountType.SAVING;
        this.accountType = AccountType.FIXED;
        this.accountType = AccountType.TRANSFER;
    }


    public static void createAccount(User user) throws InterruptedException {
        try {
        createView();

        while (true) {
            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    System.out.println("\n저축 예금 계좌를 선택하셨습니다.");
                    Thread.sleep(1000);
                    System.out.println("현재 가입하실 수 있는 예금 상품으로는 금리 일 5%의 상품이 있습니다.");
                    Thread.sleep(1500);
                    while (true) {
                        int fixed = Integer.parseInt(input("가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n>> "));
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
                            System.out.println("올바른 메뉴번호를 입력해주세요.");
                        }
                    }break;

                case "2":
                    System.out.println("\n적금 계좌를 선택하셨습니다.");
                    Thread.sleep(1000);
                    System.out.println("현재 가입하실 수 있는 적금 상품으로는 금리 일 1%의 상품이 있습니다.");
                    Thread.sleep(1500);
                    while (true) {
                        int saving = Integer.parseInt(input("가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n>> "));
                        if (saving == 1) {
                            System.out.println("\n적금 계좌를 생성합니다.");
                            createSaving(user);
                            break;
                        } else if (saving == 2) {
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            createView();
                            break;
                        } else {
                            System.out.println("올바른 메뉴번호를 입력해주세요.");
                        }
                    } break;
                case "3":
                    System.out.println("\n입출금 계좌를 선택하셨습니다.");
                    Thread.sleep(1000);
                    while (true) {
                        int saving = Integer.parseInt(input("가입을 원하신다면 1번을 아니면 2번을 입력해주세요.\n>> "));
                        if (saving == 1) {
                            System.out.println("\n입출금 계좌를 생성합니다.");
                            createTransfer(user);
                            break;
                        } else if (saving == 2) {
                            System.out.println("이전 메뉴로 돌아갑니다.");
                            createView();
                            break;
                            // 메뉴이동
                        } else {
                            System.out.println("올바른 메뉴번호를 입력해주세요.");
                        }
                    }break;

                case "4":
                    boolean flag = exitProgram();
                    if (flag) return;
                    break;
                default:
                    System.out.println("# 올바른 메뉴 번호를 입력하세요!");
            }
        }
        } catch (InterruptedException e) {
            System.out.println("처리중 입니다 . . . . .");
        }
    }



    static boolean exitProgram() {
        while (true) {
            String exit = input("- 이전화면으로 가시겠습니까? [y/n]\n>> ");
            if (exit.equals("y")) {
                System.out.println("이전화면으로 돌아갑니다.");

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