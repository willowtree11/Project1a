package project1a.ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable{
	
	String name, phoneNumber;
	
	@Override
	public int hashCode() { return (name).hashCode(); } 
    
	@Override
	public boolean equals(Object obj) {
		PhoneInfo temp = (PhoneInfo)obj;		
        if(name.equals(temp.name)==true) {    //'name'으로 분류한다.    	
        	return true;
        } 
        else {
            return false;
        }//'name'이 같으면 true/다르면 false반환한다. => 저장시에
    }	
	
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}	
	
	public PhoneInfo() {
	}

	public void showPhoneInfo() {			
		System.out.println("이름: "+name); 				
		System.out.println("전화번호: "+phoneNumber); 
		System.out.println();
		return;
	}
	
	@Override
	public String toString() {
		return "[이름: " + name + ", 전화번호: " + phoneNumber +"]";
	}
}


