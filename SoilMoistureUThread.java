package GreenHouseSim;

public class SoilMoistureUThread extends Thread {
	private SoilMCModel soilM;
	
	public SoilMoistureUThread(SoilMCModel model) {
		soilM=model;	
	}
	
	public void run() {
		while (true) {try {
			soilM.conditionCheck();
			soilM.updateSoilSaturation();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
}
