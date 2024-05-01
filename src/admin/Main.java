package admin;

import user.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        // 메뉴를 보여주는 기능
        OutputView outputView = new OutputView();
        outputView.MenuView();

        // 회원 정보가 들어있음.
        RegisterUserJW test = new RegisterUserJW();
        User testUser = RegisterUserJW.getUsers().get("qwe");
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.FIXED, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.SAVING, "1"));
        testUser.getMyAccount().add(new CreateAccountLJH(100, testUser, 1234, AccountType.TRANSFER, "1"));
        List<Account> accounts = testUser.getMyAccount();
        outputView.getTotalMoney(accounts);

        System.out.println();

        // 관리자로부터 메뉴 번호를 입력 받는 기능
        InputView inputView = new InputView();
        int menuNumber = inputView.inputMenuNumber();

        //1번을 입력 받았을 때 전체 고객 통잔 잔고를 반환하는 기능
        if(menuNumber == 1) {
            OutputView totalMoney = new OutputView();
            totalMoney.getTotalMoney();
        }

        // 2번을 입력 받았을 때 전체 고객 정보를 반환하는 기능
        if (menuNumber == 2) {
            OutputView getInfo = new OutputView();
            getInfo.getCustomerInfo(testUser);
        }
    }
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
