package user;

public interface UserInterface {
    void openAccount(); // 계좌 개설 기능
    void viewAllAccounts(); // 모든 계좌 조회 기능
    void transfer(); // 이체 기능
    void exchange(); // 환전 기능
    void viewStocks(); // 주식 관련 기능
    void moveToNextDay(); // 다음날로 이동 기능
}
