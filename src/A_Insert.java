import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class A_Insert {
	
public static void main(String[] args) {
//���ᰴü ����
	Connection con = null; 
	
//���ᰴü�� �Ѱ��Ŵ������� ��������ְ�	
	PreparedStatement pstmt= null;
	Scanner scan= new Scanner(System.in);
	
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
		System.out.println("��Ʈ�̸�");
		String name= scan.next();
		System.out.println("����");
		String location= scan.next();
		System.out.println("����");
		int land= scan.nextInt();
		System.out.println("���� ���� ���");
		int parking= scan.nextInt();
		
		
		String a = "insert into mart values(mart_seq.nextval,?,?,?,?)";
		pstmt = con.prepareStatement(a);
		pstmt.setString(1, name);
		pstmt.setString(2, location);
		pstmt.setInt(3, land);
		pstmt.setInt(4, parking);
		
		//���� ���� ����ޱ� ���۾� ������ ������ ���� �������� ���� ����.
		if (pstmt.executeUpdate() ==1) {
			System.out.println("success");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	try {
//�Ѱ��Ŵ������� ���� �ݰ�
		pstmt.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	try {
//�״��� ���ᰴü �ݱ�
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
}
