import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class OfficerLogin  implements ActionListener{

	JFrame frame = new JFrame();
	private static JButton buttonManageParking;
	private static JButton buttonRemoveSpace;
	private static JButton buttonAddSpace;
	private static JButton buttonAdd;
	private static JButton buttonRemove1;
	private static JButton buttonGrantRequest;
	private static JButton buttonCancelRequest;
	private static JButton buttonView;
	private static JButton buttonGrant;
	private static JButton buttonRemove;
	private static JLabel bookingIdLabel;
	private static JTextField bookingIdText;
	private static JLabel success;
	private static JLabel bookingSpaceLabel = new JLabel("Booking Space");
	private static JTextField bookingSpaceText;
	JLabel welcomeLabel = new JLabel("Hello!");
	public ArrayList<Integer> space = new ArrayList<Integer>();
	private int count = 1;
	
	
	OfficerLogin(){
		
	}
	
	OfficerLogin(String userID){
			
		welcomeLabel.setBounds(0,0,400,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Welcome "+userID + " !!");
		
		buttonManageParking = new JButton("MANAGE PARKING");
		buttonManageParking.setBounds(100, 150, 200, 25);
		buttonManageParking.addActionListener(new OfficerLogin());
		frame.add(buttonManageParking);
		
		buttonAddSpace = new JButton("ADD SPACE");
		buttonAddSpace.setBounds(100, 200, 200, 25);
		buttonAddSpace.addActionListener(new OfficerLogin());
		frame.add(buttonAddSpace);
		
		buttonRemoveSpace = new JButton("REMOVE SPACE");
		buttonRemoveSpace.setBounds(100, 250, 200, 25);
		buttonRemoveSpace.addActionListener(new OfficerLogin());
		frame.add(buttonRemoveSpace);
		
		buttonGrantRequest = new JButton("GRANT REQUEST");
		buttonGrantRequest.setBounds(100, 300, 200, 25);
		buttonGrantRequest.addActionListener(new OfficerLogin());
		frame.add(buttonGrantRequest);
		
		buttonCancelRequest = new JButton("CANCEL REQUEST");
		buttonCancelRequest.setBounds(100, 350, 200, 25);
		buttonCancelRequest.addActionListener(new OfficerLogin());
		frame.add(buttonCancelRequest);
			
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void loadSpace(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			int num = Integer.valueOf(reader.get("booking space"));
			space.add(num);
		}
	}
	
	public void updateSpace(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("booking space");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Integer i: space){
					csvOutput.write(i.toString());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void manageParking() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		bookingSpaceLabel = new JLabel("Booking Space:");
		bookingSpaceLabel.setBounds(10, 80, 150, 25);
		frame.add(bookingSpaceLabel);
		
		bookingSpaceText = new JTextField(20);
		bookingSpaceText.setBounds(175, 80, 165, 25);
		frame.add(bookingSpaceText);
		
		buttonView = new JButton("View");
		buttonView.setBounds(100, 300, 200, 25);
		buttonView.addActionListener(new OfficerLogin());
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		frame.add(buttonView);
		
		frame.setVisible(true);
	}
	
	public void guiGrant() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		bookingIdLabel = new JLabel("Booking ID");
		bookingIdLabel.setBounds(10, 50, 150, 25);
		frame.add(bookingIdLabel);
		
		bookingIdText = new JTextField(20);
		bookingIdText.setBounds(175, 50, 165, 25);
		frame.add(bookingIdText);
		
		buttonGrant = new JButton("Grant");
		buttonGrant.setBounds(10, 350, 300, 25);
		buttonGrant.addActionListener(new OfficerLogin());
		frame.add(buttonGrant);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}
	
public void guiRemove() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		
		bookingIdLabel = new JLabel("Booking ID");
		bookingIdLabel.setBounds(10, 50, 150, 25);
		frame.add(bookingIdLabel);
		
		bookingIdText = new JTextField(20);
		bookingIdText.setBounds(175, 50, 165, 25);
		frame.add(bookingIdText);
		
		buttonRemove = new JButton("Remove");
		buttonRemove.setBounds(10, 350, 300, 25);
		buttonRemove.addActionListener(new OfficerLogin());
		frame.add(buttonRemove);
		
		success = new JLabel();
		success.setBounds(10, 200, 300, 25);
		frame.add(success);
		success.setText(null);
		
		frame.setVisible(true);
	}

public void guiAddSpace() {
	
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(550, 550);
	frame.setLayout(null);
	
	bookingIdLabel = new JLabel("Booking Space");
	bookingIdLabel.setBounds(10, 50, 150, 25);
	frame.add(bookingIdLabel);
	
	bookingIdText = new JTextField(20);
	bookingIdText.setBounds(175, 50, 165, 25);
	frame.add(bookingIdText);
	
	buttonAdd = new JButton("Add");
	buttonAdd.setBounds(10, 350, 300, 25);
	buttonAdd.addActionListener(new OfficerLogin());
	frame.add(buttonAdd);
	
	success = new JLabel();
	success.setBounds(10, 200, 300, 25);
	frame.add(success);
	success.setText(null);
	
	frame.setVisible(true);
}

