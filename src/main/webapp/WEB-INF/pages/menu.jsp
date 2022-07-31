<%
String username=(String) session.getAttribute("username");

if(username==null){
	request.setAttribute("message", "Please Login first");
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
}
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container-fluid">
   <a class="navbar-brand"><h1>ProductManagenemt</h1></a>
    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarCenteredExample"
      aria-controls="navbarCenteredExample"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div
      class="collapse navbar-collapse justify-content-center"
      id="navbarCenteredExample"
    >
      <!-- Left links -->
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link active" href="homepage"><h5>Home</h5></a>
        </li>
        <%
         String role=(String)session.getAttribute("userrole");
        if(role.equals("Admin")){%>
   
        	   <li class="nav-item">
               <a class="nav-link" href="addUserpage"><h5>Add User</h5></a>
             </li>
             
                <li class="nav-item">
               <a class="nav-link" href="UploadUser"><h5>Upload User</h5></a>
             </li>	
        <% 
        }
        %>
     
         <li class="nav-item">
          <a class="nav-link" href="addproductpage"><h5>Add Product</h5></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="productupload"><h5>Upload Product</h5></a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="listOfUsers"><h5>User List</h5></a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="getProductList"><h5>Product List</h5></a>
        </li>
       

    
        
       
      </ul>
      
      <ul class="navbar-nav mi-auto">
       
         <li class="nav-item">
          <a class="nav-link" href="profile?username=<%=session.getAttribute("username") %>"><h5 style="color:red"><%=session.getAttribute("username") %></h5></a>
        </li>
         <li class="navbar-nav mb-2 mb-lg-0">
          <a class="nav-link" href="userlogout"><h5>Logout</h5></a>
        </li>
        
       
      </ul>
      <!-- Left links -->
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
