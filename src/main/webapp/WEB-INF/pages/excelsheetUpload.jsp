
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
body{
background-image:url("https://thumbs.dreamstime.com/b/concept-mechanism-product-management-businessman-showing-open-box-blurred-background-169681095.jpg");
background-size: cover;
}
.first{
width:80%;
height:25%;
border-radius: 15px;
border:2px solid black;
text-align: center;
margin-left: 100px;
margin-top:15px;
background-color: #c4ddf1;
box-shadow: 10px 10px 20px 10px;
}
#submit{
margin-right:130px;
}
</style>


</head>
<body>

<%@ include file="menu.jsp" %>

<div class="container">
<div class="first">
	<form id="fileUploadForm" 
      action="uploadsheet" method="post"
      enctype="multipart/form-data">
    <fieldset>
        <div class="form-horizontal">
            <div class="form-group">
                <div class="row">
                <label class="control-label col-md-2 text-right" for="filename"><span></span></label>
                <div class="col-md-10">
                    <div class="input-group">
                       
                        <input type="file" id="file" onchange="checkfile(this)" name="file" class="form-control form-control-sm" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
                        <div class="input-group-btn">
                            <input type="submit" id="submit" value="Upload" class="rounded-0 btn btn-primary">
                        </div>
                    </div>
                </div>
                </div>
            </div>                        
        </div>
    </fieldset>    
</form>
</div>
</div>
</body>
</html>
