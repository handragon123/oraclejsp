<%@page import="common.JSFunction"%>
<%@page import="common.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 폼값 읽기
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
String save_check = request.getParameter("save_check");

if("must".equals(user_id) && "1234".equals(user_pw)) { // 사용자 인증
	if (save_check != null && save_check.equals("Y")) {
		CookieManager.makeCookie(response, "loginId", user_id, 86400);
	}
	else {
		CookieManager.deleteCookie(response, "loginId");
	}
	JSFunction.alertLocation("로그인성공", "IdSaveMain.jsp", out);
}
else {
	JSFunction.alertBack("로그인 실패", out);
}
%>

