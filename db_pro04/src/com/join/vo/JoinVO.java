package com.join.vo;

import java.sql.Date;

/*
 *  회원 정보를 담아 두기 위한 객체로 활용
 *  VO : Value Object
 */
public class JoinVO {
	private String userID;		// 회원아이디
	private String userPW;		// 회원 패스워드
	private String name;		// 회원 이름
	private char gender;		// 성별('M', 'F')
	private int age;			// 나이
	private Date createDate;	// 가입일
	
	public JoinVO() {}
	public JoinVO(String userID, String userPW, String name, char gender, int age, Date createDate) {
		this.userID = userID;
		this.userPW = userPW;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.createDate = createDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender.charAt(0);
		if(this.gender == '남' || this.gender == 'M') {
			this.gender = 'M';
		} else if(this.gender == '여' || this.gender == 'F') {
			this.gender = 'F';
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
}
