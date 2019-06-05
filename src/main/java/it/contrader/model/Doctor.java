package it.contrader.model;

public class Doctor {
	
	private int doctorId;
	private String username;
	private String usertype;
	private String name;
	private String surname;
	private String password;
	private boolean userState;
	
	public Doctor() {}
		
	public Doctor(String username, String usertype){
		this.username = username;
		this.usertype = usertype;
	}
	
	public Doctor( int doctorId , String username, String usertype , String name , String surname ,String password , boolean userState) {
		this.username = username;
		this.usertype = usertype;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.doctorId = doctorId;
		this.userState = userState;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserState() {
		return userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}

	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}

	public String getUserType() {
		return usertype;
	}

	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
		
	public void changeState() {
		this.userState = !this.userState;
	}

	@Override
	public String toString() {
		return this.getDoctorId() + "\t" + this.getName()+ "\t" + this.getSurname()+"\t"+ this.getUserName() + "\t" +this.getPassword()+"\t"+ this.getUserType()+"\t"+this.isUserState();
	}
}



