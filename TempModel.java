package GreenHouseSim;

public class TempModel {
	private double currentTemp, minTemp, maxTemp, extTempRate, furnaceRate, conditionerRate, desiredTemp; 
	private boolean furnaceState = false, conditionerState = false;
	
	//Constructor
	public TempModel(){
		currentTemp =0; minTemp =0; maxTemp=0; extTempRate = 0; furnaceRate =0; conditionerRate =0;
		
	}
	
	//determine min/max temp
	
	public void setMinMax(){
		
		minTemp = desiredTemp - 3;
		maxTemp = desiredTemp +3;

	}
	
	//Checks which devices should be on
	public void conditionCheck(double minTemp, double maxTemp){
		if (currentTemp < minTemp){
			furnaceState = true;
			conditionerState = false;
		}
		
		else if(currentTemp > maxTemp){
			conditionerState = true;
			furnaceState = false;
		}
		else{
			conditionerState = false;
			furnaceState = false;
		}
	}
	
	//update the current temperature
	
	public void updateTemp(){
		
		if (furnaceState == false && conditionerState == false){
			currentTemp += extTempRate;
		}
		
		else if(furnaceState == true && conditionerState == false){
			currentTemp += (extTempRate + furnaceRate);
		}
		
		else if(furnaceState == true && conditionerState == true){
			furnaceState = false;
		}
		
		else{
			currentTemp += (extTempRate + conditionerRate);
			
		}
		
		
	}
	
	public void setParameters(double currentT, double desiredT, double furnaceR, double conditionerR , double extTempR) {
		 currentTemp = currentT;
		 desiredTemp = desiredT; 
		 furnaceRate = furnaceR;
		 conditionerRate = conditionerR;
		 extTempRate = extTempR;

	}

	public double getCurrentTemp() {
		return currentTemp;
	}
	
	public double getMinTemp(){
		return minTemp;
	}
	
	public double getMaxTemp(){
		return maxTemp;
	}
	
	public boolean getFurnaceStatus(){
		return furnaceState;
	}
	
	public boolean getConditionerStatus(){
		return conditionerState;
	}
	
}
