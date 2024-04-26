package user;

public class RunDepositYJ {

    public void depositController () {

        switch (menuNum) {
            case 1 :
                saveMonthly();
                break;

            case 2 :
                saveOnce();
                break;

            default: //뒤로 가는 기능
                before();
                break;

        }
        //if switch case 예금, 적금
        // 예금현황보기
        // 적금현황보기
    }

    public static void main(String[] args) {


    }
}
