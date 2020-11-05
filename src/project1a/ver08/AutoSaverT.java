package project1a.ver08;

public class AutoSaverT extends Thread {	
	
	PhoneBookManager pbm=new PhoneBookManager();	
	
	@Override
	public void run() {	//쓰레드 실행부
		
		while(true) {	
			System.out.println(String.format("[%s]주소록이 텍스트로 자동저장되었습니다.", getName()));
			System.out.println("현재 활성화 된 상태의 쓰레드 수: "+Thread.activeCount()); //확인용, 영상제작시 출력x
			
			try {	
				sleep(5000); //5s
			}
			catch (InterruptedException e) {
				System.out.println("InterruptedException");
				e.printStackTrace();
			}
		}
	}
}