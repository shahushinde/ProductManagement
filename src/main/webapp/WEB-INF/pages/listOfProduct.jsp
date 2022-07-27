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
      <th scope="col">PRODUCT ID</th>
      <th scope="col">PRODUCT NAME</th>
        <th scope="col">PRODUCT PRICE</th>
      <th scope="col">PRODUCT EXPIRY DATE</th>
         <th scope="col">ACTION</th>
      
  
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product}" var="product">
    <tr>
       <td><c:out value="${product.productid}"></c:out></td>
      <td><c:out value="${product.productname}"></c:out></td>
      <td><c:out value="${product.productprice}"></c:out></td>
      <td><c:out value="${product.productexpirydate}"></c:out></td>
     
      <td><a href="">EDIT</a>&emsp;<a>DELETE</a></td>
    </tr>
    </c:forEach>
 
  </tbody>
</table>

</body>