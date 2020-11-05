package project1a.ver03;
/*
객체배열을 이용해서, 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경하시오.
그리고 다음과 같은 기능을 추가로 삽입한다.
-저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
-검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 출력한다.
-삭제 : 이름을 기준으로 데이터를 찾아서 삭제의 과정을 진행한다. 단 배열의 중간에 저장된 데이터를 삭제할경우 해당 요소의 뒤에 저장된 요소들을 한칸씩 앞으로 이동시키는 형태로 삭제를 진행한다.
[1,2,3,4,5] 좌측배열에서 인덱스 3을 지웠다면 [1,2,4,5] 처럼 되어야 한다.
 
끝으로 저장, 검색, 삭제의 기능을 담당하는 PhoneBookManager클래스를 정의해서 프로그램을 완성하자.

멤버메소드명 
메뉴출력 : printMenu()
입력 : dataInput()
검색 : dataSearch()
삭제 : dataDelete()
주소록전체출력 : dataAllShow()
*/

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
	
	public void dataInput() {
		
		String name, phoneNumber, birthday;
		
		System.out.println("이름: "); name=scan.nextLine();	
		System.out.println("전화번호: "); phoneNumber=scan.nextLine();
		System.out.println("생년월일: "); birthday=scan.nextLine();
		
		people[numOfPeople++]=
				new PhoneInfo(name, phoneNumber, birthday);
		
		PhoneInfo phoneInfo=new PhoneInfo(name, phoneNumber, birthday);		
		phoneInfo.showPhoneInfo();
		
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
