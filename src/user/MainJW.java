package user;

public class MainJW {

    public static void main(String[] args) {
        RegisterUserJW test = new RegisterUserJW();
        LoginJW test2 = new LoginJW();
        test.test();
        User user = test2.login();
        System.out.println(user);


    }
}
