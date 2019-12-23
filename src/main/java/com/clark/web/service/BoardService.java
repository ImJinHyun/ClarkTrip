package com.clark.web.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.clark.web.dao.BoardDao;
import com.clark.web.model.BoardModel;
import com.clark.web.model.Search;

import java.util.*;

@Service
public class BoardService {
	
	@Autowired BoardDao boardDao;
	
	public List<Map<String, Object>> selectBoard(Model model) {
		String subject = "123124qwedasdzxc";
		
		List<Map<String, Object>> list = boardDao.selectBoard();
		model.addAttribute("list",  boardDao.selectBoard());
		model.addAttribute("view", boardDao.selectViewTest(subject));
		
		return list;
	}

	public void insertBoard(BoardModel boardTest) {
		int a = boardDao.insertBoard(boardTest);
		System.out.println("성공?=="+a);
	}

	public void introduce(Model model, BoardModel board, Search search) {
		BoardModel view = boardDao.introduce(board);
		model.addAttribute("view",view);
	}
}
