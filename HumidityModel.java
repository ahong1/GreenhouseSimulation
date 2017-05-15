package GreenHouseSim;

public class HumidityModel {
    private double humidRate, humidMax, humidMin, humidity, eHumiRate;
    private boolean isHumidifierOn;

    public HumidityModel() {
        humidRate=0; humidity=0; humidMax=100; humidMin=0; eHumiRate=0;
    }

    public void conditionCheck() {
        if (humidity > humidMax) {
            isHumidifierOn=false;
        }

        else if (humidity < humidMin) {
        	isHumidifierOn=true;
        }

        else {
            isHumidifierOn=false;
        }
    }

    public void updateHumidity() {
        conditionCheck();
        if (isHumidifierOn==true) {
            humidity+=(humidRate+eHumiRate); }

        else if (isHumidifierOn==false) {
            humidity+=eHumiRate;}
    }
    
    public double getHumidity() {
        return humidity;
    }
    
    public boolean isMachineOn() {
    	return isHumidifierOn;
    }

	public void setParameters(double houseHumid, double maxHumid, double minHumid, double rateofHumid, double enviroHuRate) {
		 humidRate=rateofHumid; humidity=houseHumid; humidMax=maxHumid; humidMin=minHumid; eHumiRate=enviroHuRate;
		
	}

}