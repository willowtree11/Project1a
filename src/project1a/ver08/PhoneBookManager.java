package project1a.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements Serializable{ 
	
	static HashSet<PhoneInfo> hs = new HashSet<PhoneInfo>(); //데이터를 저장할 해시셋 생성
	Scanner scan=new Scanner(System.in);	
	
	public void printMenu() { //메뉴
		System.out.println("==================메뉴를 선택하세요================");	
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("==============================================");
		System.out.println("메뉴선택: ");	
	}//printMenu
	
	public void preData() { //시작시 불러올 기존 저장된 정보
		try { 
			ObjectInputStream in=
					new ObjectInputStream(
							new FileInputStream("src/project1a/ver08/PhoneBook.obj"));
			
			while(true) { //무한루프로 검사
				try {
					PhoneInfo pi = (PhoneInfo)in.readObject(); //오브젝트 기반이므로 형변환
					hs.add(pi);//불러온 내역을 해시셋에 추가
					if(hs==null) {
						System.out.println("기존 데이터 로딩을 완료했습니다.");
						break;
					}
				} 
				catch (EOFException e) {
					break;
				}				
			} 
		}
		catch (FileNotFoundException e) {
			System.out.println("\n└→ 현재 저장된 전화번호 데이터가 없습니다.");
			return;
		}
		catch (Exception e) {
			System.out.println("\n ===복원 시 예외 발생===");		
		}
	}
	
	public void dataInput(int choice) { //데이터 입력		
		
		String name, phoneNumber, comName, major;
		int grade;	
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");	
		
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
				boolean phNrml=hs.add(new PhoneInfo(name, phoneNumber));
				
				if(phNrml==false) { //add가 되지 않음
					System.out.println("이미 저장된 데이터입니다.");
					System.out.println("덮어쓰시겠습니까? Y/N");	
					String answ = scan.nextLine();
	                if(answ.equalsIgnoreCase("Y")) {
	                	 Iterator<PhoneInfo> it=hs.iterator();
	                	 PhoneInfo pi = it.next();
	                	 hs.remove(pi); 
	        			 hs.add(new PhoneInfo(name, phoneNumber));
	 	                 System.out.println("덮어쓰기가 완료되었습니다.");
	                }                	 
					else {
						System.out.println("덮어쓰기를 취소합니다.");
                    }	                
				}
				else {
					System.out.println("입력한 정보가 저장되었습니다.");
				}
			}// 일반저장 선택지 else if(dChoice==SubMenuItem.NRML)	
			else if(dChoice==SubMenuItem.SCHL) {
				//학교학우
				System.out.println("== 학교주소 추가 ==");
				System.out.println("이름: "); name=scan.nextLine();	
				System.out.println("전화번호: "); phoneNumber=scan.nextLine();
				System.out.println("전공: "); major=scan.nextLine();
				System.out.println("학년: "); grade=scan.nextInt();
				
				boolean phSchl=hs.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				
				if(phSchl==false) { 
					System.out.println("이미 저장된 데이터입니다.");
					System.out.println("덮어쓰시겠습니까? Y/N");	
					String answ = scan.nextLine();
	                if(answ.equalsIgnoreCase("Y")) {
	                	 Iterator<PhoneInfo> it=hs.iterator();
	                	 PhoneInfo pi = it.next();
	                	 hs.remove(pi); 
	        			 hs.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
	 	                 System.out.println("덮어쓰기가 완료되었습니다.");
	                }                	 
					else {
						System.out.println("덮어쓰기를 취소합니다.");
                    }	                
				}
				else {
					System.out.println("입력한 정보가 저장되었습니다.");
				}				
			}
			else {
				//회사동료
				System.out.println("== 회사주소 추가 ==");
				System.out.println("이름: "); name=scan.nextLine();	
				System.out.println("전화번호: "); phoneNumber=scan.nextLine();
				System.out.println("회사이름: "); comName=scan.nextLine();				
				boolean phComp=hs.add(new PhoneCompanyInfo(name, phoneNumber, comName));
				
				if(phComp==false) { 
					System.out.println("이미 저장된 데이터입니다.");
					System.out.println("덮어쓰시겠습니까? Y/N");	
					String answ = scan.nextLine();
	                if(answ.equalsIgnoreCase("Y")) {
	                	 Iterator<PhoneInfo> it=hs.iterator();
	                	 PhoneInfo pi = it.next();
	                	 hs.remove(pi); 
	        			 hs.add(new PhoneCompanyInfo(name, phoneNumber, comName));
	 	                 System.out.println("덮어쓰기가 완료되었습니다.");
	                }                	 
					else {
						System.out.println("덮어쓰기를 취소합니다.");
                    }	                
				}
				else {
					System.out.println("입력한 정보가 저장되었습니다.");
				}				
			}
		} //try
		catch (InputMismatchException  e) {
			System.out.println("잘못된 입력입니다.");
		}		
	}//dataInput
	
	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("검색할 이름을 입력해주세요");
		String searchName=scan.nextLine();
		
		Iterator<PhoneInfo> it=hs.iterator();						
		while(it.hasNext()){			
			PhoneInfo pi = it.next();
			if(!(pi.name.equals(searchName))) { //["객체"의 이름]을 찾아야 함
				System.out.println("== 검색결과가 없습니다. ==");				
			}
			else {
				System.out.println("== 검색결과 ==");
				System.out.println(pi.toString()+"\n");
				return;
			}
		}	
