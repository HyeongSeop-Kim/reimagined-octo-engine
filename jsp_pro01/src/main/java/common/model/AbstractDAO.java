package common.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public abstract class AbstractDAO<E> {
	protected SqlSession session = DBConn.getSqlSession();
	
	public abstract List<E> selectAll();
	
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
