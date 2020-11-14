package project1a.ver08;

public class AutoSaverT extends Thread {	
	
	
	@Override
	public void run() {	//쓰레드 실행부
		/*
			해결기록:
			1. PhoneBookManager 연결도 실행부 안에서
			2. 오류원인: while문 안에 try-catch문이 있었음
					try-catch 문 안에 실행할 메소드를 넣어두어야 함.
					-> 안그러면 바깥의 while문으로 인해 catch문 반복
		 */
		PhoneBookManager pbm=new PhoneBookManager();	
		try {
			while(true) { //while try-catch 순서 유의!	
				pbm.dataSave();
				sleep(5000); //5s
				System.out.println(String.format("[%s]주소록이 텍스트로 자동저장되었습니다.", getName()));
				System.out.println("현재 활성화 된 상태의 쓰레드 수: "+Thread.activeCount()); //확인용, 영상제작시 출력x
			}
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException");
			e.printStackTrace();
		}
	}
}