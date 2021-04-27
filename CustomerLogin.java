import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CustomerLogin implements ActionListener{

	private static JFrame frame = new JFrame();
	private static String user;
	private static JButton buttonBook;
	private static JButton buttonView;
	private static JButton buttonShow;
	private static JButton buttonCancellation;
	private static JTextField bookingIdText;
	private static JLabel bookingIdLabel;
	private static JTextField bookingSpaceText;
	private static JLabel bookingSpaceLabel;
	private static JButton buttonCancelBooking;
	private static JButton buttonPay;
	private static JButton buttonDone;
	private static JLabel success;
	private static JLabel welcomeLabel = new JLabel("Hello!");
	ArrayList<Checkbox> checkbox = new ArrayList<Checkbox>();
	public static int count = 1;
	static CustomerLogin instance = null;
	
	public static CustomerLogin getInstance() {
		if(instance == null) {
			instance = new CustomerLogin();
		}
		return instance;
	}
	
	public void CustomerCreate(String user){
		CustomerLogin.user = user;	
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome "+user + " !!");
			
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		
		buttonBook = new JButton("BOOK SPACE");
		buttonBook.setBounds(10, 200, 300, 25);
		buttonBook.addActionListener(new CustomerLogin());
		frame.add(buttonBook);
		
		buttonPay = new JButton("PAY");
		buttonPay.setBounds(10, 240, 300, 25);
		buttonPay.addActionListener(new CustomerLogin());
		frame.add(buttonPay);
		
		buttonView = new JButton("VIEW BOOKINGS");
		buttonView.setBounds(10, 280, 300, 25);
		buttonView.addActionListener(new CustomerLogin());
		frame.add(buttonView);
		
		buttonCancellation = new JButton("CANCELLATION");
		buttonCancellation.setBounds(10, 320, 300, 25);
		buttonCancellation.addActionListener(new CustomerLogin());
		frame.add(buttonCancellation);
		
		frame.setVisible(true);
	}
	
	public void guiCancellation() {
		
		frame = new JFrame();
		
		welcomeLabel.setBounds(0,0,500,25);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome to Book a Parking Slot");
		frame.add(welcomeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		bookingIdLabel = new JLabel("Booking ID");
		bookingIdLabel.setBounds(10, 50, 150, 25);
		frame.add(bookingIdLabel);
		
		bookingIdText = new JTextField(20);
		bookingIdText.setBounds(175, 50, 165, 25);
		frame.add(bookingIdText);
		
		buttonCancelBooking = new JButton("Cancel Booking");
		buttonCancelBooking.setBounds(10, 350, 300, 25);
		buttonCancelBooking.addActionListener(new CustomerLogin());
		frame.add(buttonCancelBooking);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
	
	public void guiView() {
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(new FlowLayout());
		
//		Checkbox checkBox1 = new Checkbox("Bookings");
//		frame.add(checkBox1);
//		Checkbox checkBox2 = new Checkbox("Bookings");
//		frame.add(checkBox2);
		if(count == 1) {
			try {
				BookingSpace.getInstance().load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		int i = 0;
		for(Booking b : BookingSpace.getInstance().getParking()) {
			if(b.getName().equals(user)) {
				Checkbox c = new Checkbox("Booking" + i);
				getInstance().checkbox.add(c);
				frame.add(getInstance().checkbox.get(i));
				i++;
			}
		}
		
		buttonShow = new JButton("Show Details");
		buttonShow.setBounds(10, 200, 300, 25);
		buttonShow.addActionListener(new CustomerLogin());
		frame.add(buttonShow);
		
		frame.setVisible(true);
	}
	public void guiDetail(int j) {
		count = 0;
		for(Booking b : BookingSpace.getInstance().getParking()) {
			if(user.equals(b.getName())) {
				if(count == j) {
					String mssg = "ID:	" + b.getID() +	"\nExpiry time:	" + b.getTimeTo() + "\nStatus:	" + b.getStatus();
					JOptionPane.showMessageDialog(null, mssg);
					break;
				}
				else {
					count ++;
				}
			}
			
		}
	}
	
	public void guiPay() {
        frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		bookingSpaceLabel = new JLabel("Booking Space");
		bookingSpaceLabel.setBounds(10, 50, 150, 25);
		frame.add(bookingSpaceLabel);
		
		bookingSpaceText = new JTextField(20);
		bookingSpaceText.setBounds(175, 50, 165, 25);
		frame.add(bookingSpaceText);
		
		buttonDone = new JButton("DONE");
		buttonDone.setBounds(10, 300, 300, 25);
		buttonDone.addActionListener(new CustomerLogin());
		frame.add(buttonDone);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonBook) {
			frame.dispose();
			BookingSpace booking = new BookingSpace(user);
			booking.parkingCreate();
		}
		if(e.getSource() == buttonCancellation) {
			frame.dispose();
			BookingSpace cancel = new BookingSpace(user);
			guiCancellation();
		}
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";

// if CANCELBOOKING is clicked----------------------------------------
		if(e.getSource() == buttonCancelBooking) {
			Date d = new Date();
			boolean flag = true;
			String bookingID = bookingIdText.getText();	
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if(b.getID() == Integer.valueOf(bookingID) && b.getName().equals(user) && (b.getTimeFrom().compareTo(d) > 0)) {
					BookingSpace.getInstance().getParking().remove(b);
					flag = false;
					frame.dispose();
					break;
				}
			}
			if(flag) {
				success.setText("Booking ID invalid");
				success.setForeground(Color.red);
			}
			BookingSpace booking = new BookingSpace();
			try {
				booking.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
		}
		
// if VIEW BOOKINGS is clicked
		if(e.getSource() == buttonView) {
			guiView();
		}
		
// if SHOW BOOKINGS is clicked
		if(e.getSource() == buttonShow) {
			for(int j = 0; j < getInstance().checkbox.size(); j++) {
				if(getInstance().checkbox.get(j).getState()) {
					guiDetail(j);
					break;
				}
			}
		}
// if PAY button is clicked ---------------------------------------------------------------		
		if(e.getSource() == buttonPay) {
			frame.dispose();
			guiPay();
		}
		
// if DONE is cicked
		if(e.getSource() == buttonDone) {
			int bookingNum = Integer.valueOf(bookingSpaceText.getText());
			success.setText("");
			boolean flag = true;	
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if(b.getSpotNum() == bookingNum && b.getName().equals(user)) {
					if(b.getRequest().equals("granted")) {
						if(b.getStatus().equals("unpaid")) {
							String mssg = "Total amount =	$20" ;
							JOptionPane.showMessageDialog(null, mssg);
							flag = false;
							PaymentType payment = new PaymentType(user, b.getID());
							frame.dispose();
							break;
						}
						else{
							System.out.println("FALSE 1");
							success.setText("Already paid");
							success.setForeground(Color.red);
							flag = false;
							break;
						}
					}
					else {
						System.out.println("FALSE 2");
						success.setText("Access request pending");
						success.setForeground(Color.red);
						flag = false;
						break;
					}
					
				}
			}
			if(flag) {
				success.setText("Invalid Booking Space Number");
				success.setForeground(Color.red);
			}
			BookingSpace booking = new BookingSpace();
			try {
				booking.update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
		}
//			boolean flagFrom = true;
//			boolean flagTo = true;
//			boolean flagCompare = true;
//			boolean flagBetween = true;
//			boolean flagSpotNum = true;
//					
//// if timeFrom is greater than timeTo			
//			try {
//				if(dateFormat.parse(timeTo).compareTo(dateFormat.parse(timeFrom)) <= 0) {
//					success.setText("Time From is greater than Time To");
//					success.setForeground(Color.red);
//					flagCompare = false;
//				}
//			} catch (ParseException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//// if timeTo is less than current time		
//			try {
//				if(dateFormat.parse(timeTo).compareTo(d) <= 0) {
//					success.setText("TimeTo not in Future");
//					success.setForeground(Color.red);
//					flagTo = false;
//				}
//			} catch (ParseException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			
//// if timeFrom is less than current time
//			try {
//				if(dateFormat.parse(timeFrom).compareTo(d) <= 0) {
//					success.setText("TimeFrom not in Future");
//					success.setForeground(Color.red);
//					flagFrom = false;
//				}
//			} catch (ParseException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			 
//// if SpotNum is not in between [1, 7500]
//			if(Integer.valueOf(spotNum) < 1 || Integer.valueOf(spotNum) > 7500) {
//				success.setText("Incorrect Spot Number");
//				success.setForeground(Color.red);
//				flagSpotNum = false;
//			}
//			int id = BookingSpace.getInstance().getParking().get(BookingSpace.getInstance().getParking().size() - 1).getID() + 1;
//			Booking book = null;
//			try {
//				book = new Booking(name, id, Integer.valueOf(spotNum), dateFormat.parse(timeFrom), dateFormat.parse(timeTo), licensePlate, "unpaid");
//			} catch (NumberFormatException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			for(Booking b: BookingSpace.getInstance().getParking()) {
//				Date min = b.getTimeFrom();
//				Date max = b.getTimeTo();
//				if((book.getSpotNum() == b.getSpotNum()) && ((book.getTimeFrom().compareTo(min) >= 0 && book.getTimeFrom().compareTo(max) <= 0) || (book.getTimeTo().compareTo(min) >= 0 && book.getTimeTo().compareTo(max) <= 0) || (book.getTimeFrom().compareTo(min) <= 0) &&  book.getTimeTo().compareTo(max) >= 0  )) {
//					flagBetween = false;
////					System.out.println("Result coincide");
//					success.setText("Already Booked");
//					success.setForeground(Color.red);
//					break;
//				}
//			}
//			if(flagFrom && flagTo && flagCompare && flagBetween && flagSpotNum) {
//				BookingSpace.getInstance().getParking().add(book);
//				getInstance().bookingNow.add(book);
//				
//				String mssg = "Total amount =	$" + getInstance().bookingNow.size() * 20 ;
//				frame.dispose();
//				JOptionPane.showMessageDialog(null, mssg);
////				try {
////					update(path);
////				} catch (Exception e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//				System.out.println(getInstance().getParking());
//				PaymentType payment = new PaymentType(name, getInstance().bookingNow);
//			}
//
//		}	
	}
}
