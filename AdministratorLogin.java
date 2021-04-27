import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdministratorLogin implements ActionListener{

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel firstNameLabel;
	private static JTextField firstNameText;
	private static JLabel lastNameLabel;
	private static JTextField lastNameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JLabel bookingSpaceLabel;
	private static JTextField bookingSpaceText;
	private static JButton buttonAdd;
	private static JButton buttonRemove;
	private static JButton buttonOK;
	private static JButton buttonChange;
	private static JButton buttonChangePayment;
	private static JButton buttonSignUp;
	private static JButton buttonReset;
	private static JLabel success;
	private int count = 1;
	
	AdministratorLogin(){
		
	}
	
	AdministratorLogin(String userID){
			
		welcomeLabel.setBounds(0,0,400,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome "+userID + " !!");
		
		buttonAdd = new JButton("ADD");
		buttonAdd.setBounds(100, 200, 300, 25);
		buttonAdd.addActionListener(new AdministratorLogin());
		frame.add(buttonAdd);
		
		buttonRemove = new JButton("REMOVE");
		buttonRemove.setBounds(100, 280, 300, 25);
		buttonRemove.addActionListener(new AdministratorLogin());
		frame.add(buttonRemove);
			
		buttonChangePayment= new JButton("CHANGE PAYMENT STATUS");
		buttonChangePayment.setBounds(100, 360, 300, 25);
		buttonChangePayment.addActionListener(new AdministratorLogin());
		frame.add(buttonChangePayment);
	
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void addOfficer() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(10, 80, 80, 25);
		frame.add(firstNameLabel);
		
		firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 80, 165, 25);
		frame.add(firstNameText);
		
		lastNameLabel = new JLabel("last Name");
		lastNameLabel.setBounds(10, 110, 80, 25);
		frame.add(lastNameLabel);
		
		lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 110, 165, 25);
		frame.add(lastNameText);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 140, 80, 25);
		frame.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 140, 165, 25);
		frame.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 170, 80, 25);
		frame.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 170, 165, 25);
		frame.add(passwordText);
		
		buttonSignUp= new JButton("Sign Up");
		buttonSignUp.setBounds(10, 350, 300, 25);
		buttonSignUp.addActionListener(new AdministratorLogin());
		frame.add(buttonSignUp);

		buttonReset = new JButton("Reset");
		buttonReset.setBounds(10, 380, 300, 25);
		buttonReset.addActionListener(new AdministratorLogin());
		frame.add(buttonReset);
		
		success = new JLabel();
		success.setBounds(10, 220, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
	
	public void removeOfficer() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 140, 80, 25);
		frame.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 140, 165, 25);
		frame.add(userText);
		
		buttonOK = new JButton("OK");
		buttonOK.setBounds(100, 280, 150, 25);
		buttonOK.addActionListener(new AdministratorLogin());
		frame.add(buttonOK);
		
		success = new JLabel();
		success.setBounds(10, 220, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);

	}
	
	public void changePaymentStatus() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(10, 80, 250, 25);
		frame.add(firstNameLabel);
		
		firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 80, 265, 25);
		frame.add(firstNameText);
		
		lastNameLabel = new JLabel("last Name");
		lastNameLabel.setBounds(10, 110, 250, 25);
		frame.add(lastNameLabel);
		
		lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 110, 265, 25);
		frame.add(lastNameText);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 140, 250, 25);
		frame.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 140,265, 25);
		frame.add(userText);
		
		bookingSpaceLabel = new JLabel("Booking Space");
		bookingSpaceLabel.setBounds(10, 180, 250, 25);
		frame.add(bookingSpaceLabel);
		
		bookingSpaceText = new JTextField(20);
		bookingSpaceText.setBounds(100, 180, 265, 25);
		frame.add(bookingSpaceText);
		
		buttonChange = new JButton("CHANGE");
		buttonChange.setBounds(100, 360, 300, 25);
		buttonChange.addActionListener(new AdministratorLogin());
		frame.add(buttonChange);
		
		success = new JLabel();
		success.setBounds(10, 220, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\officer.csv";
		String path1 = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";
		String path2 = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\user.csv";
// if ADD is clicked
		if(e.getSource() == buttonAdd) {
			frame.dispose();
			addOfficer();
			
		}
// if SIGN UP is clicked
		
		if(e.getSource() == buttonSignUp) {
			
			String firstName = firstNameText.getText();
			String lastName = lastNameText.getText();
			String username = userText.getText();
			String password = String.valueOf(passwordText.getPassword());
			
			MaintainUser users = new MaintainUser();
			boolean flag = false;
			
			if(count == 1) {
				try {
					users.loadOfficer(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int id = users.getOfficers().get(users.getOfficers().size() - 1).getId() + 1;
			for(User u : users.getOfficers()) {
				if(u.getEmail().equals(username)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				success.setText("Email exists");
				success.setForeground(Color.red);
			}
			else {
				if(Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", username) && password != "" && firstName != "" && lastName != "") {
					System.out.println(users.getOfficers());
					User user = new User(firstName, lastName, username, password, id);
					users.getOfficers().add(user);
					System.out.println(users.getOfficers());
					success.setText("Successful");
					success.setForeground(Color.green);
					
					try {
						users.updateOfficer(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
// if RESET is clicked
		if(e.getSource() == buttonReset) {
			firstNameText.setText("");
			lastNameText.setText("");
			userText.setText("");
			passwordText.setText("");
		}
// if REMOVE is clicked
		if(e.getSource() == buttonRemove) {
			frame.dispose();
			removeOfficer();
		}
		
// if OK is clicked
		if(e.getSource() == buttonOK) {
			String username = userText.getText();
			MaintainUser users = new MaintainUser();
			boolean flag = true;
			try {
				users.loadOfficer(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(User u : users.getOfficers()) {
				System.out.println(u.getEmail().equals(username));
				System.out.println(u.getEmail() + " " + username);
				if(u.getEmail().equals(username)){
					users.getOfficers().remove(u);
					flag = false;
					break;
				}
			}
			if(flag) {
				success.setText("Email does not exists");
				success.setForeground(Color.red);
			}
			else {
				try {
					success.setText("Successful");
					success.setForeground(Color.green);
					frame.dispose();
					users.updateOfficer(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			count++;
			System.out.println(flag + "    " + count);
		}
// if CHANGE PAYMENT STATUS is clicked
		if(e.getSource() == buttonChangePayment) {
			
			frame.dispose();
			changePaymentStatus();
			
		}
// if CHANGE is clicked
		if(e.getSource() == buttonChange) {
			MaintainUser users = new MaintainUser();
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				users.load(path2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boolean flag = false;
			boolean flag1 = false;
			String username = userText.getText();
			String firstName = firstNameText.getText();
			String lastName = lastNameText.getText();
			int bookingSpaceNum = Integer.valueOf(bookingSpaceText.getText());
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if(b.getName().equals(username) && b.getSpotNum() == bookingSpaceNum) {
					for(User u : users.getUsers()) {
						if(u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
							if(b.getStatus().equals("paid")) {
								flag1 = true;
							}
							else {
								b.setStatus("paid");
								flag = true;
							}
						}
					}
				}
			}
			if(flag) {
				success.setText("Successful");
				success.setForeground(Color.green);
				String mssg = "Payment status changed";
				JOptionPane.showMessageDialog(null, mssg);
				try {
					BookingSpace.getInstance().update(path1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				success.setText("Invalid Details");
				success.setForeground(Color.red);
				
			}
			if(flag1) {
				success.setText("Already Paid");
				success.setForeground(Color.red);
			}
			count++;
			System.out.println("--"+BookingSpace.getInstance().getParking());
			System.out.println(count);
		}
	}
	
}
