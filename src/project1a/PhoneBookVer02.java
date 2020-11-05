package project1a;

import java.util.Scanner;

import project1a.ver02.PhoneInfo;

public class PhoneBookVer02 {
		
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.println("선택: ");	
			int choice=scan.nextInt();
			scan.nextLine(); //nextInt사용시 다음에 또 숫자가 나오면 buffer오류 생기므로 추가해준다.
			
			if(choice!=1 && choice!=2) {	
				System.out.println("숫자 1 또는 2를 선택하세요");				
			}
			else if(choice==1) {
				
				System.out.println("이름: ");
				String name=scan.nextLine();
				System.out.println("전화번호: ");
				String phoneNumber=scan.nextLine();
				System.out.println("생년월일: ");
				String birthday=scan.nextLine();
				
				PhoneInfo phoneInfo=new PhoneInfo(name, phoneNumber, birthday);		
				phoneInfo.showPhoneInfo();
				
				continue;
			}
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}		
	}//main
}
