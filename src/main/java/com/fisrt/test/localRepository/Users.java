package com.fisrt.test.localRepository;

public class Users {

	public Users() {}
	
	private Integer userId;
	private String userName;
	private String usreEmail;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsreEmail() {
		return usreEmail;
	}
	public void setUsreEmail(String usreEmail) {
		this.usreEmail = usreEmail;
	}
	public Users(Integer userId, String userName, String usreEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.usreEmail = usreEmail;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", usreEmail=" + usreEmail + "]";
	}
	
}
