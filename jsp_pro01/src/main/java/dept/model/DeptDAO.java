package dept.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class DeptDAO {

	private SqlSession session;
	
	public DeptDAO() {
		session = DBConn.getSqlSession();
	}
	
	public List<DeptDTO> searchAll() {
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectAll");
		return datas;
	}
	
	public List<DeptDTO> searchPage(int start, int end) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectPage", page);
		return datas;
	}
	
	public int rowCount() {
		int count = session.selectOne("deptMapper.deptRowCount");
		return count;
	}
	
	public DeptDTO searchDeptId(int id) {
		DeptDTO data = session.selectOne("deptMapper.deptSelectId", id);
		return data;
	}

	public boolean insertDept(DeptDTO data) {
		int result = session.insert("deptMapper.deptInsert", data);
		
		if(result == 1) {
			return true;
		}
		return false;
	}

	public boolean updateDept(DeptDTO data) {
		int result = session.update("deptMapper.deptUpdate", data);
		
		if(result == 1) {
			return true;
		}
		
		return false;
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
	
	public boolean deleteDept(int id) {
		int result = session.delete("deptMapper.deptDelete", id);
		
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}

}
