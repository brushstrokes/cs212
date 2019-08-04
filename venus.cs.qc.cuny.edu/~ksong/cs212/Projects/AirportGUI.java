import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.Calendar;

public class AirportGUI extends JFrame implements ActionListener{
	private static long simStartTime = Simulation.timeInMinutes(Calendar.getInstance().getTimeInMillis());
	private boolean running = false;
	
	private Departure departure;
	private Arrival arrival;
	private Runway runway;

	private int landingTime, takeoffTime,arrivalMean, departureMean;
	private TextArea arrivalTextBox = new TextArea("",38, 23, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private TextArea departureTextBox = new TextArea("",7, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private TextArea processedTextBox = new TextArea("",7, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private JTextField runwayTextBox = new JTextField("Now on runway");
	private JTextField[] textbox = {new JTextField("3000"),new JTextField("3000"),new JTextField("5000"),new JTextField("5000")};
	private JButton start = new JButton("Start/Restart Simulation");
	private JButton stop = new JButton("Stop/End Simulation");
	
	public static void main(String[] args){				
		AirportGUI airportGui = new AirportGUI();
		airportGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		airportGui.setSize(new Dimension(1030, 670));
		airportGui.setResizable(false);
		airportGui.setVisible(true);		
	}
	
	public AirportGUI(){
		stop.setEnabled(false);
		start.setEnabled(false);
		JScrollPane scrollPane;
		JLabel[] header = new JLabel[5];
		JPanel topPanel = new JPanel();
		JPanel headerPanel = new JPanel();
		String[] s = {"Acme International Airport", "Airline Arrival/Departure Simulation", "Arrivals","Departures","Processed"}; 
		topPanel.setLayout(new GridLayout(3,1));
		headerPanel.setLayout(new GridLayout(1,3));
		
		header[0] = new JLabel(s[0]);
		header[0].setFont(new Font("Arial", Font.BOLD, 22));
		header[0].setForeground(Color.black);
		header[0].setHorizontalAlignment(JTextField.CENTER);
		
		header[1] = new JLabel(s[1]);
		header[1].setFont(new Font("Arial", Font.BOLD, 16));
		header[1].setForeground(Color.black);
		header[1].setHorizontalAlignment(JTextField.CENTER);
		
		for(int i=2; i < 4; i++){
			header[i] = new JLabel(s[i]);
			header[i].setFont(new Font("monospaced", Font.BOLD, 18));
			header[i].setForeground(Color.blue);
			header[i].setHorizontalAlignment(JTextField.CENTER);
			headerPanel.add(header[i]);			
		}
		header[4] = new JLabel(s[4]);
		header[4].setFont(new Font("Times New Roman", Font.BOLD, 22));
		header[4].setForeground(Color.blue);
		header[4].setHorizontalAlignment(JTextField.CENTER);
		
		JPanel topHeaderPanel = new JPanel();
		topHeaderPanel.setLayout(new GridLayout(1,2));
		topHeaderPanel.add(headerPanel);
		topHeaderPanel.add(header[4]);
		
		topPanel.add(header[0]);
		topPanel.add(header[1]);		
		topPanel.add(topHeaderPanel);
		
		arrivalTextBox.setBackground(Color.black);
		arrivalTextBox.setForeground(Color.white);
		arrivalTextBox.setFont(new Font("monospaced", 0, 15));
		
		departureTextBox.setBackground(Color.black);
		departureTextBox.setForeground(Color.white);
		departureTextBox.setFont(new Font("monospaced", 0, 15));
		
		processedTextBox.setFont(new Font("monospaced", 0, 15));
		
		runwayTextBox.setBackground(Color.blue);
		runwayTextBox.setForeground(Color.white);
		runwayTextBox.setHorizontalAlignment(JTextField.CENTER);
		runwayTextBox.setFont(new Font("monospaced", Font.BOLD, 16));
    	
    	JPanel textWindows = new JPanel();
    	textWindows.setLayout(new GridLayout(1,2));    	
		textWindows.add(arrivalTextBox);
		textWindows.add(departureTextBox);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1,2));
		middlePanel.add(textWindows);
		middlePanel.add(processedTextBox);
		
		JLabel[] inputLabel = new JLabel[4];;
		String[] lstr = {"Landing ","Takeoff ","Arrival ","Departure "};
		for(int i=0; i< 4;i++){
			inputLabel[i] = new JLabel(lstr[i],SwingConstants.TRAILING);
			inputLabel[i].setLabelFor(textbox[i]);			
			textbox[i].setHorizontalAlignment(JTextField.CENTER);
		}
		
		TitledBorder title = BorderFactory.createTitledBorder(" Runway Time (Mins) ");
		JPanel rTimePanel = new JPanel();
		title.setTitleJustification(TitledBorder.CENTER);
		rTimePanel.setBorder(title);
		rTimePanel.setLayout(new GridLayout(1,4));
		rTimePanel.setAlignmentX(CENTER_ALIGNMENT);
		rTimePanel.add(inputLabel[0]);
		rTimePanel.add(textbox[0]);
		rTimePanel.add(inputLabel[1]);
		rTimePanel.add(textbox[1]);
		
		title = BorderFactory.createTitledBorder(" Mean Time Between (Mins) ");
		title.setTitleJustification(TitledBorder.CENTER);
		JPanel rtbPanel = new JPanel();
		rtbPanel.setBorder(title);		
		rtbPanel.setLayout(new GridLayout(1,4));
		rtbPanel.setAlignmentX(CENTER_ALIGNMENT);
		rtbPanel.add(inputLabel[2]);
		rtbPanel.add(textbox[2]);
		rtbPanel.add(inputLabel[3]);
		rtbPanel.add(textbox[3]);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1,4));
		inputPanel.add(start);
		inputPanel.add(rTimePanel);
		inputPanel.add(rtbPanel);
		inputPanel.add(stop);		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2,1));
		bottomPanel.add(runwayTextBox);
		bottomPanel.add(inputPanel);		

    	Container container = this.getContentPane();
    	container.setLayout(new BorderLayout()); 
		container.add(topPanel, BorderLayout.NORTH);
		container.add(middlePanel, BorderLayout.CENTER);
		container.add(bottomPanel, BorderLayout.SOUTH);		
		
		start.setEnabled(true);
		start.addActionListener(this);
		stop.addActionListener(this);
	}
	private void initialize(){		 

	}

	public synchronized long getStartTime(){
		return simStartTime;
	}
	public synchronized boolean getStatus(){
		return running;
	}
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		System.out.println(e);
		if(str=="Start/Restart Simulation"){
		
		}
		else if(str=="Stop/End Simulation"){				

		}	
	}

	public synchronized int getLandingTime(){
		return landingTime;
	}
	public synchronized int getTakeoffTime(){
		return takeoffTime;
	}
	public synchronized int getArrivalMean(){
		return arrivalMean;
	}
	public synchronized int getDepartureMean(){
		return departureMean;
	}
	public synchronized TextArea getArrivalTextBox(){
		return arrivalTextBox;
	}
	public synchronized TextArea getDepartureTextBox(){
		return departureTextBox;
	}
	public synchronized TextArea getProcessedTextBox(){
		return processedTextBox;
	}
	public synchronized JTextField getRunwayTextBox(){
		return runwayTextBox;
	}
	public synchronized void setArrivalTextBox(String str){
		arrivalTextBox.setText("");
		arrivalTextBox.append(str); 
	}
	public synchronized void setDepartureTextBox(String str){
		departureTextBox.setText("");
		departureTextBox.append(str);
	}
	public synchronized void setProcessedTextBox(String str){
		processedTextBox.append(str);
	}
	public synchronized void setRunwayTextBox(String str){
		runwayTextBox.setText(str);
	}
	public synchronized void setStatus(boolean status){
		running = status;
	}
	public void setStartTime(){
		simStartTime = Simulation.timeInMinutes(Calendar.getInstance().getTimeInMillis());
	}
	public synchronized long elaspedTime(){
		return Simulation.timeInMinutes(Calendar.getInstance().getTimeInMillis())  
			- simStartTime;
	}
}
