import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class D_Delete {
	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			
			System.out.println("�Է�");
			String aa = scan.next();
			
			String a = "delete from product where p_naem||'='||?"; //  << �ȵȴ�
			String b = "delete from product where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(b);
			pstmt.setString(1, aa);
			
			
			
			
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("success");		}
			else {
				System.out.println("data is null");
			}
			
			//��ǰ�� �Է� >> �Է��� ������ �����ϴ� ��ǰ�� ���� ���� �ϰԲ� ����� ����
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
}
