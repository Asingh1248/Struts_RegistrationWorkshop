<%-- 
    Document   : success
    Created on : 9 Oct, 2018, 11:32:41 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
    <body>
        <h1>Congratulations!</h1>

        <p>You have Register logged in.</p>	
        <p>Your name is:<bean:write name="RegisterForm" property="name"/>.</p>
    </body>

</body>
</html>
