package EnvironmentSim;

public class TempUThread extends Thread{
	private TempModel tempModel;
	private boolean isRunning;
	
	public TempUThread(TempModel theModel){
		tempModel = theModel;
	}

	public void run() {
		isRunning=true;
		while (isRunning) {
			try{
				Thread.sleep(1000);
				tempModel.conditionCheck(tempModel.getMinTemp(), tempModel.getMaxTemp());
				tempModel.updateTemp();
			
			}
			catch (InterruptedException e) {
				isRunning=false;
			}
		}	
	}
}
