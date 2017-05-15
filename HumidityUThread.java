package GreenHouseSim;

public class HumidityUThread extends Thread {
	private HumidityModel humM;
	
	public HumidityUThread(HumidityModel model) {
		humM=model;	
	}
	
	public void run() {
		while (true) {
			try {
				humM.conditionCheck();
				humM.updateHumidity();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
