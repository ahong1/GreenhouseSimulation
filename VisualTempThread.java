package GreenHouseSim;

public class VisualTempThread extends Thread {
	private MainView mainView;
	private TempModel tempModel;
	
	public VisualTempThread(MainView theView, TempModel theModel){
		mainView = theView;
		tempModel = theModel;
		
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				double temp=tempModel.getCurrentTemp();
				mainView.setCurrentTemp(temp);
				mainView.setFurnaceStatus(tempModel.getFurnaceStatus());
				mainView.setConditionerStatus(tempModel.getConditionerStatus());
				
			} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	}
}
