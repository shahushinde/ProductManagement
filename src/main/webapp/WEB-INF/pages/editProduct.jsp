<html>
<head>
<link rel="stylesheet" href="bootstrap.css">
<link rel="stylesheet" href="addproduct.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="">  
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRG8qBNXNNvkm1SVAo8fOS_8jJ1KdBd2g-KXA&usqp=CAU" alt=""/>
                        <h3>Welcome</h3>
                        <p>You are 30 seconds away from earning your own money!</p>
                    
                    </div>
                     
                    <div class="col-md-9 register-right">
                        <h4 style="color:red">${msg}</h4>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">ADD PRODUCT</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                   
                                   
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product id *" value="${product.productid}" name="productid" readonly="readonly" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product name *" value="${product.productname}" name="productname" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product price *" value="${product.productprice}" name="productprice" />
                                        </div>
                                        <div class="form-group">
                                            <input type="date" class="form-control" placeholder="Product Expiry Date *" value="${product.productexpirydate}" name="productexpirydate"/>
                                        </div>
                                       
                                    </div>
                                    <div class="col-md-6">
                                        
                                        <input type="submit" class="btnRegister"  value="EDIT PRODUCT" formaction="editProd" formmethod="post" />
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    
                </div>

            </div>
            </form>
            </body>
            </html>