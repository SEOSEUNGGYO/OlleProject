<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="accompany.*" %>
<%@ page import="participation.*" %>
<%@ page import="user.UserDAO" %>
<%

	request.setCharacterEncoding("UTF-8");
	
	if(request.getParameter("user_id")==null||request.getParameter("user_pw")==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�Է¾ȵ� ���� �ֽ��ϴ�.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	
	String user_id = null;
	String user_pw = null;
	if(request.getParameter("user_id")!=null){
		user_id = request.getParameter("user_id");
	}
	if(request.getParameter("user_pw")!=null){
		user_pw = request.getParameter("user_pw");
	}
	
	UserDAO userDAO = new UserDAO();
	int result = userDAO.login(user_id,user_pw);

	if(result==1){
		session.setAttribute("user_id", user_id);
		if("admin".equals(user_id)){
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('������ �α��� �Ϸ�!!. ���� �������� ���ư��ϴ�.');");
			script.println("location.href = 'adminMain.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
		else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�α��� �Ϸ�!!. ���� �������� ���ư��ϴ�.');");
			script.println("location.href = 'index.jsp'");
			script.println("</script>");
			script.close();
			return;
		}
	}else if(result==0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('��й�ȣ Ʋ�Ƚ��ϴ�!.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('���Ե��� ���� ID!.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
%>