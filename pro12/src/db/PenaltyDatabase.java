package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PenaltyDatabase {

	public void add(String input) {
		File file = new File("C:/Users/KHS/penalty.db");
		
		try(FileWriter fw = new FileWriter(file,  true)) {
			fw.write(input + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String load() {
		File file = new File("C:/Users/KHS/penalty.db");
		
		try(FileReader fr = new FileReader(file)) {
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[1024];
			while(true) {
				int size = fr.read(buff);
				if(size == -1) {
					break;
				}
				sb.append(buff, 0, size);
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public void modify(int number, String input) {
		File file = new File("C:/Users/KHS/penalty.db");
		
		try(FileReader fr = new FileReader(file)) {
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[1024];
			while(true) {
				int size = fr.read(buff);
				if(size == -1) {
					break;
				}
				sb.append(buff, 0, size);
			}
			String[] data = sb.toString().split("\n");
			data[number - 1] = input;
			
			try(FileWriter fw = new FileWriter(file)) {
				for(int i = 0; i < data.length; i++) {
					fw.write(data[i] + "\n");
				}
				fw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(int number) {
		File file = new File("C:/Users/KHS/penalty.db");
		
		try(FileReader fr = new FileReader(file)) {
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[1024];
			while(true) {
				int size = fr.read(buff);
				if(size == -1) {
					break;
				}
				sb.append(buff, 0, size);
			}
			String[] data = sb.toString().split("\n");
			number -= 1;
			
			try(FileWriter fw = new FileWriter(file)) {
				for(int i = 0; i < data.length; i++) {
					fw.write(data[i] + "\n");
				}
				fw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
