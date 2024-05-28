<%@page import="membership.MemberDAO"%>
<%@page import="membership.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 값을 받고 찍어 본다. 꼭~~
request.setCharacterEncoding("utf-8"); // 한글 처리
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String role = request.getParameter("role");

MemberDTO dto = new MemberDTO(id,pass,name);

// 3. db 처리
// MemberDAO dao = new MemberDAO();
// int rs = dao.insertMember(dto);

// 밖으로 빼야함
// {"rs":"<%=rs %>"}
%>
