package com.clark.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {
	String userId;
	String userNm;
	String userPw;
	String age;
	String birth;
	String email;
	String tel;
	String state = "0";
	String gender;
	String grade;
	String name;
	
	String emailReceiveYn;
	String smsReceiveYn;
	String addrfull;
	String zipcode;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date lastLoginDt = new Date();

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date expPwDt = new Date();
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date joinDt = new Date();
	
	
	
	
	
	
	
	
}
