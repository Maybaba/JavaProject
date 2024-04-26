package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterUserJW {
    String menuNum;
    Scanner sc = new Scanner(System.in);
    List<User> user = new ArrayList<>();

    public void test () {
        System.out.println("========== SeSeSe Bank! ==========");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 프로그램 종료");
        System.out.println("==================================");
        System.out.println("메뉴를 선택하세요.");
        System.out.print(">> ");
        menuNum=sc.nextLine();
        System.out.println(menuNum);
    }


    public void registerUser () {
        System.out.println("========== 회원 가입 ==========");
        System.out.println("# 회원가입을 시작합니다.");
        System.out.print("아이디를 입력하세요.\n >> ");
        String userAccount = sc.nextLine();

    }


}