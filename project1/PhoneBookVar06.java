package project1;

import java.util.InputMismatchException;

import java.util.Scanner;

import project1.ver06.MenuSelectException;
import project1.ver06.MenuItem;
import project1.ver06.PhoneBookManager;

public class PhoneBookVar06 implements MenuItem{
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

	PhoneBookManager pbmanager = new PhoneBookManager(100);

	while(true) {
		try {
		printMenu();
		Scanner sc = new Scanner(System.in);
		int select=sc.nextInt();

		if(select<1||select>5) {
			MenuSelectException menuSelectException = new MenuSelectException();
			throw menuSelectException;
		}
		
	switch(select) {
	
	case DATAINPUT:
		pbmanager.dataInput();
		break;
	case DATASEARCH:
		pbmanager.dataSearch();
		break;
	case DATADELETE:
		//Date삭제
		pbmanager.dataDelete();
		break;
	case 4:
		//Date출력
		pbmanager.dataAllShow();
		break;
	case EXIT:
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}
		catch (InputMismatchException e) {
			System.out.println("문자가 입력되었습니다.");
			System.out.println("다시입력하십시요.");
			e.printStackTrace();
			continue;
		}
		catch (MenuSelectException e) {
			System.out.println("1~5 사이 범위가 아닙니다.");
			System.out.println("다시 입력하십시요.");
			continue;
			}
		}
	}//main end
}//end of main class