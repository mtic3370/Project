package project1.ver03;

import java.util.Scanner;
import project1.ver03.PhoneInfo;
public class PhoneBookManager {

	public PhoneBookManager(PhoneInfo[] 
		Info, int numOfInfo) {
		super();	
		this.info = info;
		this.numOfInfo = numOfInfo;
}
	
	private PhoneInfo[] info;
	private int numOfInfo;//친구정보를 추가할때마다 +1 증가

	public PhoneBookManager(int num) {
		info = new PhoneInfo[num];
		numOfInfo = 0;
	}
	
	public void dataInput() {
		//사용자로부터 친구정보를 입력받기위한 준비
		Scanner scan = new Scanner(System.in);
		String name,phone,birthday;
		
		System.out.print("이름:");name = scan.nextLine();
		System.out.print("전화번호:");phone = scan.nextLine();
		System.out.print("생년월일:");birthday = scan.nextLine();
		PhoneInfo pi= new PhoneInfo(name,phone,birthday);
		info[numOfInfo++]=pi;
		System.out.println("정보가 입력되었습니다.");
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
			System.out.println("검색중인이름:"
					+ info[i].name);
			
			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if(searchName.compareTo(info[i].name)==0) {
				info[i].showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}////end of dataSearch
	
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
		}	
}