import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PaymentType implements ActionListener{
	
	JFrame frame = new JFrame();
	private static JButton buttonCredit;
	private static JButton buttonDebit;
	private static JButton buttonPaypal;
	private static JButton buttonPay;
	private static JLabel cardNoLabel;
	private static JLabel monthLabel;
	private static JLabel yearLabel;
	private static JLabel nameLabel;
	private static JTextField cardNoText ;
	private static JTextField monthText;
	private static JTextField yearText ;
	private static JTextField nameText;
	private static JLabel welcomeLabel = new JLabel("Hello!");
	private static String user;
	private static JLabel success;
	private static int id ;
	

	
	PaymentType(){
		
	}
	
	PaymentType(String userID, int id){
			
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome "+userID + " !!");
		
		buttonCredit = new JButton("Credit Card");
		buttonCredit.setBounds(10, 100, 300, 25);
		buttonCredit.addActionListener(new PaymentType());
		frame.add(buttonCredit);
		
		buttonDebit = new JButton("Debit Card");
		buttonDebit.setBounds(10, 140, 300, 25);
		buttonDebit.addActionListener(new PaymentType());
		frame.add(buttonDebit);
		
		buttonPaypal = new JButton("Paypal");
		buttonPaypal.setBounds(10, 180, 300, 25);
		buttonPaypal.addActionListener(new PaymentType());
		frame.add(buttonPaypal);
			
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		
		PaymentType.user = userID;
		PaymentType.id = id;
		frame.setVisible(true);
	}
	
	public void guiCard() {
		frame = new JFrame(); 
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		cardNoLabel = new JLabel("Card Number");
		cardNoLabel.setBounds(10, 50, 100, 25);
		frame.add(cardNoLabel);
		
		cardNoText = new JTextField();
		cardNoText.setBounds(10, 75, 250, 25);
		frame.add(cardNoText);
		
		monthLabel  = new JLabel("Expiry Month");
		monthLabel.setBounds(10, 200, 100, 25);
		frame.add(monthLabel);
		
		monthText = new JTextField();
		monthText.setBounds(10, 225, 150, 25);
		frame.add(monthText);
		
		yearLabel  = new JLabel("Expiry Year");
		yearLabel.setBounds(300, 200, 100, 25);
		frame.add(yearLabel);
		
		yearText = new JTextField();
		yearText.setBounds(300, 225, 150, 25);
		frame.add(yearText);
		
		nameLabel  = new JLabel("Username");
		nameLabel.setBounds(10, 300, 100, 25);
		frame.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(10, 325, 200, 25);
		frame.add(nameText);
		
		buttonPay = new JButton("Pay");
		buttonPay.setBounds(10, 400, 100, 25);
		buttonPay.addActionListener(new PaymentType());
		frame.add(buttonPay);
		
		success = new JLabel();
		success.setBounds(10, 500, 300, 25);
		frame.add(success);
		success.setText("HI");
		
		frame.setVisible(true);
	}
	
	public void paid() throws Exception {
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";
		
		for(Booking b : BookingSpace.getInstance().getParking()) {
				if(b.getID() == PaymentType.id) {
					b.setStatus("paid");
				}
			}
		System.out.println(BookingSpace.getInstance().getParking());
		BookingSpace.getInstance().update(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
// id CREDIT is clicked		
		if(e.getSource() == buttonCredit) {
			System.out.println("true");
			frame.dispose();
			guiCard();
		}
// if DEBIT is clicked
		if(e.getSource() == buttonDebit) {
			System.out.println("true");
			frame.dispose();
			guiCard();
		}
		
// if PAYPAL is clicked
		if(e.getSource() == buttonPaypal) {
			System.out.println("true");
			String mssg = "Payment Successful";
			try {
				paid();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			JOptionPane.showMessageDialog(null, mssg);
		}
		
// if PAY is clicked
		if(e.getSource() == buttonPay) {
			String name;
		 	String cardNo;
			int month;
			int year;
			
			cardNo = cardNoText.getText();
			name = nameText.getText();
			month = Integer.valueOf(monthText.getText());
			year = Integer.valueOf(yearText.getText());
			
			Payment p = new Payment(name, month, year, cardNo);
			
			boolean flag = false;
			boolean flagName = false;
			if(Pattern.matches("^[0-9]{16}$", cardNo)) {
				flag = true;
			}
			
			if(name.equals(PaymentType.user)) {
				
				flagName = true;
			}
			if(p.validMonth(month) && p.validYear(year) && flag && flagName) {
				try {
					paid();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String mssg = "Payment Successful";
				frame.dispose();
				JOptionPane.showMessageDialog(null, mssg);
				try {
					paid();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(! flagName) {
				success.setText("Invalid username");
				success.setForeground(Color.red);
			}
			
			if(!p.validYear(year)) {
				success.setText("Invalid Year");
				success.setForeground(Color.red);
			}
			
			if(!p.validMonth(month)) {
				success.setText("Invalid Month");
				success.setForeground(Color.red);
			}
			
			if(! flag) {
				success.setText("Invalid Card Number");
				success.setForeground(Color.red);
			}			
		}
	}

}
