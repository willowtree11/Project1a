package project1a;

import project1a.ver01.PhoneInfo;

public class PhoneBookVer01 {
	
	public static void main(String[] args) {
		
		PhoneInfo phoneInfo01 = new PhoneInfo("성낙현", "010-7906-3600", "751130");		
		PhoneInfo phoneInfo02 = new PhoneInfo("류상미", "010-7669-4120");
		
		phoneInfo01.showPhoneInfo();
		phoneInfo02.showPhoneInfo();
		
	}
	
	

}
