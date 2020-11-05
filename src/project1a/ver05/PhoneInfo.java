package project1a.ver05;


public class PhoneInfo {
	String name, phoneNumber;
	
	public PhoneInfo() {}

	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}	
	public void showPhoneInfo() {			
		System.out.println("이름: "+name); 				
		System.out.println("전화번호: "+phoneNumber); 
		System.out.println();
		return;
	}	
}

