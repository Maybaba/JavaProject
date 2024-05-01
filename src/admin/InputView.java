package admin;

import static util.SimpleInput.input;

//값을 입력하는 기능
public class InputView {


    public int inputMenuNumber() {

        int num = 0;
        boolean isValidInput = false;

        while(!isValidInput) {
            try {
                String menuNum = input("- 원하는 메뉴 번호를 입력해주세요: ");
                num = Integer.parseInt(menuNum);
                if (num == 0 || num == 1 || num == 2) {
                    isValidInput = true;
                } else { //0 or 1 or 2를 입력하지 않으면 예외 발생
                    System.out.println("1 또는 2를 입력하세요.");
                }
            } catch (NumberFormatException e) { //숫자 이외 문자를 입력하면 출력 예외 발생
                System.out.println("숫자를 입력해주세요.");
            }
        }
        return num;
    }

}


