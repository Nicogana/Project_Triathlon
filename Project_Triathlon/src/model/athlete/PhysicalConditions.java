package model.athlete;

import java.io.Serializable;

public class PhysicalConditions implements Serializable {
	
	//------------------------------------------------>||ATTRIBUTES||<--------------------------------------------------------\\
    private double swimmingAptitude;
    private double cyclismAptitude;
    private double pedestrianismAptitude;
    private double stamina;
    private double mentalStrength;
    
    
  //------------------------------------------------>||CONSTRUCTORS||<------------------------------------------------------------\\
    
    
	public PhysicalConditions(double swimmingAptitude, double cyclismAptitude, double pedestrianismAptitude,
			double stamina, double mentalStrength) {
		super();
		this.swimmingAptitude = swimmingAptitude;
		this.cyclismAptitude = cyclismAptitude;
		this.pedestrianismAptitude = pedestrianismAptitude;
		this.stamina = stamina;
		this.mentalStrength = mentalStrength;
	}
	
	  //------------------------------------------------>||GETTERS & SETTERS||<--------------------------------------------------------\\
    
	
	public double getSwimmingAptitude() {
		return swimmingAptitude;
	}
	public void setSwimmingAptitude(double swimmingAptitude) {
		this.swimmingAptitude = swimmingAptitude;
	}
	public double getCyclismAptitude() {
		return cyclismAptitude;
	}
	public void setCyclismAptitude(double cyclismAptitude) {
		this.cyclismAptitude = cyclismAptitude;
	}
	public double getPedestrianismAptitude() {
		return pedestrianismAptitude;
	}
	public void setPedestrianismAptitude(double pedestrianismAptitude) {
		this.pedestrianismAptitude = pedestrianismAptitude;
	}
	public double getStamina() {
		return stamina;
	}
	public void setStamina(double stamina) {
		this.stamina = stamina;
	}
	public double getMentalStrength() {
		return mentalStrength;
	}
	public void setMentalStrength(double mentalStrength) {
		this.mentalStrength = mentalStrength;
	}
	
	//------------------------------------------------>||CLASS METHODS||<--------------------------------------------------------\\

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" \n\t Swimming Aptitude: ").append(swimmingAptitude).append("\n\t Cyclism Aptitude: ").append(cyclismAptitude)
		  .append("\n\t Pedestrianism Aptitude: ").append(pedestrianismAptitude).append("\n\t Stamina: ").append(stamina)
		  .append("\n\t Mental Strength: ").append(mentalStrength);
		return sb.toString();
	}
	
    
    

}
