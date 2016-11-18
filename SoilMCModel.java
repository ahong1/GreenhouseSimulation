package EnvironmentSim;

public class SoilMCModel {
	private double soilSat, maxSat, minSat, eSMRate, sprinklerRate;
	private boolean isSprinklerOn;
	
	public SoilMCModel() {
		soilSat=0; maxSat=0; minSat=0; eSMRate=0; sprinklerRate=0;
	}
	
	public void setParameters(double saturation, double satMax, double satMin, double enviMChange, double sprinklerChange) {
		soilSat=saturation; maxSat=satMax; minSat=satMin; eSMRate=enviMChange; sprinklerRate=sprinklerChange;
	}
	
	public void conditionCheck() {
		if (soilSat >= maxSat) {
			isSprinklerOn=false;
		}
		
		else if (soilSat < minSat) {
			isSprinklerOn=true;
	    }
		
		else {
			isSprinklerOn=false;
		}
	}
	
	public void updateSoilSaturation() {
		conditionCheck();
		if (isSprinklerOn==true) {
			soilSat+=(sprinklerRate+eSMRate);
		} 
		else if (isSprinklerOn==false) {
			soilSat+=eSMRate;
		}
		if (soilSat>=100) {
			soilSat=100;
		} else if (soilSat<=0) {
			soilSat=0;
		}
	}
	
	public boolean isMachineOn() {
		return isSprinklerOn;
	}
	
	public double getCurrentSoilSat() {
		return soilSat;
	}
}
