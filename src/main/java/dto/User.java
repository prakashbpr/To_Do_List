package dto;

public class User {
	private int userid;
	private String username;
	private String useremail;
	private long usercontact;
	private String userpassword;
	private byte[] userimage;
	
	public User(int userid, String username, String useremail, long usercontact, String userpassword, byte[] userimage) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userpassword = userpassword;
		this.userimage = userimage;
	}
	public int getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	
	public String getUseremail() {
		return useremail;
	}
	
	public long getUsercontact() {
		return usercontact;
	}
	
	public String getUserpassword() {
		return userpassword;

	}
	public byte[] getUserimage() {
		return userimage;
	}


}
