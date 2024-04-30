package admin;

import user.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        OutputView outputView = new OutputView();
        outputView.selectMenu();

        RegisterUserJW test = new RegisterUserJW();
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "1"));

        List<Account> accounts = testUser.getMyAccount();

        outputView.getTotalMoney(accounts);

        System.out.println();

        //메뉴 번호를 입력 받음
        InputView inputView = new InputView();
        int menuNumber = inputView.inputMenuNumber();

//        if(menuNumber == 1) {
//            OutputView totalMoney = new OutputView();
//            totalMoney.getTotalMoney();
//        }
        if(menuNumber == 2) {
            OutputView getInfo = new OutputView();
            getInfo.getCustomerInfo(testUser);
        }





//        init();
//
//            private static init() {
//
//            UserRepository userRepository = new UserRepository();
//
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//            userRepository.save(new User("김은지", "정상", "eunji234", "1234", "2424.04.27", "1,000,000"));
//        }

    }
}
