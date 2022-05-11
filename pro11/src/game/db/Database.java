package game.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Database {
	
	private File file;
	
	public Database() {
		this.file = new File("C:/Users/KHS/data_write");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public int[] load() {
		int[] record = new int[3];
		if(file.exists()) {
			try(FileReader fr = new FileReader(file)) {
				char[] buffer = new char[4];
				char[] data = new char[0];
				
				while(true) {
					int size = fr.read(buffer);
					
					if(size == -1) {
						break;
					}
					
					data = Arrays.copyOf(data, data.length + size);
					System.arraycopy(buffer, 0, data, data.length - size, size);
				}
				StringTokenizer st = new StringTokenizer(new String(data), " ");
				record = new int[st.countTokens()];
				int i = 0;
				while(st.hasMoreElements()) {
					record[i++] = Integer.parseInt(st.nextToken());
				}
				
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return record;
	}

	public void save(int[] record) {
		// 정수 배열을 파일로 저장
		String[] recArr = new String[record.length];
		for(int i = 0; i < record.length; i++) {
			recArr[i] = Integer.valueOf(record[i]).toString();
		}
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(String.join(" ", recArr));
			fw.flush();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}