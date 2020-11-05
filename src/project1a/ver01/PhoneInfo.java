package project1a.ver01;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo() {}

	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}	
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("생년월일: "+birthday);
		System.out.println();
	}
	
	
	
}
