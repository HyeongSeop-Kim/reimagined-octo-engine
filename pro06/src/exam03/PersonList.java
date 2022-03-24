package exam03;

import java.util.Arrays;

public class PersonList {
	private Person[] pList;
	
	public PersonList() {
		this.pList = new Person[0];
	}
	
	public PersonList(Person[] data) {
		this.pList = data;
	}
	
	public Person get(int index) {
		return pList[index];
	}
	
	public int length() {
		return this.pList.length;
	}
	
	public int findIndex(String name) {
		int idx = -1;
		
		for(int i = 0; i < this.pList.length; i++) {
			Person p = this.pList[i];
			if(p.getName().equals(name)) {
				idx=i;
			}
		}
		return idx;
	}
	
	public boolean existsName(String name) {
		boolean find = false;
		
		for(int i = 0; i < this.pList.length; i++) {
			Person p = this.pList[i];
			if(p.getName().equals(name)) {
				find = true;
			}
		}
		return find;
	}
	
	public void addFirst(Person person) {
		Person[] temp = new Person[this.length() + 1];
		System.arraycopy(this.pList, 0, temp, 1, this.length());
		temp[0] = person;
		this.pList = temp;
	}
	
	public void add(Person person) {
		this.pList = Arrays.copyOf(this.pList, this.length() + 1);
		this.pList[this.length()-1] = person;
	}
	
	public void remove(int index) {
		Person[] temp = new Person[this.length() - 1];
		int idx = 0;
		for(int i = 0; i < this.length(); i++) {
			if(i != index) {
				temp[idx++] = this.pList[i];
			}
		}
		this.pList = temp;
	}
	
	public void remove(String name) {
		this.remove(this.findIndex(name));
	}
}
