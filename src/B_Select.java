import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class B_Select {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521:xe", "danidani", "1");

			// System.out.println("success");
			// 상품이름을 오름차순으로 정렬해서 상품 전체 정보 조회
			String sql = "select * from product order by p_food";

			pstmt = con.prepareStatement(sql);

			// pstmt.executeUpdate(); : 몇개나 영햐을 받았는가 (C , U, D)
			rs = pstmt.executeQuery(); // : 데이터 (R)
			// select 문을 수행한 결과 : ResultSet - List 와 비슷한 느낌

			while (rs.next()) { // : 다음 데이터로 넘어감 xml느낌.. 다음 데이터가 있으면 true 없으면 false가 리턴.
				// rs.getxxx("컬럼명") : 현재 위치의 컬럼 읽기
				// rs.getxxx("인덱스") : 안씀!.
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt("p_gram"));
				System.out.println(rs.getInt("p_price"));

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
}
