package JDBC;

import java.util.Scanner;

public class study2 {

	String name;
	String location;
	int no;
	int seat;
	
	public study2() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public void insert_store() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���̸� :");
		name = scan.next();
		System.out.println("��ġ :");
		location = scan.next();
		System.out.println("�ѹ� :");
		no = scan.nextInt();
		System.out.println("�¼� :");
		seat = scan.nextInt();
		
	}
	
}
