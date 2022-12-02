package JDBC_2;
//1.예약하기(직접 입력,날짜는 연-월-일-시-분 형식으로
//4.전체 매장 조회 (위치(좌석수)-사장님이름)
//6.예약 찾기(예약자 이름,연락처 입력하면 그 예약번호를 준다)
//7.예약 정보 수정(예약 번호를 입력하면, 연락처 변경만 할 수 있게)
//8.예약 취소(예약 번호를 입력하면 취소)
//9.프로그램종료



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
