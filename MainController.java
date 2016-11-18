package EnvironmentSim;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
	private HumidityModel humM;
	private MainView mainView;
	private SoilMCModel soilM;
	private TempModel tempModel;
	private VisualSoilThread soilVT;
	private SoilMoistureUThread soilT;
	private VisualTempThread tempVT;
	private TempUThread tempT;
	private VisualHumidThread humVT;
	private HumidityUThread humT;

	public MainController() {
		mainView = new MainView();
		humM = new HumidityModel();
		soilM = new SoilMCModel();
		tempModel = new TempModel();
		mainView.startSimListener(new StartListener());
		mainView.stopSimListener(new StopListener());
		mainView.saveSimListener(new SaveListener());
		mainView.loadSimListener(new ListenForLoad());
		mainView.disableButton(mainView.getStopButton());
	}

	public SoilMCModel getSoilModel() {
		return soilM;
	}
	
	public HumidityModel getHumidityModel() {
		return humM;
	}
	
	public TempModel getTempModel() {
		return tempModel;
	}
	
	public MainView getMainView() {
		return mainView;
	}
	
	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				double temperature = mainView.getInitialTemp();
				double desiredTemp = mainView.getDesiredTemp();
						
				double furnaceRate = mainView.getFurnaceRate();
				double conditionerRate = mainView.getConditionerRate();
				double extTempRate = mainView.getExtTemp();
			
				double humidity = mainView.getInitialHumid();
				double minHumi = mainView.getMinHumid();
				double maxHumi = mainView.getMaxHumid();
				double humiRate = (mainView.getHumidRate());
				double environHumi = mainView.getExtHumid();
				
				double soilSat = mainView.getInitialSoil();
				double minSoil = mainView.getMinSoil();
				double maxSoil = mainView.getMaxSoil();
				double sprinklerR = (mainView.getSoilRate());
				double environSoil = mainView.getExtSoil();
		
				double tempUpdateFreq = (mainView.getTempSample() * 1000);
				double humiUpdateFreq = (mainView.getHumidSample() * 1000);
				double soilUpdateFreq = (mainView.getSoilSample() * 1000);
				
				tempModel.setParameters(temperature, desiredTemp, furnaceRate, conditionerRate, extTempRate);
				tempModel.setMinMax();
				soilM.setParameters(soilSat, maxSoil, minSoil, environSoil, sprinklerR);
				humM.setParameters(humidity, minHumi, maxHumi, humiRate, environHumi);
		
				soilVT = new VisualSoilThread(mainView, soilM, soilUpdateFreq);
				soilT = new SoilMoistureUThread(soilM);
				tempVT = new VisualTempThread(mainView, tempModel, tempUpdateFreq);
				tempT = new TempUThread(tempModel);
				humVT = new VisualHumidThread(mainView, humM, humiUpdateFreq);
				humT = new HumidityUThread(humM);
				soilVT.start(); soilT.start();
				tempVT.start(); tempT.start();
				humVT.start(); humT.start();
				mainView.disableButton(mainView.getStartButton());
				mainView.enableButton(mainView.getStopButton());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect Values");
			}
		}	
	}

	private class StopListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			soilVT.interrupt();
			soilT.interrupt();
			tempVT.interrupt();
			tempT.interrupt();
			humVT.interrupt();
			humT.interrupt();
			mainView.enableButton(mainView.getStartButton());
			mainView.disableButton(mainView.getStopButton());
		}
	}
	
	private class ListenForLoad implements ActionListener{
		public void actionPerformed(ActionEvent event){
			double[] dataArray = new double[18];
			
			Scanner readText = null;
			try {
				soilVT.interrupt(); soilT.interrupt();
				tempVT.interrupt(); tempT.interrupt();
				humVT.interrupt(); humT.interrupt();
				mainView.enableButton(mainView.getStartButton());
				mainView.disableButton(mainView.getStopButton());
				
				}
			catch (NullPointerException e) {
				
			}
			
			try{
				readText = new Scanner(new FileInputStream("simData.txt"));
				
			}
			catch (FileNotFoundException e){
				System.out.println("File not found");
				System.exit(0);
				
			}
			int counter = 0;
			while(readText.hasNextLine()) {
				dataArray[counter] = readText.nextDouble();
				System.out.println("reading line: " + Double.toString(dataArray[counter]));
				counter++;
			}
			mainView.initialTempField.setText(Double.toString(dataArray[0]));
			mainView.desiredTempField.setText(Double.toString(dataArray[1]));
			mainView.furnaceRateField.setText(Double.toString(dataArray[2]));
			mainView.conditionerRateField.setText(Double.toString(dataArray[3]));
			mainView.extTempField.setText(Double.toString(dataArray[4]));
			mainView.initialHumidField.setText(Double.toString(dataArray[5]));
			mainView.minHumidField.setText(Double.toString(dataArray[6]));
			mainView.maxHumidField.setText(Double.toString(dataArray[7]));
			mainView.humidRateField.setText(Double.toString(dataArray[8]));
			mainView.extHumidField.setText(Double.toString(dataArray[9]));
			mainView.initialSoilField.setText(Double.toString(dataArray[10]));
			mainView.minSoilField.setText(Double.toString(dataArray[11]));
			mainView.maxSoilField.setText(Double.toString(dataArray[12]));
			mainView.soilRateField.setText(Double.toString(dataArray[13]));
			mainView.extSoilField.setText(Double.toString(dataArray[14]));
			mainView.tempSampleField.setText(Double.toString(dataArray[15]/1000));
			mainView.humidSampleField.setText(Double.toString(dataArray[16]/1000));
			mainView.soilSamplField.setText(Double.toString(dataArray[17]/1000));
		}
			
		}	
	
	private class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PrintWriter output=null;
			try {
				output=new PrintWriter(new FileOutputStream("simData.txt"));
			} catch (FileNotFoundException error) {
				
			}
			ArrayList<Double> data=getSaveData();
			if (data.size()==0) {
				System.out.println("Invalid");
			}
			else {
			for (int index=0; index<data.size(); index++) {
				if (index==data.size()-1) {
					output.write(data.get(index).toString());
				} else
					output.write(data.get(index).toString()+"\n");
				}
			}
			output.close();
		}
		
		private ArrayList<Double> getSaveData() {
			ArrayList<Double>  dataList=new ArrayList<Double> ();
			try {
				double temperature=tempModel.getCurrentTemp();
				double desiredTemp = mainView.getDesiredTemp();
				
				double furnaceRate = mainView.getFurnaceRate();
				double conditionerRate = mainView.getConditionerRate();
				double extTempRate = mainView.getExtTemp();

				double humidity=humM.getHumidity();
				double minHumi = mainView.getMinHumid();
				double maxHumi = mainView.getMaxHumid();
				double humiRate = (mainView.getHumidRate());
				double environHumi = mainView.getExtHumid();

				double soilSat = soilM.getCurrentSoilSat();
				double minSoil = mainView.getMinSoil();
				double maxSoil = mainView.getMaxSoil();
				double sprinklerR = (mainView.getSoilRate());
				double environSoil = mainView.getExtSoil();
		
				double tempUpdateFreq = (mainView.getTempSample() * 1000);
				double humiUpdateFreq = (mainView.getHumidSample() * 1000);
				double soilUpdateFreq = (mainView.getSoilSample() * 1000);
			
				dataList.add(temperature);
				dataList.add(desiredTemp);
				
				dataList.add(furnaceRate);
				dataList.add(conditionerRate);
				dataList.add(extTempRate);
				
				dataList.add(humidity);
				dataList.add(minHumi);
				dataList.add(maxHumi);
				dataList.add(humiRate);
				dataList.add(environHumi);
				
				dataList.add(soilSat);
				dataList.add(minSoil);
				dataList.add(maxSoil);
				dataList.add(sprinklerR);
				dataList.add(environSoil);
				
				dataList.add(tempUpdateFreq);
				dataList.add(humiUpdateFreq);
				dataList.add(soilUpdateFreq);	
				
			} catch (NumberFormatException e) {
				System.out.println("Value Error");
			}
			return dataList;
			
		}
		
	}
}
