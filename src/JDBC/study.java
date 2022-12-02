package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class study {

	public void connect() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			System.out.println("success");

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void insert() {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");
			String aa = "insert into store values(store_seq.nextval,?,?,?,?)";

			System.out.println("가게이름 :");
			String a = scan.next();
			System.out.println("위치 :");
			String b = scan.next();
			System.out.println("넘버 :");
			int c = scan.nextInt();
			System.out.println("좌석 :");
			int d = scan.nextInt();

			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			pstmt.setInt(3, c);
			pstmt.setInt(4, d);

			if (pstmt.executeUpdate() == 1)
				;
			System.out.println("success");

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

	public void insert2(study2 s2) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "insert into store values(store_seq.nextval,?,?,?,?)";

			s2.insert_store();

			pstmt = con.prepareStatement(aa);
			pstmt.setString(1, s2.name);
			pstmt.setString(2, s2.location);
			pstmt.setInt(3, s2.no);
			pstmt.setInt(4, s2.seat);

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

	public void select() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "select * from reservation";

			pstmt = con.prepareStatement(aa);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("rr_name"));
				System.out.println(rs.getDate("rr_date"));
				System.out.println(rs.getInt("rr_phone"));
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void update() {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "update store set s_seat=1 where s_ceo=7";

			pstmt = con.prepareStatement(aa);

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

	public void delete() {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			String aa = "delete from store where s_ceo=7";

			pstmt = con.prepareStatement(aa);

			if (pstmt.executeUpdate() >= 1) {
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