//		if(isFind==false) {
//			System.out.println("== 검색결과가 없습니다. ==");
//		}
	}//dataSearch
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.println("데이터를 삭제할 이름을 입력해주세요");
		String infoDelete=scan.nextLine();
		boolean isFind=false;
		
		Iterator<PhoneInfo> it=hs.iterator();		
		while(it.hasNext()){			
			PhoneInfo pi = it.next();//해시셋 내 모든 객체 찾기
			if(pi.name.equals(infoDelete)) { //입력 받은 값(infoDelete)과 같은 ["객체"의 이름 pi]을 찾아야 함
				System.out.println("== 해당 데이터를 삭제합니다 ==");
				System.out.println(pi.toString()+"\n");
				hs.remove(pi);
				isFind = true;
				System.out.println("데이터 삭제가 완료되었습니다");
				return;
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
	
	public void dataSave() { //저장 및 경로 지정
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1a/ver08/AutoSaveBook.txt"));			
			Iterator<PhoneInfo> it=hs.iterator();
			while(it.hasNext()){
				PhoneInfo pi=it.next();
				out.print(pi.toString());	
				out.println("");
			}
			out.close();
		} 
		catch (Exception e) {
			System.out.println("저장 오류");
		}		
	}
	
	AutoSaverT autoS;
	boolean isActive=false; //실행중인지?
	public void saveStart(){ //class AutoSaverT 실행용 메소드		
		
//		System.out.println("1.자동저장ON 2.자동저장Off");
//		int save = scan.nextInt();
//		scan.nextLine();
//		if(save==1) {
//			if(autoS.isAlive()) {
//				System.out.println("이미 자동저장이 실행중입니다.\n");
//				return;
//			}
//			autoS= new AutoSaverT();
//			System.out.println(autoSaverT);
//			autoS.setDaemon(true);
//			autoS.start();
//		}
//		else if(save==2) {
//			System.out.println("자동저장 종료\n");
//			System.out.println(autoSaverT);
//			autoS.interrupt();
//			
//		}

		System.out.println("==저장옵션선택==\n"
				+ "저장옵션을 선택하세요.\n"
				+ "1.자동저장On, 2.자동저장Off\n"
				+ "선택: ");
		
		Scanner scan=new Scanner(System.in);
		int sChoice=scan.nextInt(); //sub 메뉴 선택지를 받을 scanner
		scan.nextLine();
		try {	
			if(sChoice==1) {//1. 자동저장On				
				if(isActive==true) { //오토세이브 스레드가 실행중이면 autoS.isAlive()
					System.out.println("자동저장이 이미 실행중입니다.");
					return;
				}
				else {
					try {
						isActive=true;
						autoS=new AutoSaverT();
						autoS.setDaemon(isActive);
						autoS.start(); //데몬쓰레드	실행
					} 
					catch (Exception e) {	
						System.out.println("쓰레드 실행 오류");
						return;
					}
				}	
			}
			else if(sChoice==2){//2.자동저장Off	
				try {					
					autoS.interrupt();
					System.out.println("자동저장을 중지합니다.");
				} 
				catch(Exception e) {
					System.out.println("자동 저장 종료 예외 발생");
					System.out.println(e);
				}	
			}
			else { //선택지 숫자 잘못씀 (!(sChoice>0&&sChoice<3))
			System.out.println("숫자 1, 2 중에서 선택하세요");
			}
			
		} //try 자동저장 on/off 선택지
		catch (Exception e) {
			System.out.println("자동 저장 예외 발생");
			System.out.println(e);
			e.getStackTrace();
		}
	}
	
	public void prgrExit() {
		try {
			//인스턴스를 파일에 저장하기 위한 스트림을 생성
			ObjectOutputStream out=
				new ObjectOutputStream(
					new FileOutputStream("src/project1a/ver08/PhoneBook.obj"));	
			
			Iterator<PhoneInfo> it=hs.iterator();

			while(it.hasNext()) { //모든 데이터를 수거
				PhoneInfo pi=it.next();
				out.writeObject(pi);
			}
			out.close();
			System.out.println("입력한 데이터들을 저장합니다...");
			System.out.println("obj 파일로 저장되었습니다.");
		} 
		catch (Exception e) {
			System.out.println("저장 예외 발생");
		}
	}//prgrExit 종료 및 저장
}//class PhoneBookManager
