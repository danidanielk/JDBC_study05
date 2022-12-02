package JDBC_2;

import java.util.Scanner;

public class ConsoleScreen {
	
	String rsvname;
	String rsvdate;
	int	rsvphone;
	String rsvlocation;
	
	String rstowner;
	String rstlocation;
	int rstseat;
	public ConsoleScreen() {
		// TODO Auto-generated constructor stub
	}
	public ConsoleScreen(String rsvname, String rsvdate, int rsvphone, String rsvlocation, String rstowner,
			String rstlocation, int rstseat) {
		super();
		this.rsvname = rsvname;
		this.rsvdate = rsvdate;
		this.rsvphone = rsvphone;
		this.rsvlocation = rsvlocation;
		this.rstowner = rstowner;
		this.rstlocation = rstlocation;
		this.rstseat = rstseat;
	}
	public String getRsvname() {
		return rsvname;
	}
	public void setRsvname(String rsvname) {
		this.rsvname = rsvname;
	}
	public String getRsvdate() {
		return rsvdate;
	}
	public void setRsvdate(String rsvdate) {
		this.rsvdate = rsvdate;
	}
	public int getRsvphone() {
		return rsvphone;
	}
	public void setRsvphone(int rsvphone) {
		this.rsvphone = rsvphone;
	}
	public String getRsvlocation() {
		return rsvlocation;
	}
	public void setRsvlocation(String rsvlocation) {
		this.rsvlocation = rsvlocation;
	}
	public String getRstowner() {
		return rstowner;
	}
	public void setRstowner(String rstowner) {
		this.rstowner = rstowner;
	}
	public String getRstlocation() {
		return rstlocation;
	}
	public void setRstlocation(String rstlocation) {
		this.rstlocation = rstlocation;
	}
	public int getRstseat() {
		return rstseat;
	}
	public void setRstseat(int rstseat) {
		this.rstseat = rstseat;
	}
	
	public void no1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요 : ");
		rsvname = scan.next();
		
		System.out.println("예약일 지정해주세요 : ");
		rsvdate = scan.next();
		
		System.out.println("연락처를 입력해 주세요 : ");
		rsvphone = scan.nextInt();
		
		System.out.println("지역을 입력해 주세요 : ");
		rsvlocation = scan.next();
	}
	
	public void no2() {
		
	}
}
