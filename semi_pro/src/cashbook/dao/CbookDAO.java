package cashbook.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cashbook.vo.CbookVO;
import conn.db.DBConn;

public class CbookDAO {
	private DBConn db;
	
	public CbookDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet inquiry(Date startDate, Date endDate) {
		String query = "SELECT TRANSACTION_DATE"
				+ ", SERIAL_NUM"
				+ ", SITE_NAME"
				+ ", BREAKDOWN"
				+ ", DEPOSIT"
				+ ", EXPENSE"
				+ ", NOTE_NAME"
				+ " FROM CASHBOOK"
				+ " JOIN NOTE"
				+ " ON NOTE.NOTE_NUM = CASHBOOK.NOTE_NUM"
				+ " WHERE TRANSACTION_DATE >= ? AND TRANSACTION_DATE <= ?"
				+ " ORDER BY TRANSACTION_DATE";
//		String sDate = new java.sql.Date(startDate.getTime()).toString(); 
//		String eDate = new java.sql.Date(endDate.getTime()).toString(); 
		java.sql.Date sDate = new java.sql.Date(startDate.getTime()); 
		java.sql.Date eDate = new java.sql.Date(endDate.getTime()); 
		try {
			PreparedStatement pstat = db.getPstat(query);
//			pstat.setString(1, sDate);
//			pstat.setString(2, eDate);
			pstat.setDate(1, sDate);
			pstat.setDate(2, eDate);
			ResultSet rs = db.sendSelectQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet inquiry() {
		String query = "SELECT TRANSACTION_DATE"
				+ ", SERIAL_NUM"
				+ ", SITE_NAME"
				+ ", BREAKDOWN"
				+ ", DEPOSIT"
				+ ", EXPENSE"
				+ ", NOTE_NAME"
				+ " FROM CASHBOOK"
				+ " JOIN NOTE"
				+ " ON NOTE.NOTE_NUM = CASHBOOK.NOTE_NUM"
				+ " ORDER BY TRANSACTION_DATE";
		try {
			PreparedStatement pstat = db.getPstat(query);
			ResultSet rs = db.sendSelectQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet getNoteList() {
		String query = "SELECT * FROM NOTE";
		try {
			PreparedStatement pstat = db.getPstat(query);
			ResultSet rs = db.sendSelectQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addDeposit(CbookVO cVO) {
		String query = "INSERT INTO CASHBOOK VALUES (SQU_SNUM.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setDate(1, cVO.getTransactionDate());
			pstat.setString(2, cVO.getSiteName());
			pstat.setString(3, cVO.getBreakdown());
			pstat.setInt(4, cVO.getDeposit());
			pstat.setInt(5, 0);
			pstat.setInt(6, cVO.getNoteNum());
			int rs = db.sendInsertQuery();
			if(rs == 1) {
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addExpense(CbookVO cVO) {
		String query = "INSERT INTO CASHBOOK VALUES (SQU_SNUM.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setDate(1, cVO.getTransactionDate());
			pstat.setString(2, cVO.getSiteName());
			pstat.setString(3, cVO.getBreakdown());
			pstat.setInt(4, 0);
			pstat.setInt(5, cVO.getExpense());
			pstat.setInt(6, cVO.getNoteNum());
			int rs = db.sendInsertQuery();
			if(rs == 1) {
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modify(CbookVO cVO) {
		String query = "UPDATE CASHBOOK SET TRANSACTION_DATE = ?"
					 + ", SITE_NAME = ?"
					 + ", BREAKDOWN = ?"
					 + ", DEPOSIT = ?"
					 + ", EXPENSE = ?"
					 + ", NOTE_NUM = ?"
					 + " WHERE SERIAL_NUM = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setDate(1, cVO.getTransactionDate());
			pstat.setString(2, cVO.getSiteName());
			pstat.setString(3, cVO.getBreakdown());
			pstat.setInt(4, cVO.getDeposit());
			pstat.setInt(5, cVO.getExpense());
			pstat.setInt(6, cVO.getNoteNum());
			pstat.setInt(7, cVO.getSerialNum());
			int rs = db.sendUpdateQuery();
			if(rs == 1) {
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remove(int serialNum) {
		String query = "DELETE FROM CASHBOOK WHERE SERIAL_NUM=?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, serialNum);
			int rs = db.sendDeleteQuery();
			if(rs == 1) {
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet findData(int serialNum) {
		String query = "SELECT * FROM CASHBOOK WHERE SERIAL_NUM=?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, serialNum);
			ResultSet rs = db.sendSelectQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
