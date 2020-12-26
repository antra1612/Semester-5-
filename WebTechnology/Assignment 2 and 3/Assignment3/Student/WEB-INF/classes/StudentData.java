package student;

public class StudentData{
	private String fname,lname,address;
	int age;
	public void setFname(String fname){
		this.fname=fname;
	}
	public String getFname(){
		return this.fname;
	}
	public void setLname(String lname){
		this.lname=lname;
	}
	public String getLname(){
		return this.lname;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}
}