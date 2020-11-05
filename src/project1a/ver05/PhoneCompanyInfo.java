package project1a.ver05;

public class PhoneCompanyInfo extends PhoneInfo{
	
	String comName;

	public PhoneCompanyInfo(String name, String phoneNumber, String comName) {
		super(name, phoneNumber);
		this.comName=comName;
	}
	
	@Override
	public void showPhoneInfo() {
		System.out.println("== 회사 주소록 ==");
		super.showPhoneInfo();
		System.out.println("회사이름: "+comName);
	}	
}