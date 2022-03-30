package exam07;

public class Worker {
	private String name;
	private String[] appointment = new String[]{"사원", "대리", "과장", "차장", "부장"};
	private String position;
	protected double annualIncom;
	protected int month = 1;
	
	public Worker(String name, String position) {
		this.name = name;
		setPosition(position);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPosition(String position) {
		this.position = position;
		_setAnnualIncom(this.position);
	}
	
	public String getPosition() {
		return this.position;
	}
	
	private void _setAnnualIncom(String position) {
		int index = _findIndex(position);
		
		switch(index) {
			case 0 :
				this.annualIncom = 28000000;
				break;
			case 1 :
				this.annualIncom = 30000000;
				break;
			case 2 :
				this.annualIncom = 40000000;
				break;
			case 3 :
				this.annualIncom = 55000000;
				break;
			case 4 :
				this.annualIncom = 80000000;
				break;
			default :
				break;
		}
	}
	
	public double getAnnualIncom() {
		return this.annualIncom;
	}
	
	public double salary() {
		double salary = this.annualIncom / 12;
		double bonus = _bonus(this.position);
		month++;
		
		return salary + bonus;
	}
	
	protected double _bonus(String position) {
		int index = _findIndex(position);
		double bonus=0;
		switch(index) {
		case 0 : case 1 :
			if(month%6 == 0) {
				bonus = this.annualIncom*0.25;
			}
			break;
		case 2 : case 3 :
			if(month%4 == 0) {
				bonus = this.annualIncom*0.25;
			}
			break;
		case 4 :
			if(month%12 == 0) {
				bonus = this.annualIncom*0.25;
			}
			break;
		default :
			break;
		}
				
		return bonus;
	}
	
	private int _findIndex(String position) {
		int index = -1;
		for(int i = 0; i < this.appointment.length; i ++) {
			if(this.appointment[i].equals(position)) {
				index = i;
			}
		}
		return index;
	}
}
