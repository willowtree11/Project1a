package project1a;

import java.util.Scanner;

import project1a.ver05.MenuItem;
import project1a.ver05.PhoneBookManager;

public class PhoneBookVer05 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager=new PhoneBookManager(100);
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			manager.printMenu();
			int choice=scan.nextInt();
			scan.nextLine();
			if(!(0<choice && choice<6)) {
				System.out.println("숫자 1 또는 2를 선택하세요");
			}
			else {
				switch(choice) {
				
				case MenuItem.INPT:		
					//정보추가
					manager.dataInput(choice);
					break;
				case MenuItem.SRCH:		
					//정보검색
					manager.dataSearch();
					break;
				case MenuItem.DLT:		
					//정보삭제
					manager.dataDelete();
					break;
				case MenuItem.PRNT:		
					//주소록전체출력
					manager.dataAllShow();
					break;				
				case MenuItem.EXT:		
					//프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			
		}		
	}//main
}