public void guiRemoveSpace() {
	
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(550, 550);
	frame.setLayout(null);
	
	bookingIdLabel = new JLabel("Booking Space");
	bookingIdLabel.setBounds(10, 50, 150, 25);
	frame.add(bookingIdLabel);
	
	bookingIdText = new JTextField(20);
	bookingIdText.setBounds(175, 50, 165, 25);
	frame.add(bookingIdText);
	
	buttonRemove1 = new JButton("Remove");
	buttonRemove1.setBounds(10, 350, 300, 25);
	buttonRemove1.addActionListener(new OfficerLogin());
	frame.add(buttonRemove1);
	
	success = new JLabel();
	success.setBounds(10, 200, 300, 25);
	frame.add(success);
	success.setText(null);
	
	frame.setVisible(true);
}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\booking.csv";
		String path1 = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\BookingSpace.csv";
		
		if(count == 1) {
			try {
				loadSpace(path1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
// if MANAGE PARKING is clicked
		if(e.getSource() == buttonManageParking) {
			frame.dispose();
			manageParking();
		}
// if VIEW is clicked
		if(e.getSource() == buttonView) {
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int bookingSpace = Integer.valueOf(bookingSpaceText.getText());
			boolean flag = true;
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if (b.getSpotNum() == bookingSpace) {
					flag = false;
					frame.dispose();
					String mssg = "ID:	" + b.getID() +	"\nExpiry time:	" + b.getTimeTo() + "\nStatus:	" + b.getStatus();
					JOptionPane.showMessageDialog(null, mssg);
				}
			}
			if(flag) {
				success.setText("Booking Space not found");
				success.setForeground(Color.red);
			}
			count++;
		}
// if ADD SPACE is clicked
		if(e.getSource() == buttonAddSpace) {
			frame.dispose();
			guiAddSpace();
		}
// if ADD is clicked
		if(e.getSource() == buttonAdd) {
			System.out.println(count);
//			if(count == 1) {
//				try {
//					loadSpace(path1);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
			int num = Integer.valueOf(bookingIdText.getText());
			
			if(space.contains(num)) {
				success.setText("Already exists");
				success.setForeground(Color.red);
			}
			else {
				space.add(num);
				String mssg = num + "	added";
				JOptionPane.showMessageDialog(null, mssg);
				success.setText("Successful");
				success.setForeground(Color.green);
			}
			try {
				updateSpace(path1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
			System.out.println(count);
		}
// if REMOVE SPACE is clicked
		if(e.getSource() == buttonRemoveSpace) {
			frame.dispose();
			guiRemoveSpace();
		}
// if REMOVE is clicked
		if(e.getSource() == buttonRemove1) {
			System.out.println(count);
//			if(count == 1) {
//				try {
//					loadSpace(path1);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
			int num = Integer.valueOf(bookingIdText.getText());
			
			
			if(space.contains(num)) {
				space.remove((Object)num);
				String mssg = num + "	removed";
				JOptionPane.showMessageDialog(null, mssg);
				success.setText("Successful");
				success.setForeground(Color.green);
			}
			else {
				success.setText("Does not exists");
				success.setForeground(Color.red);
			}
			
			try {
				updateSpace(path1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
			System.out.println(count);
		}
//  if GRANT REQUEST is clicked
		if(e.getSource() == buttonGrantRequest) {
			frame.dispose();
			guiGrant();
		}
// if CANCEL REQUEST is clicked
		if(e.getSource() == buttonCancelRequest) {
			frame.dispose();
			guiRemove();
		}
// if GRANT is clicked
		if(e.getSource() == buttonGrant) {
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int bookingSpace = Integer.valueOf(bookingIdText.getText());
			boolean flag = true;
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if (b.getID() == bookingSpace && b.getRequest().equals("pending")) {
					flag = false;
					b.setRequest("granted");
					frame.dispose();
					String mssg = "Access Granted";
					JOptionPane.showMessageDialog(null, mssg);
					break;
				}
			}
			if(flag) {
				success.setText("Booking ID not valid");
				success.setForeground(Color.red);
			}
			try {
				BookingSpace.getInstance().update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
		}
		if(e.getSource() == buttonRemove) {
			if(count == 1) {
				try {
					BookingSpace.getInstance().load(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			int bookingSpace = Integer.valueOf(bookingIdText.getText());
			boolean flag = true;
			
			for(Booking b : BookingSpace.getInstance().getParking()) {
				if (b.getID() == bookingSpace && b.getRequest().equals("pending")) {
					flag = false;
					BookingSpace.getInstance().getParking().remove(b);
					frame.dispose();
					String mssg = "Removed";
					JOptionPane.showMessageDialog(null, mssg);
					break;
				}
			}
			if(flag) {
				success.setText("Booking ID not valid");
				success.setForeground(Color.red);
			}
			try {
				BookingSpace.getInstance().update(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			count++;
		}
	}
}
