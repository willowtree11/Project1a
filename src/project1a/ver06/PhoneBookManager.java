package project1a.ver06;

import java.util.Scanner;

public class PhoneBookManager {
	
	PhoneInfo[] people;
	int numOfPeople;
	Scanner scan=new Scanner(System.in);
	
	public PhoneBookManager(int num) {
		people=new PhoneInfo[num];
		numOfPeople=0;
	}//PhoneBookManager
	
	public void printMenu() {
		
		System.out.println("선택하세요...");		
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택: ");		
		
	}//printMenu
	
	public void dataInput(int choice) {
			
		String name, phoneNumber, comName, major;
		int grade;		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");	
		
		Scanner scan=new Scanner(System.in);
		int dChoice=scan.nextInt();
		scan.nextLine();
		
		if(!(dChoice>0&&dChoice<4)) {
			System.out.println("숫자 1, 2, 3 중에서 선택하세요");
		}
		else if(dChoice==SubMenuItem.NRML) {
			//기본
			System.out.println("== 일반주소록 ==");
			System.out.println("이름: "); name=scan.nextLine();	
			System.out.println("전화번호: "); phoneNumber=scan.nextLine();
			people[numOfPeople++]=
					new PhoneInfo(name, phoneNumber);			
			PhoneInfo phoneInfo=new PhoneInfo(name, phoneNumber);		
			phoneInfo.showPhoneInfo();
		}		
		else if(dChoice==SubMenuItem.SCHL) {
			//학교학우
			System.out.println("이름: "); name=scan.nextLine();	
			System.out.println("전화번호: "); phoneNumber=scan.nextLine();
			System.out.println("전공: "); major=scan.nextLine();
			System.out.println("학년: "); grade=scan.nextInt();
			people[numOfPeople++]=
					new PhoneSchoolInfo(name, phoneNumber, major, grade);
				
		}
		else if(dChoice==SubMenuItem.CMPN) {
			//회사동료
			System.out.println("이름: "); name=scan.nextLine();	
			System.out.println("전화번호: "); phoneNumber=scan.nextLine();
			System.out.println("회사이름: "); comName=scan.nextLine();
			people[numOfPeople++]=
					new PhoneCompanyInfo(name, phoneNumber, comName);
		}
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}//dataInput
	
	public void dataSearch() {
		boolean isFind=true;
		System.out.println("데이터 검색을 시작합니다..");
		String searchName=scan.nextLine();
		
		for(int i=0; i<numOfPeople; i++) {
			if(searchName.compareTo(people[i].name)==0) {
				people[i].showPhoneInfo();				
				isFind=true;
			}
			else {
				System.out.println("== 검색 결과가 없습니다 ==");
			}
		}
		
	}//dataSearch
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		String infoDelete=scan.nextLine();
		
		int deleteIndex=-1;
		
		for(int i=0; i<numOfPeople; i++) {
			if(infoDelete.compareTo(people[i].name)==0) {
				people[i]=null;
				deleteIndex=i;
				numOfPeople--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("== 삭제된 데이터가 없습니다 ==");
		}
		else {
			for(int i=deleteIndex; i<numOfPeople; i++) {
				people[i]=people[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다");
		}
	}//dataDelete
	
	public void dataAllShow() {
		for(int i=0; i<numOfPeople; i++) {
			people[i].showPhoneInfo();
		}
		System.out.println("전체 데이터가 출력되었습니다"); 
	}//dataAllShow
	
	
}
