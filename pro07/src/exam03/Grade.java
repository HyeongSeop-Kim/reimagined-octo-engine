package exam03;

public class Grade extends Score {
	private char level;
	
	public Grade(double point) {
		
	}
	 
	@Override
	public void setPoint(double point) {
		if(point >= 0 && point <= 100) {
			super.setPoint(point);
		}
	}
}
