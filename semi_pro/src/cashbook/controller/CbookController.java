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
		CbookVO rs = cDAO.inquiry(startDate, endDate);
		String result = new String();
		
		if(rs != null) {			
			for(int i = 0; i < rs.lengthSerialNum(); i++) {
				java.util.Date transDate = new java.util.Date(rs.getTransactionDate(i).getTime());
				result += "| " + String.format("%6d", rs.getSerialNum(i)) + " | "
						+ sFormat.format(transDate) + " | "
						+ String.format("%10s", rs.getSiteName(i)) + " | "
						+ String.format("%20s", rs.getBreakdown(i)) + " | "
						+ String.format("%,11d", rs.getDeposit(i)) + " | "
						+ String.format("%,11d", rs.getExpense(i)) + " | "
						+ String.format("%10s", rs.getNoteName(i)) + " | \n"
						+"+--------------------------------------------------------------------------------------------------------+\n";
			}
			return result;
		}
		return null;
	}
		
	public String inquiry() {
		CbookVO rs = cDAO.inquiry();
		String result = new String();
		
		if(rs != null) {			
			for(int i = 0; i < rs.lengthSerialNum(); i++) {
				java.util.Date transDate = new java.util.Date(rs.getTransactionDate(i).getTime());
				result += "| " + String.format("%6d", rs.getSerialNum(i)) + " | "
						+ sFormat.format(transDate) + " | "
						+ String.format("%10s", rs.getSiteName(i)) + " | "
						+ String.format("%20s", rs.getBreakdown(i)) + " | "
						+ String.format("%,11d", rs.getDeposit(i)) + " | "
						+ String.format("%,11d", rs.getExpense(i)) + " | "
						+ String.format("%10s", rs.getNoteName(i)) + " | \n"
						+"+--------------------------------------------------------------------------------------------------------+\n";
			}
			return result;
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
		CbookVO rs = cDAO.getNoteList();
		String result = new String();
		
		if(rs != null) {			
			System.out.print("+---------------+\n| 번호 |   비고   |\n+---------------+\n");
			for(int i = 0; i < rs.lengthNoteNum(); i++) {
				result += "|  "
						+ String.format("%-2d", rs.getNoteNum(i)) + " | "
						+ String.format("%6s", rs.getNoteName(i)) + " | \n"
						+"+---------------+\n";
			}
			return result;
		} 
		return null;
	}
		
}
