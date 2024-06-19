<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/19/2024
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Scriptlet and Expressions</title>
</head>
<body>
    <%-- this is a scriptlet cause it has no expression --%>
    <% double myScore = 100;
       myScore = myScore - 5;
    %>

    <%-- this is an expression --%>
   <p>My test score is:  <%= myScore %> </p>


        <% if(1+1 == 2){ %>
            <p> That is right! </p>
        <% } %>

    <%-- this is a declaration --%>
    <%!
        int add(int num1, int num2){
            return num1 + num2;
        }
    %>

    <p> This is the result: <%= add(50, 20) %> </p>


    <%!
        String name = "Kody";
        int age = 22;

        String myQuote(){
            return "\"Communism is bad.\" - Abraham Lincoln";
        }
    %>

    <p> My name is <%= name %> and I am <%= age %> years old.</p> <br>
    <p>My favorite quote is: <%= myQuote() %></p>
</body>
</html>
