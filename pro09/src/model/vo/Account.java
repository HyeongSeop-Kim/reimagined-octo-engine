package model.vo;

import exception.PasswordUnvalidException;

public class Account {
	private String name;
	private String password;
	
	public Account(String name) {
		this.name = name;
		this.password = "1111";
	}
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(!(password.length()>=4 && password.length()<=12)) {
			throw new PasswordUnvalidException("비밀번호의 길이는 4 ~ 12 자 사이여야합니다.");
		} else {
			for(int i = 0; i < password.length(); i++) {
				boolean checkNum = false;
				boolean checkSpel = false;
				if(password.charAt(i)>='A' && password.charAt(i)<='z') {
					checkSpel = true;
				}
				if(password.charAt(i)>='0' && password.charAt(i)<='9') {
					checkNum = true; 
				}
				if(checkNum == false && checkSpel == false) {
					throw new PasswordUnvalidException("비밀번호는 영문자와 숫자의 조합으로 만들어주세요.");
				}
			}
		}
		this.password = password;
	}
	
	public boolean changePassword(String currPass, String changePass) {
		if(currPass.equals(getPassword())) {
			setPassword(changePass);
			return true;
		}
		return false;
	}
	
}
