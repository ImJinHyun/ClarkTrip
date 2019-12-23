package com.clark.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardModel {
	private String board_id;
	private String board_no;
	private String subject;
	private String content;
	private String name;
	private String id;
	private String event_Yn;
	private String lang;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date reg_dt = new Date();
	@JsonFormat(pattern = "yyyy-MM-dd HH:MM:SS", timezone = "Asia/Seoul")
	private Date update_dt = new Date();
	
	private String path;
	private String pride;
	private String upload_img;
}
