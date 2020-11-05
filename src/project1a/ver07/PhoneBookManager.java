package project1a.ver07;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	HashSet<PhoneInfo> hs = new HashSet<PhoneInfo>(); //데이터를 저장할 해시셋 생성
	Scanner scan=new Scanner(System.in);	
		
	public void printMenu() { //메뉴
		
		System.out.println("선택하세요...");		
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택: ");		
		
	}//printMenu
	
	public void dataInput(int choice) { //데이터 입력
			
		String name, phoneNumber, comName, major;
		int grade;	
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");	
		
		Scanner scan=new Scanner(System.in);
		int dChoice=scan.nextInt(); //sub 메뉴 선택지를 받을 scanner
		scan.nextLine();
		try {
			if(!(dChoice>0&&dChoice<4)) {
				System.out.println("숫자 1, 2, 3 중에서 선택하세요");
			}
			else if(dChoice==SubMenuItem.NRML) {
				//기본
				System.out.println("== 일반주소 추가 ==");
				System.out.println("이름: "); name=scan.nextLine();	
				System.out.println("전화번호: "); phoneNumber=scan.nextLine();
				
				Iterator<PhoneInfo> it=hs.iterator();
				while(it.hasNext()){					
					PhoneInfo pi = it.next();					
					if(pi.name.equals(name)) { 
						System.out.println(pi.toString()+"은(는) 이미 저장된 데이터입니다.");
						System.out.println("덮어쓰시겠습니까? Y/N");											
		                String answ = scan.nextLine();
		                if(answ.equalsIgnoreCase("Y")) {
	                        if(pi.name.equals(name)) {
	                        	System.out.println("기존 정보를 삭제하고 입력하신 정보를 덮어씁니다.");
	                        	hs.remove(pi);
	                        	hs.add(new PhoneInfo(name, phoneNumber));
		                        System.out.println("덮어쓰기가 완료되었습니다.");
	                        	break;
	                        }		                        
		                }		                
		                if(answ.equalsIgnoreCase("N")) {
		                     System.out.println("덮어쓰기를 취소합니다.");
		                }	
					}
				}				
				hs.add(new PhoneInfo(name, phoneNumber));
				System.out.println("입력한 정보가 저장되었습니다.");
			}		
			else if(dChoice==SubMenuItem.SCHL) {
				//학교학우
				System.out.println("== 학교주소 추가 ==");
				System.out.println("이름: "); name=scan.nextLine();	
				System.out.println("전화번호: "); phoneNumber=scan.nextLine();
				System.out.println("전공: "); major=scan.nextLine();
				System.out.println("학년: "); grade=scan.nextInt();
				
				Iterator<PhoneInfo> it=hs.iterator();
				while(it.hasNext()){					
					PhoneInfo pi = it.next();					
					if(pi.name.equals(name)) { 
						System.out.println(pi.toString()+"은(는) 이미 저장된 데이터입니다.");
						System.out.println("덮어쓰시겠습니까? Y/N");											
		                String answ = scan.nextLine();
		                if(answ.equalsIgnoreCase("Y")) {
	                        if(pi.name.equals(name)) {
	                        	System.out.println("기존 정보를 삭제하고 입력하신 정보를 덮어씁니다.");
	                        	hs.remove(pi);
	                        	hs.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
		                        System.out.println("덮어쓰기가 완료되었습니다.");
	                        	break;
	                        }		                        
		                }		                
		                if(answ.equalsIgnoreCase("N")) {
		                     System.out.println("덮어쓰기를 취소합니다.");
		                }	
					}
				}				
				hs.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				System.out.println("입력한 정보가 저장되었습니다.");
			}
			else {
				//회사동료
				System.out.println("== 회사주소 추가 ==");
				System.out.println("이름: "); name=scan.nextLine();	
				System.out.println("전화번호: "); phoneNumber=scan.nextLine();
				System.out.println("회사이름: "); comName=scan.nextLine();
				
				Iterator<PhoneInfo> it=hs.iterator();
				while(it.hasNext()){					
					PhoneInfo pi = it.next();					
					if(pi.name.equals(name)) { 
						System.out.println(pi.toString()+"은(는) 이미 저장된 데이터입니다.");
						System.out.println("덮어쓰시겠습니까? Y/N");											
		                String answ = scan.nextLine();
		                if(answ.equalsIgnoreCase("Y")) {
	                        if(pi.name.equals(name)) {
	                        	System.out.println("기존 정보를 삭제하고 입력하신 정보를 덮어씁니다.");
	                        	hs.remove(pi);
	                        	hs.add(new PhoneCompanyInfo(name, phoneNumber, comName));
		                        System.out.println("덮어쓰기가 완료되었습니다.");
	                        	break;
	                        }		                        
		                }		                
		                if(answ.equalsIgnoreCase("N")) {
		                     System.out.println("덮어쓰기를 취소합니다.");
		                }	
					}
				}				
				hs.add(new PhoneCompanyInfo(name, phoneNumber, comName));
				System.out.println("입력한 정보가 저장되었습니다.");
			}
		} //try
		catch (InputMismatchException  e) {
			e.printStackTrace();
		}		
	}//dataInput
	
	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("검색할 이름을 입력해주세요");
		String searchName=scan.nextLine();
		boolean isFind=false;
		
		Iterator<PhoneInfo> it=hs.iterator();
						
		while(it.hasNext()){
			
			PhoneInfo pi = it.next();
			if(pi.name.equals(searchName)) { //["객체"의 이름]을 찾아야 함
				System.out.println("== 검색결과 ==");
				System.out.println(pi.toString()+"\n");
				isFind = true;
			}
		}	
		if(isFind==false) {
			System.out.println("== 검색결과가 없습니다. ==");
		}
	}//dataSearch
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.println("데이터를 삭제할 이름을 입력해주세요");
		String infoDelete=scan.nextLine();
		boolean isFind=false;
		
		Iterator<PhoneInfo> it=hs.iterator();
		
		while(it.hasNext()){
			
			PhoneInfo pi = it.next();
			if(pi.name.equals(infoDelete)) { //["객체"의 이름]을 찾아야 함
				System.out.println("== 해당 데이터를 삭제합니다 ==");
				System.out.println(pi.toString()+"\n");
				hs.remove(pi);
				isFind = true;
				System.out.println("데이터 삭제가 완료되었습니다");
			}
		}	
		
		if(isFind==false) {
			System.out.println("== 해당 이름이 존재하지 않습니다 ==");
			System.out.println("== 삭제된 데이터가 없습니다 ==");
		}
	}//dataDelete
	
	public void dataAllShow() {
		Iterator<PhoneInfo> it=hs.iterator();		
		while(it.hasNext()){
			System.out.println(it.next()+" ");
			System.out.println("----------------------------");
		}
		System.out.println("[총 데이터 수]: "+hs.size());
		System.out.println("전체 데이터가 출력되었습니다");
	}//dataAllShow
	
	
}
