package com.conn.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.conn.db.DBconn;

public class Employees {
	
	private DBconn db;
	
	public Employees() {
		try {
			db = new DBconn("localhost", "1521", "XEPDB1", "puser1", "puser1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSalary(int salary) {
		/*
		 * salary 에 해당하는 데이터를 조회하여 출력해보기
		 * 출력에 사용할 컬럼은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALRARY 로 한다.
		 */
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY = " + salary;
		try {
			ResultSet rs = db.sendSelectQuery(query);
			while(rs.next()) {
				System.out.println("EMPLOYEE_ID : " + rs.getInt("EMPLOYEE_ID"));
				System.out.println(" FIRST_NAME : " + rs.getString("FIRST_NAME"));
				System.out.println("  LAST_NAME : " + rs.getString("LAST_NAME"));
				System.out.println("     SALARY : " + rs.getInt("SALARY"));
				System.out.println("-----------------------------------------");
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			db.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Employees emp = new Employees();
		emp.getSalary(10000);
		emp.close();
	}
}
