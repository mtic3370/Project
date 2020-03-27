package project1.ver03;

public class PhoneBookManager {

	
	String name;	//이름
	String phone;	//전화번호
	String birthday;//생년월일

	public void PhoneBook(String name, String phone, String birthday) {
		
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	//멤버메소드
	/*
	멤버변수 전체 정보를 출력하는 메소드
	 */
	public void dataAllShow() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("생년월일:"+ birthday);
	}
}// end of PhoneBookManager	
