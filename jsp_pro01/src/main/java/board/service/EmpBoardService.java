package board.service;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;

public class EmpBoardService {
	public int addContent(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
			dao.close();
			return data.getId();
		}
		dao.rollback();
		dao.close();
		return -1;
	}
}
