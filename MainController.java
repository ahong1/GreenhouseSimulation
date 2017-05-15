//need to force the humidifier rate, sprinkler rate, and conditioner rate to be negative

package GreenHouseSim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainController {
    private HumidityModel humM;
    private MainView mainView;
    private SoilMCModel soilM;
    protected TempModel tempModel;
	private boolean simStatus=false;
	private boolean paused=false;
	private VisualSoilThread soilVT; private SoilMoistureUThread soilT;
	private VisualTempThread tempVT; private TempUThread tempT;
	private VisualHumidThread humVT; private HumidityUThread humT;

    public MainController() {
        mainView=new MainView(); humM=new HumidityModel(); soilM=new SoilMCModel();
        tempModel=new TempModel();
        mainView.startSimListener(new StartListener());
        //mainView.stopandResumeSimListener(new StopResumeListener());
        //mainView.saveSimListener(listenForStart);
        // mainView.loadSimListener(listenForStop);
    }

    private class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (simStatus==false) {
            	runThreads();
        		simStatus=true;
            } else {
            	soilVT.interrupt(); soilT.interrupt();
            	//tempVT.interrupt(); tempT.interrupt()
            	humVT.interrupt(); humT.interrupt();
            	runThreads();
            	}
            }
        
        public void runThreads() {
  
    	
        	mainView.setFurnaceStatus(tempModel.getFurnaceStatus());
        	mainView.setConditionerStatus(tempModel.getConditionerStatus());
        	
        	double temperature = mainView.getInitialTemp();
        	double desiredTemp = mainView.getDesiredTemp();
        	
        	tempModel.setMinMax();
        	
        	double minTemp = tempModel.getMinTemp();
        	double maxTemp = tempModel.getMaxTemp();
        	double furnaceRate =mainView.getFurnaceRate();
        	double conditionerRate = mainView.getConditionerRate();
        	double extTempRate = mainView.getExtTemp();
        			
        	
        	
        	
        	double humidity=mainView.getInitialHumid();
        	double minHumi=mainView.getMinHumid();
        	double maxHumi=mainView.getMaxHumid();
        	double humiRate=(mainView.getHumidRate()/12);
    		
        	double soilSat=mainView.getInitialSoil();
    		double minSoil=mainView.getMinSoil();
    		double maxSoil=mainView.getMaxSoil();
    		double sprinklerR=(mainView.getSoilRate()/12);
    		
    		double environTemp=mainView.getExtTemp();
    		double environSoil=mainView.getExtSoil();
    		double environHumi=mainView.getExtHumid();
    		
    		tempModel.setParameters(temperature, desiredTemp, furnaceRate, conditionerRate, extTempRate);
    		soilM.setParameters(soilSat, maxSoil, minSoil, environSoil, sprinklerR);
    		humM.setParameters(humidity, minHumi, maxHumi, humiRate, environHumi);
    		
    		
    		
    		soilVT=new VisualSoilThread(mainView, soilM);
    		soilT=new SoilMoistureUThread(soilM);
    		tempVT=new VisualTempThread(mainView, tempModel);
    		tempT=new TempUThread(tempModel);
    		humVT=new VisualHumidThread(mainView, humM);
    		humT=new HumidityUThread(humM);
    		soilVT.start(); soilT.start();
    		tempVT.start(); tempT.start();
    		humVT.start(); humT.start();
    		}
        }
 
    private class StopResumeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
    		if (event.getActionCommand()=="1") {
    			try {
	    	
	    			paused=true;
    			} catch (NullPointerException error) {
    				System.out.println("Wrong");
    				}
    		}
    		else if (event.getActionCommand()=="2") {
    			try {
                	if (paused==true) {
	    			
                	}
    			} catch (NullPointerException error) {
    				System.out.println("Wrong");
    			}
    		}
    	}
    }
}


    		
    		
    		
    		
    	  		
