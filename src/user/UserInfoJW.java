package user;



public class UserInfoJW {


    // 매개변수로 받은 User의 정보를 보여주는 메서드
    public void userInfo(User user) {
        System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ SeSeSe Bank ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
        System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 회원 정보 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");
        System.out.println("# 이름 : " + user.getName());
        System.out.println("# 아이디 : " + user.getBankId());
        System.out.println("# 가입일 : " + user.getNowDate());
        System.out.println("\n 🧼 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 보유 계좌 ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ 🧼 ");

        // 통장 호출시 번호를 매기기 위한 지역변수
        int accountCount = 1;
        String accountType;
        // 총 잔고를 표시하기 위한 지역변수
        long totalBalance = 0;

        for (Account account : user.getMyAccount()) {
            // enum Type에 따른 무슨 통장인지 한글로 나타내기 위한 메서드 호출
            accountType = accountType(account.getAccountType());
            System.out.println("\n" + accountCount + ". " + accountType);
            System.out.println("# 계좌번호 : " + account.getAccountNum());
            System.out.println("# 잔액 : " + account.getBalance()+ "원");
            // 통장을 호출할때마다 잔액을 총 잔액에 더해줌
            totalBalance += account.getBalance();
            System.out.println("# 개설 일자 : " + account.getOpenAccountDate());
            System.out.println("# 최대 이체 한도 : " + account.getSingleTransferLimit());
            accountCount++;
        }
        System.out.println(" ☐ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎");
        user.setMyMoney(totalBalance);
        System.out.println("\n 🧼 총 잔액 : " + user.getMyMoney() + "원");
    }


    public String accountType (AccountType type) {
        switch (type) {
            case SAVING:
                return "적금통장";
            case FIXED:
                return "예금통장";
            case TRANSFER:
                return "입출금통장";
        }
        return "보유 통장 없음";
    }
}
