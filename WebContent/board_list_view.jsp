<%@page import="com.study.dto.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<%
		ArrayList<Dto> dtos=null; 
		
		if(request.getAttribute("list")!=null){
			 dtos = (ArrayList<Dto>)request.getAttribute("list");
		}
	
	
	%>	
	<table border="1">
		<tr align="center">
			<td>��ȣ</td>
			<td>�ۼ���</td>
			<td class="board_title">����</td>
			<td>�ۼ���¥</td>
			<td>��ȸ��</td>
		</tr>
		<% for(int i=0;i<dtos.size();i++){ 
		out.print(dtos.size());
		%>
		
		<tr align="center">
			<td><%=dtos.get(i).getBid()%></td>
			<td><%=dtos.get(i).getBname()%></td>
			<td align="left"><%=dtos.get(i).getBtitle()%></td>
			<td><%=dtos.get(i).getBcontent()%></td>
			<td><%=dtos.get(i).getBdate()%></td>
		</tr>
	
	<% }%>
		
	</table>
	<a href="board_write_view.do">�谡 ��������</a>
	<input class="btn" type="button" value="���ۼ�" onclick="window.location.href='board_write_view.do'">
</body>
</html>