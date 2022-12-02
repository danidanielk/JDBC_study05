import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class A_Insert {
	
public static void main(String[] args) {
//연결객체 열고
	Connection con = null; 
	
//연결객체를 총괄매니저에게 연결시켜주고	
	PreparedStatement pstmt= null;
	Scanner scan= new Scanner(System.in);
	
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
		System.out.println("마트이름");
		String name= scan.next();
		System.out.println("지역");
		String location= scan.next();
		System.out.println("몇평");
		int land= scan.nextInt();
		System.out.println("주차 가능 대수");
		int parking= scan.nextInt();
		
		
		String a = "insert into mart values(mart_seq.nextval,?,?,?,?)";
		pstmt = con.prepareStatement(a);
		pstmt.setString(1, name);
		pstmt.setString(2, location);
		pstmt.setInt(3, land);
		pstmt.setInt(4, parking);
		
		//전송 실행 결과받기 이작업 때문에 영향을 받은 데이터의 수가 리턴.
		if (pstmt.executeUpdate() ==1) {
			System.out.println("success");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	try {
//총괄매니저부터 먼저 닫고
		pstmt.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	try {
//그다음 연결객체 닫기
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
}
