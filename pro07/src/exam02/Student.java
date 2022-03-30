package exam02;

public class Student extends Person {
	private int classLevel;
	private int classRoom;
	
	public Student(String name) {
		super.setName(name);
	}
	
	@Override
	public String getGender() {
		return super.getGender() + "학생";
	}
	
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
}
