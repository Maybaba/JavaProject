package user;


import java.util.Scanner;

public class MainJW {

    public static void main(String[] args) throws InterruptedException {
        RegisterUserJW test = new RegisterUserJW();
        LoginJW test2 = new LoginJW();
//        test.test();
//        User user = test2.login();
        User testUser = RegisterUserJW.getUsers().get("qwe");

        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "1"));
        System.out.println(user);

        DepositWithdrawalHS test3 = new DepositWithdrawalHS();
        test3.run(testUser);


    }
}
