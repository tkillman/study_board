package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.study.dto.Dto;

public class Dao {

		//������ ���̽� (JDBC)

		//5. ��� �� ����
	
	
	private static Dao instance = new Dao();
	
	//�̱��� ����
	private Dao(){
		
	}
	
	public static Dao getInstance(){
		return instance;
	}
	
	//Ŀ�ؼ�Ǯ �����ͺ��̽� ����
	private Connection getConnect(){
		
		Connection connection=null;
		Context context=null;
		DataSource dataSource= null;
		
		try {
			
			context= new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection= dataSource.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return connection;
	}
	
	public ArrayList<Dto> getList(){
		
		Connection connection = getConnect();
		ArrayList<Dto> dtos=null;
	
		
		try {
			
			String sql="select * from board_table";
			PreparedStatement pStamement =connection.prepareStatement(sql);
			
			ResultSet resultSet = pStamement.executeQuery();
			dtos = new ArrayList<>();
			
			
			while(resultSet.next()){
				
				Dto dto = new Dto();
				dto.setBid(resultSet.getInt("bid"));
				dto.setBname(resultSet.getString("bname"));
				dto.setBtitle(resultSet.getString("btitle"));
				dto.setBcontent(resultSet.getString("bcontent"));
				dto.setBdate(resultSet.getDate("bdate"));
				dto.setHit(resultSet.getInt("bhit"));
				
				dtos.add(dto);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		
		
		return dtos;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
