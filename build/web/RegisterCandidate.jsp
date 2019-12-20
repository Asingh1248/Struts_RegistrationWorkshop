<%-- 
    Document   : RegisterCandidate
    Created on : 9 Oct, 2018, 11:23:16 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action="/register">
        <center>
            <bean:write name="RegisterForm" property="error" filter="false"/><br><br>
            Enter Your Name:<html:text property="name"/><br><br>
            Enter Your Designation<html:text property="designation"/><br><br>
            Enter Your Organisation<html:text property="organisation"/><br><br>
            Enter Your No of Years of experience<html:text property="experienceyear"/><br><br>
            Enter Your Gender<br>
            Male:<html:radio property="gender" value="male"/><br>
            Female:<html:radio property="gender" value="female"/><br><br>
            Enter Your EmailId<html:text property="email"/><br><br>
            Enter Your ContactNo<html:text property="contactno"/><br><br>
            <html:submit value="Register"/>
         </center>   
        </html:form>
    </body>
</html>
