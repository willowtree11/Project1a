package project1a;

import java.util.Scanner;

import project1a.ver09.PhoneBookManager;

public class PhoneBookVer09 {
		
	public static void main(String[] args) {
		
		PhoneBookManager manager=new PhoneBookManager(100);
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			manager.printMenu();
			int choice=scan.nextInt();				
			if(!(0<choice && choice<6)) {
				System.out.println("숫자 1 또는 2를 선택하세요");
			}
			else {
				switch(choice) {
				
				case 1:		
					//정보추가
					manager.dataInput();
					break;
				case 2:		
					//정보검색
					manager.dataSearch();
					break;
				case 3:		
					//정보삭제
					manager.dataDelete();
					break;
				case 4:		
					//주소록전체출력
					manager.dataAllShow();
					break;				
				case 5:		
					//프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			
		}		
	}//main
}
