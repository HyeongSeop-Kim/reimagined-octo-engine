package conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DBConn {
	
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	private PreparedStatement pstat;
	
	public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
	}
	
	public DBConn(File config) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(config));
			
			while(br.ready()) {
				String[] kv = br.readLine().split("=");
				map.put(kv[0].strip(), kv[1].strip());
			}
			
			if(map.get("host") != null) {
				url_address = String.format("%s:%s/%s", map.get("host"), map.get("port"), map.get("service"));
			} else {
				System.out.println(config.getName() + "파일의 데이터베이스 연결 구성 정보가 잘못되었습니다.");
			}
			this.createConnection(map.get("username"),map.get("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createConnection(String username, String password) throws Exception {
		Class.forName(DRIVER_NAME);
		conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
	}
	
	public PreparedStatement getPstat(String query) throws Exception {
		pstat = conn.prepareStatement(query);
		return pstat;
	}
	
	public ResultSet sendSelectQuery() throws Exception {
		return this.pstat.executeQuery();
	}
	
	public int sendInsertQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	public int sendUpdateQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	public int sendDeleteQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	public void close() throws Exception {
		this.pstat.close();
		this.conn.close();
	}
}
