package project1a.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 3단계[배열] PhoneBookVer03.java 을 복사하여 PhoneBookVer09.java를 생성한다. 
또한 ver03 패키지를 복사하여 ver09 패키지를 생성한다.
9단계는 JDBC를 이용하여 오라클과 연동하는 프로그램을 제작해본다.

테이블 생성 
이름, 전화번호, 생년월일을 저장할수 있는 테이블을 생성한다.
테이블명 : phonebook_tb
primary key와 같은 제약조건도 걸어준다.
시퀀스 생성
시퀀스명 : seq_phonebook

입력 : dataInput()
PreparedStatement 클래스 이용
검색 : dataSearch()
Statement 클래스 이용
삭제 : dataDelete()
PreparedStatement 클래스 이용

위 부분을 DML문을 이용하여 구현한다. 
입력은 insert, 검색은 like를 이용한 select, 삭제는 delete로 구현하면 된다.

 */
public class PhoneDB {
	
	Connection con;
	Statement stmt;
	
	//생성자
	public PhoneDB() {
		try {
			//1. 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 커넥션 객체를 통해 DB연결
			con=DriverManager.getConnection(
						"jdbc:oracle:thin://@localhost:1521:orcl",
						"kosmo",
						"1234");
				System.out.println("오라클 DB연결 성공");						
		} 
		catch (ClassNotFoundException e) {
			//ojdbc6.jar 파일이 없거나 연동되지 않았을 때 예외 발생
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			//커넥션 URL이나 계정명이 잘못되었을 때 예외 발생
			System.out.println("DB연결 실패"); //쿼리 구문 오류
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알 수 없는 예외 발생");
			e.printStackTrace();
		}
	}//end of InsertSQL	
	//쿼리작성 및 실행메소드
	private void execute() {
		try {
			//3. Statement 객체 생성을 위한 메소드 호출
			stmt = con.createStatement();
			
			//4. SQL문(쿼리문) 작성
			String sql = "INSERT INTO member VALUES "
					+" ('test3', '2222', '삼길동', SYSDATE) ";
			
			//5. 쿼리 실행 및 결과값 반환
			/*
			 executeUpdate(): 쿼리문이 insert/update/delete와 같이 기존 레코드에 영향을 미치는(편집) 경우에 사용된다. 
			 				  실행 후 영향을 받은 행의 갯수가 int형으로 반환된다.
			 executeQuery(): select 쿼리를 실행할 때 호출되는 메소드로 레코드에 영향을 미치지 않고 조회만 하는 경우 사용된다.
			 				 조회한 레코드를 반환값을 받아야 하므로 ResultSet객체를 반환타입으로 사용하게된다.
			 */
			int affected = stmt.executeUpdate(sql); //executeUpdate() 실행하게 하는 메소드 반환타입 int
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch (SQLException e) {
			System.out.println("쿼리 실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}//end of execute
		
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원 반납 완료");
		} catch (SQLException e) {
			System.out.println("자원 반납시 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}//end of close	
	
	public static void main(String[] args) {
		
		//실행방법 1: 객체 생성 후 참조변수에 대입 후 메소드 호출
//			InsertQuery iSQL=new InsertQuery();
//			iSQL.execute();	
		
		//실행방법 2: 객체생성과 동시에 메소드 호출
		new PhoneDB().execute();
		
	}//end of main
}
