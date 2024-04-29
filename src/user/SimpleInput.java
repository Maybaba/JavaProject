package user;

import java.util.Scanner;

// role : 스캐너 입력을 간소화해주는 객체
public class SimpleInput {
    //  private static Scanner sc = new Scanner(System.in);
    //아래의 방식을 따른다.
    private static Scanner sc;
    static  {
        sc = new Scanner(System.in);
    }


    //문자열 입력 처리
    public static String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    //엔터를 누르기 전까지 멈춰있는 기능
    public void stopInput() {
        System.out.println("==============엔터를 누르면 계속...==========");
        sc.nextLine();
    }
}