public class Payment {
	
	private String name;
	private int month;
	private int year;
	private String cardNo;
	
	Payment(String name, int month, int year, String cardNo){
		this.name = name;
		this.month = month;
		this.year = year;
		this.cardNo = cardNo;
	}	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear () {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo  = cardNo;
	}
	
	public boolean validMonth(int m) {
		return (m >= 1) && (m <= 12);
	}
	
	public boolean validYear(int year) {
		return year >= 2021;
	}
}

