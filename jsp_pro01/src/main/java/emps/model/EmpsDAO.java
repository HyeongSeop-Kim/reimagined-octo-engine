package emps.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class EmpsDAO {
	private SqlSession session = DBConn.getSqlSession();
	private String mapper = "empsMapper.%s";
	
	public Map<String, Integer> checkSalaryRange(String id) {
		String mapId = String.format(mapper, "checkSalaryRange");
		Map<String, Integer> data = session.selectOne(mapId, id);
		return data;
	}
	
	public List<EmpsDTO> selectAll() {
		String mapId = String.format(mapper, "selectAll");
		List<EmpsDTO> datas = session.selectList(mapId);
		return datas;
	}

	public List<EmpsDTO> selectPage(int start, int end) {
		String mapId = String.format(mapper, "selectPage");
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		List<EmpsDTO> datas = session.selectList(mapId, page);
		return datas;
	}
	
	public int rowCount() {
		String mapId = String.format(mapper, "rowCount");
		int count = session.selectOne(mapId);
		return count;
	}
	
	public EmpsDetailDTO selectEmpDetail(int empId) {
		String mapId = String.format(mapper, "selectEmpDetail");
		EmpsDetailDTO data = session.selectOne(mapId, empId);
		return data;
	}
	
	public boolean updateEmp(EmpsDTO empsData) {
		String mapId = String.format(mapper, "updateEmp");
		int result = session.update(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateEmpDetail(EmpsDetailDTO empsDetailData) {
		String mapId = String.format(mapper, "updateEmpDetail");
		int result = session.update(mapId, empsDetailData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean insertEmp(EmpsDTO empsData) {
		String mapId = String.format(mapper, "insertEmp");
		int result = session.update(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public EmpsDTO selectId(int id) {
		String mapId = String.format(mapper, "selectId");
		EmpsDTO data = session.selectOne(mapId, id);
		return data;
	}

	public boolean deleteId(int id) {
		String mapId = String.format(mapper, "deleteId");
		int result = session.delete(mapId, id);
		return result == 1 ? true : false;
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
