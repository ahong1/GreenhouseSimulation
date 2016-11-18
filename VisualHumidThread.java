package EnvironmentSim;

public class VisualHumidThread extends Thread {
	private MainView mainView;
	private HumidityModel humM;
	private long updateFreq;
	private boolean isRunning;
	
	public VisualHumidThread(MainView view, HumidityModel model, double freq) {
		humM=model;
		mainView=view;
		updateFreq=(new Double(freq).longValue());
	}
	
	public void run() {
		isRunning=true;
		while (isRunning) {
			try {
				Thread.sleep(updateFreq);
				double humidity=humM.getHumidity();
				mainView.setCurrentHumid(humidity);
				mainView.setHumidifierStatus(humM.isMachineOn());
			} catch (InterruptedException e) {
				isRunning=false;
		}}
		

	}
}
