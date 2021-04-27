import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JLabel passwordLabel;
	private static JButton buttonLoginCustomer;
	private static JButton buttonLoginAuthority;
	private static JButton buttonLoginAdministrator;
	private static JButton buttonReset;
	private static JButton buttonRegister;
	private static JLabel success;

	
	public GUI(){
		super();
	}

	
	public void guiCreate() {
		
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		buttonLoginCustomer = new JButton("Login As Customer");
		buttonLoginCustomer.setBounds(10, 300, 300, 25);
		buttonLoginCustomer.addActionListener(new GUI());
		panel.add(buttonLoginCustomer);
		
		buttonLoginAuthority = new JButton("Login As Authority");
		buttonLoginAuthority.setBounds(10, 340, 300, 25);
		buttonLoginAuthority.addActionListener(new GUI());
		panel.add(buttonLoginAuthority);
		
		buttonLoginAdministrator = new JButton("Login As Administrator");
		buttonLoginAdministrator.setBounds(10, 380, 300, 25);
		buttonLoginAdministrator.addActionListener(new GUI());
		panel.add(buttonLoginAdministrator);
		
		buttonReset = new JButton("Reset");
		buttonReset.setBounds(10, 420, 300, 25);
		buttonReset.addActionListener(new GUI());
		panel.add(buttonReset);
		
		buttonRegister = new JButton("Register");
		buttonRegister.setBounds(10, 460, 300, 25);
		buttonRegister.addActionListener(new GUI());
		panel.add(buttonRegister);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		panel.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.guiCreate();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\user.csv";
		String path1 = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\officer.csv";
		MaintainUser users = new MaintainUser();
		
		String username = userText.getText();
		String password = String.valueOf(passwordText.getPassword());
		
// if login is clicked	
		boolean flag = false;
		if(e.getSource() == buttonLoginCustomer) {
			int i = 0;

			try {
				users.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(User u : users.getUsers()) {
				if(u.getEmail().equals(username) && u.getPassword().equals(password)) {
					i = users.getUsers().indexOf(u);
					flag = true;
					break;
				}
			}
			if(flag == true) {
				success.setForeground(Color.green);
				success.setText("Successful");
				frame.dispose();
				CustomerLogin customer = new CustomerLogin();
				customer.CustomerCreate(users.getUsers().get(i).getEmail());
			}
			else {
				success.setForeground(Color.red);
				success.setText("Incorrect User or Password");
			}
		}
// if Login as authority is clicked
		if(e.getSource() == buttonLoginAuthority) {
				int i = 0;
				System.out.println("before");
				try {
					users.loadOfficer(path1);
					System.out.println("after");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(User u : users.getOfficers()) {
					if(u.getEmail().equals(username) && u.getPassword().equals(password)) {
						i = users.getUsers().indexOf(u);
						flag = true;
						break;
					}
				}
				if(flag == true) {
					success.setForeground(Color.green);
					success.setText("Successful");
					frame.dispose();
					OfficerLogin officer = new OfficerLogin(username);
					
				}
				else {
					success.setForeground(Color.red);
					success.setText("Incorrect User or Password");
				}
		}
// if Login As Aministrator is clicked
		if(e.getSource() == buttonLoginAdministrator) {
			String user ="prit@yorku.ca";
			String pass = "prit";
			if(user.equals(username) && pass.equals(password)) {
				AdministratorLogin admin = new AdministratorLogin(user);
				frame.dispose();
			}
			else {
				success.setText("Invalid Details");
				success.setForeground(Color.red);
			}
		}
// if Register is clicked
		if(e.getSource() == buttonRegister) {
			frame.dispose();
			NewUser newUser = new NewUser();
			newUser.NewUserCreate();
		}
// if reset is clicked
		if(e.getSource() == buttonReset) {
			userText.setText("");
			passwordText.setText("");
			success.setText(null);
		}
		
	}

}







//if(u.getEmail() == username && flagUser) {
//	if(u.getPassword() == password && flagPassword) {
//		flagUser = false;
//		flagPassword = false;
//		success.setForeground(Color.green);
//		success.setText("Successful");
//		frame.dispose();
//		CustomerLogin customer = new CustomerLogin(username);
//	}
//	else {
//		success.setForeground(Color.red);
//		success.setText("Incorrect Password");
//	}
//}
//else {
//	success.setForeground(Color.red);
//	success.setText("Incorrect User");
//}
