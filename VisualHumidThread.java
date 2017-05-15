package GreenHouseSim;

public class VisualHumidThread extends Thread {
	private MainView mainView;
	private HumidityModel humM;

	public VisualHumidThread(MainView view, HumidityModel model) {
		humM=model;
		mainView=view;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				double humidity=humM.getHumidity();
				mainView.setCurrentHumid(humidity);
				mainView.setHumidifierStatus(humM.isMachineOn());
			} catch (InterruptedException e) {
			e.printStackTrace();
		}}
		

	}
}
