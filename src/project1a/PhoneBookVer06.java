package project1a;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1a.ver06.MenuItem;
import project1a.ver06.MenuSelectException;
import project1a.ver06.PhoneBookManager;

public class PhoneBookVer06 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager=new PhoneBookManager(100);
		Scanner scan = new Scanner(System.in);
		
		try {
			while(true) {
				manager.printMenu();
				int choice=scan.nextInt();
				scan.nextLine();
				if(!(0<choice && choice<6)) {
					throw new MenuSelectException(); //!!!!기억하기
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
					}//switch				
				}//else		
			}//while
		} 
		catch (MenuSelectException e) {
			e.printStackTrace();
			System.out.println("1~5사이의 숫자를 입력하세요.");
		}
		catch (InputMismatchException  e) {
			e.printStackTrace();
			System.out.println("문자를 입력할 수 없습니다.");
		}
		
	}//main
}
