package user;
class NextdayCountYJ {
    
    //field
    private static final NextdayCountYJ instance = new NextdayCountYJ();
    int nextDay; // CHECKNEXTDAY가 계속 0으로 초기화 되어야 함
    int nextDaya; // CHECKNEXTDAY가 계속 0으로 초기화 되어야 함

    // 현재 날짜를 이전 날짜로 업데이트하고 현재 날짜를 새로운 날짜로 설정
    //다음날로 지나갔을때 이전날 = 오늘의 날 대입
    public void moveToNextDay() {
//        addDayAccount();
        nextDay++;
        nextDaya++;
    }

    // 다음날로 넘어갔는지 확인하는 메서드
    boolean checkNextDay() {
        if (nextDay == 0) {
             return false; // 첫 호출일 때는 다음날로 넘어가지 않은 것으로 간주
        } else {
            nextDay = 0; //이미 1인 값을 0으로 초기화
            // System.out.println("실험 로그 : 하루 재 초기화 됨.");
            return true; // 이미 다음날로 넘어간 상태
        }
    }
    boolean checkNextDay2() {
        if (nextDaya == 0) {
            return false; // 첫 호출일 때는 다음날로 넘어가지 않은 것으로 간주
        } else {
            nextDaya = 0; //이미 1인 값을 0으로 초기화
            //System.out.println("실험 로그 : 하루가 초기화되었습니다.");
            return true; // 이미 다음날로 넘어간 상태
        }
    }
    // 하루를 초기화하는 메서드
    void resetDay() {
        nextDay = 0;
    }  static NextdayCountYJ getInstance() {
        return instance;
    }

}
