package dept.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import common.model.AbstractDAO;

public class DeptDAO extends AbstractDAO<List<DeptDTO>, DeptDTO> {
	
	@Override
	public List<DeptDTO> selectAll() {		
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectAll");
		return datas;
	}
	
	@Override
	public DeptDTO selectId(int id) {
		DeptDTO data = session.selectOne("deptMapper.deptSelectId", id);
		return data;
	}

	@Override
	public DeptDTO selectId(DeptDTO e) {
		DeptDTO data = session.selectOne("deptMapper.deptSelectId", e.getDeptId());
		return data;
	}
	
	@Override
	public int rowCount() {
		int count = session.selectOne("deptMapper.deptRowCount");
		return count;
	}

	@Override
	public boolean insertData(DeptDTO data) {
		int result = session.insert("deptMapper.deptInsert", data);
		
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateData(DeptDTO data) {
		int result = session.update("deptMapper.deptUpdate", data);
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteData(int id) {
		int result = session.delete("deptMapper.deptDelete", id);
		
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteData(DeptDTO e) {
		int result = session.delete("deptMapper.deptDelete", e.getDeptId());
		
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public List<DeptDTO> searchPage(int start, int end) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectPage", page);
		return datas;
	}
	
	public List<DeptDTO> searchPage(int start, int end, String sort) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		switch(sort) {
			case "deptId":
				page.put("sort", 1); break;
			case "deptName":
				page.put("sort", 2); break;
			case "mngId":
				page.put("sort", 3); break;
			case "locId":
				page.put("sort", 4); break;
		}
		
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectPage", page);
		return datas;
	}
	
	public boolean existManager(int id) {
		int result = session.selectOne("deptMapper.existManager", id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean existLocation(int id) {
		int result = session.selectOne("deptMapper.existLocation", id);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public boolean existDeptId(String id) {
		int result = session.selectOne("deptMapper.existDeptId", id);
		if(result == 1) {
			return true;
		}
		return false;
	}

}
