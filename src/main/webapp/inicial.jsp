<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>GeekStore</title>
    </head>
    <body>
        <div class="container">
            <div class="navbar-wrapper">
                <nav class="navbar navbar-default">
                    <ul class="nav navbar-nav">
                        <c:forTokens items= "ALL BRANDS,SKINCARE,MAKE UP,HAIR CARE,BATH & BODY,BEAUTY SUPPLEMENTS,PROMOS" delims = "," var = "opcao">
                            <li><a href="#">${opcao}</a></li>
                            </c:forTokens>
                    </ul>
                </nav>
            </div>
            <div id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/3/3c/Cityoflondon2019june.jpg">
                    </div>
                    <div class="item">
                        <img src="https://d2mpqlmtgl1znu.cloudfront.net/AcuCustom/Sitename/DAM/019/TokyoMtFuji_Adobe.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="https://cdn.vox-cdn.com/thumbor/DMDe34cFs_imVaa0lekmrH3YWc4=/0x0:4000x2667/1200x800/filters:focal(1680x1014:2320x1654)/cdn.vox-cdn.com/uploads/chorus_image/image/62767478/shutterstock_788608396.0.jpg" alt="">
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
            </div>
        </div>
    </body>
</html>