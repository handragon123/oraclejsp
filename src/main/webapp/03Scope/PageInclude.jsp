<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<title>Include 페이지</title>
<% 
int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
%>
<ul>
<li>Integer 객체 : <%=pInteger2 %></li>
<li>Person 객체 : <%=pPerson2.getName() %>, <%=pPerson2.getAge() %></li>
</ul>