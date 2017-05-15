package GreenHouseSim;

public class VisualSoilThread extends Thread {
	private SoilMCModel soilM;
	private MainView mainView;

	public VisualSoilThread(MainView view, SoilMCModel model) {
		soilM=model;
		mainView=view;
	}
	
	public void run() {
		while (true) {
		try { 
			Thread.sleep(3000);
			double soilSaturation=soilM.getCurrentSoilSat();
			mainView.setCurrentSoil(soilSaturation);
			mainView.setSprinklerStatus(soilM.isMachineOn());
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
}
