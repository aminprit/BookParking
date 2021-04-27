import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking{
	private int id;
	private int spotNum;
	private String name;
	private Date timeFrom;
	private Date timeTo;
	private String licensePlate;
	private String status;
	private String request;



	public Booking( String name, int id, int spotNum, Date timeFrom, Date timeTo, String licensePlate, String status, String request) {
		super();
		this.name = name;
		this.id = id;
		this.spotNum = spotNum;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.licensePlate = licensePlate;
		this.status = status;
		this.request = request;
	}
	
	public Booking(){
		super();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getSpotNum() {
		return this.spotNum;
	}
	
	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}
	
	public Date getTimeFrom () {
		return this.timeFrom;
	}
	
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	
	public Date getTimeTo() {
		return this.timeTo;
	}
	
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return "Booking [name=" + name + ", id=" + id + ", spotNum=" + spotNum+ ", timeFrom=" + dateFormat.format(timeFrom) + ", timeTo=" + dateFormat.format(timeTo)+ ", License Plate=" + licensePlate + ", status="+ status+ ", request=" + request +"]";
	}
}
