package project1.ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{

	private PhoneInfo[] PhoneInfo;
	private int numOfInfo;//친구정보를 추가할때마다 +1 증가
	Scanner sc = new Scanner(System.in);
	
	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
	public PhoneBookManager(int num) {
		PhoneInfo = new PhoneInfo[100];
		numOfInfo = 0;
	}

	public void dataInput() {
		try {
			System.out.println("데이터 입력을 시작합니다.");
			System.out.println("1.일반친구, 2.학교친구, 3.회사동료");
			System.out.print("선택>>");
			sc = new Scanner(System.in);
			int choice = sc.nextInt();
			sc.nextLine();
		
			if(choice<1 || choice>3) {
				MenuSelectException menuSelectException = new MenuSelectException();
				throw menuSelectException;
		}
			System.out.print("이름:");
			String name = sc.next();
			System.out.print("전화번호:");
			String phone = sc.next();
		
			switch(choice) {
			case PHONEINDEX:
				PhoneInfo[numOfInfo] = new PhoneInfo(name, phone);
				break;
			
			case SCHOOLFRIENDS:
				System.out.print("전공:");
				String major = sc.next();
				System.out.print("학년:");
				int grade = sc.nextInt();
				PhoneInfo[numOfInfo] = new PhoneSchoolInfo(name, phone, major, grade);
				break;
				
			case COMPANY:
				System.out.print("회사:");
				String company = sc.next();
				PhoneInfo[numOfInfo] = new PhoneCompanyInfo(name, phone, company);
				break;
			}
			
			numOfInfo++;
			System.out.println("데이터 입력이 완료되었습니다.");
		}
	catch (InputMismatchException e) {
		System.out.println("문자가 입력되었습니다.");
		dataInput();
		}
	catch (MenuSelectException e) {
		System.out.println("1~3의 범위가 아닙니다.");
		System.out.println("다시 입력해 주십시요.");
		dataInput();
	}
}//end of dataInput
	//친구정보 전체보기
	public void dataAllShow() {
		for(int i=0 ; i<numOfInfo ; i++) {
			PhoneInfo[i].showPhoneInfo();
			System.out.println("==출력 정보입니다==");
		}
	}////end of dataAllShow

	
	//주소록 검색
	public void dataSearch() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = sc.next();

		for(int i=0 ; i<numOfInfo ; i++) {			
			System.out.println("검색중인이름:"+ PhoneInfo[i].name);
			
			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if(searchName.compareTo(PhoneInfo[i].name)==0) {
				PhoneInfo[i].showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				break;
			}
		}
	}
	catch (NullPointerException e) {
		System.out.println("검색결과가 없습니다.");
		e.printStackTrace();
		}
	}////end of dataSearch
		
	//데이터 삭제
	public void dataDelete() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.next();
		
		int deleteIndex = -1;
		for(int i=0 ; i<numOfInfo ; i++) {
			if(PhoneInfo[i].name.equals(deleteName)) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				PhoneInfo[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체카운트 변수 -1 차감
				numOfInfo--;
				System.out.println("데이터가 삭제 되었습니다.");
				break;
			}
		}
		if(deleteIndex!=-1) {
			for(int i=deleteIndex ; i<numOfInfo ; i++) {
				PhoneInfo[i] = PhoneInfo[i+1];
			}
		}
	}
	catch(NullPointerException e) {	
		//검색된 데이터가 없는경우...
		System.out.println ("삭제된 데이터가 없습니다");
		e.printStackTrace();
		}
	}////end of dataDelete
}//end of main