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
			// ��ǰ�̸��� ������������ �����ؼ� ��ǰ ��ü ���� ��ȸ
			String sql = "select * from product order by p_food";

			pstmt = con.prepareStatement(sql);

			// pstmt.executeUpdate(); : ��� ������ �޾Ҵ°� (C , U, D)
			rs = pstmt.executeQuery(); // : ������ (R)
			// select ���� ������ ��� : ResultSet - List �� ����� ����

			while (rs.next()) { // : ���� �����ͷ� �Ѿ xml����.. ���� �����Ͱ� ������ true ������ false�� ����.
				// rs.getxxx("�÷���") : ���� ��ġ�� �÷� �б�
				// rs.getxxx("�ε���") : �Ⱦ�!.
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
