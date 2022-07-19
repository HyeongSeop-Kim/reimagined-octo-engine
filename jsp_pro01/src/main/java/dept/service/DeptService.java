package dept.service;

import java.util.ArrayList;
import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;
	
	public List<DeptDTO> getAll() {
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchAll();
		dao.close();
		return datas;
	}
	
	public List<DeptDTO> getPage(int pageNumber) {
		int start = 1 + (pageNumber-1) * 10;
		int end = pageNumber*10;
		
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}
	
	public List<DeptDTO> getPage(int pageNumber, int count) {
		int start = 1 + (pageNumber-1) * count;
		int end = pageNumber*count;
		
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}
	
	public List<DeptDTO> getPage(int pageNumber, int count, String sort) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchPage(start, end, sort);
		dao.close();
		return datas;
	}
	
	public List<Integer> getPageNumberList() {
		dao = new DeptDAO();
		int rowCount = dao.rowCount();
		dao.close();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / 10;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
	
	public List<Integer> getPageNumberList(int count) {
		dao = new DeptDAO();
		int rowCount = dao.rowCount();
		dao.close();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / count;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
	
	public DeptDTO getDeptId(String id) {
		boolean isNumber = id.matches("\\d+");
		if(isNumber) {
			int deptId = Integer.parseInt(id);
			dao = new DeptDAO();
			DeptDTO data = _getDeptId(deptId);
			dao.close();
			return data;
		}
		return null;
	}
	
	public DeptDTO getDeptId(int id) {
		dao = new DeptDAO();
		DeptDTO data = _getDeptId(id);
		dao.close();
		return data;
	}
	
	private DeptDTO _getDeptId(int id) {
		dao = new DeptDAO();
		DeptDTO data = dao.searchDeptId(id);
		return data;
	}

	public DEPT_SERVICE_STATUS addDept(DeptDTO data) {
		dao = new DeptDAO();
		DEPT_SERVICE_STATUS status = DEPT_SERVICE_STATUS.SUCCESS;
		
		if(_getDeptId(data.getDeptId()) != null) {
			status = DEPT_SERVICE_STATUS.DEPT_ID_DUPLICATED;
		}
		if(!_existManager(data.getMngId())) {
			status = DEPT_SERVICE_STATUS.MNG_ID_NOT_EXISTS;
		}
		if(!_existLocation(data.getLocId())) {
			status = DEPT_SERVICE_STATUS.LOC_ID_NOT_EXISTS;
		}
		
		switch(status) {
			case SUCCESS :
				if(dao.insertDept(data)) {
					dao.commit();
				} else {
					status = DEPT_SERVICE_STATUS.FAILED;
					dao.rollback();
				}
				break;
			default:
				dao.close();
		}
		
		return status;
	}
	
	public DEPT_SERVICE_STATUS modifyDept(DeptDTO data) {
		dao = new DeptDAO();
		DEPT_SERVICE_STATUS status = DEPT_SERVICE_STATUS.SUCCESS;

		if(!_existManager(data.getMngId())) {
			status = DEPT_SERVICE_STATUS.MNG_ID_NOT_EXISTS;
		}
		if(!_existLocation(data.getLocId())) {
			status = DEPT_SERVICE_STATUS.LOC_ID_NOT_EXISTS;
		}
		
		switch(status) {
			case SUCCESS :
				if(dao.updateDept(data)) {
					dao.commit();
				} else {
					status = DEPT_SERVICE_STATUS.FAILED;
					dao.rollback();
				}
				break;
			default:
				dao.close();
		}
		
		return status;
	}

	public DEPT_SERVICE_STATUS deleteDept(String id) {
		dao = new DeptDAO();
		DEPT_SERVICE_STATUS status = DEPT_SERVICE_STATUS.SUCCESS;
		
		if(!_existDeptId(id)) {
			status = DEPT_SERVICE_STATUS.DEPT_ID_NOT_EXISTS;
		}
		
		switch(status) {
			case SUCCESS:
				if(dao.deleteDept(Integer.parseInt(id))) {
					dao.commit();
				} else {
					status = DEPT_SERVICE_STATUS.FAILED;
					dao.rollback();
				}
				break;
			default:
				dao.close();
		}
		return status;
	}

	private boolean _existDeptId(String id) {
		boolean result = dao.existDeptId(id);
		return result;
	}

	private boolean _existManager(int id) {
		boolean result = dao.existManager(id);
		return result;
	}
	
	private boolean _existLocation(int id) {
		boolean result = dao.existLocation(id);
		return result;
	}
	
}



