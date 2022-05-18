package cashbook.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cashbook.dao.CbookDAO;
import cashbook.vo.CbookVO;

public class CbookController {
	CbookDAO cDAO = new CbookDAO();
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public String inquiry(Date startDate, Date endDate) {
		ResultSet rs = cDAO.inquiry(startDate, endDate);
		String result = new String();
		
		if(rs != null) {			
			try {
				while(rs.next()) {
					java.util.Date transDate = new java.util.Date(rs.getDate("TRANSACTION_DATE").getTime());
					result += "| " + String.format("%6d", rs.getInt("SERIAL_NUM")) + " | "
							+ sFormat.format(transDate) + " | "
							+ String.format("%10s", rs.getString("SITE_NAME")) + " | "
							+ String.format("%20s", rs.getString("BREAKDOWN")) + " | "
							+ String.format("%,11d", rs.getInt("DEPOSIT")) + " | "
							+ String.format("%,11d", rs.getInt("EXPENSE")) + " | "
							+ String.format("%10s", rs.getString("NOTE_NAME")) + " | \n"
							+"+--------------------------------------------------------------------------------------------------------+\n";
				}
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
		
	public String inquiry() {
		ResultSet rs = cDAO.inquiry();
		String result = new String();
		
		if(rs != null) {			
			try {
				while(rs.next()) {
					java.util.Date transDate = new java.util.Date(rs.getDate("TRANSACTION_DATE").getTime());
					result += "| " + String.format("%6d", rs.getInt("SERIAL_NUM")) + " | "
							+ sFormat.format(transDate) + " | "
							+ String.format("%10s", rs.getString("SITE_NAME")) + " | "
							+ String.format("%20s", rs.getString("BREAKDOWN")) + " | "
							+ String.format("%,11d", rs.getInt("DEPOSIT")) + " | "
							+ String.format("%,11d", rs.getInt("EXPENSE")) + " | "
							+ String.format("%10s", rs.getString("NOTE_NAME")) + " | \n"
							+"+--------------------------------------------------------------------------------------------------------+\n";
				}
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}
	
	public boolean addDeposit(CbookVO cVO) {
		boolean result = cDAO.addDeposit(cVO);
		return result;
	}
	
	public boolean addExpense(CbookVO cVO) {
		boolean result = cDAO.addExpense(cVO);
		return result;
	}
	
	public boolean modify(CbookVO cVO) {
		boolean result = cDAO.modify(cVO);
		return result;
	}
	
	public boolean remove(int serialNum) {
		boolean result = cDAO.remove(serialNum);
		return result;
	}
	
	public String showNoteList() {
		ResultSet rs = cDAO.getNoteList();
		String result = new String();
		
		if(rs != null) {			
			try {
				System.out.print("+---------------+\n| 번호 |   비고   |\n+---------------+\n");
				while(rs.next()) {
					result += "|  "
							+ String.format("%-2d", rs.getInt("NOTE_NUM")) + " | "
							+ String.format("%6s", rs.getString("NOTE_NAME")) + " | \n"
							+"+---------------+\n";
				}
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return null;
	}
	
	public CbookVO findData(int serialNum) {
		ResultSet rs = cDAO.findData(serialNum);
		CbookVO data = new CbookVO();
		try {
			while(rs.next()) {
				data.setTransactionDate(rs.getDate("TRANSACTION_DATE"));
				data.setSiteName(rs.getString("SITE_NAME"));
				data.setBreakdown(rs.getString("BREAKDOWN"));
				data.setDeposit(rs.getInt("DEPOSIT"));
				data.setExpense(rs.getInt("EXPENSE"));
				data.setNoteNum(rs.getInt("NOTE_NUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
		
}
