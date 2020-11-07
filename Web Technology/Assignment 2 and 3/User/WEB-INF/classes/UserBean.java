package user;

public class UserBean{
	private String backgroundcolor,foregroundcolor,username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	public void setBackgroundcolor(String backgroundcolor){
		this.backgroundcolor=backgroundcolor;
	}
	public String getBackgroundcolor(){
		return this.backgroundcolor;
	}
	public void setForegroundcolor(String foregroundcolor){
		this.foregroundcolor=foregroundcolor;
	}
	public String getForegroundcolor(){
		return this.foregroundcolor;
	}
}