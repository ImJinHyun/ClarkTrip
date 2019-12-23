package com.clark.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.clark.web.dao.BoardDao;

@EnableScheduling @Component
public class ApiScheduling {

	@Value("${service.env}") String env;
	
	@Autowired BoardDao boardDao;
	
	/**
	 * 일 1회 이상 배치
	 */
	
	// 5시간마다.. 홈페이지 꺼지는거 방지 ㅜㅜ
	@Scheduled(cron = "0 0 0/5 * * ?") void mysqlRunning() {boardDao.selectBoard();};
	
}
