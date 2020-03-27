package project1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import project1.ver03.PhoneInfo;


class PhoneInfoHandler {
	private PhoneInfo[] info;
	private int numOfInfo;//친구정보를 추가할때마다 +1 증가
 
	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
	public PhoneInfoHandler(int num) {
		info = new PhoneInfo[num];
		numOfInfo = 0;
	}

	//새로운 데이터 입력
	public void dataInput() {
		
		//사용자로부터 친구정보를 입력받기위한 준비
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iBirthday;
		
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("생년월일:");iBirthday = scan.nextLine();
		System.out.println("정보가 입력되었습니다.");
		
		info[numOfInfo++] = new PhoneInfo(iName, iPhone, iBirthday);
		
	}////end of dataInput
	

public void dataAllShow() {
	for(int i=0 ; i<numOfInfo ; i++) {
		info[i].showPhoneInfo();
		}

	System.out.println("==전체정보가 출력되었습니다==");
}////end of dataAllShow

//주소록 검색
public void dataSearch() {
	Scanner scan = new Scanner(System.in);
	System.out.print("검색할 이름을 입력하세요:");
	String searchName = scan.nextLine();

	for(int i=0 ; i<numOfInfo ; i++) {			
		System.out.println("검색중인이름:"+ info[i].name);
		
		//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
		if(searchName.compareTo(info[i].name)==0) {
			info[i].showPhoneInfo();
			System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
		}
	}
}////end of searchInfo

//주소록 항목 삭제
public void dataDelete() {
	Scanner scan = new Scanner(System.in);
	System.out.print("삭제할 이름을 입력하세요:");
	String deleteName = scan.nextLine();
	
	/*
	배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
	요소를 삭제한후 빈자리를 채울때 사용할 예정임.
	 */
	int deleteIndex = -1;

	for(int i=0 ; i<numOfInfo ; i++) {
		if(deleteName.compareTo(info[i].name)==0) {
			//요소를 삭제하기 위해 참조값을 null로 변경
			info[i] = null;
			//삭제된 요소의 인덱스값 저장
			deleteIndex = i;
			//전체카운트 변수 -1 차감
			numOfInfo--;
		}
	}

	if(deleteIndex==-1) {
		//검색된 데이터가 없는경우...
		System.out.println("==삭제된 데이터가 없습니다==");
	}
	else {
		/*
		객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를
		앞으로 하나씩 교환한다. 
		 */
		for(int i=deleteIndex ; i<numOfInfo ; i++) {
			info[i] = info[i+1];
		}
		System.out.println("==데이터("+ deleteIndex
				+"번)가 삭제되었습니다==");
		}
	}////end of deleteInfo
}////end of PhoneInfoHandler
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

	PhoneInfoHandler handler =
			new PhoneInfoHandler(100);
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