package login;

public class LoginBean{
	private String username,password;
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public boolean validateUser(){
		if(password.equals("Admin"))
			return true;
		else
			return false;
	}
}