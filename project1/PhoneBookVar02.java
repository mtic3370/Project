package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVar02 {
	    	//프로그램에서의 입력메뉴 출력
	public static void menuShow() {
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1.데이터입력");
		System.out.println("2.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
		
		//새로운 데이터 입력
	public static void addDate() {
			
			//사용자로부터 친구정보를 입력받기위한 준비
			Scanner scan = new Scanner(System.in);
			String iName,iPhone,iBirthday;
			
			System.out.print("이름:");iName = scan.nextLine();
			System.out.print("전화번호:");iPhone = scan.nextLine();
			System.out.print("생년월일:");iBirthday = scan.nextLine();
			PhoneInfo phoneInfo = new PhoneInfo(iName, iPhone, iBirthday);
			System.out.println("정보가 입력되었습니다.입력하신 정보는?");
			phoneInfo.showPhoneInfo();
	}
	public static void main(String[] args) {

		int choice;
		Scanner scan = new Scanner(System.in);
    	while(true) {
    		menuShow();
    		choice = scan.nextInt();
		switch(choice) {
		case 1:
			addDate();
			break;
		case 2:
			System.out.println("프로그램을 종료합니다.");
			return;//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}
	}
}