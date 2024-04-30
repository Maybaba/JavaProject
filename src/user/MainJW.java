package user;


public class MainJW {

    public static void main(String[] args) throws InterruptedException {
        RegisterUserJW test = new RegisterUserJW();
        LoginJW test2 = new LoginJW();
//        test.test();
//        User user = test2.login();
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "111-111111-111"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "111111111"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "213-123542"));
        System.out.println(testUser);
//        createAccount(user);
//        System.out.println(user);

        DepositViewYJ start = new DepositViewYJ();
        start.depositMenu(testUser);

    }
}
