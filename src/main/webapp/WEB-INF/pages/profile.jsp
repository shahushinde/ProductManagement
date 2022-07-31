<head>
<link href="register.css" rel="stylesheet">
<link href="profile.css" rel="stylesheet">
<link href="register.js" rel="script">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.panel-heading{
font:15px;
}
.first{
height:650px;
}
.a1{
width:300px;

}
option{
width:200px;
}
</style>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="first">
<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://media.istockphoto.com/vectors/user-member-vector-icon-for-ui-user-interface-or-profile-face-avatar-vector-id1130884625?k=20&m=1130884625&s=612x612&w=0&h=OITK5Otm_lRj7Cx8mBhm7NtLTEHvp6v3XnZFLZmuB9o=" alt=""/>
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        ${user.username}
                                    </h5>
                                    <h6>
                                      Role: ${user.role}
                                    </h6>
                                    <h5 style="color:red";>${message}</h5>
                                   
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile" formaction="editprofile" formmethod="post"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                       
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>USERNAME</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" class="a1" name="username" value="${user.username}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>PASSWORD</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="a1" name="password" value="${user.password}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>EMAIL</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" class="a1" name="email" value="${user.email}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>ROLE</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="a1" name="role" value="${user.role}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>GENDER</label>
                                            </div>
                                            <div class="col-md-6">
                                                    <select  name="question">
                                                <option class="hidden"  selected disabled>${user.gender}</option>
                                                <option values="Male">Male</option>
                                                <option values="Female">Female</option>
                                            </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>QUESTION</label>
                                            </div>
                                            <div class="col-md-6">
                                                
                                                   <select  name="question" >
                                                <option class="hidden"  selected disabled>${user.question}</option>
                                                <option values="What is your Birthdate?">What is your Birthdate?</option>
                                                <option values="What is Your old Phone Number?">What is Your old Phone Number?</option>
                                                <option values="What is your Pet Name?">What is your Pet Name?</option>
                                            </select>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-6">
                                                <label>ANSWER</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input type="text" class="a1" name="answer" value="${user.answer}">
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br/>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
          </div>
</body>