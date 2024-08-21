package model;

public class DisciplineDistance {
	
	//------------------------------------------------>||ATTRIBUTES||<--------------------------------------------------------\\
	
	private double distance;
	private double time;
	private Discipline discipline;
	
	
	//------------------------------------------------>||CONSTRUCTORS||<------------------------------------------------------------\\
	
	public DisciplineDistance(double distance, double time, Discipline discipline) {
		super();
		this.distance = distance;
		this.time = time;
		this.discipline = discipline;
		
	}
	
	 //------------------------------------------------>||GETTERS & SETTERS||<--------------------------------------------------------\\
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	
	
	
	

}


