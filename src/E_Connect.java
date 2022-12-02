import java.sql.Connection;
import java.sql.DriverManager;

public class E_Connect {
	//원래 		: 	cmd 기반 sqlplus 라는 프로그램으로oracleDB제어
		//				cmd 기반 불편
		//사제품의 등장	:	orange, toad, eclipse, dbeaver, sqldeveloper, ...
		
		//soket 통신
		//http 통신 
		//두가지를 해보았다.
		
		//DB서버와 통신을 해보자 : java 안에 내장되어 있다 (미완성상태) 
		//					: DB 메이커가 많기 때문에 .. > 메이커 별로 통신이 조금씩 달라서
		//					: 연결 할 DB에 맞춰서 조금씩 터치를 해줘야 한다..
		//					: 현재 oracleDB 사용중 > 여기에 맞춰서 세팅해보자.
		//					: 그 기능은 ojdbc8.jar 에 다 있음.
		//					: ojdbc8.jar 넣기만 하면 알아서 사용할 수 있음.
		
		
		public static void main(String[] args) {
			Connection con = null;
			
			
			try {
			//연결할 DB서버의 주소가 필요 (메이커별로 형식이 다르다.)
			//data source explorer 서버 이름족에  오른쪽 마우스 버튼 클릭
				String addr = "jdbc:oracle:thin:@192.168.123.100:1521:xe";
				con = DriverManager.getConnection(addr, "danidani", "1");
				System.out.println("success");
				
			} catch (Exception e) {
					e.printStackTrace();
			}
			try {
				con.close(); //안닫으면 다른사람이 못써요
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
