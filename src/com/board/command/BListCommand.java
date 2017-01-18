package com.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Dao;
import com.study.dto.Dto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//데이터 베이스 접속
		//결과값을 받아서 -> 컨트롤러 전송
		Dao dao = Dao.getInstance();
		ArrayList<Dto> dtos = dao.getList();
		
		request.setAttribute("list", dtos);
		
		
	}

}
