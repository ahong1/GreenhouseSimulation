package EnvironmentSim;

public class SoilMoistureUThread extends Thread {
	private SoilMCModel soilM;
	private boolean isRunning;
	
	public SoilMoistureUThread(SoilMCModel model) {
		soilM=model;	
	}
	
	public void run() {
		isRunning=true;
		while (isRunning) {
			try {
				soilM.conditionCheck();
				soilM.updateSoilSaturation();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				isRunning=false;
			}
		}
	}
}
