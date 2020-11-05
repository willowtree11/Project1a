package project1a;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1a.ver08.Game3by3;
import project1a.ver08.MenuItem;
import project1a.ver08.MenuSelectException;
import project1a.ver08.PhoneBookManager;

public class PhoneBookVer08 implements Serializable{
	
	public static void main(String[] args) {

		PhoneBookManager manager=new PhoneBookManager();		
		Game3by3 game=new Game3by3();
		Scanner scan = new Scanner(System.in);		
		
		try {
			while(true) {
				manager.printMenu();
				manager.preData();
				int choice=scan.nextInt();
				scan.nextLine();
				if(!(0<choice && choice<7)) {
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
					case MenuItem.SAVE:		
						//저장
						manager.saveStart();
						break;
					case MenuItem.EXT:		
						//프로그램 종료
						manager.prgrExit();						
						System.out.println("프로그램을 종료합니다.");
						return;
					}//switch				
				}//else		
			}//while
		} 
		catch (MenuSelectException e) {
			System.out.println("1~7사이의 숫자를 입력하세요.\n");
		}
		catch (InputMismatchException  e) {
			System.out.println("문자를 입력할 수 없습니다.\n");
		}
		finally {
			main(args);
		}
		
	}//main
}
