package JDBC_2;
//1.�����ϱ�(���� �Է�,��¥�� ��-��-��-��-�� ��������
//4.��ü ���� ��ȸ (��ġ(�¼���)-������̸�)
//6.���� ã��(������ �̸�,����ó �Է��ϸ� �� �����ȣ�� �ش�)
//7.���� ���� ����(���� ��ȣ�� �Է��ϸ�, ����ó ���游 �� �� �ְ�)
//8.���� ���(���� ��ȣ�� �Է��ϸ� ���)
//9.���α׷�����



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DAO {

	Scanner scan = new Scanner(System.in);

	public void insert_reservation(ConsoleScreen cs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			cs.no1();
			String aa = "insert into reservation values(reservation_seq.nextval,?,to_date(?,'YYYYMMDD_HH24:MI:SS'),?,?)";
			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, cs.rsvname);
			pstmt.setString(2, cs.rsvdate);
			pstmt.setInt(3, cs.rsvphone);
			pstmt.setString(4, cs.rsvlocation);
			if (pstmt.executeUpdate() == 1) {
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

	public void select_restaurant(ConsoleScreen cs) {
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con= DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			
			String aa ="select * from restaurant";
			
			pstmt = con.prepareStatement(aa);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("r_oner"));
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_location"));
				System.out.println(rs.getInt("r_seat"));
				System.out.println("------------------------");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void select_reservation() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
