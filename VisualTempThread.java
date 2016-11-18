package EnvironmentSim;

public class VisualTempThread extends Thread {
	private MainView mainView;
	private TempModel tempModel;
	private long updateFreq;
	private boolean isRunning;
	
	public VisualTempThread(MainView theView, TempModel theModel, double freq){
		mainView = theView;
		tempModel = theModel;
		updateFreq=(new Double(freq).longValue());
	}
	
	public void run() {
		isRunning=true;
		while (isRunning) {
			try {
				Thread.sleep(updateFreq);
				double temp=tempModel.getCurrentTemp();
				mainView.setCurrentTemp(temp);
				mainView.setFurnaceStatus(tempModel.getFurnaceStatus());
				mainView.setConditionerStatus(tempModel.getConditionerStatus());
				
			} catch (InterruptedException e) {
				isRunning=false;
				}
			}
	}
}
