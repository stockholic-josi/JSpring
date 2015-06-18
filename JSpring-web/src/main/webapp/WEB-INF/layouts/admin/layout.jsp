<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags"	prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal.user" />
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:getAsString name="title"/></title>
        <tiles:insertDefinition name="css" />
         <tiles:insertDefinition name="script"/>
    </head>
    <body>
		<tiles:insertAttribute name="header" />
		
		<div>
			<sec:authorize ifNotGranted="ROLE_USER">
		        로그인
		    </sec:authorize>
		     <sec:authorize ifAnyGranted="ROLE_USER"> 
		     	${user.userNm}(${user.userId})
				<a href="/logout">로그아웃</a>
			</sec:authorize>
		    
	    </div>
		    
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer"/>
    </body>

</html>
