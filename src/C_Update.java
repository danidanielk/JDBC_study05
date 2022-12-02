import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class C_Update {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt= null;
		Scanner scan = new Scanner(System.in);
		
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
		
		System.out.println("매장명을 입력하세요 : ");
		String a = scan.next();
		
		String aa = "update product set p_price = p_price*0.8 where p_m_no = (select m_no from mart where m_name like '%'||?||'%')";
		
		pstmt = con.prepareStatement(aa);
		pstmt.setString(1, a);
		
		
		if ( pstmt.executeUpdate() >= 1 ) {
			System.out.println("success");
		}
		
	} catch (Exception e) {
		// TODO: handle exception

	}	
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
