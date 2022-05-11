package com.conn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.conn.exam.Employees;

public class DBconn {
	
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	private Statement stat;
	
	public DBconn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
	}
	public DBconn(String tnsAlias, String walletPath, String username, String password) throws Exception {
		url_address = String.format("%s?TNS_ADMIN=%s", tnsAlias, walletPath);
		this.createConnection(username, password);
	}
	
	private void createConnection(String username, String password) throws Exception {
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
		stat = conn.createStatement();
	}
	
	public ResultSet sendSelectQuery(String query) throws Exception {
		return this.stat.executeQuery(query);
	}
	
	public int sendInsertQuery(String query) throws Exception {
		return this.stat.executeUpdate(query);
	}
	
	public int sendUpdateQuery(String query) throws Exception {
		return this.stat.executeUpdate(query);
	}
	
	public int sendDeletetQuery(String query) throws Exception {
		return this.stat.executeUpdate(query);
	}
	
	public void close() throws Exception {
		this.stat.close();
		this.conn.close();
	}
//	
//	public void localConnect() throws Exception {
//		// 1. Driver 등록
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		// 2. DBMS 연결
//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "puser1", "puser1");
//		
//		// 3. Statement 생성
//		Statement stat = conn.createStatement();
//		
//		// 4. SQL 질의문 전송 및 반환
//		//int rowCount = stat.executeUpdate("INSERT INTO DEPARTMENTS VALUES(280, 'Tester', NULL, 1700");
//		//int rowCount = stat.executeUpdate("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 280")l
//		ResultSet rs = stat.executeQuery("SELECT * FROM DEPARTMENTS");
//		while(rs.next()) {
//			System.out.println(rs.getString(1) + "\t");
//			System.out.println(rs.getString(2) + "\t");
//			System.out.println(rs.getString(3) + "\t");
//			System.out.println(rs.getString(4) + "\n");
//			
//		}
//		
//		// 5. 객체 반환
//		rs.close();
//		stat.close();
//		conn.close();
//	}
//	public static void main(String[] args) throws Exception {
//		DBconn myDB = new DBconn();
// 		myDB.localConnect();
//		Employees ep = new Employees();
//		ep.getSalrary(24000);
//	}

}
