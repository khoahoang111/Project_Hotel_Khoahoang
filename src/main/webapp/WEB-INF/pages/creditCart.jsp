<%-- 
    Document   : searchBooking
    Created on : Jun 28, 2021, 8:09:54 PM
    Author     : khoa hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="include/css-page.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="include/menu-page.jsp" />

        <div class="block-30 block-30-sm item" style="background-image: url(<c:url value="/resources/images/bg_2.jpg"/>);" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-10">
                        <span class="subheading-sm">Rooms</span>
                        <h2 class="heading">Rooms &amp; Suites</h2>
                    </div>
                </div>
            </div>
        </div>
        </br>
        <div class="container">



            <div class="row">
                <div class="col-md-12 col-xs-12 col-lg-12">
                    <button class="btn btn-primary"
                            onclick="location.href = '<c:url value="/view-booking" />'">Back</button>
                </div>
            </div>

            <form action="<c:url value="/result-booking" />" method="POST" >
                <div style="margin-bottom: 35px">
                    <h4>Customer's Credit Card: </h4>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label>Cardholder Name <font color = "#ff0000">(*)</font> </label>
                        <input class="form-control" type="text" name="name" required >
                    </div>
                    <div class="form-group col-6">
                        <label>Card Number <font color = "#ff0000">(*)</font></label>
                        <input class="form-control" type="text" name="cardNumber" maxlength="19" minlength="12" required >
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label>Expiration Date <font color = "#ff0000">(*)</font> </label>
                        <input type="date" class="form-control" name="expireDate" required >
                    </div>
                    <div class="form-group col-6">
                        <label>CVV <font color = "#ff0000">(*)</font> </label>
                        <input class="form-control" type="password" name="cvv" maxlength="3" minlength="3" required >
                    </div>
                </div>
                <div >
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" 
                                style=" width: 150px">
                            <i class="fas fa-credit-card"></i>&ensp;Payment
                        </button> 
                    </div>
                </div>

            </form>
        </div>
    </div>
    <jsp:include page="include/footer-page.jsp"/>
    <jsp:include page="include/js-page.jsp" />
</body>
</html>
