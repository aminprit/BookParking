import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class BookingSpace implements ActionListener {
	
	ArrayList<Booking> parking = new ArrayList<Booking>();
	private static String user;
	private static JFrame frame = new JFrame();
	private static JLabel spotNumLabel;
	private static JTextField spotNumText;
	private static JLabel timeFromLabel;
	private static JTextField licensePlateText;
	private static JLabel licensePlateLabel;
	private static JTextField timeFromText;
	private static JLabel timeToLabel;
	private static JTextField timeToText;
	private static JButton buttonCancel;
//	private static JButton buttonPay;
	private static JButton buttonDone;
	private static JButton buttonBookMore;
	private static JLabel success;
	private static JLabel welcomeLabel = new JLabel("Hello!");
	static BookingSpace instance = null;
	public static int count = 1;
	public static int bookCount = 1;
	ArrayList<Booking> bookingNow = new ArrayList<Booking>();

	
	BookingSpace(){
		
	}
	
	BookingSpace(String user){
		BookingSpace.user = user;
	}
	
	public static BookingSpace getInstance() {
		if(instance == null) {
			instance = new BookingSpace();
		}
		return instance;
	}
	
	public void parkingCreate(){
			
		welcomeLabel.setBounds(0,0,500,25);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome to Book a Parking Slot");
		frame.add(welcomeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		spotNumLabel = new JLabel("Spot Number");
		spotNumLabel.setBounds(10, 50, 150, 25);
		frame.add(spotNumLabel);
		
		spotNumText = new JTextField(20);
		spotNumText.setBounds(175, 50, 165, 25);
		frame.add(spotNumText);
		
		licensePlateLabel = new JLabel("License Plate");
		licensePlateLabel.setBounds(10, 80, 150, 25);
		frame.add(licensePlateLabel);
		
		licensePlateText = new JTextField(20);
		licensePlateText.setBounds(175, 80, 165, 25);
		frame.add(licensePlateText);
		
		timeFromLabel = new JLabel("Time From");
		timeFromLabel.setBounds(10, 110, 150, 25);
		frame.add(timeFromLabel);
		
		timeFromLabel = new JLabel("dd-MM-yyyy hh:mm");
		timeFromLabel.setBounds(350, 110, 120, 25);
		frame.add(timeFromLabel);
		
		timeFromText = new JTextField(20);
		timeFromText.setBounds(175, 110, 165, 25);
		frame.add(timeFromText);
		
		timeToLabel = new JLabel("Time To");
		timeToLabel.setBounds(10, 140, 150, 25);
		frame.add(timeToLabel);
		
		timeToLabel = new JLabel("dd-MM-yyyy hh:mm");
		timeToLabel.setBounds(350, 140, 120, 25);
		frame.add(timeToLabel);
		
		timeToText = new JTextField(20);
		timeToText.setBounds(175, 140, 165, 25);
		frame.add(timeToText);
		
		buttonBookMore = new JButton("Book More");
		buttonBookMore.setBounds(10, 360, 300, 25);
		buttonBookMore.addActionListener(new BookingSpace());
		frame.add(buttonBookMore);
		
//		buttonPay = new JButton("Pay");
//		buttonPay.setBounds(10, 450, 300, 25);
//		buttonPay.addActionListener(new BookingSpace());
//		frame.add(buttonPay);
		
		buttonDone= new JButton("Done");
		buttonDone.setBounds(10, 390, 300, 25);
		buttonDone.addActionListener(new BookingSpace());
		frame.add(buttonDone);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(10, 420, 300, 25);
		buttonCancel.addActionListener(new BookingSpace());
		frame.add(buttonCancel);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		
		
		frame.setVisible(true);
	}
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
	   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		while(reader.readRecord()){ 
			Booking booking = new Booking();
			booking.setName(reader.get("name"));
			booking.setID(Integer.valueOf(reader.get("id")));
			booking.setSpotNum(Integer.valueOf(reader.get("spot num")));
			booking.setTimeFrom(dateFormat.parse(reader.get("from")));
			booking.setTimeTo(dateFormat.parse(reader.get("to")));
			booking.setLicensePlate(reader.get("license"));
			booking.setStatus(reader.get("status"));
			booking.setRequest(reader.get("request"));
			getInstance().parking.add(booking);
		}
		System.out.println("Load ---------------" + getInstance().getParking());
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("id");
				csvOutput.write("spot num");
		    	csvOutput.write("from");
		    	csvOutput.write("to");
		    	csvOutput.write("license");
		    	csvOutput.write("status");
		    	csvOutput.write("request");

				csvOutput.endRecord();
				// else assume that the file already has the correct header line
				// write out a few records
				
				for(Booking b: BookingSpace.getInstance().getParking()){
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String timeFrom = dateFormat.format(b.getTimeFrom());
					String timeTo = dateFormat.format(b.getTimeTo());
					csvOutput.write(b.getName());
					csvOutput.write(String.valueOf(b.getID()));
					csvOutput.write(String.valueOf(b.getSpotNum()));
					csvOutput.write(timeFrom);
					csvOutput.write(timeTo);
					csvOutput.write(b.getLicensePlate());
					csvOutput.write(b.getStatus());
					csvOutput.write(b.getRequest());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println("Update ---------------" + getInstance().getParking());

	}
	
	public ArrayList<Booking> getParking(){
		return this.parking;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";
		String spotNum = spotNumText.getText();
		String timeFrom = timeFromText.getText();
		String timeTo = timeToText.getText();
		String licensePlate = licensePlateText.getText();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date d = new Date();
	
		String name = BookingSpace.user;
		if(count == 1) {
			try {
				load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

// if CANCEL button is clicked ------------------------------------------------------------	
		if(e.getSource() == buttonCancel) {
			frame.dispose();
		}


// if BOOKMORE button is clicked-------------------------------------------------------------------------
		if(e.getSource() == buttonBookMore) {
			if(bookCount < 3) {
				boolean flagFrom = true;
				boolean flagTo = true;
				boolean flagCompare = true;
				boolean flagBetween = true;
				boolean flagSpotNum = true;
				
				spotNumText.setText("");
				licensePlateText.setText("");
				timeFromText.setText("");
				timeToText.setText("");
	// if timeFrom is greater than timeTo			
				try {
					if(dateFormat.parse(timeTo).compareTo(dateFormat.parse(timeFrom)) <= 0) {
						success.setText("Time From is greater than Time To");
						success.setForeground(Color.red);
						flagCompare = false;
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	// if timeTo is less than current time		
				try {
					if(dateFormat.parse(timeTo).compareTo(d) <= 0) {
						success.setText("TimeTo not in Future");
						success.setForeground(Color.red);
						flagTo = false;
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
	// if timeFrom is less than current time
				try {
					if(dateFormat.parse(timeFrom).compareTo(d) <= 0) {
						success.setText("TimeFrom not in Future");
						success.setForeground(Color.red);
						flagFrom = false;
					}
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 
	// if SpotNum is not in between [1, 7500]
				if(Integer.valueOf(spotNum) < 1 || Integer.valueOf(spotNum) > 7500) {
					success.setText("Incorrect Spot Number");
					success.setForeground(Color.red);
					flagSpotNum = false;
				}
				int id = BookingSpace.getInstance().getParking().get(BookingSpace.getInstance().getParking().size() - 1).getID() + 1;
				Booking book = null;
				try {
					book = new Booking(name, id, Integer.valueOf(spotNum), dateFormat.parse(timeFrom), dateFormat.parse(timeTo), licensePlate, "unpaid", "pending");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Booking b: getInstance().getParking()) {
					Date min = b.getTimeFrom();
					Date max = b.getTimeTo();
					if((book.getSpotNum() == b.getSpotNum()) && ((book.getTimeFrom().compareTo(min) >= 0 && book.getTimeFrom().compareTo(max) <= 0) || (book.getTimeTo().compareTo(min) >= 0 && book.getTimeTo().compareTo(max) <= 0) || (book.getTimeFrom().compareTo(min) <= 0) &&  book.getTimeTo().compareTo(max) >= 0  )) {
						flagBetween = false;
//						System.out.println("Result coincide");
						success.setText("Already Booked");
						success.setForeground(Color.red);
						break;
					}
				}
				if(flagFrom && flagTo && flagCompare && flagBetween && flagSpotNum) {
					BookingSpace.getInstance().parking.add(book);
					getInstance().bookingNow.add(book);
					
					try {
						update(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(BookingSpace.getInstance().getParking());
					System.out.println(getInstance().bookingNow);
					getInstance();
					BookingSpace.bookCount++;

					
//					Payment payment = new Payment(name, parking);
				}
			}
			else {
				success.setText("Max booking done. Proceed to DONE");
				success.setForeground(Color.red);
			}
			BookingSpace.count++;
			
		}
		
// if DONE is clicked
		if(e.getSource() == buttonDone) {
			boolean flagFrom = true;
			boolean flagTo = true;
			boolean flagCompare = true;
			boolean flagBetween = true;
			boolean flagSpotNum = true;
			System.out.println(getInstance().getParking());
// if timeFrom is greater than timeTo			
			try {
				if(dateFormat.parse(timeTo).compareTo(dateFormat.parse(timeFrom)) <= 0) {
					success.setText("Time From is greater than Time To");
					success.setForeground(Color.red);
					flagCompare = false;
				}
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
// if timeTo is less than current time		
			try {
				if(dateFormat.parse(timeTo).compareTo(d) <= 0) {
					success.setText("TimeTo not in Future");
					success.setForeground(Color.red);
					flagTo = false;
				}
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
// if timeFrom is less than current time
			try {
				if(dateFormat.parse(timeFrom).compareTo(d) <= 0) {
					success.setText("TimeFrom not in Future");
					success.setForeground(Color.red);
					flagFrom = false;
				}
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 
// if SpotNum is not in between [1, 7500]
			if(Integer.valueOf(spotNum) < 1 || Integer.valueOf(spotNum) > 7500) {
				success.setText("Incorrect Spot Number");
				success.setForeground(Color.red);
				flagSpotNum = false;
			}
			int id = BookingSpace.getInstance().getParking().get(BookingSpace.getInstance().getParking().size() - 1).getID() + 1;
			Booking book = null;
			try {
				book = new Booking(name, id, Integer.valueOf(spotNum), dateFormat.parse(timeFrom), dateFormat.parse(timeTo), licensePlate, "unpaid", "pending");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(Booking b: BookingSpace.getInstance().getParking()) {
				Date min = b.getTimeFrom();
				Date max = b.getTimeTo();
				if((book.getSpotNum() == b.getSpotNum()) && ((book.getTimeFrom().compareTo(min) >= 0 && book.getTimeFrom().compareTo(max) <= 0) || (book.getTimeTo().compareTo(min) >= 0 && book.getTimeTo().compareTo(max) <= 0) || (book.getTimeFrom().compareTo(min) <= 0) &&  book.getTimeTo().compareTo(max) >= 0  )) {
					flagBetween = false;
//					System.out.println("Result coincide");
					success.setText("Already Booked");
					success.setForeground(Color.red);
					break;
				}
			}
			if(flagFrom && flagTo && flagCompare && flagBetween && flagSpotNum) {
				BookingSpace.getInstance().getParking().add(book);
				getInstance().bookingNow.add(book);
				
//				String mssg = "Total amount =	$" + getInstance().bookingNow.size() * 20 ;
//				frame.dispose();
//				JOptionPane.showMessageDialog(null, mssg);
				try {
					update(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(getInstance().bookingNow);
				System.out.println(getInstance().getParking());
				frame.dispose();
//				PaymentType payment = new PaymentType(name, getInstance().bookingNow);
			}
			BookingSpace.count++;
		}

	}
	
	
}
	
	
	
	
	


