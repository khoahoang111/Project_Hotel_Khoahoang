<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html"><img src="<c:url value="/resources/images/logo4-01.png"/>" height="60px"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="<c:url value="/home"/>" class="nav-link">Home</a></li>
                <li class="nav-item  active"><a href="room_type" class="nav-link">Rooms</a>
<!--                    <ul class="dropdown-content">
                        <li><a href="blog.html">Blog</a></li>
                        <li><a href="single-blog.html">Blog Details</a></li>
                    </ul>-->
                </li>
<!--                <li class="nav-item"><a href="services.html" class="nav-link">Services</a></li>
                <li class="nav-item"><a href="about.html" class="nav-link">About Us</a></li>
                <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
                <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>-->
            </ul>
        </div>
    </div>
</nav>