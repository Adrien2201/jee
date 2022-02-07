<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Struts 2</title>
</head>
<body>
	<h1><a href="<s:url action='hello'/>"> Hello Struts 2</a></h1>
	<h3><s:property value="getText('global.heading')"/></h3>
				
				<s:url action="locale" var="indexEN">
					<s:param name="request_locale">en</s:param>
				</s:url>
				<s:a href="%{indexEN}">English</s:a>
				
				<s:url action="locale" var="indexFR" >
					<s:param name="request_locale">fr</s:param>
				</s:url>
				<s:a href="%{indexFR}">Français</s:a>
				
				<br><br>
				<i><s:property value="getText('global.required')"/></i>
				<s:form action="hello">
					<s:radio name="personne.genre" list="{'M', 'F'}" key="global.gender"/>
  					<s:textfield name="personne.firstName" key="global.firstname" />
  					<s:textfield name="personne.lastName" key="global.lastname" />
  					<s:textfield name="personne.age"  key="global.age"/>
  					<s:textfield name="personne.email" key="global.email" />
  					<s:textfield name="personne.title" key="global.title" />
  					
  					<s:textfield type="date" name="personne.startDate" key="global.startdate" />
  					<s:select name="personne.dept" list="{'', 'Admin', 'Loans', 'Operations', 'IT'}" key="global.dept"/>
  					<s:checkboxlist name="personne.options" list="{'A', 'B', 'C', 'D'}" key="global.options"/>
 					   					
  					<s:submit key="global.submit" />
				</s:form>
</body>
</html>