import java.sql.Connection;
import java.sql.DriverManager;

public class E_Connect {
	//���� 		: 	cmd ��� sqlplus ��� ���α׷�����oracleDB����
		//				cmd ��� ����
		//����ǰ�� ����	:	orange, toad, eclipse, dbeaver, sqldeveloper, ...
		
		//soket ���
		//http ��� 
		//�ΰ����� �غ��Ҵ�.
		
		//DB������ ����� �غ��� : java �ȿ� ����Ǿ� �ִ� (�̿ϼ�����) 
		//					: DB ����Ŀ�� ���� ������ .. > ����Ŀ ���� ����� ���ݾ� �޶�
		//					: ���� �� DB�� ���缭 ���ݾ� ��ġ�� ����� �Ѵ�..
		//					: ���� oracleDB ����� > ���⿡ ���缭 �����غ���.
		//					: �� ����� ojdbc8.jar �� �� ����.
		//					: ojdbc8.jar �ֱ⸸ �ϸ� �˾Ƽ� ����� �� ����.
		
		
		public static void main(String[] args) {
			Connection con = null;
			
			
			try {
			//������ DB������ �ּҰ� �ʿ� (����Ŀ���� ������ �ٸ���.)
			//data source explorer ���� �̸�����  ������ ���콺 ��ư Ŭ��
				String addr = "jdbc:oracle:thin:@192.168.123.100:1521:xe";
				con = DriverManager.getConnection(addr, "danidani", "1");
				System.out.println("success");
				
			} catch (Exception e) {
					e.printStackTrace();
			}
			try {
				con.close(); //�ȴ����� �ٸ������ �����
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
