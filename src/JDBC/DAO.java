package JDBC;

import java.nio.file.attribute.AclEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

//1.�����ϱ�(���� �Է�,��¥�� ��-��-��-��-�� ��������
//4.��ü ���� ��ȸ (��ġ(�¼���)-������̸�)
//5.���� ã��(�ּ� �¼� �� �Է��ϸ� �¼������� �����̳�����)
//6.���� ã��(������ �̸�,����ó �Է��ϸ� �� �����ȣ�� �ش�)
//7.���� ���� ����(���� ��ȣ�� �Է��ϸ�, ����ó ���游 �� �� �ְ�)
//8.���� ���(���� ��ȣ�� �Է��ϸ� ���)
//9.���α׷�����

// reservation values(reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran');
// restaurant values(default,'moran','dani',500);

public class DAO {

	Scanner scan = new Scanner(System.in);

	public void insert_reservation() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			System.out.println("�̸� : ");
			String name = scan.next();
			System.out.println("������ : ");
			String date = scan.next();
			System.out.println("�޴�����ȣ : ");
			int phone = scan.nextInt();
			System.out.println("���� : ");
			String location = scan.next();

			String aa = "insert into reservation values(reservation_seq.nextval,?,to_date(?,'YYYYMMDD_HH24:MI:SS'),?,?)";
			pstmt = con.prepareStatement(aa);

			pstmt.setString(1, name);
			pstmt.setString(2, date);
			pstmt.setInt(3, phone);
			pstmt.setString(4, location);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("seccess");
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

	public void select_restaurant() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "select * from restaurant";

			pstmt = con.prepareStatement(aa);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("r_name"));
				System.out.println("owner name 	: "+rs.getString("r_oner"));
				System.out.println("location 	: "+rs.getString("r_location"));
				System.out.println("seat_no		: "+rs.getInt("r_seat"));
				System.out.println("-------------------------");
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();

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
	
	public void select_seat() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			
			System.out.println("�ּ� �¼� : ");
			int seat = scan.nextInt();
			
			String aa ="select * from restaurant where r_seat >= ?";
			
			pstmt = con.prepareStatement(aa);
			pstmt.setInt(1, seat);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("r_name"));
				System.out.println("location 	: "+rs.getString("r_location"));
				System.out.println("seat_no		: "+rs.getInt("r_seat"));
				System.out.println("-------------------------");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			rs.close();
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
	
	public void select_no(){
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			
			System.out.println("�̸��� �Է��ϼ��� : ");
			String name = scan.next();
			System.out.println("����ó�� �Է��ϼ��� : ");
			int phone = scan.nextInt();
			
			String aa= "select rr_no,rr_name,rr_phone from reservation where rr_name = ? and rr_phone = ?";
			
			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, name);
			pstmt.setInt(2, phone);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("�����ȣ 	: "+rs.getInt("rr_no"));
				System.out.println("������	: "+rs.getString("rr_name"));
				System.out.println("����ó	: "+rs.getInt("rr_phone"));
				System.out.println("-----------------------");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void update() {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			
			System.out.println("���� ��ȣ�� �Է����ּ��� : ");
			int no= scan.nextInt();
			System.out.println("�ٲٽ� ����ó�� �Է����ּ��� : ");
			int phone = scan.nextInt();
			
			String aa="update reservation set rr_phone=? where rr_no = ?";
			
			pstmt = con.prepareStatement(aa);
			pstmt.setInt(1, phone);
			pstmt.setInt(2, no);
			
			if(pstmt.executeUpdate()==1) {
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
	
	public void delete () {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
		con= DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
		
		System.out.println("�����ȣ�� �Է��� �ּ��� : ");
		int no = scan.nextInt();
		
		String aa = "delete from reservation where rr_no = ?";
		
		pstmt = con.prepareStatement(aa);
		pstmt.setInt(1, no);
			
		if(pstmt.executeUpdate() >=1) {
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
