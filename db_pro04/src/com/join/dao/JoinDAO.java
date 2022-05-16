package com.join.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.db.DBconn;
import com.join.vo.JoinVO;

// DAO : Database Access Object
public class JoinDAO {
	private DBconn db;
	
	public JoinDAO() {
		try {
			db = new DBconn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean add(JoinVO data) {
		// 데이터 추가
		
//		StringBuilder query1 = new StringBuilder();
//		query1.append("INSERT INTO ACCOUNTS VALUES(\'");
//		query1.append(data.getUserID() + "\', \'");
//		query1.append(data.getUserPW() + "\', \'");
//		query1.append(data.getName() + "\', \'");
//		query1.append(data.getGender() + "\', ");
//		query1.append(data.getAge() + ", \'");
//		query1.append("\')");			
		String query = "INSERT INTO ACCOUNTS VALUES(?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserID());
			pstat.setString(2, data.getUserPW());
			pstat.setString(3, data.getName());
			pstat.setString(4, Character.toString(data.getGender()));
			pstat.setInt(5, data.getAge());
			
			int result = db.sendInsertQuery();
			
			if(result == 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modify(JoinVO data) {
		String query = "UPDATE ACCOUNTS SET USERPW = ?"
					 + ", NAME = ?"
					 + ", GENDER = ?"
					 + ", AGE = ?"
					 + " WHERE USERID = '" + data.getUserID() + "'";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserPW());
			pstat.setString(2, data.getName());
			pstat.setString(3, Character.toString(data.getGender()));
			pstat.setInt(4, data.getAge());
			pstat.setString(5, data.getUserID());
			
			int rs = db.sendUpdateQuery();
			
			if(rs == 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean remove(JoinVO data) {
		String query = "DELETE FROM ACCOUNTS"
				 + " WHERE USERID = ?";
	try {
		PreparedStatement pstat = db.getPstat(query);
		pstat.setString(1, data.getUserID());
		
		int rs = db.sendDeleteQuery();
		
		if(rs == 1) {
			return true;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}
	
	public JoinVO get(String userID) {
		// 단일 데이터 조회		
		String query = String.format("SELECT * FROM ACCOUNTS WHERE USERID = ?");
		
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, userID);
			
			ResultSet result = db.sendSelectQuery();
			
			if(result.next()) {
				JoinVO data = new JoinVO();
				data.setUserID(result.getString("USERID"));
				data.setUserPW(result.getString("USERPW"));
				data.setName(result.getString("NAME"));
				data.setGender(result.getString("GENDER").charAt(0));
				data.setAge(result.getInt("AGE"));
				data.setCreateDate(result.getDate("join_date"));
				return data;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
