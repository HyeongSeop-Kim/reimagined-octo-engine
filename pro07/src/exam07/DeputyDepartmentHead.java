package exam07;

public class DeputyDepartmentHead extends SectionChief implements TeamManager, HeadManager{
	public boolean director = false;
	
	public DeputyDepartmentHead(String name, String position) {
		super(name, position);
	}
	
	public void setDirector(boolean director) {
		if(this.getTeamLeader() && director) {
			this.setTeamLeader(false);
		}
		this.director = director;
	}
	
	@Override
	public double salary() {
		double salary, bonus;
		if(this.director) {
			salary = headPayBonus();
			bonus = _bonus(this.getPosition());
			month++;
		} else {
			salary = this.annualIncom / 12;
			bonus = _bonus(this.getPosition());
			month++;
		}		
		return salary + bonus;
	}

	@Override
	public double headPayBonus() {
		double salary = this.annualIncom * 1.2 / 12;	
		return salary;
	}

}
