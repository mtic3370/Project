package project1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import project1.ver03.PhoneBookManager;
import project1.ver03.PhoneInfo;

public class PhoneBookVar03 {
    	//프로그램에서의 입력메뉴 출력
public static void printMenu() {
System.out.println("***메뉴를 선택하세요***");
System.out.println("1.데이터입력");
System.out.println("2.데이터 검색");
System.out.println("3.데이터 삭제");
System.out.println("4.주소록 출력");
System.out.println("5.프로그램 종료");
System.out.print("메뉴선택>>>");
}
	
public static void main(String[] args) {

	PhoneBookManager handler =
			new PhoneBookManager(100);
		int choice;
	Scanner scan = new Scanner(System.in);
	while(true) {
		printMenu();
		
		choice = scan.nextInt();
	switch(choice) {
	
	case 1:
		handler.dataInput();
		break;
	case 2:
		//Date검색
		handler.dataSearch();
		break;
	case 3:
		//Date삭제
		handler.dataDelete();
	case 4:
		//Date출력
		handler.dataAllShow();
		break;
	case 5:
		System.out.println("프로그램을 종료합니다.");
		return;//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}
	}//main end
}//end of main class