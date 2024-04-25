package admin;

public class Bank {
    private double totalBalance; // 은행 총 잔고

    public double getTotalBalance() {
        return totalBalance;
    }

    public void updateTotalBalance(double amount) {
        // 은행 총 잔고 업데이트
        this.totalBalance += amount;
    }
}
