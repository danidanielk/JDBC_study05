package JDBC_2;

public class Controller {
public static void main(String[] args) {
	ConsoleScreen cs = new ConsoleScreen();
	DAO dao = new DAO();
	
	dao.insert_reservation(cs);


}

}
