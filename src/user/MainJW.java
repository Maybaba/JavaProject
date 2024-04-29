package user;


public class MainJW {

    public static void main(String[] args) throws InterruptedException {
        RegisterUserJW test = new RegisterUserJW();
        LoginJW test2 = new LoginJW();
        test.test();
        User user = test2.login();
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER));
        System.out.println(testUser);
//        createAccount(user);
//        System.out.println(user);


    }
}
