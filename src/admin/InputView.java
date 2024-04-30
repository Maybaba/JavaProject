package admin;

import static util.SimpleInput.input;

//값을 입력하는 기능
public class InputView {


    public int inputMenuNumber() {

        int num = 0;
        boolean isValidInput = false;

        while(!isValidInput) {
            try { //예외가능성이 있는 코드
                String menuNum = input("- 원하는 메뉴 번호를 입력해주세요: ");
                num = Integer.parseInt(menuNum);
                if (num == 1 || num == 2) {
                    isValidInput = true;
                } else {
                    System.out.println("1 또는 2를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
        return num;
    }
}


