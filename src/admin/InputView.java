package admin;

import static util.SimpleInput.input;

//값을 입력하는 기능
public class InputView {

    public int inputMenuNumber() {
        String menuNum = input("- 원하는 메뉴 번호를 입력해주세요: ");

        try {
            int num = Integer.parseInt(menuNum);
            if (menuNum.length() == 1 && (num == 1 || num == 2)) {
                return num;
            } else {
                throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}

