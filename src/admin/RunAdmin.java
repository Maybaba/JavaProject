package admin;

import user.*;

import java.util.List;

public class RunAdmin {

    public void play() {
        // 메뉴를 보여주는 기능
        OutputView outputView = new OutputView();
        outputView.showMenu();

        System.out.println();

        // 관리자로부터 메뉴 번호를 입력 받는 기능
        InputView inputView = new InputView();
        int menuNumber = inputView.inputMenuNumber();


        // 1번 입력 시 계좌 전체 잔액 반환 기능
        if (menuNumber == 1) {
            OutputView totalMoney = new OutputView();
            totalMoney.getTotalMoney(RegisterUserJW.getUsers());
        }

        // 2번을 입력 받았을 때 전체 고객 정보를 반환하는 기능
        if (menuNumber == 2) {
            OutputView getInfo = new OutputView();
            getInfo.getCustomerInfo(RegisterUserJW.getUsers());
        }



    }
}
