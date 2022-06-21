package cashbook.vo;

import java.sql.Date;
import java.util.ArrayList;

public class CbookVO {
	private ArrayList<Integer> serialNum = new ArrayList<>();
	private ArrayList<Date> transactionDate = new ArrayList<>();
	private ArrayList<String> siteName = new ArrayList<>();
	private ArrayList<String> breakdown = new ArrayList<>();
	private ArrayList<Integer> deposit = new ArrayList<>();
	private ArrayList<Integer> expense = new ArrayList<>();
	private ArrayList<Integer> noteNum = new ArrayList<>();
	private ArrayList<String> noteName = new ArrayList<>();
	
//	private int serialNum;
//	private Date transactionDate;
//	private String siteName;
//	private String breakdown;
//	private int deposit;
//	private int expense;
//	private int noteNum;
//	private String noteName;
	
	public CbookVO() {}

	public int getSerialNum(int idx) {
		return serialNum.get(idx);
	}

	public void setSerialNum(int serialNum) {
		this.serialNum.add(serialNum);
	}

	public Date getTransactionDate(int idx) {
		return transactionDate.get(idx);
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate.add(transactionDate);
	}

	public String getSiteName(int idx) {
		return siteName.get(idx);
	}

	public void setSiteName(String siteName) {
		this.siteName.add(siteName);
	}

	public String getBreakdown(int idx) {
		return breakdown.get(idx);
	}

	public void setBreakdown(String breakdown) {
		this.breakdown.add(breakdown);
	}

	public int getDeposit(int idx) {
		return deposit.get(idx);
	}

	public void setDeposit(int deposit) {
		this.deposit.add(deposit);
	}

	public int getExpense(int idx) {
		return expense.get(idx);
	}

	public void setExpense(int expense) {
		this.expense.add(expense);
	}

	public int getNoteNum(int idx) {
		return noteNum.get(idx);
	}

	public void setNoteNum(int noteNum) {
		this.noteNum.add(noteNum);
	}

	public String getNoteName(int idx) {
		return noteName.get(idx);
	}

	public void setNoteName(String noteName) {
		this.noteName.add(noteName);
	}
	public int lengthSerialNum() {
		return this.serialNum.size();
	}
	public int lengthNoteNum() {
		return this.noteNum.size();
	}
	
	
	
//	public int getSerialNum() {
//		return serialNum;
//	}
//	public void setSerialNum(int serialNum) {
//		this.serialNum = serialNum;
//	}
//	public Date getTransactionDate() {
//		return transactionDate;
//	}
//	public void setTransactionDate(Date transactionDate) {
//		this.transactionDate = transactionDate;
//	}
//	public String getSiteName() {
//		return siteName;
//	}
//	public void setSiteName(String stieName) {
//		this.siteName = stieName;
//	}
//	public String getBreakdown() {
//		return breakdown;
//	}
//	public void setBreakdown(String breakdown) {
//		this.breakdown = breakdown;
//	}
//	public int getDeposit() {
//		return deposit;
//	}
//	public void setDeposit(int deposit) {
//		this.deposit = deposit;
//	}
//	public int getExpense() {
//		return expense;
//	}
//	public void setExpense(int expense) {
//		this.expense = expense;
//	}
//	public int getNoteNum() {
//		return noteNum;
//	}
//	public void setNoteNum(int noteNum) {
//		this.noteNum = noteNum;
//	}
//	public String getNoteName() {
//		return noteName;
//	}
//	public void setNoteName(String noteName) {
//		this.noteName = noteName;
//	}
//	
}
