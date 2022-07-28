<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link href="register.css" rel="stylesheet">
<link href="register.js" rel="script">
<link href="bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">


</style>
</head>


<body>
<div>
<%@ include file="menu.jsp" %>

</div>

<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">USERNAME</th>
       <th scope="col">EMAIL</th>
        <th scope="col">GENDER</th>
      <th scope="col">ROLE</th>
      
      
       <%
         role=(String)session.getAttribute("userrole");
        if(role.equals("Admin")){%>
   
       <th scope="col">PASSWORD</th>
      <th scope="col">QUESTION</th>
      <th scope="col">ANSWER</th>
      <th scope="col">ACTION</th> 	
        <% 
        }
        %>
     
     
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${user}" var="users">
    <tr>
       <td><c:out value="${users.username}"></c:out></td>
       <td><c:out value="${users.email}"></c:out></td>
      <td><c:out value="${users.gender}"></c:out></td>
      <td><c:out value="${users.role}"></c:out></td>
      
            <%
         role=(String)session.getAttribute("userrole");
        if(role.equals("Admin")){%>
      <td><c:out value="${users.password}"></c:out></td>
      <td><c:out value="${users.question}"></c:out></td>
      <td><c:out value="${users.answer}"></c:out></td>
      <td><a href="profile?username=${users.username}">EDIT</a>&emsp;<a href="delete?username=${users.username}">DELETE</a></td>	
        <% 
        }
        %>
     
    </tr>
    </c:forEach>
 
  </tbody>
</table>

</body>