package com.fisrt.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="UserDetails")
public class UserDetails {		
	public UserDetails(){}
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	
	private String userName;
	
	private String userEmail;
	
	private long userphone;
	
	private String userAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetails productDetails;
	
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getUserphone() {
		return userphone;
	}
	public void setUserphone(long userphone) {
		this.userphone = userphone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public UserDetails(Integer userId, String userName, String userEmail, long userphone, String userAddress) {
		super();
		UserId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userphone = userphone;
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "UserDetails [UserId=" + UserId + ", userName=" + userName + ", userEmail=" + userEmail + ", userphone="
				+ userphone + ", userAddress=" + userAddress + "]";
	}
	
	
	
}
