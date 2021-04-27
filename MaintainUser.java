import java.io.FileWriter;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser {
	public ArrayList<User> officers = new ArrayList<User>();
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setFirstName(reader.get("firstname"));
			user.setLastName(reader.get("lastname"));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			users.add(user);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("firstname");
				csvOutput.write("lastname");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getFirstName());
					csvOutput.write(u.getLastName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public ArrayList<User> getOfficers(){
		return this.officers;
	}
	
	public void loadOfficer(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			user.setFirstName(reader.get("firstname"));
			user.setLastName(reader.get("lastname"));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			user.setId(Integer.valueOf(reader.get("id")));
			officers.add(user);
		}
	}
	
	public void updateOfficer(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');

				csvOutput.write("firstname");
				csvOutput.write("lastname");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.write("id");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: officers){
					csvOutput.write(u.getFirstName());
					csvOutput.write(u.getLastName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(String.valueOf(u.getId()));
					csvOutput.endRecord();
				}
				csvOutput.close();
			System.out.println(officers);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
//	public boolean searchUser(String user, String password, String path) throws Exception {
//		
//		this.load(path);
//		boolean flag = false;
//		for(User u : this.getUsers()) {
//			if(u.getEmail() == user && u.getPassword() == password) {
//				flag = true;
//				break;
//			}
//		}
//		return flag;
//	}
//	public static void main(String [] args) throws Exception{
//		String path = "C:\\Users\\aminp\\OneDrive\\Desktop\\EECS3311\\user.csv";
//		MaintainUser maintain = new MaintainUser();
//	
//		maintain.load(path);
//		for(User u: maintain.users){
//			System.out.println(u.toString());
//		}
//		
////		User newUser = new User("f4", "l4", "t4@yorku.ca", "t4t4");
////		maintain.users.add(newUser);
//		
////		maintain.update(path);
//	}
}
