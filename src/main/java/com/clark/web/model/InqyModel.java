package com.clark.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class InqyModel {
	private String board_no;
	private String firstName;
	private String lastName;
	private String email;
	private String subject;
	private String content;
	private String lang;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date reg_dt = new Date();
	@JsonFormat(pattern = "yyyy-MM-dd HH:MM:SS", timezone = "Asia/Seoul")
	private Date update_dt = new Date();
	
	private String path;
	private String pride;
	private String upload_img;
}
