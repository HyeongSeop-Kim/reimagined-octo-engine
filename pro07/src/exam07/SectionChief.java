package exam07;

public class SectionChief extends DeputySectionChief {
	public boolean teamLeader = false;
	
	public SectionChief(String name, String position) {
		super(name, position);
	}
	
	public void setTeamLeader(boolean teamLeader) {
		this.teamLeader = teamLeader;
	}
	
	public boolean getTeamLeader() {
		return this.teamLeader;
	}
	
	@Override
	public double salary() {
		double salary, bonus;
		if(teamLeader) {
			salary = this.annualIncom * 1.1 / 12;
			bonus = _bonus(this.getPosition());
			month++;
		} else {
			salary = this.annualIncom / 12;
			bonus = _bonus(this.getPosition());
			month++;
		}		
		return salary + bonus;
	}
}
