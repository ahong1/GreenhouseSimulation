package EnvironmentSim;

public class VisualSoilThread extends Thread {
	private SoilMCModel soilM;
	private MainView mainView;
	private long updateFreq;
	private boolean isRunning;

	public VisualSoilThread(MainView view, SoilMCModel model, double freq) {
		soilM=model;
		mainView=view;
		updateFreq=(new Double(freq).longValue());
	}
	
	public void run() {
		isRunning=true;
		while (isRunning) {
		try { 
			Thread.sleep(updateFreq);
			double soilSaturation=soilM.getCurrentSoilSat();
			mainView.setCurrentSoil(soilSaturation);
			mainView.setSprinklerStatus(soilM.isMachineOn());
		} catch (InterruptedException e) {
			isRunning=false;
			}
		}
	}
}
