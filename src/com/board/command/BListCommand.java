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
		
		//������ ���̽� ����
		//������� �޾Ƽ� -> ��Ʈ�ѷ� ����
		Dao dao = Dao.getInstance();
		ArrayList<Dto> dtos = dao.getList();
		
		request.setAttribute("list", dtos);
		
		
	}

}
