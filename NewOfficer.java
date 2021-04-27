import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewOfficer {

	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel firstNameLabel;
	private static JTextField firstNameText;
	private static JLabel lastNameLabel;
	private static JTextField lastNameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton buttonCustomer;
	private static JButton buttonAuthority;
	private static JButton buttonAdministrator;
	private static JButton buttonReset;
	private static JButton buttonCancel;
	private static JLabel success;
	private static JLabel welcomeLabel = new JLabel("Hello!");
	
	NewOfficer(){
		super();
	}
	
	public void NewUserCreate(){
			
		welcomeLabel.setBounds(0,0,400,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome to Sign Up");
		frame = new JFrame();
		panel = new JPanel();
		
			
		
		frame.add(welcomeLabel);
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
//		frame.setLayout(null);

		
		panel.setLayout(null);
		
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(10, 80, 80, 25);
		panel.add(firstNameLabel);
		
		firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 80, 165, 25);
		panel.add(firstNameText);
		
		lastNameLabel = new JLabel("last Name");
		lastNameLabel.setBounds(10, 110, 80, 25);
		panel.add(lastNameLabel);
		
		lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 110, 165, 25);
		panel.add(lastNameText);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 140, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 140, 165, 25);
		panel.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 170, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 170, 165, 25);
		panel.add(passwordText);
		
		buttonCustomer= new JButton("Sign Up as Customer");
		buttonCustomer.setBounds(10, 300, 300, 25);
		buttonCustomer.addActionListener(new NewUser());
		panel.add(buttonCustomer);
		
		buttonAuthority = new JButton("Sign Up as Authority");
		buttonAuthority.setBounds(10, 330, 300, 25);
		buttonAuthority.addActionListener(new NewUser());
		panel.add(buttonAuthority);
		
		buttonAdministrator = new JButton("Sign Up as Administrator");
		buttonAdministrator.setBounds(10, 360, 300, 25);
		buttonAdministrator.addActionListener(new NewUser());
		panel.add(buttonAdministrator);
		
		buttonReset = new JButton("Reset");
		buttonReset.setBounds(10, 390, 300, 25);
		buttonReset.addActionListener(new NewUser());
		panel.add(buttonReset);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(10, 420, 300, 25);
		buttonCancel.addActionListener(new NewUser());
		panel.add(buttonCancel);
		
		success = new JLabel();
		success.setBounds(10, 220, 300, 25);
		panel.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
}
