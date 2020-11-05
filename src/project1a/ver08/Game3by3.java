package project1a.ver08;

import java.util.Scanner;

public class Game3by3 {

	public void game3by3(){
		String[][] gBoard={
				{"1","2","3"},
				{"4","5","6"},
				{"7","8","x"}
		};
		
		System.out.println("==========="); 
		gamePrint(gBoard);
		System.out.println("[ 이동 ] a:Left d:Right w:Up s:Down");
		System.out.println("[ 종료 ] x:Exit");
		System.out.println("\"키를 입력해주세요 :\"");
		System.out.println("==========="); 
		
		Scanner scan = new Scanner(System.in);
		String gChoice=scan.nextLine(); 
		
		if(gChoice=="x") {
			return;
		}
		else {
			System.out.println("3 by 3 퍼즐게임 미완");
		}
	}	
	public void gamePrint(String[][] gBoard) {
		for(int i=0; i<gBoard.length; i++) {			
			for(int j=0; j<gBoard[i].length; j++) {
				System.out.printf("%-2d",gBoard[i][j]);
			}
		}
	}
}
