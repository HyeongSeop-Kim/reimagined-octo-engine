package com.join.controller;

import com.join.dao.JoinDAO;
import com.join.vo.JoinVO;

public class JoinController {
	
	private JoinDAO dao = new JoinDAO();
	
	public boolean join(JoinVO data) {
		// 회원가입 처리 전 필요한 로직(데이터 검사, 계산 등)
		// 회원가입 처리 후 결과를 반환한다.
		JoinVO account = dao.get(data.getUserID());
		if(account == null) {
			boolean result = dao.add(data);
			if(result) {
				return true;
			}
		}
		return false;
	}
	
	public JoinVO login(String userID, String userPW) {
		JoinVO account = dao.get(userID);
		
		// userID에 해당하는 계정이 있는지 확인
		if(account != null) {
			if(account.getUserPW().equals(userPW)) {
				return account;
			}
		}
		
		return null;
		// 해당 계정이 userPW의 값과 동일한 패스워드를 가지고 있는지 확인 후
		
		// 동일한 정보면 사용자 정보 객체(JoinVO) 전달 아니면 null 전달
	}
	
	public boolean update(JoinVO data) {
		return dao.modify(data);
	}
	
	public boolean remove(JoinVO data, String password) {
		if(data.getUserPW().equals(password)) {
			return dao.remove(data);
		} else {
			return false;
		}
	}
}
