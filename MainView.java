package EnvironmentSim;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView extends JFrame{
	
	//Creating and formatting labels

	private JLabel titleLabel = new JLabel("Greenhouse Simulation");

	private JLabel userInputTitle = new JLabel("User Inputs");
	private JLabel tempTitle = new JLabel("Temperature Settings");
	private JLabel humidTitle = new JLabel("Humidity Settings");
	private JLabel soilTitle = new JLabel("Soil Moisture Settings");
	
	private JLabel initialCondTtitle = new JLabel("Initial Conditions");
	private JLabel enviroTitle = new JLabel("Environment Settings");
	
	private JLabel tempLabel = new JLabel("Temperature");
	private JLabel humidLabel = new JLabel("Humidity");
	private JLabel soilLabel = new JLabel("Soil Moisture");
	private JLabel environLabel = new JLabel("Environment");
	
	private JLabel desiredTempLabel = new JLabel("Desired Tempurature: ");
	private JLabel furnHeatRateLabel = new JLabel("Furnace Heat Rate: ");
	private JLabel airConRateLabel = new JLabel("Air Conditioner Cooling Rate: ");
	private JLabel tempSampleRateLabel = new JLabel("Temperature Sampling Rate: ");
	
	
	private JLabel minHumidLabel = new JLabel("Min.Humidity: ");
	private JLabel maxHumidLabel = new JLabel("Max. Humidity: ");
	private JLabel HumidRateLabel = new JLabel("Humidifier Rate: ");
	private JLabel humidSampleRateLabel = new JLabel("Humidity Sample Rate: ");
	
	
	private JLabel minSoilLabel = new JLabel("Min. Soil Moisture:");
	private JLabel maxSoilLabel = new JLabel("Max. Soil Moisture:");
	private JLabel sprinklerRateLabel = new JLabel("Sprinkler Rate:");
	private JLabel soilSampleRateLabel = new JLabel("Soil Moisture Sample Rate:");
	
	private JLabel environTempLabel = new JLabel("Environmental Temperature Rate:");
	private JLabel environHumidLabel = new JLabel("Environmental Humidity Rate:");
	private JLabel environSoilLabel = new JLabel("Environmental Soil Moisture Rate:");
	
	private JLabel initialTempLabel = new JLabel("Initial Temperature: ");
	private JLabel initialHumidLabel = new JLabel("Initial Humidity: ");
	private JLabel initialSoilLabel = new JLabel("Initial Soil Moisture: ");
	
	private JLabel tempHeadingLabel = new JLabel("Furnace / Air Conditioner Status");
	private JLabel furnaceStatusLabel = new JLabel("Furnace ON/OFF: ");
	private JLabel conditionerStatusLabel = new JLabel("Air Conditioenr ON/OFF: ");
	
	private JLabel humidHeadingLabel = new JLabel("Humidifier Status");
	private JLabel humidStatusLabel = new JLabel("Humidifier ON/OFF: ");
	
	private JLabel soilHeadingLabel = new JLabel("Sprinkler Status");
	private JLabel soilStatusLabel = new JLabel("Sprinkler ON/OFF: ");
	
	private JLabel environHeadingLabel = new JLabel("Output Conditions");
	private JLabel currentTempLabel = new JLabel("Current Temperature:");
	private JLabel currentHumidLabel = new JLabel("Current Humidity:");
	private JLabel currentSoilLabel = new JLabel("Current Soil Moisture:");
	
	
	
	//empty label for formatting
	private JLabel emptyLabel = new JLabel(" ");
	
	//TextFields
	protected JTextField desiredTempField = new JTextField(10);
	protected JTextField furnaceRateField = new JTextField(10);
	protected JTextField conditionerRateField = new JTextField(10);
	protected JTextField tempSampleField = new JTextField(10);
	
	protected JTextField minHumidField = new JTextField(10);
	protected JTextField maxHumidField = new JTextField(10);
	protected JTextField humidRateField = new JTextField(10);
	protected JTextField humidSampleField = new JTextField(10);
	
	protected JTextField minSoilField = new JTextField(10);
	protected JTextField maxSoilField = new JTextField(10);
	protected JTextField soilRateField = new JTextField(10);
	protected JTextField soilSamplField = new JTextField(10);
	
	protected JTextField extTempField = new JTextField(10);
	protected JTextField extHumidField = new JTextField(10);
	protected JTextField extSoilField = new JTextField(10);
	
	protected JTextField initialTempField = new JTextField(10);
	protected JTextField initialHumidField = new JTextField(10);
	protected JTextField initialSoilField = new JTextField(10);
	
	// Buttons
	private JButton startButton = new JButton("Start Simulation");
	private JButton stopButton = new JButton("Stop Simulation");
	private JButton saveButton = new JButton("SAVE");
	private JButton loadButton = new JButton("LOAD");
	
	
	public MainView() {
		setSize(1000,1000);
		setVisible(true);
		this.setLayout(new GridLayout(10,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creating panels
		
		JPanel userInputHeadingPanel = new JPanel();
		userInputHeadingPanel.setLayout(new GridLayout(1,3));
		
		JPanel userInputHeadingPanel2 = new JPanel();
		userInputHeadingPanel2.setLayout(new GridLayout(1,2));
		
		
		JPanel userInputPanel = new JPanel();
		userInputPanel.setLayout(new GridLayout(1,4,5,5));
		
		JPanel userTempPanel = new JPanel();
		userTempPanel.setLayout(new GridLayout(4,2,3,3));
		JPanel userHumidPanel = new JPanel();
		userHumidPanel.setLayout(new GridLayout(4,2,3,3));
		JPanel userSoilPanel = new JPanel();
		userSoilPanel.setLayout(new GridLayout(4,2,3,3));
		
		JPanel userEnvironPanel = new JPanel();
		userEnvironPanel.setLayout(new GridLayout(3,2,3,3));
		
		JPanel initialCondPanel = new JPanel();
		initialCondPanel.setLayout(new GridLayout(3,2,3,3));
		
		JPanel userInputPanel2 = new JPanel();
		userInputPanel2.setLayout(new GridLayout(1,2,5,5));
		
		JPanel startStopPanel = new JPanel();
		startStopPanel.setLayout(new GridLayout(1,2));
		
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(1,3));
		
		
		JPanel statusTempPanel = new JPanel();
		statusTempPanel.setLayout(new GridLayout(3,1));
		JPanel statusHumidPanel = new JPanel();
		statusHumidPanel.setLayout(new GridLayout(3,1));
		JPanel statusSoilPanel = new JPanel();
		statusSoilPanel.setLayout(new GridLayout(3,1));
		
		JPanel currentOutputPanel = new JPanel();
		currentOutputPanel.setLayout(new GridLayout(4,2));
		
		JPanel saveLoadPanel = new JPanel();
		saveLoadPanel.setLayout(new GridLayout(1,2));
		
		//Formatting Labels
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
		
		
		userInputTitle.setHorizontalAlignment(JLabel.CENTER);
		userInputTitle.setFont(new Font("Serif", Font.PLAIN, 20));
		
		tempTitle.setHorizontalAlignment(JLabel.CENTER);
		humidTitle.setHorizontalAlignment(JLabel.CENTER);
		soilTitle.setHorizontalAlignment(JLabel.CENTER);
		enviroTitle.setHorizontalAlignment(JLabel.CENTER);
		environHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
		tempHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
		furnaceStatusLabel.setHorizontalAlignment(JLabel.CENTER);
		conditionerStatusLabel.setHorizontalAlignment(JLabel.CENTER);
		humidHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
		humidStatusLabel.setHorizontalAlignment(JLabel.CENTER);
		soilHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
		soilStatusLabel.setHorizontalAlignment(JLabel.CENTER);
		environHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
		currentTempLabel.setHorizontalAlignment(JLabel.CENTER);
		currentHumidLabel.setHorizontalAlignment(JLabel.CENTER);
		currentSoilLabel.setHorizontalAlignment(JLabel.CENTER);
		
		tempLabel.setHorizontalAlignment(JLabel.CENTER);
		tempLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		humidLabel.setHorizontalAlignment(JLabel.CENTER);
		humidLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		soilLabel.setHorizontalAlignment(JLabel.CENTER);
		soilLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		environLabel.setHorizontalAlignment(JLabel.CENTER);
		environLabel.setFont(new Font("Serif", Font.BOLD, 20));
		
		initialCondTtitle.setHorizontalAlignment(JLabel.CENTER);
		initialCondTtitle.setFont(new Font("Serif", Font.BOLD, 20));

		//Creating user input heading panel
		userInputHeadingPanel.add(tempLabel);
		userInputHeadingPanel.add(humidLabel);
		userInputHeadingPanel.add(soilLabel);
		
		
		//Creating User Input Panel 1
		
		userTempPanel.add(desiredTempLabel);
		userTempPanel.add(desiredTempField);
		userTempPanel.add(furnHeatRateLabel);
		userTempPanel.add(furnaceRateField);
		userTempPanel.add(airConRateLabel);
		userTempPanel.add(conditionerRateField);
		userTempPanel.add(tempSampleRateLabel);
		userTempPanel.add(tempSampleField);
	
		
		userHumidPanel.add(minHumidLabel);
		userHumidPanel.add(minHumidField);
		userHumidPanel.add(maxHumidLabel);
		userHumidPanel.add(maxHumidField);
		userHumidPanel.add(HumidRateLabel);
		userHumidPanel.add(humidRateField);
		userHumidPanel.add(humidSampleRateLabel);
		userHumidPanel.add(humidSampleField);

		
		userSoilPanel.add(minSoilLabel);
		userSoilPanel.add(minSoilField);
		userSoilPanel.add(maxSoilLabel);
		userSoilPanel.add(maxSoilField);
		userSoilPanel.add(sprinklerRateLabel);
		userSoilPanel.add(soilRateField);
		userSoilPanel.add(soilSampleRateLabel);
		userSoilPanel.add(soilSamplField);
		
		userInputPanel.add(userTempPanel);
		userInputPanel.add(userHumidPanel);
		userInputPanel.add(userSoilPanel);
		
		//Creating User Input Panel 2
		userInputHeadingPanel2.add(environLabel);
		userInputHeadingPanel2.add(initialCondTtitle);
		
		userEnvironPanel.add(environTempLabel);
		userEnvironPanel.add(extTempField);
		userEnvironPanel.add(environHumidLabel);
		userEnvironPanel.add(extHumidField);
		userEnvironPanel.add(environSoilLabel);
		userEnvironPanel.add(extSoilField);
		
		initialCondPanel.add(initialTempLabel);
		initialCondPanel.add(initialTempField);
		initialCondPanel.add(initialHumidLabel);
		initialCondPanel.add(initialHumidField);
		initialCondPanel.add(initialSoilLabel);
		initialCondPanel.add(initialSoilField);
		
				
		userInputPanel2.add(userEnvironPanel);
		userInputPanel2.add(initialCondPanel);
		
		//Creating start/stop panel
		startStopPanel.add(startButton);
		startStopPanel.add(stopButton);
		
		//Creating device status panel
		
		statusTempPanel.add(tempHeadingLabel);
		statusTempPanel.add(furnaceStatusLabel);
		statusTempPanel.add(conditionerStatusLabel);
		
		statusHumidPanel.add(humidHeadingLabel);
		statusHumidPanel.add(humidStatusLabel);
		statusHumidPanel.add(emptyLabel);
		
		statusSoilPanel.add(soilHeadingLabel);
		statusSoilPanel.add(soilStatusLabel);
		statusSoilPanel.add(emptyLabel);
		
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		statusPanel.add(statusTempPanel);
		statusPanel.add(statusHumidPanel);
		statusPanel.add(statusSoilPanel);
		
		//Creating output conditions panel
		
		currentOutputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		currentOutputPanel.add(environHeadingLabel);
		currentOutputPanel.add(currentTempLabel);
		currentOutputPanel.add(currentHumidLabel);
		currentOutputPanel.add(currentSoilLabel);
	
		//Creating Save/Load Panel
		saveLoadPanel.add(saveButton);
		saveLoadPanel.add(loadButton);
		
		
		userInputTitle.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(titleLabel);
		this.add(userInputTitle);
		this.add(userInputHeadingPanel);
		this.add(userInputPanel);
		this.add(userInputHeadingPanel2);
		this.add(userInputPanel2);
		this.add(startStopPanel);
		this.add(statusPanel);
		this.add(currentOutputPanel);
		this.add(saveLoadPanel);
	}
	
	//Methods to get information from textFields
	
	
	public double getDesiredTemp(){
		return Double.parseDouble(desiredTempField.getText());
	}
	
	public double getFurnaceRate(){
		return Double.parseDouble(furnaceRateField.getText());
	}
	
	public double getConditionerRate(){
		return Double.parseDouble(conditionerRateField.getText());
	}
	
	public double getTempSample(){
		return Double.parseDouble(tempSampleField.getText());
	}
	
	public double getMinHumid(){
		return Double.parseDouble(minHumidField.getText());
	}
	
	public double getMaxHumid(){
		return Double.parseDouble(maxHumidField.getText());
	}
	
	public double getHumidRate(){
		return Double.parseDouble(humidRateField.getText());
	}
	
	public double getHumidSample(){
		return Double.parseDouble(humidSampleField.getText());
	}
	
	public double getMinSoil(){
		return Double.parseDouble(minSoilField.getText());
	}
	
	public double getMaxSoil(){
		return Double.parseDouble(maxSoilField.getText());
	}
	
	public double getSoilRate(){
		return Double.parseDouble(soilRateField.getText());
	}
	
	public double getSoilSample(){
		return Double.parseDouble(soilSamplField.getText());
	}
	
	public double getExtTemp(){
		return Double.parseDouble(extTempField.getText());
	}
	
	public double getExtHumid(){
		return Double.parseDouble(extHumidField.getText());
	}
	
	public double getExtSoil(){
		return Double.parseDouble(extSoilField.getText());
	}
	
	public double getInitialTemp(){
		return Double.parseDouble(initialTempField.getText());
	}
	
	public double getInitialHumid(){
		return Double.parseDouble(initialHumidField.getText());
	}
	
	public double getInitialSoil(){
		return Double.parseDouble(initialSoilField.getText());
	}
	
	
	// Methods for buttons
	
	public void startSimListener(ActionListener listenForStart){
		startButton.addActionListener(listenForStart);
	}
	
	public void stopSimListener(ActionListener listen){
		stopButton.addActionListener(listen);
	}
	
	public void saveSimListener(ActionListener saveListener){
		saveButton.addActionListener(saveListener);
	}
	
	public void loadSimListener(ActionListener listenForStop){
		loadButton.addActionListener(listenForStop);
	}
	
	public void disableButton(JButton button) {
		button.setEnabled(false);
		button.setOpaque(true);
	}
	
	public void enableButton(JButton button) {
		button.setEnabled(true);
		button.setOpaque(false);
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	
	public JButton getStopButton() {
		return stopButton;
	}
	
	//Methods for updating the output labels
	
	public void setFurnaceStatus(boolean furnaceStatus){
		if (furnaceStatus == true){
			furnaceStatusLabel.setText("Furnace Status (ON/OFF): ON" );
		}
		else{
			furnaceStatusLabel.setText("Furnace Status (ON/OFF): OFF" );
		}
	}
	
	public void setConditionerStatus(boolean conditionerStatus){
		if (conditionerStatus == true){
			conditionerStatusLabel.setText("Conditioner Status (ON/OFF): ON" );
		}
		else{
			conditionerStatusLabel.setText("Conditioner Status (ON/OFF): OFF" );
		}
	}
	
	public void setHumidifierStatus(boolean humidifierStatus){
		if (humidifierStatus == true){
			humidStatusLabel.setText("Humidifier Status (ON/OFF): ON" );
		}
		else{
			humidStatusLabel.setText("Humidifier Status (ON/OFF): OFF" );
		}		
	}
	
	public void setSprinklerStatus(boolean sprinklerStatus){
		if (sprinklerStatus == true){
			soilStatusLabel.setText("Sprinkler Status (ON/OFF): ON" );
		}
		else{
			soilStatusLabel.setText("Sprinkler Status (ON/OFF): OFF" );
		}
	}
	
	public void setCurrentTemp(double currentTemp){
		currentTempLabel.setText("Current Temperature: " + Double.toString(currentTemp));
	}
	
	public void setCurrentHumid(double currentHumid){
		currentHumidLabel.setText("Current Humidity: " + Double.toString(currentHumid));
	}
	
	public void setCurrentSoil(double currentSoil){
		currentSoilLabel.setText("Current Soil Moisture: " + Double.toString(currentSoil));
	}
}
	

