package job.model;

import java.util.List;

import common.model.AbstractDAO;

public class JobDAO extends AbstractDAO {


	public List<JobDTO> selectAll() {
		List<JobDTO> datas = session.selectList("empsMapper.selectAll");
		return datas;
	}
}
