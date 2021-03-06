package board.model;

import java.sql.Date;

public class EmpBoardDTO {
	private int id;
	private String title;
	private String content;
	private int empId;
	private Date createDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "EmpBoardDTO [id=" + id + ", title=" + title + ", content=" + content + ", empId=" + empId
				+ ", createDate=" + createDate + "]";
	}
	
}
