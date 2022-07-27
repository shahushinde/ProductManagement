<html>
<head>
<link href="register.css" rel="stylesheet">
<link href="addUser.css" rel="stylesheet">
<link href="register.js" rel="script">
<link href="bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.panel-heading{
font:15px;
}
</style>
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="post">
<h4 style="color:red;">${message}</h4>
<div class="container register">
                <div class="row">
                 
                    <div class="col-md-3 register-left">
                   
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRG8qBNXNNvkm1SVAo8fOS_8jJ1KdBd2g-KXA&usqp=CAU" alt=""/>
                        <h3>Welcome</h3>
                        <p>You are 30 seconds away from earning your own money!</p>
                       
                    </div>
                    <div class="col-md-9 register-right">
                       
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">ADD USER</h3>
                               
                                <div class="row register-form">
                                    <div class="col-md-6">
                                     
                                   
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Username *" value="" name="username"/>
                                        </div>
                                       
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="Password *" value="" name="password"/>
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="email" class="form-control" placeholder="Email *" value="" name="email"/>
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                               <div class="form-group">
                                            <select name="role" class="form-control">
                                                <option class="hidden" name="role" selected disabled>Please Select Your Role</option>
                                                <option value="Admin">Admin</option>
                                                <option value="User">User</option>
                                                
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <select  name="question" class="form-control">
                                                <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                                <option values="What is your Birthdate?">What is your Birthdate?</option>
                                                <option values="What is Your old Phone Number?">What is Your old Phone Number?</option>
                                                <option values="What is your Pet Name?">What is your Pet Name?</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="answer" placeholder="Enter Your Answer *" value="" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="ADD USER" formaction="addUser" formmethod="post">
                                    </div>
                                </div>
                            </div>
          
                        </div>
                    </div>
                  
                </div>

            </div>
</form>
</body>