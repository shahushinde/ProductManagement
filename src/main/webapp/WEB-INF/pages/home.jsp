<html>
<head>
<link href="bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
             //  0          1        2       3
var images = ["image1","image2","image3","image4"];

var currentIndex = -1;
 

function changeImage() {

	var img = document.getElementById("i1");
	
    // change currentIndex in a loop

    currentIndex++;

    if (currentIndex == images.length)
        currentIndex = 0;
     
    //alert(images[currentIndex]);
    img.src = images[currentIndex] + ".jpg";
}

setInterval(changeImage,3000);

</script>
<style>

img
{
	height:500px;
	width:700px;
	border-radius:50%;
	margin: auto;
}
.img{
	height:400px;
	width:500px;
	border-radius:50%;
	margin-left: 425px;

}

element.style {
}
.navbar-light .navbar-brand {
    color: #4e67d4;
}
.navbar-brand {
    display: inline-block;
    padding-top: 0.3125rem;
    padding-bottom: 0.3125rem;
    margin-right: 1rem;
    font-size: 2rem;
    line-height: inherit;
    white-space: nowrap;
}
body{
/* background-color:#5fa7ba; */
background-image:url("https://cdn.stocksnap.io/img-thumbs/280h/bokeh-abstract_SYN6S8JAZG.jpg") ;
background-repeat: no-repeat;
background-size: cover;

}


</style>
</head>
<body>
<%@ include file="menu.jsp" %>
 <h4 style:"color=red";>${msg}</h4><br><br><br>
 <div class="img">
	<img id="i1"  src="image4.jpg">
</div>
</body>
</html>