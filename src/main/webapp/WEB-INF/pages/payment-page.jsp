<%-- 
    Document   : payment-page
    Created on : Jul 22, 2021, 10:49:19 PM
    Author     : khoa hoang
--%>




<%-- 
    Document   : searchBooking
    Created on : Jun 28, 2021, 8:09:54 PM
    Author     : khoa hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="include/css-page.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="include/menu-page.jsp" />
        <div class="block-30 block-30-sm item" style="background-image: url('resources/images/bg_2.jpg');" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-10">
                        <span class="subheading-sm">Rooms</span>
                        <h2 class="heading">Rooms &amp; Suites</h2>
                    </div>
                </div>
            </div>
        </div>

        
        <div class="container shadow-lg p-3 mb-5 bg-white rounded">
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Booking successful</h4>     
            <h4>${message}</h4>
        </div>

<jsp:include page="include/footer-page.jsp"/>
<jsp:include page="include/js-page.jsp" />
</body>
</html>
