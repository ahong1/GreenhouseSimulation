package GreenHouseSim;

public class TempUThread extends Thread{
	private TempModel tempModel;
	
	public TempUThread(TempModel theModel){
		tempModel = theModel;
	}
	
	
	
	public void run() {
		while (true) {
			try{
			tempModel.conditionCheck(tempModel.getMinTemp(), tempModel.getMaxTemp());
			tempModel.updateTemp();
			Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
